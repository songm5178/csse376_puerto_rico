package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.List;

/**
 * List of roles
 *
 * @author songm. Created Apr 22, 2015.
 */
public enum PlayerRoles {
	Settler, Builder, Craftsman, Trader, Captain, Prospector, Mayor;

	private PlayerRoles() {
		// null constructor
	}

	public static List<String> getValues() {
		List<String> rtn = new ArrayList<String>();

		for (PlayerRoles v : PlayerRoles.values()) {
			rtn.add(v.toString());
		}

		return rtn;
	}
}
