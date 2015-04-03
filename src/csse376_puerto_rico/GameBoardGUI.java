package csse376_puerto_rico;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

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
		String temp = "0";
		for (Enumeration<AbstractButton> buttons = this.bGroup.getElements(); buttons
				.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				temp = button.getText();
			}
		}
		int numberPlayers = Integer.parseInt(temp);
		
		this.addPlayers(numberPlayers);
		
		this.mainframe.add(mainPanel);
		
		this.players = new ArrayList<Player>();
	}
	
	public List<Player> addPlayers(int numberOfPlayers) {
		List<Player> answ = new ArrayList<Player>();
		answ.add(new Player("a"));
		answ.add(new Player("b"));
		answ.add(new Player("c"));
		System.out.println(answ.size());
		return answ;
	}

	public List<Player> getPlayers(){
		return this.players;
	}

}
