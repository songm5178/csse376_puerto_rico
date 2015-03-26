package csse376_puerto_rico;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ButtonHandler implements ActionListener {
	
	private JFrame mainframe;

	public ButtonHandler(JFrame frame) {
		this.mainframe = frame;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if(action.equals("Quit")){
			System.exit(0);
		}
	}

}
