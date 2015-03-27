package csse376_puerto_rico;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoardGUI {

	private JFrame mainframe;

	public GameBoardGUI(JFrame frame) {
		this.mainframe = frame;
		this.mainframe.getContentPane().removeAll();
		this.mainframe.getContentPane().revalidate();
		this.mainframe.setBackground(Color.BLACK);
		this.mainframe.setTitle("Your Adventure");

		JPanel mainPanel = new JPanel();
		
		String image = "sample.jpg";
		JLabel imageLabel = new JLabel(new ImageIcon(image));
		
		mainPanel.add(imageLabel);
		
		this.mainframe.add(mainPanel);
	}

}
