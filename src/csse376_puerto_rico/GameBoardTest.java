package csse376_puerto_rico;

import static org.junit.Assert.assertNotNull;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;

import org.junit.Test;

/**
 * TODO Put here a description of what this class does.
 *
 * @author songm.
 *         Created Apr 2, 2015.
 */
public class GameBoardTest {

	@Test
	public void initial_test() {
		GameBoardGUI gb = new GameBoardGUI(new JFrame(), new ButtonGroup());
	}
	
	@Test
	public void getListOfPlayers_NotNullTest() {
		GameBoardGUI gb = new GameBoardGUI(new JFrame(), new ButtonGroup());
		
		assertNotNull(gb.getPlayers());
	}

}
