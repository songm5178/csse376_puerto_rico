package csse376_puerto_rico_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import csse376_puerto_rico.PlayerRoles;

public class PlayerRolesTest {

	

	@Test
	public void captain_test() {

		assertEquals("Captain", PlayerRoles.Captain.toString());
	}

	@Test
	public void settler_test() {

		assertEquals("Settler", PlayerRoles.Settler.toString());
	}

	@Test
	public void builder_test() {

		assertEquals("Builder", PlayerRoles.Builder.toString());
	}

	@Test
	public void roles_test() {
		List<String> roles = new ArrayList<String>(Arrays.asList("Settler",
				"Builder", "Craftsman", "Trader", "Captain", "Prospector",
				"Mayor"));
		Object[] pRoles = PlayerRoles.getValues().toArray();
		for(int i = 0; i < roles.size(); i++){
			String role = roles.get(i);
			assertEquals(role, pRoles[i].toString());
		}
	}

}
