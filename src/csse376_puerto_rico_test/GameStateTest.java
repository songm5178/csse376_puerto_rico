package csse376_puerto_rico_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import csse376_puerto_rico.GameState;
import csse376_puerto_rico.Player;
import csse376_puerto_rico.Player.Good;

/**
 * TODO Put here a description of what this class does.
 *
 * @author songm. Created May 7, 2015.
 */
public class GameStateTest {

	private ArrayList<Player> fakePlayers = new ArrayList<Player>();

	@Test
	public void test() {
		fakePlayers = new ArrayList<Player>();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		new GameState(fakePlayers);
	}

	@Test
	public void testGoods() {
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);

		int coffee = g.getGood(Player.Good.COFFEE);
		assertEquals(9, coffee);

		g.addGood(Player.Good.COFFEE);
		coffee = g.getGood(Player.Good.COFFEE);
		assertEquals(10, coffee);
	}

	@Test
	public void testColonistsThreePlayers() {
		fakePlayers = new ArrayList<Player>();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);

		assertEquals(3, g.getColonistsOnBoard());
		assertEquals(55, g.getColonistsTotal());

	}

	@Test
	public void TestIsAbleToAddGood1() {
		Player player = new Player();
		player.addGood("Corn", 3);
		fakePlayers.add(player);
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);
		assertEquals(true, g.isAbleToAddGood(player));
	}

	@Test
	public void TestIsAbleToAddGood2() {
		Player player = new Player();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);
		assertEquals(false, g.isAbleToAddGood(player));
	}

	@Test
	public void TestIsAbleToAddGood3() {
		Player player = new Player();
		fakePlayers.add(player);
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);
		player.addGood(Good.CORN, 3);
		g.addGoodToCargoShip(4, 3, Good.INDIGO);
		g.addGoodToCargoShip(5, 4, Good.COFFEE);
		g.addGoodToCargoShip(6, 5, Good.TOBACCO);
		assertEquals(false, g.isAbleToAddGood(player));

	}

	@Test
	public void TestUpdateShips() {
		fakePlayers = new ArrayList<Player>();
		Player player = new Player();
		fakePlayers.add(player);
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);
		player.addGood(Good.CORN, 3);
		g.addGoodToCargoShip(4, 4, Good.INDIGO);
		g.addGoodToCargoShip(5, 5, Good.INDIGO);
		g.addGoodToCargoShip(6, 6, Good.INDIGO);
		assertEquals(4, g.cargoship4);
		g.updateAtEndOfTurn();
		assertEquals(0, g.cargoship4);
		assertEquals(0, g.cargoship5);
		assertEquals(0, g.cargoship6);

	}

	public void testColonistsFourPlayers() {
		fakePlayers = new ArrayList<Player>();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		GameState g = new GameState(fakePlayers);
		assertEquals(54, g.doubloons);
		assertEquals(4, g.getColonistsOnBoard());
		assertEquals(75, g.getColonistsTotal());
	}

	@Test
	public void testColonistsFivePlayers() {
		fakePlayers = new ArrayList<Player>();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		GameState g = new GameState(fakePlayers);

		assertEquals(5, g.getColonistsOnBoard());
		assertEquals(95, g.getColonistsTotal());
	}

	@Test
	public void testAddGoodToCargoShipWithCornToShip4() {
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);

		assertEquals(0, g.addGoodToCargoShip(4, 1, "corn"));
	}

	@Test
	public void test_getGood() {
		fakePlayers = new ArrayList<Player>();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);

		assertEquals(9, g.getGood(Good.COFFEE));
	}

	@Test
	public void test_addGood() {
		fakePlayers = new ArrayList<Player>();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);
		g.addGood(Good.COFFEE);
		assertEquals(10, g.getGood(Good.COFFEE));
	}

	@Test
	public void test_colonistsOnBoard() {
		fakePlayers = new ArrayList<Player>();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);

		assertEquals(3, g.getColonistsOnBoard());
		assertEquals(55, g.getColonistsTotal());
	}

	@Test
	public void test_addColonistsOnBoard() {
		fakePlayers = new ArrayList<Player>();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);
		g.addColonistsToBoard();
		assertEquals(3, g.getColonistsOnBoard());
		assertEquals(55, g.getColonistsTotal());
	}

	@Test
	public void test_isGameEndState() {
		fakePlayers = new ArrayList<Player>();
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());

		GameState g = new GameState(fakePlayers);

		assertEquals(false, g.isGameEndState());
	}

	@Test
	public void test_getWinner() {
		fakePlayers = new ArrayList<Player>();
		Player player = new Player();
		player.setPoints(10);
		fakePlayers.add(player);
		fakePlayers.add(new Player());
		fakePlayers.add(new Player());
		
		GameState g = new GameState(fakePlayers);

		assertEquals(player, g.getWinner());
	}
}
