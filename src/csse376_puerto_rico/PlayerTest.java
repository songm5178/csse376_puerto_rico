package csse376_puerto_rico;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test_playersRoleAsTrader() {
		Player player = new Player("trader");
		assertEquals("trader", player.getRole());
	}

	@Test
	public void test_playersRoleAsMayor() {
		Player player = new Player("mayor");
		assertEquals("mayor", player.getRole());
	}

	@Test
	public void test_playersRoleAsBuilder() {
		Player player = new Player("builder");
		assertEquals("builder", player.getRole());
	}

	@Test
	public void test_getRolesList() {
		List<String> roles = new ArrayList<String>();
		roles.add("Settler");
		roles.add("Mayor");
		roles.add("Builder");
		roles.add("Craftsman");
		roles.add("Trader");
		roles.add("Captain");
		roles.add("Prospector");

		assertEquals(roles, Player.getRoles());
	}
	
	@Test
	public void test_getPlayerTurn(){
		//Default turn should be false;
		Player player = new Player(Player.getRoles().get(0));
		assertEquals(false, player.isTurn);
		
	}
	
	@Test
	public void test_getPlayersPoints(){
		
		Player player = new Player(Player.getRoles().get(0));
		assertEquals(0, player.getPoints());
	}
	
	@Test
	public void test_setPlayerRole(){
		Player player = new Player();
		player.setRole(player.getRoles().get(0));
		assertEquals("Settler", player.getRole());
	}

}
