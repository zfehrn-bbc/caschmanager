package cashmanager.cashmanager;

import java.awt.GridLayout;

import javax.swing.JButton;

public class LeftManager{
    GridLayout layout = new GridLayout(1, 2);
    this.setLayout(layout);
    this.setSize(700, 700);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    buttonPanel = new JPanel();
    buttonPanel.setSize(new Dimension(30, 100));

    JButton rectButton = new JButton("Rectangle");
    JButton ovalButton = new JButton("Oval");
    buttonPanel.add(rectButton);
    buttonPanel.add(ovalButton);
    this.add(buttonPanel);
    this.add(new PaintSurface());
    this.setVisible(true);  
}
}