package cashmanager.cashmanager.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cashmanager.cashmanager.Umbuchung;
import cashmanager.cashmanager.Konto;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UmbuchungJDBCDao {
	
	private Connection				con	= null;
	private PreparedStatement	ps	= null;
	private ResultSet					rs	= null;
	
	// Beutzerid finden
	public Umbuchung findUmbuchungById(int id) throws SQLException {
		Umbuchung um = null;
		String sql = "SELECT * FROM Umbuchung WHERE ID_Umbuchung = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			// neues Benutzerobjekt
			um = new Umbuchung();
			
			// variabeln für a anhand der tabelle auslesen
			um.setId(rs.getInt("ID_Umbuchung"));
			um.setName(rs.getString("UmbuchungName"));
			um.setKategorie(rs.getString("UmbuchungKategorie"));
			um.setBetrag(rs.getDouble("UmbuchungBetrag"));
			um.setDatum(rs.getDate("UmbuchungDatum"));
			um.setStartkonto(rs.getString("StartUmbuchung"));
			um.setZielkonto(rs.getString("ZielUmbuchung"));
			break;
		}
		// con, ps und rs schliessen
		return um;
	}
	
	// Neuen Benutzer eintragen
	public void insertUmbuchung(Umbuchung um, Konto k) throws SQLException {
		
		if (um != null) {
			
			if (!getAllId(k).contains(um.getId())) {
				
				// Benutzer einfügen
				String sql = "INSERT INTO CASHMANAGER.Umbuchung (ID_Umbuchung, UmbuchungName, UmbuchungKategorie, UmbuchungBetrag, UmbuchungDatum,"
						+ "StartUmbuchung, ZielUmbuchung, Konto_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				con = openConnection();
				ps = (PreparedStatement) con.prepareStatement(sql);
				int i = 1;
				ps.setInt(i++, um.getId());
				ps.setString(i++, um.getName());
				ps.setString(i++, um.getKategorie());
				ps.setDouble(i++, um.getBetrag());
				ps.setDate(i++, (Date) um.getDatum());
				ps.setString(i++, um.getStartkonto());
				ps.setString(i++, um.getZielkonto());
				ps.setInt(i++, k.getId());
				ps.executeUpdate();
				this.closeConnection();
			} else {
				
				// Update driver
				this.updateUmbuchung(um, k);
			}
		}
	}
	
	// Benutzer erneuern falls Daten geändert wurden
	private void updateUmbuchung(Umbuchung um, Konto k) throws SQLException {
		if (um != null) {
			
			if (getAllId(k).contains(um.getId())) {
				
				String sql = "UPDATE CASHMANAGER.Umbuchung SET UmbuchungName = ?, UmbuchungKategorie = ?, UmbuchungBetrag = ?,"
						+ "StartUmbuchung = ?, ZielUmbuchung = ? WHERE ID_Umbuchung = ?";
				con = openConnection();
				ps = (PreparedStatement) con.prepareStatement(sql);
				int i = 1;
				ps.setString(i++, um.getName());
				ps.setString(i++, um.getKategorie());
				ps.setDouble(i++, um.getBetrag());
				ps.setString(i++, um.getStartkonto());
				ps.setString(i++, um.getZielkonto());
				ps.setInt(i++, um.getId());
				ps.executeUpdate();
				this.closeConnection();
				
			} else {
				this.insertUmbuchung(um, k);
			}
		}
	}
	
	// Benutzer löschen
	private void deleteUmbuchung(Umbuchung um) throws SQLException {
		String sql = "DELETE FROM CASHMANAGER.Umbuchung WHERE ID_Umbuchung = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, um.getId());
		ps.executeUpdate();
		um.setId(0);
		this.closeConnection();
	}
	
	// Alle Benutzer Abrufen
	public Collection<Integer> getAllId(Konto k) throws SQLException {
		List idList = null;
		String sql = "SELECT ID_Umbuchung FROM CASHMANAGER.Umbuchung WHERE Konto_ID = ?";
		con = openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, k.getId());
		rs = ps.executeQuery();
		
		if (rs.next()) {
			idList = new ArrayList<String>();
			
			do {
				idList.add(rs.getInt("ID_Umbuchung"));
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
