package csse376_puerto_rico;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
		for (int i = 0; i < numberOfPlayers; i++) {
			Player p = new Player();
			p.isGovernor = true;

			JTextArea jta = new JTextArea("Player " + (i + 1) + "\nRole: "
					+ "\nScore: " + p.getPoints());
			jta.setRows(5);
			jta.setColumns(15);
			p.setHUD(jta);
			this.players.add(p);
			this.mainframe.add(jta);

		}
		updateRoles();

		return this.players;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public String getPlayerText(int playerNum, String role, int points) {
		return String.format("Player %d \nRole: %s \nScore: %d", playerNum,
				role, points);

	}

	public void updateRoles() {
		for (int i = 0; i < this.players.size(); i++) {
			Player player = this.players.get(i);
			Object[] options = Player.getRoles().toArray();
			int n = JOptionPane.showOptionDialog(this.mainframe,
					"Choose your role!", "Player " + (i + 1),
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options,
					options[options.length - 1]);
			String role = (String) options[n];
			int points = player.getPoints();
			player.getHUD().setText(getPlayerText(i + 1, role, points));
		}
	}
}
