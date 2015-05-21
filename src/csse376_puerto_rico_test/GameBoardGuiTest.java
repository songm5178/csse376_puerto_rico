package csse376_puerto_rico_test;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;

import org.junit.Test;

import csse376_puerto_rico.GameBoardGUI;
import csse376_puerto_rico.Player;

/**
 * TODO Put here a description of what this class does.
 *
 * @author songm. Created Apr 16, 2015.
 */
public class GameBoardGuiTest {

	@Test
	public void constructor_test() {
		// GameBoardGUI g = new GameBoardGUI(new JFrame(), new ButtonGroup());
		GameBoardGUI g = new GameBoardGUI();

	}

	@Test
	public void test_updateMsgBar() {
		// GameBoardGUI g = new GameBoardGUI(new JFrame(), new ButtonGroup());
		GameBoardGUI g = new GameBoardGUI();
		g.updateMsgBar("Updated");
		assertEquals("Updated", g.msgBar.getText());
	}

}
