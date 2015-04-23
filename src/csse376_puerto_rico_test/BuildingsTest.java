package csse376_puerto_rico_test;

import static org.junit.Assert.*;

import org.junit.Test;

import csse376_puerto_rico.Buildings;
import csse376_puerto_rico.Buildings.Building;

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
	
	@Test public void getBuildingFieldsTest(){
		Buildings b = new Buildings();
		Building bs = b.getBuildings().get(0);
		assertNotNull(bs.getCost);
		assertNotNull(bs.getPoints);
		assertNotNull(bs.getNumberOfJobs);
		assertNotNull(bs.getNumberOfWorkers);
	}


}
