package cashmanager.cashmanager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftManager {

	private static JPanel left = new JPanel(new GridLayout(2, 4));
	private static JPanel left2 = new JPanel(new GridLayout(2, 4));
	private static JPanel left3 = new JPanel(new GridLayout(2, 4));
	private static JPanel left4 = new JPanel(new GridLayout(2, 4));
	

	
	public static JPanel getContent(String name) {	
		
		// JTEXTFIELDS Einnahme
		ItemName.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		
		switch(name) {
		case "Einnahme":
			left.setBorder(BorderFactory.createEmptyBorder(20, 50, 450, 20));
			left.setLayout(new GridLayout(7, 2));
			left.add(new JLabel("Name"), BorderLayout.CENTER);
			left.add(ItemName);
			left.add(new JLabel("Kategorie"));
			left.add(kategorieBox);
			left.add(new JLabel("Betrag"));
			left.add(ItemBetrag);
			left.add(new JLabel("Datum"));
			left.add(emptyLabel());
			left.add(emptyLabel());
			left.add(abschicken);
			left.add(emptyLabel());
			left.add(emptyLabel());
			left.add(emptyLabel());
			left.add(neuesKonto);
			return left;
		case "Ausgabe":
			
			left2.add(new JLabel("Name"), BorderLayout.CENTER);
			left2.add(ItemName2);
			left2.add(new JLabel("Kategorie"), BorderLayout.CENTER);
			left2.add(kategorieBox);
			left2.add(new JLabel("Betrag"));
			left2.add(ItemName2);
			
			return left2;
		case "Umbuchung":
				
		case "Budget":
				
		}
		return null;
	}
	
	public static Component emptyLabel() {
		return new JLabel();

	}
	}
