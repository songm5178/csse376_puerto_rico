package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.List;

/**
 * List of roles
 *
 * @author songm. Created Apr 22, 2015.
 */
public class PlayerRoles {
	public static final String Settler = "Settler";
	public static final String Builder = "Builder";
	public static final String Craftsman = "Craftsman";
	public static final String Trader = "Trader";
	public static final String Captain = "Captain";
	public static final String Prospector = "Prospector";
	public static final String Mayor = "Mayor";

	private PlayerRoles() {
		// null constructor
	}

	public static List<String> getValues() {
		List<String> rtn = new ArrayList<String>();

		rtn.add(Settler);
		rtn.add(Builder);
		rtn.add(Craftsman);
		rtn.add(Trader);
		rtn.add(Captain);
		rtn.add(Prospector);
		rtn.add(Mayor);

		return rtn;
	}
}
