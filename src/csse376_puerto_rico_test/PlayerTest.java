package csse376_puerto_rico_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.junit.Assert;
import org.junit.Test;

import csse376_puerto_rico.Buildings.Building;
import csse376_puerto_rico.Player;
import csse376_puerto_rico.Player.Plantation;

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
	
	@Test
	public void test_toString1()
	{
		Player player = new Player();
		String expected = "Player 0 \nRole:  \nScore: 0 \nBuilding:  \nPlantation:  \nGoods: [Coffee: 0, Corn: 0, Tobacco: 0, Sugar: 0, Indigo: 0]";
		assertEquals(expected, player.toString());
	}
	
	@Test
	public void test_toString2()
	{
		Player player = new Player("Mayor");
		String expected = "Player 0 \nRole: Mayor \nScore: 0 \nBuilding:  \nPlantation:  \nGoods: [Coffee: 0, Corn: 0, Tobacco: 0, Sugar: 0, Indigo: 0]";
		assertEquals(expected, player.toString());
	}
	
	@Test
	public void test_toString3()
	{
		Player player = new Player("Prospector");
		String expected = "Player 0 \nRole: Prospector \nScore: 0 \nBuilding:  \nPlantation:  \nGoods: [Coffee: 0, Corn: 0, Tobacco: 0, Sugar: 0, Indigo: 0]";
		assertEquals(expected, player.toString());
	}
	
	@Test
	public void test_toString4()
	{
		Player player = new Player("Builder");
		String expected = "Player 0 \nRole: Builder \nScore: 0 \nBuilding:  \nPlantation:  \nGoods: [Coffee: 0, Corn: 0, Tobacco: 0, Sugar: 0, Indigo: 0]";
		assertEquals(expected, player.toString());
	}
	
	@Test
	public void test_toString6()
	{
		Player player = new Player("Captain");
		String expected = "Player 0 \nRole: Captain \nScore: 0 \nBuilding:  \nPlantation:  \nGoods: [Coffee: 0, Corn: 0, Tobacco: 0, Sugar: 0, Indigo: 0]";
		assertEquals(expected, player.toString());
	}
	
	
	@Test
	public void test_toString7()
	{
		Player player = new Player("Trader");
		String expected = "Player 0 \nRole: Trader \nScore: 0 \nBuilding:  \nPlantation:  \nGoods: [Coffee: 0, Corn: 0, Tobacco: 0, Sugar: 0, Indigo: 0]";
		assertEquals(expected, player.toString());
	}
	
	@Test
	public void test_getPlayerNum(){
		Player player = new Player();
		player.setPlayerNum(1);
		assertEquals(1, player.getPlayerNum());
		
	}
	
	@Test
	public void test_add3Points()
	{
		Player player = new Player();
		player.setPoints(9);
		assertEquals(9, player.getPoints());
		player.addPoints(3);
		assertEquals(12, player.getPoints());
	}
	
	@Test
	public void test_add5Points()
	{
		Player player = new Player();
		player.setPoints(9);
		assertEquals(9, player.getPoints());
		player.addPoints(5);
		assertEquals(14, player.getPoints());
	}
	
	@Test
	public void settlerTest1()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Corn", false));
		String answer = player.getPlantationsStringList().toString();
		assertEquals("[Corn]", answer);
	}
	
	@Test
	public void settlerTest2()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Coffee", false));
		String answer = player.getPlantationsStringList().toString();
		assertEquals("[Coffee]", answer);
	}
	
	@Test
	public void settlerTest3()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Indigo", false));
		String answer = player.getPlantationsStringList().toString();
		assertEquals("[Indigo]", answer);
	}
	
	@Test
	public void settlerTest4()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Quarry", false));
		String answer = player.getPlantationsStringList().toString();
		assertEquals("[Quarry]", answer);
	}
	
	@Test
	public void settlerTest5()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Tobacco", false));
		String answer = player.getPlantationsStringList().toString();
		assertEquals("[Tobacco]", answer);
	}
	
	@Test
	public void settlerTest6()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Sugar", false));
		String answer = player.getPlantationsStringList().toString();
		assertEquals("[Sugar]", answer);
	}
	
	@Test
	public void settlerTest7()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Sugar", false));
		player.getPlantations().add(new Plantation("Coffee", false));
		String answer = player.getPlantationsStringList().toString();
		assertEquals("[Sugar, Coffee]", answer);
	}
	
	@Test
	public void craftsmanTest1()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Sugar", false));
		player.checkPlantation();
		assertEquals(1, player.getNumberOfGood("Sugar"));
	}
	
	@Test
	public void craftsmanTest2()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Coffee", false));
		player.checkPlantation();
		assertEquals(1, player.getNumberOfGood("Coffee"));
	}
	
	@Test
	public void craftsmanTest3()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Corn", false));
		player.checkPlantation();
		assertEquals(1, player.getNumberOfGood("Corn"));
	}
	
	@Test
	public void craftsmanTest4()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Indigo", false));
		player.checkPlantation();
		assertEquals(1, player.getNumberOfGood("Indigo"));
	}
	
	@Test
	public void craftsmanTest5()
	{
		Player player = new Player();
		player.getPlantations().add(new Plantation("Tobacco", false));
		player.checkPlantation();
		assertEquals(1, player.getNumberOfGood("Tobacco"));
	}

}
