package cashmanager.cashmanager.dao;

import java.sql.SQLException;
import java.util.Collection;

import cashmanager.cashmanager.EinAus;
import cashmanager.cashmanager.Konto;

public interface EintragDao {
	
public static void insertEinAus(EinAus ea, Konto k) throws SQLException {
		
	}
	
	public static void updateEinAus(EinAus ea, Konto k) throws SQLException {
		
	}
	
	public static void deleteEinAus(EinAus ea) throws SQLException {
		
	}
	
	public static EinAus findEinAusById(int id) throws SQLException {
		return null;
	}
	
	public static Collection<Integer> getAllId(Konto k) throws SQLException {
		return null;
		
	}
}
