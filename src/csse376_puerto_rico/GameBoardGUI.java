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
	public static List<Player> players;
	public static ArrayList<JPanel> playerCards;
	private ButtonGroup bGroup;
	private static int turnCount;

	public GameBoardGUI(JFrame frame, ButtonGroup group) {
		this.players = new ArrayList<Player>();
		this.mainframe = frame;
		this.bGroup = group;
		NextMoveButton nextMove = new NextMoveButton();
		nextMove.setText("Turn "+turnCount);
		this.mainframe.getContentPane().removeAll();
		this.mainframe.getContentPane().revalidate();
		this.mainframe.setBackground(Color.GREEN);
		this.mainframe.setTitle("Puerto Rico");
		this.mainframe.add(nextMove);
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

	/**
	 * This method allows us to add the space on the game board for buildings and goods to
	 * be placed. It also gives a list of these "cards" so they can be accessed later.
	 * 
	 * @param numberPlayers
	 * @return an arrayList of the buildingSpaces that are JPanels
	 */
	public ArrayList<JPanel> addPlayerCards(int numberPlayers) {
		ArrayList<JPanel> playerSpaces = new ArrayList<JPanel>();
		for(int i = 0; i < numberPlayers; i++){
			JPanel buildingSpace = new JPanel();
			MigLayout layout = new MigLayout();
			buildingSpace.setLayout(layout);
			buildingSpace.setBackground(Color.BLACK);
			playerSpaces.add(buildingSpace);
			this.mainframe.add(buildingSpace, "cell "+i+" 2, w 165!, h 200!");
		}
		this.playerCards = playerSpaces;
		return playerSpaces;
	}

	public List<Player> addPlayers(int numberOfPlayers) {
		this.addPlayerCards(numberOfPlayers);
		for (int i = 0; i < numberOfPlayers; i++) {
			Player p = new Player();
			if (i == 0) {
				p.isGovernor = true;
			}
			JTextArea jta = new JTextArea("Player " + (i + 1) + "\nRole: "
					+ "\nScore: " + p.getPoints() + "\nBuildings:" + p.getBuildings() + "\nPlantations:");
			jta.setRows(5);
			jta.setColumns(15);
			p.setHUD(jta);
			this.players.add(p);
			this.mainframe.add(jta, "cell "+i+" 1");

		}
		updateRoles();

		return this.players;
	}

	public List<Player> getPlayers() {
		return this.players;
	}
	
	public static int getTurnCount()
	{
		return turnCount;
	}

	public String getPlayerText(int playerNum, String role, int points, 
			String building, String plantation, boolean isGovernor) {
		String rtn = null;
		if (isGovernor) {
			rtn = String.format("Player %d \nRole: %s \nScore: %d \nBuilding: %s \nPlantation: %s \nGovernor",
					playerNum, role, points, building, plantation);

		} else {
			rtn = String.format("Player %d \nRole: %s \nScore: %d \nBuilding: %s \nPlantation: %s", playerNum,
					role, points, building, plantation);

		}
		return rtn;
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
			StringBuilder buildingList = new StringBuilder();
			StringBuilder plantationList = new StringBuilder();
			for (String s : player.getBuildings())
			{
				buildingList.append(s + ", ");
			}
			for (String s : player.getGoods())
			{
				plantationList.append(s + ", ");
			}
			String role = (String) options[n];
			int points = player.getPoints();
			player.getHUD().setText(
					getPlayerText(i + 1, role, points, buildingList.toString(), plantationList.toString(), player.isGovernor));
		}
	}
}
