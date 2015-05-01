package csse376_puerto_rico_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.junit.Assert;
import org.junit.Test;

import csse376_puerto_rico.Buildings.Building;
import csse376_puerto_rico.Player;

public class PlayerTest {

	@Test
	public void test_playersRoleAsTrader() {
		Player player = new Player("Trader");
		assertEquals("Trader", player.getRole());
	}

	@Test
	public void test_playersRoleAsBuilder() {
		Player player = new Player("Builder");
		assertEquals("Builder", player.getRole());
	}
	
	@Test
	public void test_playersRoleAsCaptain() {
		Player player = new Player("Captain");
		assertEquals("Captain", player.getRole());
	}
	
	@Test
	public void test_playersRoleAsSettler() {
		Player player = new Player("Settler");
		assertEquals("Settler", player.getRole());
	}
	
	@Test
	public void test_playersRoleAsCraftsman() {
		Player player = new Player("Craftsman");
		assertEquals("Craftsman", player.getRole());
	}
	
	@Test
	public void test_playersRoleAsProspector() {
		Player player = new Player("Prospector");
		assertEquals("Prospector", player.getRole());
	}
	
	@Test
	public void test_playersRoleAsMayor() {
		Player player = new Player("Mayor");
		assertEquals("Mayor", player.getRole());
	}

	@Test
	public void test_getRolesList() {
		List<String> roles = new ArrayList<String>();
		roles.add("Settler");
		roles.add("Builder");
		roles.add("Craftsman");
		roles.add("Trader");
		roles.add("Captain");
		roles.add("Prospector");
		roles.add("Mayor");

		assertEquals(roles, Player.getRoles());
	}
	
	@Test
	public void test_getPlayerTurn1(){
		//Default turn should be false;
		Player player = new Player();
		assertEquals(false, player.isTurn);
		
	}
	
	@Test
	public void test_getPlayerTurn2(){
		//Default turn should be false;
		Player player = new Player(Player.getRoles().get(0));
		assertEquals(false, player.isTurn);
		
	}
	
	@Test
	public void test_getPlayersPoints1(){
		
		Player player = new Player();
		assertEquals(0, player.getPoints());
	}
	
	@Test
	public void test_getPlayersPoints2(){
		
		Player player = new Player(Player.getRoles().get(0));
		assertEquals(0, player.getPoints());
	}
	
	@Test
	public void test_checkGovorner1(){
		
		Player player = new Player();
		assertEquals(false, player.isGovernor());
	}
	
	@Test
	public void test_checkGovernor2(){
		
		Player player = new Player(Player.getRoles().get(0));
		assertEquals(false, player.isGovernor());
	}
	
	@Test
	public void test_setPlayerRole(){
		Player player = new Player();
		player.setRole(player.getRoles().get(0));
		assertEquals("Settler", player.getRole());
	}
	
	@Test
	public void test_getHUDisNotNull(){
		Player player = new Player();
		Assert.assertNotNull(player.getHUD());
	}
	
	@Test
	public void test_setHUD(){
		Player player = new Player();
		JTextArea fakeHUD = new JTextArea();
		player.setHUD(fakeHUD);
		assertEquals(fakeHUD, player.getHUD());
	}
	
	@Test
	public void test_getBuildings(){
		Player player = new Player();
		player.addBuilding(new Building("Building"));
		assertNotNull(player.getBuildingsStringList());
	}
	
	@Test 
	public void test_getPlayerGoods(){
		Player player = new Player();
		assertNotNull(player.getGoods());
	}
	
	@Test
	public void add_1Tobacco(){
		Player player = new Player();
		player.addGood("Tobacco", 1);
		assertEquals(1, player.getNumberOfGood("Tobacco"));
	}
	
	@Test
	public void add_MultipleTobaccos(){
		Player player = new Player();
		player.addGood("Tobacco", 3);
		assertEquals(3, player.getNumberOfGood("Tobacco"));
	}
	
	@Test
	public void add_1Corn(){
		Player player = new Player();
		player.addGood("Corn", 1);
		assertEquals(1, player.getNumberOfGood("Corn"));
	}
	
	@Test
	public void add_MultipleCorn(){
		Player player = new Player();
		player.addGood("Corn", 3);
		assertEquals(3, player.getNumberOfGood("Corn"));
	}
	
	@Test
	public void add_1Sugar(){
		Player player = new Player();
		player.addGood("Sugar", 1);
		assertEquals(1, player.getNumberOfGood("Sugar"));
	}
	
	@Test
	public void add_MultipleSugar(){
		Player player = new Player();
		player.addGood("Sugar", 1);
		assertEquals(1, player.getNumberOfGood("Sugar"));
	}
	
	@Test
	public void add_1Coffee(){
		Player player = new Player();
		player.addGood("Coffee", 1);
		assertEquals(1, player.getNumberOfGood("Coffee"));
	}
	
	@Test
	public void add_MultipleCoffee(){
		Player player = new Player();
		player.addGood("Coffee", 3);
		assertEquals(3, player.getNumberOfGood("Coffee"));
	}
	
	@Test
	public void add_1Indigo(){
		Player player = new Player();
		player.addGood("Indigo", 1);
		assertEquals(1, player.getNumberOfGood("Indigo"));
	}
	
	@Test
	public void add_MultipleIndigo(){
		Player player = new Player();
		player.addGood("Indigo", 1);
		assertEquals(1, player.getNumberOfGood("Indigo"));
	}
	
	@Test
	public void test_getPlantation(){
		Player player = new Player();
		assertNotNull(player.getPlantationsStringList());
		
	}
	
	@Test
	public void test_getPlantations(){
		Player p = new Player();
		assertNotNull(p.getPlantations());
	}
}
