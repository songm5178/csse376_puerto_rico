package csse376_puerto_rico;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;

import org.junit.Test;

/**
 * TODO Put here a description of what this class does.
 *
 * @author songm.
 *         Created Apr 16, 2015.
 */
public class GameBoardGuiTest {

	@Test
	public void constructor_test() {
		GameBoardGUI g = new GameBoardGUI(new JFrame(), new ButtonGroup());
	}
	@Test
	public void first_player_test() {
		GameBoardGUI g = new GameBoardGUI(new JFrame(), new ButtonGroup());
		List<Player> players = g.addPlayers(3);
		Player p0 = players.get(0);
		
		assertEquals(p0.isGovernor(), true);
	}
	
	

}
