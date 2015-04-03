package csse376_puerto_rico;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

public class GameBoardGUI {

	private JFrame mainframe;
	private List<Player> players;
	private ButtonGroup bGroup;

	public GameBoardGUI(JFrame frame, ButtonGroup group) {
		this.players = new ArrayList<Player>();
		this.mainframe = frame;
		this.bGroup = group;

		this.mainframe.getContentPane().removeAll();
		this.mainframe.getContentPane().revalidate();
		this.mainframe.setBackground(Color.GREEN);
		this.mainframe.setTitle("Puerto Rico");
		MigLayout layout = new MigLayout();
		this.mainframe.setLayout(layout);

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
	}
	
	public List<Player> addPlayers(int numberOfPlayers) {
		for(int i = 0; i < numberOfPlayers; i++){
			Player p = new Player();
			String role = p.getRoles().get(i);
			p.setRole(role);
			this.players.add(p);
			
			JTextArea jta = new JTextArea("Player "+(i+1)+"\nRole: "+p.getRole()+"\nScore: "+p.getPoints());
			jta.setRows(5);
			jta.setColumns(15);
						
			this.mainframe.add(jta);
			this.mainframe.add(p);
//			this.mainframe.update(this.mainframe.getGraphics());
		}
		return this.players;
	}

	public List<Player> getPlayers(){
		return this.players;
	}

}
