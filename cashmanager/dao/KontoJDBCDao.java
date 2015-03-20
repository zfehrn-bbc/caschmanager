package cashmanager.cashmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cashmanager.cashmanager.Benutzer;
import cashmanager.cashmanager.Konto;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class KontoJDBCDao {
	
	private Connection				con	= null;
	private PreparedStatement	ps	= null;
	private ResultSet					rs	= null;
	
	// Beutzerid finden
	public Konto findKontoById(int id) throws SQLException {
		Konto k = null;
		String sql = "SELECT * FROM Konto WHERE ID_Konto = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			// neues Benutzerobjekt
			k = new Konto();
			
			// variabeln für a anhand der tabelle auslesen
			k.setId(rs.getInt("ID_Konto"));
			k.setName(rs.getString("KontoName"));
			k.setTyp(rs.getString("KontoTyp"));
			k.setKontostand(rs.getDouble("KontoStand"));
			break;
		}
		// con, ps und rs schliessen
		return k;
	}
	
	// Neuen Benutzer eintragen
	public void insertKonto(Konto k, Benutzer b) throws SQLException {
		
		if (k != null) {
			
			if (!getAllId(b).contains(k.getId())) {
				
				// Benutzer einfügen
				String sql = "INSERT INTO CASHMANAGER.Konto (ID_Konto, KontoName, KontoTyp, Benutzer_ID, KontoStand) VALUES (?, ?, ?, ?, ?)";
				con = openConnection();
				ps = (PreparedStatement) con.prepareStatement(sql);
				int i = 1;
				ps.setInt(i++, k.getId());
				ps.setString(i++, k.getName());
				ps.setString(i++, k.getTyp());
				ps.setInt(i++, b.getId());
				ps.setDouble(i++, k.getKontostand());
				ps.executeUpdate();
				this.closeConnection();
			} else {
				
				// Update driver
				this.updateKonto(k, b);
			}
		}
	}
	
	// Benutzer erneuern falls Daten geändert wurden
	private void updateKonto(Konto k, Benutzer b) throws SQLException {
		if (k != null) {
			
			if (getAllId(b).contains(k.getId())) {
				
				String sql = "UPDATE CASHMANAGER.Konto SET KontoName = ?, KontoTyp = ?, KontoStand = ?, WHERE ID_Konto = ?";
				con = openConnection();
				ps = (PreparedStatement) con.prepareStatement(sql);
				int i = 1;
				ps.setString(i++, k.getName());
				ps.setString(i++, k.getTyp());
				ps.setDouble(i++, k.getKontostand());
				ps.setInt(i++, k.getId());
				ps.executeUpdate();
				this.closeConnection();
				
			} else {
				this.insertKonto(k, b);
			}
		}
	}
	
	// Benutzer löschen
	private void deleteKonto(Konto k) throws SQLException {
		String sql = "DELETE FROM CASHMANAGER.Konto WHERE ID_Konto = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, k.getId());
		ps.executeUpdate();
		k.setId(0);
		this.closeConnection();
	}
	
	// Alle Benutzer Abrufen
	public Collection<Integer> getAllId(Benutzer b) throws SQLException {
		List idList = null;
    String sql = "SELECT ID_Konto FROM CASHMANAGER.Konto WHERE Benutzer_ID = ?";
    con = openConnection();
    ps = (PreparedStatement) con.prepareStatement(sql);
    ps.setInt(1, b.getId());
    rs = ps.executeQuery();

    if (rs.next()) {
      idList = new ArrayList<String>();

      do {
        idList.add(rs.getInt("ID_Konto"));
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
