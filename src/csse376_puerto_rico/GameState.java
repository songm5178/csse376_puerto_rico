package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import csse376_puerto_rico.Player.Good;
import csse376_puerto_rico.Player.Plantation;

public class GameState {

	private HashMap<String, Integer> goods = new HashMap<String, Integer>();
	public int colonistsTotal;
	public int colonistsOnBoard;
	public int cargoship4 = 0;
	public String cargoship4Good = "";
	public int cargoship5 = 0;
	public String cargoship5Good = "";
	public int cargoship6 = 0;
	public String cargoship6Good = "";
	public boolean isGameEndState = false;
	public int doubloons;
	private int numOfPlayers;
	private List<Player> players;
	public int victoryPoints;
	public static ArrayList<String> rolesToAdd;
	public static ArrayList<String> addDoubloonToRole;

	public static final int ERROR = -99;

	public GameState() {

		// for testing purposes
		// goods
		goods.put(Player.Good.COFFEE, 0);
		goods.put(Player.Good.CORN, 0);
		goods.put(Player.Good.INDIGO, 0);
		goods.put(Player.Good.SUGAR, 0);
		goods.put(Player.Good.TOBACCO, 0);

		// colonists

		colonistsTotal = 0;
		colonistsOnBoard = 0;
		// ships

		// doubloons
		doubloons = 0;
		rolesToAdd = new ArrayList<String>();
		addDoubloonToRole = new ArrayList<String>();
		victoryPoints = 50;
	}

	public GameState(List<Player> players) {

		// game start state - Min

		for (Player p : players) {
			p.setDoubloons(players.size() - 1);
		}

		// goods
		goods.put(Player.Good.COFFEE, 9);
		goods.put(Player.Good.CORN, 10);
		goods.put(Player.Good.INDIGO, 11);
		goods.put(Player.Good.SUGAR, 11);
		goods.put(Player.Good.TOBACCO, 9);

		// colonists. victory points and plantations
		this.players = players;
		numOfPlayers = players.size();
		colonistsOnBoard = numOfPlayers;

		this.players.get(0).addPlantations(new Plantation(Good.INDIGO, false));
		this.players.get(1).addPlantations(new Plantation(Good.INDIGO, false));

		if (numOfPlayers == 3) {
			colonistsTotal = 55;
			victoryPoints = 75;
			this.players.get(2)
					.addPlantations(new Plantation(Good.CORN, false));
		} else if (numOfPlayers == 4) {
			colonistsTotal = 75;
			victoryPoints = 100;
			this.players.get(2)
					.addPlantations(new Plantation(Good.CORN, false));
			this.players.get(3)
					.addPlantations(new Plantation(Good.CORN, false));

		} else if (numOfPlayers == 5) {
			colonistsTotal = 95;
			victoryPoints = 122;
			this.players.get(2).addPlantations(
					new Plantation(Good.INDIGO, false));
			this.players.get(3)
					.addPlantations(new Plantation(Good.CORN, false));
			this.players.get(4)
					.addPlantations(new Plantation(Good.CORN, false));
		}
		// ships

		// doubloons
		doubloons = 54;
		rolesToAdd = new ArrayList<String>();
		addDoubloonToRole = new ArrayList<String>();

	}

	public int getGood(String good) {

		return goods.get(good);
	}

	public void addGood(String good) {

		goods.put(good, goods.get(good) + 1);
	}

	public int getColonistsOnBoard() {
		//
		return colonistsOnBoard;
	}

	public int getColonistsTotal() {
		//
		return colonistsTotal;
	}

	public void addRolesToList(String toAdd) {
		rolesToAdd.add(toAdd);
		if (rolesToAdd.size() == 3) {
			List<String> totalRoles = Player.getRoles();
			for (int i = 0; i < rolesToAdd.size(); i++) {
				totalRoles.remove(rolesToAdd.get(i));
			}
			addDoubloonToRole = rolesToAdd;
			rolesToAdd = new ArrayList<String>();
		}
	}

