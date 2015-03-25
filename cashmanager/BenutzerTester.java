package cashmanager.cashmanager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

import cashmanager.cashmanager.dao.BenutzerJDBCDao;

public class BenutzerTester {
	
	static BenutzerJDBCDao benutzer = new BenutzerJDBCDao();
	
	private static Collection<Integer>	list;
	
	public static void main(String[] args) {
		try {
			Benutzer ben = new Benutzer();
			ben.setId(0);
			ben.setName("Peterli");
			benutzer.insertBenutzer(ben);
			System.out.println("Eingetragen");
			
			list = benutzer.getAllId();
			for (int l : list) {
				Benutzer b = benutzer.findBenutzerById(l);
				System.out.println(b.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
