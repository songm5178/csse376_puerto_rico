package csse376_puerto_rico_test;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({ BuildingsTest.class, GameBoardGuiTest.class,
		PlayerRolesTest.class, PlayerTest.class})
public class AllTests {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("csse376_puerto_rico_test.AllTests");
	}
}
