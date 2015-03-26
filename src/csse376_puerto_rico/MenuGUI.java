package csse376_puerto_rico;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGUI {
	/**
     * Mainframe.
     */
     JFrame mainframe = new JFrame();
     
     /**
     * Constructs the Start up screen.
     * 
     */
     public MenuGUI() {
           this.mainframe.setTitle("Puerto Rico");
           this.mainframe.setSize(1366, 800);
           this.mainframe.setVisible(true);
           this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.mainframe.setResizable(false);
           
           JPanel imgPanel = new JPanel();
           JPanel buttonPanel = new JPanel();
           
           String image = "puerto-rico.jpg";
           imgPanel.add(new JLabel(new ImageIcon(image)));
           
           JButton newGame = new JButton("New Game");
           newGame.addActionListener(new ButtonHandler(mainframe));
           JButton quit = new JButton("Quit");
           
           buttonPanel.add(newGame);
           buttonPanel.add(quit);
           
           this.mainframe.add(imgPanel, BorderLayout.NORTH);
           this.mainframe.add(buttonPanel, BorderLayout.SOUTH);
     }

}
