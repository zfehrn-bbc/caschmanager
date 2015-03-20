package cashmanager.cashmanager;

import java.sql.SQLException;
import java.util.Scanner;

import cashmanager.cashmanager.dao.BenutzerJDBCDao;

public class BenutzerTester {
	
	static BenutzerJDBCDao benutzer = new BenutzerJDBCDao();
	
	public static void main(String[] args) {
		try {
			Benutzer ben = new Benutzer();
			ben.setId(0);
			ben.setName("Iwan");
			benutzer.insertBenutzer(ben);
			System.out.println("Eingetragen");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
