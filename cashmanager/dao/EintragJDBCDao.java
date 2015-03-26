package cashmanager.cashmanager.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cashmanager.cashmanager.EinAus;
import cashmanager.cashmanager.Konto;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EintragJDBCDao implements EintragDao {
	
	private Connection				con	= null;
	private PreparedStatement	ps	= null;
	private ResultSet					rs	= null;
	
	// Beutzerid finden
	public EinAus findEintragById(int id) throws SQLException {
		EinAus ea = null;
		String sql = "SELECT * FROM Eintrag WHERE ID_Eintrag = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			// neues Benutzerobjekt
			ea = new EinAus();
			
			// variabeln für a anhand der tabelle auslesen
			ea.setId(rs.getInt("ID_Eintrag"));
			ea.setName(rs.getString("EintragName"));
			ea.setKategorie(rs.getString("EintragKategorie"));
			ea.setBetrag(rs.getDouble("EintragBetrag"));
			ea.setDatum(rs.getDate("EintragDatum"));
			ea.setTyp(rs.getString("EintragTyp"));
			break;
		}
		// con, ps und rs schliessen
		return ea;
	}
	
	// Neuen Benutzer eintragen
	public void insertEintrag(EinAus ea, Konto k) throws SQLException {
		
		if (ea != null) {
			
			//if (!getAllId(k).contains(ea.getId())) {
				
				// Neuen Eintrag einfügen
				String sql = "INSERT INTO CASHMANAGER.Eintrag (ID_Eintrag, EintragName, EintragKategorie, EintragBetrag, EintragDatum,"
						+ "EintragTyp, Konto_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
				con = openConnection();
				ps = (PreparedStatement) con.prepareStatement(sql);
				int i = 1;
				ps.setInt(i++, ea.getId());
				ps.setString(i++, ea.getName());
				ps.setString(i++, ea.getKategorie());
				ps.setDouble(i++, ea.getBetrag());
				ps.setDate(i++, (java.sql.Date) ea.getDatum());
				ps.setString(i++, ea.getTyp());
				;
				ps.setInt(i++, k.getId());
				ps.executeUpdate();
				this.closeConnection();
			} else {
				
				// Update driver
				this.updateEintrag(ea, k);
			}
		}
//	}
	
	// Benutzer erneuern falls Daten geändert wurden
	private void updateEintrag(EinAus ea, Konto k) throws SQLException {
		if (ea != null) {
			
			if (getAllId(k).contains(ea.getId())) {
				
				String sql = "UPDATE CASHMANAGER.Eintrag SET EintragName = ?, EintragKategorie = ?, EintragBetrag = ?,"
						+ "EintragDatum = ?, EintragTyp = ?, WHERE ID_Eintrag = ?";
				con = openConnection();
				ps = (PreparedStatement) con.prepareStatement(sql);
				int i = 1;
				ps.setString(i++, ea.getName());
				ps.setString(i++, ea.getKategorie());
				ps.setDouble(i++, ea.getBetrag());
				ps.setDate(i++, (Date) ea.getDatum());
				ps.setString(i++, ea.getTyp());
				ps.setInt(i++, ea.getId());
				ps.executeUpdate();
				this.closeConnection();
				
			} else {
				this.insertEintrag(ea, k);
			}
		}
	}
	
	// Benutzer löschen
	private void deleteEintrag(EinAus ea) throws SQLException {
		String sql = "DELETE FROM CASHMANAGER.Eintrag WHERE ID_Eintrag = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, ea.getId());
		ps.executeUpdate();
		ea.setId(0);
		this.closeConnection();
	}
	
	// Alle Benutzer Abrufen
	public Collection<Integer> getAllId(Konto k) throws SQLException {
		List idList = null;
		String sql = "SELECT ID_Eintrag FROM CASHMANAGER.Eintrag WHERE Konto_ID = ?";
		con = openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, k.getId());
		rs = ps.executeQuery();
		
		if (rs.next()) {
			idList = new ArrayList<String>();
			
			do {
				idList.add(rs.getInt("ID_Eintrag"));
			} while (rs.next());
		}
		closeConnection();
		return idList;
	}
	
	// Öffnen der FactoryConnection
	private Connection openConnection() throws SQLException {
		return (Connection) ConnectionFactory.getInstance().getConnection();
	}
	
	// Schliessen der FactoryConnection
	private void closeConnection() {
		// TODO Auto-generated method stub
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			// TODO Replace by logger
			System.err.println("Error in " + getClass().getName() + ": "
					+ sqle.getMessage());
		}
	}
}
