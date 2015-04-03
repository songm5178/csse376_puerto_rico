package csse376_puerto_rico;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoardGUI {

	private JFrame mainframe;
	private List<Player> players;
	private ButtonGroup bGroup;

	public GameBoardGUI(JFrame frame, ButtonGroup group) {
		this.mainframe = frame;
		this.mainframe.getContentPane().removeAll();
		this.mainframe.getContentPane().revalidate();
		this.mainframe.setBackground(Color.BLACK);
		this.mainframe.setTitle("Your Adventure");
		JPanel mainPanel = new JPanel();

		this.bGroup = group;
		ButtonModel select = this.bGroup.getSelection();
		
		String image = "sample.jpg";
		JLabel imageLabel = new JLabel(new ImageIcon(image));
		
		mainPanel.add(imageLabel);
		
		this.mainframe.add(mainPanel);
		
		this.players = new ArrayList<Player>();
	}
	
	public List<Player> getPlayers(){
		return this.players;
	}

}
