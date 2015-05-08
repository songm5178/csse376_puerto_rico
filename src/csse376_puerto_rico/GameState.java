package csse376_puerto_rico;

import java.util.HashMap;

public class GameState {

	private HashMap<String, Integer> goods = new HashMap<String, Integer>();
	public int colonistsTotal;
	public int colonistsOnBoard;
	public int cargoship4;
	public String cargoship4Good;
	public int cargoship5;
	public String cargoship5Good;
	public int cargoship6;
	public String cargoship6Good;

	public int doubloons;

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

	public GameState(int numOfPlayers) {

		// TODO: game start state - Min
		// goods
		goods.put(Player.Good.COFFEE, 0);
		goods.put(Player.Good.CORN, 0);
		goods.put(Player.Good.INDIGO, 0);
		goods.put(Player.Good.SUGAR, 0);
		goods.put(Player.Good.TOBACCO, 0);

		// colonists
		/**
		 * For each empty circle on the buildings on the player boards of all
		 * players (empty circles on plantations and quarries do not count!),
		 * the mayor takes one colonist from the colonist supply and places it
		 * on the colonist ship. However, as a minimum, the mayor should always
		 * place at least as many colonists on the ship as there are players in
		 * the game.
		 */
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

}
