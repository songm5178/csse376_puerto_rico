package csse376_puerto_rico_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import csse376_puerto_rico.GameState;
import csse376_puerto_rico.Player;

/**
 * TODO Put here a description of what this class does.
 *
 * @author songm.
 *         Created May 7, 2015.
 */
public class GameStateTest {

	@Test
	public void test() {
		new GameState();
	}
	
	@Test
	public void testGoods(){
		
		GameState g = new GameState();
		
		int coffee = g.getGood(Player.Good.COFFEE);
		assertEquals(0, coffee);
		
		g.addGood(Player.Good.COFFEE);
		coffee = g.getGood(Player.Good.COFFEE);
		assertEquals(1, coffee);
	}
	
	@Test
	public void testColonistsThreePlayers(){
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		GameState g = new GameState(players);
		
		assertEquals(3, g.getColonistsOnBoard());
		assertEquals(55, g.getColonistsTotal());
		
	}
	
	@Test
	public void testColonistsFourPlayers(){
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		GameState g = new GameState(players);
		
		assertEquals(4, g.getColonistsOnBoard());
		assertEquals(75, g.getColonistsTotal());
	}
	
	@Test
	public void testColonistsFivePlayers(){
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		GameState g = new GameState(players);
		
		assertEquals(5, g.getColonistsOnBoard());
		assertEquals(95, g.getColonistsTotal());
	}
	
	@Test
	public void testAddGoodToCargoShipWithCornToShip4(){
		GameState g = new GameState();
		
		assertEquals(3, g.addGoodToCargoShip(4, 1, "corn"));
	}


}
