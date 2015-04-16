package csse376_puerto_rico;

import static org.junit.Assert.*;

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

}
