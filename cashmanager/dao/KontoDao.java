package cashmanager.cashmanager.dao;

import java.sql.SQLException;
import java.util.Collection;

import cashmanager.cashmanager.Benutzer;
import cashmanager.cashmanager.Konto;

public interface KontoDao {
	
	public static void insertKonto(Konto k, Benutzer b) throws SQLException {
		
	}
	
	public static void updateKonto(Konto k, Benutzer b) throws SQLException {
		
	}
	
	public static void deleteKonto(Konto k) throws SQLException {
		
	}
	
	public static Konto findKontobyId(int id) throws SQLException {
		return null;
		
	}
	
	public static Collection<Integer> getAllId(Benutzer b) throws SQLException {
		return null;
		
	}
	
}
