package csse376_puerto_rico;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import junit.framework.Assert;

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
		GameBoardGUI gb = new GameBoardGUI(new JFrame());
	}
	
	@Test
	public void getListOfPlayers_NotNullTest() {
		GameBoardGUI gb = new GameBoardGUI(new JFrame());
		
		assertNotNull(gb.getPlayers());
	}

}
