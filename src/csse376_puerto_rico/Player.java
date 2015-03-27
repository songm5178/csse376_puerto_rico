package csse376_puerto_rico;

public class Player {
	
	private String role;
	private boolean isTurn;
	private boolean isMayor;

	public Player(String role){
		this.role = role;
		this.isMayor = false;
		this.isTurn = false;
	}
	
	public String getRole(){
		return this.role;
	}

}
