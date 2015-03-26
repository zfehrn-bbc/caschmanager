package cashmanager.cashmanager.dao;

import java.sql.SQLException;
import java.util.Collection;

import cashmanager.cashmanager.EinAus;
import cashmanager.cashmanager.Konto;

public interface EintragDao {
	
public static void insertEintrag(EinAus ea, Konto k) throws SQLException {
		
	}
	
	public static void updateEintrag(EinAus ea, Konto k) throws SQLException {
		
	}
	
	public static void deleteEintrag(EinAus ea) throws SQLException {
		
	}
	
	public static EinAus findEintragById(int id) throws SQLException {
		return null;
	}
	
	public static Collection<Integer> getAllId(Konto k) throws SQLException {
		return null;
		
	}
}
