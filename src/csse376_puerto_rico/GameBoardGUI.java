package csse376_puerto_rico;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

public class GameBoardGUI {

	private JFrame mainframe;
	public static List<Player> players;
	public static JTextArea msgBar;
//	public static ArrayList<JPanel> playerCards;
	private ButtonGroup bGroup;
	private static int turnCount;

	public GameBoardGUI(JFrame frame, ButtonGroup group) {
		this.players = new ArrayList<Player>();
		this.mainframe = frame;
		this.mainframe.setTitle("Puerto Rico");
		this.mainframe.getContentPane().removeAll();
		this.mainframe.getContentPane().revalidate();
		this.mainframe.setBackground(Color.GREEN);
		MigLayout layout = new MigLayout();
		this.mainframe.setLayout(layout);
		this.bGroup = group;
		this.msgBar = new JTextArea();

		String temp = "0";
		for (Enumeration<AbstractButton> buttons = this.bGroup.getElements(); buttons
				.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				temp = button.getText();
			}
		}
		int numberPlayers = Integer.parseInt(temp);
		this.addPlayers(numberPlayers);
		displayMessageBar();
		addGoodsButtons();
	}

	private void displayMessageBar() {
		msgBar.setColumns(90);
		this.mainframe.add(msgBar, "cell 0 0, span "+this.players.size());
	}

	private void addGoodsButtons() {
		// TODO: Isaiah : Add buttons correctly.
		GoodsButton CoffeeButton = new GoodsButton("Coffee", this);
		GoodsButton CornButton = new GoodsButton("Corn", this);
		GoodsButton TobaccoButton = new GoodsButton("Tobacco", this);
		GoodsButton IndigoButton = new GoodsButton("Indigo", this);
		GoodsButton SugarButton = new GoodsButton("Sugar", this);
		this.mainframe.add(CoffeeButton, "cell 0 2");
		this.mainframe.add(CornButton, "cell 0 2");
		this.mainframe.add(TobaccoButton, "cell 0 2");
		this.mainframe.add(SugarButton, "cell 0 2");
		this.mainframe.add(IndigoButton, "cell 0 2");
	}

//	/**
//	 * This method allows us to add the space on the game board for buildings and goods to
//	 * be placed. It also gives a list of these "cards" so they can be accessed later.
//	 * 
//	 * @param numberPlayers
//	 * @return an arrayList of the buildingSpaces that are JPanels
//	 */
//	public ArrayList<JPanel> addPlayerCards(int numberPlayers) {
//		ArrayList<JPanel> playerSpaces = new ArrayList<JPanel>();
//		for(int i = 0; i < numberPlayers; i++){
//			JPanel buildingSpace = new JPanel();
//			MigLayout layout = new MigLayout();
//			buildingSpace.setLayout(layout);
//			buildingSpace.setBackground(Color.BLACK);
//			playerSpaces.add(buildingSpace);
//			this.mainframe.add(buildingSpace, "cell "+i+" 2, w 165!, h 200!");
//		}
//		this.playerCards = playerSpaces;
//		return playerSpaces;
//	}

	public List<Player> addPlayers(int numberOfPlayers) {
//		this.addPlayerCards(numberOfPlayers);
		for (int i = 0; i < numberOfPlayers; i++) {
			Player p = new Player();
			if (i == 0) {
				p.isGovernor = true;
			}
			JTextArea jta = new JTextArea("Player " + (i + 1) + "\nRole: "
					+ "\nScore: " + p.getPoints() + "\nBuildings:" + p.getBuildings() + "\nPlantations:\n");
			jta.setRows(15);
			jta.setColumns(15);
			p.setHUD(jta);
			this.players.add(p);
			this.mainframe.add(jta, "cell "+i+" 1");

		}
		updateRoles();

		return this.players;
	}

	public List<Player> getPlayers() {
		return this.players;
	}
	
	public static int getTurnCount()
	{
		return turnCount;
	}

	//Will be deleted
	@Deprecated
	public String getPlayerText(int playerNum, String role, int points, 
			String buildingList, String plantationList, boolean isGovernor) {
		String rtn = null;
		if (isGovernor) {
			rtn = String.format("Player %d \nRole: %s \nScore: %d \nBuilding: %s \nPlantation: %s \nGovernor",
					playerNum, role, points, buildingList, plantationList);

		} else {
			rtn = String.format("Player %d \nRole: %s \nScore: %d \nBuilding: %s \nPlantation: %s", playerNum,
					role, points, buildingList, plantationList);

		}
		return rtn;
	}

	public void updateRoles() {
		for (int i = 0; i < this.players.size(); i++) {
			Player player = this.players.get(i);
			Object[] options = Player.getRoles().toArray();
			//TODO: Min, make player not able to choose role already chosen for this turn.
			int n = JOptionPane.showOptionDialog(this.mainframe,
					"Choose your role!", "Player " + (i + 1),
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options,
					options[options.length - 1]);
			//in this block of code I had to convert the lists of buildings,plantations into Strings
			
			//TODO: move the building, plantation string builder to getPlayerText method.
			// kurian
			StringBuilder buildingList = new StringBuilder();
			StringBuilder plantationList = new StringBuilder();
			for (String s : player.getBuildings())
			{
				buildingList.append(s + " ");
			}
			for (String s : player.getGoods())
			{
				plantationList.append(s + " ");
			}
			String role = (String) options[n];
			int points = player.getPoints();
			player.getHUD().setText(getPlayerText(i + 1, role, points, buildingList.toString(), plantationList.toString(), player.isGovernor));
			//player.updatePlayerInfo(); TODO: uncomment this later and comment out above.
			playRole(player);
		}
		
		// TODO: Check endgame, otherwise go back this loop
		
	}
	
	public void updateMsgBar(){
		this.msgBar.setText("Updated");
	}
	
	public void playRole(Player player){
		//TODO: puts in all, Min
		if(player.getRole().equals(PlayerRoles.Captain.toString())){
			
		}
	
	}
}
