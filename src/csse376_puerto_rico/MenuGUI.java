package csse376_puerto_rico;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MenuGUI {
	/**
     * Mainframe.
     */
     JFrame mainframe = new JFrame();
     
     /**
     * Constructs the Menu.
     * 
     */
     public MenuGUI() {
           this.mainframe.setTitle("Puerto Rico");
           this.mainframe.setSize(1366, 800);
           this.mainframe.setVisible(true);
           this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.mainframe.setResizable(false);
//           MigLayout layout = new MigLayout();
//   		   this.mainframe.setLayout(layout);
           
           JPanel imgPanel = new JPanel();
           JPanel buttonPanel = new JPanel();
           
           String imageLoc = "puerto-ricosmall.jpg";
           ImageIcon imageIcon = new ImageIcon(imageLoc);
           
           imgPanel.add(new JLabel(imageIcon));
           
           JButton newGame = new JButton("New Game");
           newGame.addActionListener(new ButtonHandler(mainframe, null));
           JButton quit = new JButton("Quit");
           
           buttonPanel.add(newGame);
           buttonPanel.add(quit);
           
           this.mainframe.add(imgPanel, BorderLayout.NORTH);
           this.mainframe.add(buttonPanel, BorderLayout.SOUTH);
     }

}
