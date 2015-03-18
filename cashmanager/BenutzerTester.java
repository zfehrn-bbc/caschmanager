package cashmanager.cashmanager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BenutzerTester {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out
				.println("Willkommen beim Cashmanager\n*****************************\n");
		System.out.println("Gib deinen Namen ein: ");
		String name = in.nextLine();
		
		Benutzer b = new Benutzer();
		b.setName(name);
		System.out.println("\nHallo: " + b.getName());
		
		System.out.println("Lege ein neues Konto an, wie soll es heissen?");
		String kontoname = in.nextLine();
		b.setName(kontoname);
		System.out.println("Dein Konto heisst " +b.getName ());
		
		System.out.println("Bitte gib dein momentanes Budget ein");
		String budget = in.nextLine();
		b.setName(budget);
		System.out.println("Dein Budget beträgt: "+ b.getName()) ;
		
		System.out.println("Was möchtest du tun? E = Geldeinnahme A = Geldausgabe ");
		String Eingabe = in.nextLine();
		b.setName(Eingabe);
		 switch (Eingabe){
			 case "E": {
				 System.out.println("Wie viel Geld möchtest du zu deinem Konto hinzufügen?");
			 }
			 case "A": {
				 System.out.println("Wie viel Geld hast du ausgeben?");
			 }
		}
	}
}
