package cashmanager.cashmanager;

import java.sql.SQLException;
import java.util.Scanner;

import cashmanager.cashmanager.dao.BenutzerJDBCDao;

public class BenutzerTester {
	
	static BenutzerJDBCDao benutzer = new BenutzerJDBCDao();
	
	public static void main(String[] args) {
		try {
			Benutzer b = benutzer.findBenutzerById(1);
			System.out.println(b.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
