package csse376_puerto_rico;

import static org.junit.Assert.assertEquals;
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
	public void addListOfPlayers_Test3() {
		GameBoardGUI gb = new GameBoardGUI(new JFrame(), new ButtonGroup());
		assertEquals(3, gb.addPlayers(3).size());
	}
	
	@Test
	public void addListOfPlayers_Test4() {
		GameBoardGUI gb = new GameBoardGUI(new JFrame(), new ButtonGroup());
		assertEquals(4, gb.addPlayers(4).size());
	}
	
	@Test
	public void addListOfPlayers_Test5() {
		GameBoardGUI gb = new GameBoardGUI(new JFrame(), new ButtonGroup());
		assertEquals(5, gb.addPlayers(5).size());
	}
	
	@Test
	public void getListOfPlayers_NotNullTest() {
		GameBoardGUI gb = new GameBoardGUI(new JFrame(), new ButtonGroup());
		assertNotNull(gb.getPlayers());
	}
	

}
