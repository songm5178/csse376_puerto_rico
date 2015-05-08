package csse376_puerto_rico;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import csse376_puerto_rico.Buildings.Building;

public class GameBoardGUI {

	private JFrame mainframe;
	public static List<Player> players;
	public static JTextArea msgBar;
	// public static ArrayList<JPanel> playerCards;
	private ButtonGroup bGroup;
	private static int turnCount;
	private GameState gameState;

	public GameBoardGUI() {
		// For testing purposes.
		this.msgBar = new JTextArea();
		this.players = new ArrayList<Player>();
		this.mainframe = new JFrame();
		this.gameState = new GameState();
	}

	public GameBoardGUI(JFrame frame, ButtonGroup group) {
		this.players = new ArrayList<Player>();
		this.mainframe = frame;
		this.mainframe.setTitle("Puerto Rico");
		this.mainframe.getContentPane().removeAll();
		this.mainframe.getContentPane().revalidate();
		this.mainframe.setBackground(Color.GREEN);
		MigLayout layout = new MigLayout();
		this.mainframe.setLayout(layout);
		this.bGroup = group;
		this.msgBar = new JTextArea();
		this.gameState = new GameState();

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

	private void displayMessageBar() {
		msgBar.setColumns(90);
		this.mainframe.add(msgBar, "cell 0 0, span " + this.players.size());
	}

	private void addGoodsButtons() {
		GoodsButton CoffeeButton = new GoodsButton("Coffee", this);
		GoodsButton CornButton = new GoodsButton("Corn", this);
		GoodsButton TobaccoButton = new GoodsButton("Tobacco", this);
		GoodsButton IndigoButton = new GoodsButton("Indigo", this);
		GoodsButton SugarButton = new GoodsButton("Sugar", this);
		this.mainframe.add(CoffeeButton, "cell 0 2");
		this.mainframe.add(CornButton, "cell 0 2");
		this.mainframe.add(TobaccoButton, "cell 0 2");
		this.mainframe.add(SugarButton, "cell 0 2");
		this.mainframe.add(IndigoButton, "cell 0 2");
	}

	public List<Player> addPlayers(int numberOfPlayers) {
		// this.addPlayerCards(numberOfPlayers);
		for (int i = 0; i < numberOfPlayers; i++) {
			Player p = new Player();
			if (i == 0) {
				p.isGovernor = true;
			}
			p.setPlayerNum(i);
			JTextArea jta = new JTextArea("Player " + i + "\nRole: "
					+ "\nScore: " + p.getPoints() + "\nBuildings:"
					+ p.getBuildingsStringList() + "\nPlantations:\n");
			jta.setRows(15);
			jta.setColumns(15);
			p.setHUD(jta);
			this.players.add(p);
			this.mainframe.add(jta, "cell " + i + " 1");

		}
		displayMessageBar();
		addGoodsButtons();
		updateRoles();

		return this.players;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public static int getTurnCount() {
		return turnCount;
	}

	// Will be deleted
	@Deprecated
	public String getPlayerText(int playerNum, String role, int points,
			String buildingList, String plantationList, boolean isGovernor) {
		String rtn = null;
		if (isGovernor) {
			rtn = String
					.format("Player %d \nRole: %s \nScore: %d \nBuilding: %s \nPlantation: %s \nGovernor",
							playerNum, role, points, buildingList,
							plantationList);

		} else {
			rtn = String
					.format("Player %d \nRole: %s \nScore: %d \nBuilding: %s \nPlantation: %s",
							playerNum, role, points, buildingList,
							plantationList);

		}
		return rtn;
	}

	public void updateRoles() {

		Object[] options = Player.getRoles().toArray();
		while (!checkEndGame()) {
			options = Player.getRoles().toArray();
			for (int i = 0; i < this.players.size(); i++) {
				Player player = this.players.get(i);
				// DONE: Min, make player not able to choose role already chosen
				// for this turn.
				int n = JOptionPane.showOptionDialog(this.mainframe,
						"Choose your role!", "Player " + i,
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[options.length - 1]);
				// in this block of code I had to convert the lists of
				// buildings,plantations into Strings

				// TODO: move the building, plantation string builder to
				// getPlayerText method.
				// kurian

				String role = (String) options[n];
				player.setRole(role);

				player.updatePlayerInfo();

				playRole(i);

				// removing selected
				List<Object> temp = new ArrayList<Object>();
				for (int j = 0; j < options.length; j++) {
					if (j != n) {
						temp.add(options[j]);
					}
				}
				options = temp.toArray();
			}

		}

	}

	public boolean checkEndGame() {
		// checks the end of the game, default to true for testing, otherwise false
		return false;
	}

	public void updateMsgBar() {
		this.msgBar.setText("Updated");
	}

	public void playRole(int roleNum) {
		// 
		Player player = players.get(roleNum);
		String role = player.getRole();

		if (role.equals(PlayerRoles.Mayor)) {

			for (int i = 0; i < players.size(); i++) {
				// TODO: player goes to next person, it should not start with

				player = players.get(roleNum);

				Object[] options = { "Building", "Plantation", "Do Nothing" };
				boolean selected = false;
				while (!selected) {
					int n = JOptionPane
							.showOptionDialog(
									this.mainframe,
									"Give the colonosists a job! \nChoose a structure.",
									"Player " + roleNum,
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null,
									options, options[options.length - 1]);
					if (n == 0) {
						ArrayList<String> pBuildingsNames = (ArrayList<String>) player
								.getBuildingsStringList().clone();
						pBuildingsNames.add("Go Back");
						Object[] temp = pBuildingsNames.toArray();

						int buildingNum = JOptionPane
								.showOptionDialog(
										this.mainframe,
										"Give the colonosists a job! \nChoose a building",
										"Player " + (roleNum),
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE, null,
										temp, null);
						if (buildingNum != temp.length - 1) {
							// TODO: need a check on this, adding workers.
							player.getBuildings().get(buildingNum).numberOfWorkers++;
							selected = true;
						} else {
							selected = false;
						}

					} else if (n == 1) {
						ArrayList<String> pPlantations = (ArrayList<String>) player
								.getPlantationsStringList().clone();
						pPlantations.add("Go Back");
						Object[] temp = pPlantations.toArray();

						int plantationNum = JOptionPane
								.showOptionDialog(
										this.mainframe,
										"Give the colonosists a job! \nChoose a plantation",
										"Player " + (roleNum),
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE, null,
										temp, null);
						if (plantationNum != temp.length - 1) {

							selected = true;
						} else {
							selected = false;
						}
					} else {
						// Do nothing
						selected = true;
					}
					player.updatePlayerInfo();
				}
				roleNum = (roleNum + 1) % players.size();

			}
		} else if (role.equals(PlayerRoles.Builder)) {
			Buildings b = new Buildings();
			ArrayList<String> bNames = b.getBuildingNames();
			bNames.add("Nothing");
			Object[] options = bNames.toArray();
			// TODO: add condition that builder gets discount,
			for (int i = 0; i < players.size(); i++) {

				player = players.get(roleNum);
				System.out.println(roleNum);
				// player = player.next at the end
				int n = JOptionPane.showOptionDialog(this.mainframe,
						"Choose a building to build!", "Player " + (roleNum),
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[options.length - 1]);
				if (n != bNames.size() - 1) {
					player.addBuilding(new Building(bNames.get(n)));
				}
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		}else if(role.equals(PlayerRoles.Settler)){
			//TODO: kurian
			for (int i = 0; i < players.size(); i++) {

				player = players.get(roleNum);
				//TODO:
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		}else if(role.equals(PlayerRoles.Craftsman)){
			//TODO: kurian
			for (int i = 0; i < players.size(); i++) {

				player = players.get(roleNum);
				//TODO:
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		}else if(role.equals(PlayerRoles.Trader)){
			//TODO: Min
			for (int i = 0; i < players.size(); i++) {

				player = players.get(roleNum);
				//TODO:
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		}else if(role.equals(PlayerRoles.Captain)){
			//TODO: Isaiah
			for (int i = 0; i < players.size(); i++) {

				player = players.get(roleNum);
				//TODO:
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		}else if(role.equals(PlayerRoles.Prospector)){
			//:do nothing
			for (int i = 0; i < players.size(); i++) {

				player = players.get(roleNum);
				//:
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		}

	}

}
