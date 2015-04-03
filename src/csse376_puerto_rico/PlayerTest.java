package csse376_puerto_rico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {
	
	@Test
	public void test_playersRoleAsTrader() {
		Player player = new Player("trader");
		assertEquals("trader",player.getRole());
	}
	@Test
	public void test_playersRoleAsMayor() {
		Player player = new Player("mayor");
		assertEquals("mayor",player.getRole());
	}
	@Test
	public void test_playersRoleAsBuilder() {
		Player player = new Player("builder");
		assertEquals("builder",player.getRole());
	}
	
	

}
