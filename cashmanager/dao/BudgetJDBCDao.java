package cashmanager.cashmanager.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cashmanager.cashmanager.Budget;
import cashmanager.cashmanager.Konto;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BudgetJDBCDao implements BudgetDao {
	
	private Connection				con	= null;
	private PreparedStatement	ps	= null;
	private ResultSet					rs	= null;
	
	// Beutzerid finden
	public Budget findBudgetById(int id) throws SQLException {
		Budget bud = null;
		String sql = "SELECT * FROM Budget WHERE ID_Budget = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			// neues Benutzerobjekt
			bud = new Budget();
			
			// variabeln für a anhand der tabelle auslesen
			bud.setId(rs.getInt("ID_Budget"));
			bud.setName(rs.getString("BudgetName"));
			bud.setKategorie(rs.getString("BudgetKategorie"));
			bud.setBetrag(rs.getDouble("BudgetBetrag"));
			bud.setDatum(rs.getDate("BudgetDatum"));
			bud.setVonBudget(rs.getDate("VonBudget"));
			bud.setBisBudget(rs.getDate("BisBudget"));
			break;
		}
		// con, ps und rs schliessen
		return bud;
	}
	
	// Neuen Benutzer eintragen
	public void insertBudget(Budget bud, Konto k) throws SQLException {
		
		if (bud != null) {
			
			// Benutzer einfügen
			String sql = "INSERT INTO CASHMANAGER.Budget (ID_Budget, BudgetName, BudgetKategorie, BudgetBetrag, BudgetDatum,"
					+ "VonBudget, BisBudget, Konto_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			con = openConnection();
			ps = (PreparedStatement) con.prepareStatement(sql);
			int i = 1;
			ps.setInt(i++, bud.getId());
			ps.setString(i++, bud.getName());
			ps.setString(i++, bud.getKategorie());
			ps.setDouble(i++, bud.getBetrag());
			ps.setDate(i++, (Date) bud.getDatum());
			ps.setDate(i++, (Date) bud.getVonBudget());
			ps.setDate(i++, (Date) bud.getBisBudget());
			ps.setInt(i++, k.getId());
			ps.executeUpdate();
			this.closeConnection();
		} else {
			
			// Update driver
			this.updateBudget(bud, k);
		}
	}
	
	// Benutzer erneuern falls Daten geändert wurden
	private void updateBudget(Budget bud, Konto k) throws SQLException {
		if (bud != null) {
			
			if (getAllId(k).contains(bud.getId())) {
				
				String sql = "UPDATE CASHMANAGER.Budget SET BudgetName = ?, BudgetKategorie = ?, BudgetBetrag = ?,"
						+ "VonBudget = ?, BisBudget = ? WHERE ID_Budget = ?";
				con = openConnection();
				ps = (PreparedStatement) con.prepareStatement(sql);
				int i = 1;
				ps.setString(i++, bud.getName());
				ps.setString(i++, bud.getKategorie());
				ps.setDouble(i++, bud.getBetrag());
				ps.setDate(i++, (Date) bud.getVonBudget());
				ps.setDate(i++, (Date) bud.getBisBudget());
				ps.setInt(i++, bud.getId());
				ps.executeUpdate();
				this.closeConnection();
				
			} else {
				this.insertBudget(bud, k);
			}
		}
	}
	
	// Benutzer löschen
	private void deleteBudget(Budget bud) throws SQLException {
		String sql = "DELETE FROM CASHMANAGER.Budget WHERE ID_Budget = ?";
		con = this.openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, bud.getId());
		ps.executeUpdate();
		bud.setId(0);
		this.closeConnection();
	}
	
	// Alle Benutzer Abrufen
	public Collection<Integer> getAllId(Konto k) throws SQLException {
		List idList = null;
		String sql = "SELECT ID_Budget FROM CASHMANAGER.Budget WHERE Konto_ID = ?";
		con = openConnection();
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, k.getId());
		rs = ps.executeQuery();
		
		if (rs.next()) {
			idList = new ArrayList<String>();
			
			do {
				idList.add(rs.getInt("ID_Budget"));
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
