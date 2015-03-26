package cashmanager.cashmanager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewKontoView extends JFrame {
	
	public NewKontoView() {
		KontoUI();
	}
	
	public static void main(String[] args) {
		NewKontoView gui = new NewKontoView();
		gui.setSize(300, 400);
		gui.setMinimumSize(new Dimension(400, 250));
		gui.setVisible(true);
		gui.pack();
	}
	
	private void KontoUI() {
		JLabel kontonameLabel;
		JTextField nameTextfield;
		JLabel kontostandLabel;
		JTextField kontostandTextfield;
		JLabel typLabel;
		JComboBox typBox;
		JLabel jcomp7;
		JButton newkontoButton;
		
		// construct preComponents
		String[] typBoxItems = { "Sparkonto", "Girokonto" };
		
		// construct components
		kontonameLabel = new JLabel("Name");
		nameTextfield = new JTextField(5);
		kontostandLabel = new JLabel("Kontostand");
		kontostandTextfield = new JTextField(5);
		typLabel = new JLabel("Typ des Kontos");
		typBox = new JComboBox(typBoxItems);
		jcomp7 = new JLabel("");
		newkontoButton = new JButton("Konto erstellen");
		
		// set components properties
		nameTextfield.setToolTipText("Name des Kontos");
		kontostandTextfield.setToolTipText("Kontostand des Kontos");
		typLabel.setToolTipText("Bsp. Sparkonto");
		typBox.setToolTipText("Typ des Kontos auswählen");
		newkontoButton.setToolTipText("Mit diesem Knopf ein neues Konto erstellen");
		
		// adjust size and set layout
		setPreferredSize(new Dimension(400, 250));
		BorderLayout layout = new BorderLayout();
		setLayout(layout);	
		
		JPanel all = new JPanel(new GridLayout(4, 2, 43, 21));
		
		// add components
		all.add(kontonameLabel);
		all.add(nameTextfield);
		all.add(kontostandLabel);
		all.add(kontostandTextfield);
		all.add(typLabel);
		all.add(typBox);
		all.add(jcomp7);
		all.add(newkontoButton);
		add(new JPanel(), BorderLayout.NORTH);
		add(new JPanel(), BorderLayout.WEST);
		add(new JPanel(), BorderLayout.SOUTH);
		add(new JPanel(), BorderLayout.EAST);
		add(all, BorderLayout.CENTER);
		setSize(400, 250);
		setTitle("Neues Konto anlegen");
		setVisible(true);
	}
}