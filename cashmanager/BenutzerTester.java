package cashmanager.cashmanager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.rendersnake.HtmlCanvas;

import cashmanager.cashmanager.dao.BenutzerJDBCDao;

public class BenutzerTester {
	
	public static void main(String[] args) {
		StringBuilder htmlBuilder = new StringBuilder();
		htmlBuilder.append("<html>");
		htmlBuilder.append("<body>");
		for(int i = 1; i<11; i++) {
		htmlBuilder.append("<p style='color: green;'>Look at my body!</p>");
		}
		htmlBuilder.append("</body>");
		
			JFrame gui = new JFrame("Hallo Coder");
			JLabel htmlinterface = new JLabel(htmlBuilder.toString());
			gui.add(htmlinterface);
			gui.setSize(300, 300);
			gui.setVisible(true);
	}
}
