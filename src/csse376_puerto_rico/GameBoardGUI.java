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
import csse376_puerto_rico.Player.Good;
import csse376_puerto_rico.Player.Plantation;

public class GameBoardGUI {

	private JFrame mainframe;
	public static List<Player> players;
	public static JTextArea msgBar;
	public static JTextArea gameStateInfo;
	// public static ArrayList<JPanel> playerCards;
	private ButtonGroup bGroup;
	private static int turnCount;
	private GameState gameState;

	public GameBoardGUI() {
		// For testing purposes.
		this.msgBar = new JTextArea();
		this.gameStateInfo = new JTextArea();
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
		this.gameStateInfo = new JTextArea();

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

	private void displayGameState() {
		int coffee = this.gameState.getGood(Player.Good.COFFEE);
		int corn = this.gameState.getGood(Player.Good.CORN);
		int indigo = this.gameState.getGood(Player.Good.INDIGO);
		int sugar = this.gameState.getGood(Player.Good.SUGAR);
		int tobacco = this.gameState.getGood(Player.Good.TOBACCO);
		int colonists = this.gameState.getColonistsOnBoard();

		String parsedInfo = "Coffe: " + coffee + "    Corn: " + corn
				+ "    Indigo: " + indigo + "\nSugar: " + sugar
				+ "        Tobacco: " + tobacco + "\nColonists: " + colonists
				+ "\n" + "\nCargo Ship: " + (4 - this.gameState.cargoship4)
				+ " spots for " + this.gameState.cargoship4Good
				+ "    Cargo Ship: " + (5 - this.gameState.cargoship5)
				+ " spots for " + this.gameState.cargoship5Good
				+ "    Cargo Ship: " + (6 - this.gameState.cargoship6)
				+ " spots for " + this.gameState.cargoship6Good;
		gameStateInfo.setColumns(20);
		gameStateInfo.setRows(7);
		gameStateInfo.setText(parsedInfo);
		this.mainframe.add(gameStateInfo, "cell 0 5, span 5");
	}

	private void updateGameStateDisplay() {
		int coffee = this.gameState.getGood(Player.Good.COFFEE);
		int corn = this.gameState.getGood(Player.Good.CORN);
		int indigo = this.gameState.getGood(Player.Good.INDIGO);
		int sugar = this.gameState.getGood(Player.Good.SUGAR);
		int tobacco = this.gameState.getGood(Player.Good.TOBACCO);
		int colonists = this.gameState.getColonistsOnBoard();

		String parsedInfo = "Coffe: " + coffee + "    Corn: " + corn
				+ "    Indigo: " + indigo + "\nSugar: " + sugar
				+ "        Tobacco: " + tobacco + "\nColonists: " + colonists
				+ "\n" + "\nCargo Ship: " + (4 - this.gameState.cargoship4)
				+ " spots for " + this.gameState.cargoship4Good
				+ "    Cargo Ship: " + (5 - this.gameState.cargoship5)
				+ " spots for " + this.gameState.cargoship5Good
				+ "    Cargo Ship: " + (6 - this.gameState.cargoship6)
				+ " spots for " + this.gameState.cargoship6Good;

		gameStateInfo.setText(parsedInfo);
	}

	private void displayMessageBar() {
		msgBar.setColumns(90);
		this.mainframe.add(msgBar, "cell 0 0, span " + this.players.size());
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
		this.gameState = new GameState(this.players);

		displayGameState();
		displayMessageBar();
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

				String role = (String) options[n];
				player.setRole(role);
				// Every start of the role each player gets an extra doubloon.
				player.setDoubloons(player.getDoubloons() + 1);
				gameState.doubloons--;
				player.updatePlayerInfo();

				playRole(i);

				// update
				this.gameState.updateAtEndOfTurn();

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
		updateMsgBar("Winner is Player : "
				+ this.gameState.getWinner().getPlayerNum());

	}

	public boolean checkEndGame() {
		// checks the end of the game, default to true for testing, otherwise
		// false
		return gameState.isGameEndState();
	}

	public void updateMsgBar(String msg) {
		this.msgBar.setText(msg);
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
							Building playerB = player.getBuildings().get(
									buildingNum);
							if (playerB.numberOfJobs > playerB.numberOfWorkers) {
								player.getBuildings().get(buildingNum).numberOfWorkers++;
								selected = true;
								updateMsgBar("Player " + i
										+ " added worker to building "
										+ playerB.name);
							} else {
								updateMsgBar("Building " + playerB.name
										+ " is already full of workers.");
							}
						} else {
							updateMsgBar("Player " + i + " has no buildings");
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
							Plantation pPlantation = player.getPlantations()
									.get(plantationNum);
							if (pPlantation.hasWorker) {
								updateMsgBar("Plantation already has a worker.");
							} else {
								pPlantation.hasWorker = true;
								selected = true;
								updateMsgBar("Player " + i
										+ " added worker to plantation");
							}
						} else {
							updateMsgBar("Player " + i + " has no plantions");
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
			player.setDoubloons(player.getDoubloons() + 1);
			Buildings b = new Buildings();

			for (int i = 0; i < players.size(); i++) {
				player = players.get(roleNum);
				System.out.println(roleNum);

				ArrayList<Building> bs = b.getBuildings();
				ArrayList<String> bNames = new ArrayList<String>();
				for (Building building : bs) {
					if (building.cost <= player.getDoubloons()) {
						bNames.add(building.name);
					}
				}
				bNames.add("Nothing");
				Object[] options = bNames.toArray();

				// player = player.next at the end
				int n = JOptionPane.showOptionDialog(this.mainframe,
						"Choose a building to build!", "Player " + (roleNum),
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[options.length - 1]);
				if (n != bNames.size() - 1) {
					player.addBuilding(new Building(bNames.get(n)));
					if (player.getBuildings().size() >= 12) {
						this.gameState.isGameEndState = true;
					}
				}
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		} else if (role.equals(PlayerRoles.Settler)) {
			// DONE: kurian
			List<String> gNames = player.getAllGoods();
			gNames.add("Nothing");
			Object[] options = gNames.toArray();
			// Settler picks one more plantation
			for (int i = 0; i <= players.size(); i++) {

				player = players.get(roleNum);
				// player = player.next at the end
				int n = JOptionPane.showOptionDialog(this.mainframe,
						"Choose a Good to harvest!", "Player " + (roleNum),
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[options.length - 1]);
				System.out.println(gNames.get(n));
				if (n != gNames.size() - 1) {
					player.getPlantations().add(
							new Plantation(gNames.get(n), false));
				}
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();
			}
		} else if (role.equals(PlayerRoles.Craftsman)) {
			// DONE: kurian
			for (int i = 0; i < players.size(); i++) {

				player = players.get(roleNum);
				player.checkPlantation();
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		} else if (role.equals(PlayerRoles.Trader)) {
			// 
			for (int i = 0; i < players.size(); i++) {

				player = players.get(roleNum);
				// TODO:
				
				ArrayList<String> goodList = new ArrayList<String>();
				for (String s : player.getAllGoods()){
					int n = player.getNumberOfGood(s);
					if(n>0){
						goodList.add(s);
					}
				}
				goodList.add("Nothing");
				Object[] options = goodList.toArray();
				
				int n = JOptionPane.showOptionDialog(this.mainframe,
						"Choose a Good to trade!", "Player " + (roleNum),
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[options.length - 1]);
				if(n!=goodList.size()-1){
					if(goodList.get(n).equals(Good.COFFEE)){
						
					}else if(goodList.get(n).equals(Good.CORN)){
						
					}else if(goodList.get(n).equals(Good.INDIGO)){
						
					}else if(goodList.get(n).equals(Good.SUGAR)){
						
					}else if(goodList.get(n).equals(Good.TOBACCO)){
						
					}
				}
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		} else if (role.equals(PlayerRoles.Captain)) {

			for (int i = 0; i < players.size(); i++) {
				// TODO:
				player = players.get(roleNum);
				Object[] goodOptions = player.getAllGoods().toArray();

				int good = JOptionPane.showOptionDialog(this.mainframe,
						"Choose a good to ship!", "Player " + (roleNum),
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, goodOptions,
						goodOptions[goodOptions.length - 1]);

				Object[] shipOptions = new Object[3];
				shipOptions[0] = 4;
				shipOptions[1] = 5;
				shipOptions[2] = 6;
				int ship = JOptionPane.showOptionDialog(this.mainframe,
						"Choose a cargo ship to put good!", "Player "
								+ (roleNum), JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, shipOptions,
						shipOptions[shipOptions.length - 1]);

				if (ship == 0) {
					this.gameState.cargoship4Good = (String) goodOptions[good];
					this.gameState.cargoship4++;
				} else if (ship == 1) {
					this.gameState.cargoship5Good = (String) goodOptions[good];
					this.gameState.cargoship5++;
				} else if (ship == 2) {
					this.gameState.cargoship6Good = (String) goodOptions[good];
					this.gameState.cargoship6++;
				}

				updateGameStateDisplay();
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		} else if (role.equals(PlayerRoles.Prospector)) {
			// :do nothing
			for (int i = 0; i < players.size(); i++) {

				player = players.get(roleNum);
				// :
				player.updatePlayerInfo();
				roleNum = (roleNum + 1) % players.size();

			}
		}

	}

}