	public void addDoubloon(Player player, String role) {
		if (addDoubloonToRole.contains(role) && addDoubloonToRole.size() > 0) {
			player.setDoubloons(player.getDoubloons() + 1);
			addDoubloonToRole.remove(role);
		}
	}

	public void addColonistsToBoard() {
		/**
		 * For each empty circle on the buildings on the player boards of all
		 * players (empty circles on plantations and quarries do not count!),
		 * the mayor takes one colonist from the colonist supply and places it
		 * on the colonist ship. However, as a minimum, the mayor should always
		 * place at least as many colonists on the ship as there are players in
		 * the game.
		 */
		int temp = 0;
		for (Player player : players) {
			for (Building b : player.getBuildings()) {
				temp += b.numberOfJobs - b.numberOfWorkers;
			}
			for (Plantation p : player.getPlantations()) {
				if (!p.hasWorker) {
					temp += 1;
				}
			}
		}
		if (temp < numOfPlayers) {
			colonistsOnBoard = numOfPlayers;
		} else {
			colonistsOnBoard = temp;
		}
	}

	/**
	 * 
	 * returns leftover, if 99 then that means it is an error or wrong good on
	 * cargo
	 * 
	 * @param shipNum
	 * @param goodNum
	 * @param good
	 * @return int
	 *
	 */
	public int addGoodToCargoShip(int shipNum, int goodNum, String good) {
		int leftover = 0;
		if (shipNum == 4) {
			System.out.println("ship4");
			if (cargoship4 == 0
					|| (cargoship4 < 4 && cargoship4Good.equals(good))) {
				leftover = cargoship4 + goodNum - 4;
				if (goodNum != 0)
					cargoship4Good = good;

				if (leftover > 0) {
					cargoship4 = 4;
				} else {
					cargoship4 += goodNum;
					leftover = 0;
				}

			} else {
				leftover = ERROR;
			}
		} else if (shipNum == 5) {
			System.out.println("ship5");
			if (cargoship5 == 0
					|| (cargoship5 < 5 && cargoship5Good.equals(good))) {
				leftover = cargoship5 + goodNum - 5;
				if (goodNum != 0)
					cargoship5Good = good;
				if (leftover > 0) {
					cargoship5 = 5;
				} else {
					cargoship5 += goodNum;
					leftover = 0;
				}
			} else {
				leftover = ERROR;
			}

		} else if (shipNum == 6) {
			System.out.println("ship6");
			if (cargoship6 == 0
					|| (cargoship6 < 6 && cargoship6Good.equals(good))) {
				leftover = cargoship6 + goodNum - 6;
				if (goodNum != 0)
					cargoship6Good = good;
				if (leftover > 0) {
					cargoship6 = 6;
				} else {
					cargoship6 += goodNum;
					leftover = 0;
				}
			} else {
				leftover = ERROR;
			}
		}
		return leftover;
	}

	public boolean isAbleToAddGood() {

		for (Player p : players) {
			if (isAbleToAddGood(p)) {
				return true;
			}
		}
		return false;
	}

	public boolean isAbleToAddGood(Player p) {
		List<String> goodStringList = p.getAllGoods();
		for (String good : goodStringList) {

			if (p.getNumberOfGood(good) > 0) {
				for (int i = 4; i <= 6; i++) {
					int e = addGoodToCargoShip(i, 0, good);
					if (e != ERROR) {
						return true;

					}
				}
			}
		}
		return false;
	}

	public boolean isGameEndState() {

		return isGameEndState;
	}

	public Player getWinner() {
		Player max = this.players.get(0);
		for (Player p : this.players) {
			if (max.getPoints() <= p.getPoints()) {
				max = p;
			}
		}

		return max;
	}

	public void updateAtEndOfTurn() {
		addColonistsToBoard();

		// Must ship these
		if (cargoship4 == 4) {
			cargoship4 = 0;
			cargoship4Good = "";
		}
		if (cargoship5 == 5) {
			cargoship5 = 0;
			cargoship5Good = "";
		}
		if (cargoship6 == 6) {
			cargoship6 = 0;
			cargoship6Good = "";
		}
	}

}
