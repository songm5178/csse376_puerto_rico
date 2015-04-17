package csse376_puerto_rico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class NextMoveButton extends JButton 
{
	private List<Player> players;
	public NextMoveButton()
	{
		players = GameBoardGUI.players;
		final ArrayList<Integer> count = new ArrayList<Integer>();
		final Integer zero = 0;
		count.add(zero);
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer newCount = count.get(0);
				newCount = newCount +1;
				count.remove(0);
				count.add(newCount);
				if(newCount > 0 && newCount % players.size() ==0)
				{
					Integer finalCount = newCount/3;
					setText("Turn " +finalCount.toString());
				}
				
				makeMove();
			}
		});
	}
	public void makeMove()
	{
		//once you find the first true isTurn value, 
		//you should set it off to mark that player's turn has ended
		//then you mark the next player's turn has started by turning its isTurn value as true
		//once these changes are made, this new players list replaces the mainboard's player's list
		for(int i=0;i<players.size();i++)
		{
			if(players.get(i).isTurn)
			{
				players.get(i).isTurn = false;
				if(i == players.size()-1)
				{
					players.get(0).isTurn = true;
				}
				else
				{
					players.get(i+1).isTurn = true;
				}
				break;
			}
		}
		GameBoardGUI.players = players;
	}
}

	

