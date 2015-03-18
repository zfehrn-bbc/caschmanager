package cashmanager.cashmanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class CashmanagerView extends JFrame {
	
	// JTABBEDPANE
	JTabbedPane														tabbedpane											= new JTabbedPane();
	
	// JPANELS
	private JPanel												mainPanel												= new JPanel();
	private JPanel												secondaryPanel									= new JPanel();
	private JPanel												left														= new JPanel();
	private JPanel												right														= new JPanel();
	
	// JSPLITPANE
	JSplitPane														split														= new JSplitPane(
																																						JSplitPane.HORIZONTAL_SPLIT,
																																						left,
																																						right);
	
	// JLABELS
	private JLabel												title														= new JLabel(
																																						"Cashmanager");
	private JLabel												welcome													= new JLabel(
																																						"Willkommen User");
	
	// JBUTTONS
	private JButton												hi															= new JButton(
																																						"Hi");
	
	// JMENU
	protected final JMenuBar							mainMenuBar											= new JMenuBar();
	
	protected final JMenu									fileMenu												= new JMenu(
																																						"Datei");
	protected final JMenu									lafMenu													= new JMenu(
																																						"Look and Feel");
	protected final JMenu									toolbarMenu											= new JMenu(
																																						"Toolbar");
	
	// Look and Feel Variabeln
	protected final ButtonGroup						lafButtonGroup									= new ButtonGroup();
	
	protected final JRadioButtonMenuItem	metalDefaultRadioButtonMenuItem	= new JRadioButtonMenuItem(
																																						"Metal Default");
	protected final JRadioButtonMenuItem	metalOceanRadioButtonMenuItem		= new JRadioButtonMenuItem(
																																						"Metal Ocean");
	protected final JRadioButtonMenuItem	motifRadioButtonMenuItem				= new JRadioButtonMenuItem(
																																						"Motif");
	protected final JRadioButtonMenuItem	windowsRadioButtonMenuItem			= new JRadioButtonMenuItem(
																																						"Windows");
	protected final JRadioButtonMenuItem	nimbusRadioButtonMenuItem				= new JRadioButtonMenuItem(
																																						"Nimbus");
	
	public static void main(String[] args) {
		CashmanagerView gui = new CashmanagerView();
		gui.setSize(1200, 800);
		gui.setVisible(true);
	}
	
	public CashmanagerView() {
		setTitle("Cashmanger");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// MainPanel adden
		this.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));		
		mainPanel.add(title, BorderLayout.CENTER);
		mainPanel.add(welcome, BorderLayout.CENTER);
		mainPanel.add(tabbedpane);
		
		// title
		title.setFont(title.getFont().deriveFont(30.0f));
		
		// create tabbedpane
		tabbedpane.add("Konto1", secondaryPanel);
		tabbedpane.add("Konto2", secondaryPanel);
		
		// split settings
		split.setContinuousLayout(true);
		split.setOneTouchExpandable(true);
		
		// secondaryPanel
		secondaryPanel.add(split);
		
		// split
		
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
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | UnsupportedLookAndFeelException e) {
				}
			}
		});
		
		metalOceanRadioButtonMenuItem.setSelected(true);
		metalOceanRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					MetalLookAndFeel.setCurrentTheme(new OceanTheme());
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | UnsupportedLookAndFeelException e) {
				}
			}
		});
		
		motifRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | UnsupportedLookAndFeelException e) {
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
						| IllegalAccessException | UnsupportedLookAndFeelException e) {
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
						| IllegalAccessException | UnsupportedLookAndFeelException e) {
				}
			}
		});
	}
}