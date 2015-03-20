package cashmanager.cashmanager.dao;

import java.sql.SQLException;
import java.util.Collection;

import cashmanager.cashmanager.Budget;
import cashmanager.cashmanager.Konto;

public interface BudgetDao {
	
public static void insertBudget(Budget bud, Konto k) throws SQLException {
		
	}
	
	public static void updateBudget(Budget bud, Konto k) throws SQLException {
		
	}
	
	public static void deleteBudget(Budget bud) throws SQLException {
		
	}
	
	public static Budget findBudgetById(int id) throws SQLException {
		return null;
		
	}
	
	public static Collection<Integer> getAllId(Konto k) throws SQLException {
		return null;
		
	}
	
}
