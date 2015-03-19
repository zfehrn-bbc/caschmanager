package cashmanager.cashmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cashmanager.cashmanager.Benutzer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BenutzerJDBCDao implements BenutzerDao {
	
	private Connection				con	= null;
	private PreparedStatement	ps	= null;
	private ResultSet					rs	= null;
	
	// Beutzerid finden
	public Benutzer findBenutzerById(int id) throws SQLException {
		Benutzer b = null;
		String sql = "SELECT * FROM Benutzer WHERE ID_Adresse = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			// neues Benutzerobjekt
			b = new Benutzer();
			
			// variabeln für a anhand der tabelle auslesen
			b.setId(rs.getInt("ID_Benutzer"));
			b.setName(rs.getString("BenutzerName"));
			break;
		}
		// con, ps und rs schliessen
		return b;
	}
	
	// Neuen Benutzer eintragen
	public void insertBenutzer(Benutzer b) throws SQLException {
		
		if (b != null) {
			
			if (!getAllId().contains(b.getId())) {
				
				// Benutzer einfügen
				String sql = "INSERT INTO CASHMANAGER.Benutzer (ID_Benutzer, BenutzerName) VALUES (?, ?)";
				con = openConnection();
				ps = (PreparedStatement) con.prepareStatement(sql);
				int i = 1;
				ps.setInt(i++, b.getId());
				ps.setString(i++, b.getName());
				ps.executeUpdate();
				this.closeConnection();
			} else {
				
				// Update driver
				this.updateBenutzer(b);
			}
		}
	}
	
	// Benutzer erneuern falls Daten geändert wurden
	private void updateBenutzer(Benutzer b) throws SQLException {
		if (b != null) {
			
			if (getAllId().contains(b.getId())) {
				
				String sql = "UPDATE CASHMANAGER.Benutzer SET BenutzerName = ? WHERE ID_Benutzer = ?";
				con = openConnection();
				ps = (PreparedStatement) con.prepareStatement(sql);
				int i = 1;
				ps.setString(i++, b.getName());
				ps.executeUpdate();
				this.closeConnection();
				
			} else {
				this.insertBenutzer(b);
			}
		}
	}
	
	// Benutzer löschen
	private void deleteBenutzer(Benutzer b) throws SQLException {
		String sql = "DELETE FROM CASHMANAGER.Benutzer WHERE ID_Benutzer = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, b.getId());
		ps.executeUpdate();
		b.setId((Integer) null);
		this.closeConnection();
	}
	
	// Alle Benutzer Abrufen
	public Collection<Integer> getAllId() throws SQLException {
		List idList = null;
    String sql = "SELECT ID_Benutzer FROM CASHMANAGER.Benutzer";
    con = openConnection();
    ps = (PreparedStatement) con.prepareStatement(sql);
    rs = ps.executeQuery();

    if (rs.next()) {
      idList = new ArrayList<String>();

      do {
        idList.add(rs.getInt("ID_Benutzer"));
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
