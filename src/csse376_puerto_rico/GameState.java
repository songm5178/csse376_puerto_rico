package csse376_puerto_rico;

import java.util.HashMap;

public class GameState {
	
	private HashMap<String, Integer> goods = new HashMap<String, Integer>(); 
	public int colonistsTotal;
	public int colonistsOnBoard;
	public int cargoship4;
	public String cargoship4Good;
	public int cargoship5;
	public String cargoship5Good;
	public int cargoship6;
	public String cargoship6Good;
	
	public int doubloons;
	
	
	public GameState(){
		
		//TODO: game start state - Min
		// goods
		goods.put(Player.Good.COFFEE, 0);
		goods.put(Player.Good.CORN, 0);
		goods.put(Player.Good.INDIGO, 0);
		goods.put(Player.Good.SUGAR, 0);
		goods.put(Player.Good.TOBACCO, 0);
		
		// colonists
		colonistsTotal = 0;
		colonistsOnBoard = 0;
		// ships
		
		// doubloons
		doubloons = 0;
		
	}


	public int getGood(String good) {
		
		return goods.get(good);
	}



	public void addGood(String good) {
		
		goods.put(good, goods.get(good)+1);
	}
	
	
	
	
}
