package csse376_puerto_rico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class NextMoveButton extends JButton 
{
	private List<Player> players;
	public NextMoveButton()
	{
		players = GameBoardGUI.players;
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//makeMove();
			}
		});
	}
}
	

