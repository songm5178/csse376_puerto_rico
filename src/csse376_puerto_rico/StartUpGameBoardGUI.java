package csse376_puerto_rico;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class StartUpGameBoardGUI {

	private JFrame mainframe;

	public StartUpGameBoardGUI(JFrame frame) {
		this.mainframe = frame;
		this.mainframe.getContentPane().removeAll();
		this.mainframe.getContentPane().revalidate();
		this.mainframe.setBackground(Color.BLACK);
		this.mainframe.setTitle("Choose Players");

		JPanel mainPanel = new JPanel();
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton rb3 = new JRadioButton("3", true);
		JRadioButton rb4 = new JRadioButton("4", false);
		JRadioButton rb5 = new JRadioButton("5", false);
		group.add(rb3);
		group.add(rb4);
		group.add(rb5);
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ButtonHandler(this.mainframe, group));
		
		mainPanel.add(rb3);
		mainPanel.add(rb4);
		mainPanel.add(rb5);
		mainPanel.add(startButton);
		
		this.mainframe.add(mainPanel);
	}

}
