package ch.studihome.model;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file*:src/main/webapp/WEB-INF/config/springMVC.xml",
			"file*:src/main/webapp/WEB-INF/config/springData.xml",
				"file*:src/main/webapp/WEB-INF/config/springSecurity.xml"})
//@Transactional
//@TransactionConfiguration(defaultRollback = true)
public class AdressTest {

	@Test
	public void testGetAdr_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAdr_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStreet() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStreet() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlz() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlz() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCity() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdvert() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAdvert() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCoordinate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCoordinate() {
		fail("Not yet implemented");
	}

}
