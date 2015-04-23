package csse376_puerto_rico_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import csse376_puerto_rico.PlayerRoles;


public class PlayerRolesTest {

	@Test
	public void basic_test() {
		
		PlayerRoles.values();
	}
	@Test
	public void captain_test() {
		
		assertEquals(PlayerRoles.Captain, "Captain");
	}

}
