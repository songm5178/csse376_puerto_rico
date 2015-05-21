package csse376_puerto_rico_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import csse376_puerto_rico.Building;
import csse376_puerto_rico.Buildings;

/**
 * TODO Put here a description of what this class does.
 *
 * @author songm. Created Apr 22, 2015.
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

	@Test
	public void getBuildingFieldsTest() {
		Buildings b = new Buildings();
		Building bs = b.getBuildings().get(0);
		assertNotNull(bs.cost);
		assertNotNull(bs.points);
		assertNotNull(bs.numberOfJobs);
		assertNotNull(bs.numberOfWorkers);

	}

	@Test
	public void getBuildingFieldsTest2() {
		Buildings b = new Buildings();
		Building bs = b.getBuildings().get(0);

		assertEquals(1, bs.cost);
		assertEquals(1, bs.points);
		assertEquals(1, bs.numberOfJobs);

		assertEquals(0, bs.numberOfWorkers);

	}

	@Test
	public void getBuildingNames() {
		Buildings b = new Buildings();
		assertNotNull(b.getBuildingNames());
	}

}
