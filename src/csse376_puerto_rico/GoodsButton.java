package csse376_puerto_rico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class GoodsButton extends JButton 
{
	private List<Player> players;
	private String goodsName;
	private JTextArea msgBar;
	private GameBoardGUI gbGUI;
	public GoodsButton(String good, GameBoardGUI gbg)
	{
		gbGUI = gbg;
		goodsName = good;
		setText(goodsName);
		players = gbg.players;
		msgBar = gbg.msgBar;
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			
					for(int i=0;i<players.size();i++)
					{
						int playerNumber = i+1;
						System.out.println( "Player "+playerNumber+": "+ players.get(i).getGoods());
						players.get(i).addGood(goodsName, 1);
						gbGUI.updateMsgBar("You pressed a button");
					}
			}
		});
		
		GameBoardGUI.players = players;
	}
}
