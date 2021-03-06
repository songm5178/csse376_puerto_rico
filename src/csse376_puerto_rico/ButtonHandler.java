package csse376_puerto_rico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;

public class ButtonHandler implements ActionListener {
	
	private JFrame mainframe;
	private ButtonGroup bGroup;

	public ButtonHandler(JFrame frame, ButtonGroup group) {
		this.mainframe = frame;
		this.bGroup = group;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if(action.equals("Quit")){
			System.exit(0);
		}else if(action.equals("New Game")){
			new StartUpGameBoardGUI(this.mainframe);
		}else if(action.equals("Start")){
			new GameBoardGUI(this.mainframe, this.bGroup);
		}else if(action.equals("Add Points")){
			
		}
	}

}
