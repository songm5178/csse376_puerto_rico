package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import csse376_puerto_rico.Buildings.Building;
import csse376_puerto_rico.Player.Plantation;

public class GameState {

	private HashMap<String, Integer> goods = new HashMap<String, Integer>();
	public int colonistsTotal;
	public int colonistsOnBoard;
	public int cargoship4 = 0;
	public String cargoship4Good;
	public int cargoship5 = 0;
	public String cargoship5Good;
	public int cargoship6 = 0;
	public String cargoship6Good;
	public boolean isGameEndState = false;
	public int doubloons;
	private int numOfPlayers;
	private List<Player> players;

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

	}

	public GameState(List<Player> players2) {

		// TODO: game start state - Min
		// goods
		goods.put(Player.Good.COFFEE, 0);
		goods.put(Player.Good.CORN, 0);
		goods.put(Player.Good.INDIGO, 0);
		goods.put(Player.Good.SUGAR, 0);
		goods.put(Player.Good.TOBACCO, 0);

		// colonists
		this.players = players2;
		numOfPlayers = players2.size();
		colonistsOnBoard = numOfPlayers;
		if (numOfPlayers == 3) {
			colonistsTotal = 55;
		} else if (numOfPlayers == 4) {
			colonistsTotal = 75;
		} else if (numOfPlayers == 5) {
			colonistsTotal = 95;
		}
		// ships

		// doubloons
		doubloons = 0;

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
		switch (shipNum) {
		case 4:
			if (cargoship4 == 0 || (cargoship4 < 4 && cargoship4Good.equals(good))) {
				leftover = cargoship4 + goodNum - 4;
			} else {
				leftover = ERROR;
			}
			break;
		case 5:
			if (cargoship5 == 0 ||(cargoship5 < 5 && cargoship5Good.equals(good))) {
				leftover = cargoship4 + goodNum - 5;
			} else {
				leftover = ERROR;
			}
			break;
		case 6:
			if (cargoship6 == 0 ||(cargoship6 < 6 && cargoship6Good.equals(good))) {
				leftover = cargoship6 + goodNum - 6;
			} else {
				leftover = ERROR;
			}
			break;
		default:
			break;
		}
		return leftover;
	}

	public boolean isGameEndState() {
		return isGameEndState;
	}

	public void updateAtEndOfTurn() {
		addColonistsToBoard();
		
		//Must ship these
		if (cargoship4 == 4) {
			cargoship4 = 0;
		}
		if (cargoship5 == 5) {
			cargoship5 = 0;
		}
		if (cargoship6 == 6) {
			cargoship6 = 0;
		}
	}

}
