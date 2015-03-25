package cashmanager.cashmanager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

public class CashmanagerView extends JFrame {

	// JTABBEDPANE
	JTabbedPane tabbedpane = new JTabbedPane();

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof JTabbedPane) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			System.out.println("Selected paneNo : " + pane.getSelectedIndex());
		}
	}

	// leftsplit
	private static JPanel left = new JPanel(new GridLayout(2, 4));

	// JPANELS
	private JPanel mainPanel = new JPanel();
	private JPanel titlePanel = new JPanel(new GridLayout(2, 1));
	private JPanel secondaryPanel = new JPanel();
	private JPanel right = new JPanel();
	private JPanel all = new JPanel();
	private JPanel bottom = new JPanel();

	// JSPLITPANE
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);

	// JCALENDERBUTTONS
	protected JCalendarButton fromCalendarButton;
	protected JCalendarButton untilCalendarButton;
	protected final JLabel fromDateLabel = new JLabel();
	protected final JLabel untilDateLabel = new JLabel();

	// JLABELS
	private JLabel title = new JLabel("Cashmanager");

	// Layout

	// JBUTTONS
	private JButton abschicken = new JButton("Absenden");
	private JButton neuesKonto = new JButton("Neues Konto?");

	// JCOMBOBOX
	private String[] KategorieArray = { "Essen", "Freizeit", "Ausgang",
			"Haushalt", };
	private String[] KategorieArray2 = { "Essen", "Freizeit", "Ausgang",
			"Haushalt", };
	private String[] KategorieArray3 = { "Konto1", "Konto2", };
	private String[] KategorieArray4 = { "Konto1", "Konto2", };

	// KATEGORIE Combo Box
	protected JComboBox kategorieBox = new JComboBox<Object>(KategorieArray);
	protected JComboBox kategorieBox2 = new JComboBox<Object>(KategorieArray2);
	protected JComboBox kategorieBox3 = new JComboBox<Object>(KategorieArray3);
	protected JComboBox kategorieBox4 = new JComboBox<Object>(KategorieArray4);

	// JTEXTFIELDS
	protected final JTextField ItemName = new JTextField();
	protected final JTextField ItemName2 = new JTextField();
	protected final JTextField von = new JTextField();
	protected final JTextField bis = new JTextField();
	protected final JTextField ItemBetrag = new JTextField();
	protected final JTextField ItemBetrag2 = new JTextField();
	protected final JTextField ItemNameAusgabe = new JTextField();

	// JMENU
	protected final JMenuBar mainMenuBar = new JMenuBar();

	protected final JMenu fileMenu = new JMenu("Datei");
	protected final JMenu lafMenu = new JMenu("Look and Feel");
	protected final JMenu toolbarMenu = new JMenu("Toolbar");

	// Look and Feel Variabeln
	protected final ButtonGroup lafButtonGroup = new ButtonGroup();

	protected final JRadioButtonMenuItem metalDefaultRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Metal Default");
	protected final JRadioButtonMenuItem metalOceanRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Metal Ocean");
	protected final JRadioButtonMenuItem motifRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Motif");
	protected final JRadioButtonMenuItem windowsRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Windows");
	protected final JRadioButtonMenuItem nimbusRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Nimbus");

	public static void main(String[] args) {
		CashmanagerView gui = new CashmanagerView();
		gui.setSize(1000, 700);
		gui.setMinimumSize(new Dimension(1000, 700));
		gui.setVisible(true);
		gui.pack();
	}

	public CashmanagerView() {
		setTitle("Cashmanger");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// MainPanel adden
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		mainPanel.add(tabbedpane);

		// Tabbedpane
		tabbedpane.add("Konto", secondaryPanel);

		// TitlePanel
		titlePanel.setLayout(new GridLayout(2, 1));
		titlePanel.add(title);
		titlePanel.add(new JLabel("Willkommen " + this.getName()));

		// title
		title.setFont(title.getFont().deriveFont(30.0f));

		// split settings
		split.setContinuousLayout(true);
		split.setPreferredSize(new Dimension(1000, 500));

		// secondaryPanel
		secondaryPanel.setLayout(new BorderLayout());
		secondaryPanel.add(split, BorderLayout.CENTER);
		secondaryPanel.add(new JLabel("Kontostand: " + this.getName()),
				BorderLayout.NORTH);

		// Toolbar
		final JCheckBoxMenuItem toolbarCheckBoxMenuItem = new JCheckBoxMenuItem(
				"Toolbar anzeigen");
		toolbarMenu.add(toolbarCheckBoxMenuItem);

		// Datei
		final Icon exitImageIcon = loadIcon("exit_large.png");
		final Icon printImageIcon = loadIcon("printer.png");
		final Icon neuesKontoImageIcon = loadIcon("add.png");

		// JMenuItem
		final JMenuItem exitMenuItem = new JMenuItem("Verlassen", exitImageIcon);
		final JMenuItem printMenuItem = new JMenuItem("Drucken",printImageIcon);
		final JMenuItem newkontoItem = new JMenuItem("Neues Konto?", neuesKontoImageIcon);
		
		// Add to fileMenu
		fileMenu.add(exitMenuItem);
		fileMenu.add(printMenuItem);
		fileMenu.add(newkontoItem);
		
		//Menu item 'Neues Konto?'
		newkontoItem.setMnemonic(KeyEvent.VK_K);
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,
				ActionEvent.CTRL_MASK));
		exitMenuItem.addActionListener(new NewKontoListener(this));

		// Menu item 'exit'
		exitMenuItem.setMnemonic(KeyEvent.VK_C);
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));
		exitMenuItem.addActionListener(new ExitListener(this));

		// Menu item 'print'
		printMenuItem.setMnemonic(KeyEvent.VK_P);
		printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				ActionEvent.CTRL_MASK));
		printMenuItem.addActionListener(new PrintListener(this));

		// Radio Buttons: Typecontrols

		JPanel typecontrols = new JPanel(new FlowLayout(1));
		JRadioButton einnahme = (JRadioButton) typecontrols
				.add(new JRadioButton("Einnahme"));
		JRadioButton ausgabe = (JRadioButton) typecontrols
				.add(new JRadioButton("Ausgabe"));
		JRadioButton budget = (JRadioButton) typecontrols.add(new JRadioButton(
				"Budget"));
		JRadioButton umbuchung = (JRadioButton) typecontrols
				.add(new JRadioButton("Umbuchung"));
		add(typecontrols, BorderLayout.NORTH);

		// zweites formular
		JPanel form2 = new JPanel(new GridLayout(0, 2));
		form2.setBorder(BorderFactory.createTitledBorder("Ausgabe,Einnahme"));
		form2.add(new JLabel("Name"), BorderLayout.CENTER);
		form2.add(ItemName2);
		form2.add(new JLabel("Kategorie"));
		form2.add(kategorieBox2);
		form2.add(new JLabel("Betrag"));
		form2.add(ItemBetrag2);
		form2.add(new JLabel("Datum"));
		form2.add(new JCalendarButton());

		// drittes formular
		JPanel Abstand = new JPanel();
		JPanel form3 = new JPanel(new GridLayout(0, 2));
		form3.setBorder(BorderFactory.createTitledBorder("Wenn Budget"));
		form3.add(new JLabel("Von:"));
		form3.add(new JCalendarButton());
		form3.add(new JLabel("Bis:"));
		form3.add(new JCalendarButton());
		form3.add(Abstand, BorderLayout.SOUTH);

		// viertes formular
		JPanel form4 = new JPanel(new GridLayout(0, 2));
		JPanel Abstand2 = new JPanel();
		form4.setBorder(BorderFactory.createTitledBorder("Wenn Umbuchung"));
		form4.add(new JLabel("Startkonto:"));
		form4.add(kategorieBox3);
		form4.add(new JLabel("Zielkonto:"));
		form4.add(kategorieBox4);
		form4.add(Abstand2, BorderLayout.SOUTH);

		// Action event
		ActionListener sliceActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton aButton = (AbstractButton) actionEvent
						.getSource();
				System.out.println("Selected: " + aButton.getText());
			}
		};

		// JRadioButtons Actionlistener
		einnahme.addActionListener(sliceActionListener);
		ausgabe.addActionListener(sliceActionListener);
		budget.addActionListener(sliceActionListener);
		umbuchung.addActionListener(sliceActionListener);

		ButtonGroup group = new ButtonGroup();
		group.add(einnahme);
		group.add(ausgabe);
		group.add(budget);
		group.add(umbuchung);

		// Panel für linke seite für formular
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
		all.add(form2);
		all.add(form3);
		all.add(form4);

		// JPanel Bottom
		bottom.add(abschicken);
		bottom.add(neuesKonto);

		// splitleft
		left.setLayout(new BorderLayout());
		left.add(typecontrols, BorderLayout.NORTH);
		left.add(all, BorderLayout.CENTER);
		left.add(bottom, BorderLayout.SOUTH);

		// splitright
		right.setLayout(new GridLayout(0, 1));
		right.setMinimumSize(new Dimension(500, 50));

		// Add radio button menu items to button group
		lafButtonGroup.add(metalDefaultRadioButtonMenuItem);
		lafButtonGroup.add(metalOceanRadioButtonMenuItem);
		lafButtonGroup.add(windowsRadioButtonMenuItem);
		lafButtonGroup.add(motifRadioButtonMenuItem);
		lafButtonGroup.add(nimbusRadioButtonMenuItem);

		// Add radio button menu items to menu 'laf'
		lafMenu.add(metalDefaultRadioButtonMenuItem);
		lafMenu.add(metalOceanRadioButtonMenuItem);
		lafMenu.add(windowsRadioButtonMenuItem);
		lafMenu.add(motifRadioButtonMenuItem);
		lafMenu.add(nimbusRadioButtonMenuItem);

		mainMenuBar.add(fileMenu);
		mainMenuBar.add(lafMenu);
		mainMenuBar.add(toolbarMenu);

		// Menu Bar
		setJMenuBar(mainMenuBar);

		// Configure laf radio button menu items
		metalDefaultRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
					UIManager
							.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});

		metalOceanRadioButtonMenuItem.setSelected(true);
		metalOceanRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					MetalLookAndFeel.setCurrentTheme(new OceanTheme());
					UIManager
							.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});

		motifRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swilb ng.plaf.motif.MotifLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});

		windowsRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});

		nimbusRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});
	}

	private static Icon loadIcon(String iconName) {
		final URL resource = CashmanagerView.class.getResource("/images/"
				+ iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println("Error in " + CashmanagerView.class.getName()
					+ ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

	public static Component emptyLabel() {
		return new JLabel();

	}
};
