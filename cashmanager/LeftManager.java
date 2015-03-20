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
	
	private static JButton abschicken = new JButton("Absenden");
	private static JButton neuesKonto = new JButton("Neues Konto?");
	
	// JCOMBOBOX
	private static String[] KategorieArray = { "Essen", "Freizeit", "Ausgang",
			"Haushalt", };

	// KATEGORIE Combo Box
	protected static JComboBox kategorieBox = new JComboBox<Object>(
			KategorieArray);
	
	// JTEXTFIELDS
		protected final static JTextField ItemName = new JTextField();
		protected final static JTextField ItemBetrag = new JTextField();
		protected final JTextField ItemNameAusgabe = new JTextField();
	
	public static JPanel getContent(String name) {
		
		left.setBorder(BorderFactory.createEmptyBorder(20, 50, 450, 20));
		left.setLayout(new GridLayout(7, 2));
		// JTEXTFIELDS Einnahme
		ItemName.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		
		switch(name) {
		case "Einnahme":
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
			
		case "Umbuchung":
			
		case "Budget":
			
		}
		return left;
	}
	
	public static Component emptyLabel() {
		return new JLabel();

	}
	}
