package csse376_puerto_rico_test;

import static org.junit.Assert.*;

import org.junit.Test;

import csse376_puerto_rico.Buildings;

/**
 * TODO Put here a description of what this class does.
 *
 * @author songm.
 *         Created Apr 22, 2015.
 */
public class BuildingsTest {

	@Test
	public void basic_test() {
		Buildings b = new Buildings();
	}
	
	@Test
	public void getBuildings_test() {
		Buildings b = new Buildings();
		assertNotNull(b.getBuildings());
		
	}


}
