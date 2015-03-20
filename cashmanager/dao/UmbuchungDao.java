package cashmanager.cashmanager.dao;

import java.sql.SQLException;
import java.util.Collection;

import cashmanager.cashmanager.Umbuchung;
import cashmanager.cashmanager.Konto;

public interface UmbuchungDao {
	
	public static void insertUmbuchung(Umbuchung um, Konto k) throws SQLException {
		
	}
	
	public static void updateUmbuchung(Umbuchung um, Konto k) throws SQLException {
		
	}
	
	public static void deleteUmbuchung(Umbuchung um) throws SQLException {
		
	}
	
	public static Umbuchung findUmbuchungById(int id) throws SQLException {
		return null;
		
	}
	
	public static Collection<Integer> getAllId(Konto k) throws SQLException {
		return null;
		
	}
	
}
