package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.FlightDaoImpl;
import exception.FlightException;
import passenger.Flight;

public class FlightDaoTest {
	
	static FlightDaoImpl dao;
	static Flight donor;

	@BeforeAll
	public static void initialize() {
		System.out.println("in before class");
		dao = new FlightDaoImpl();
		donor = new Flight();
	}

	@Test
	public void testAddFlightDetails() throws FlightException, ClassNotFoundException, SQLException, IOException {

		assertNotNull(dao.addFlight(donor));

	}

	/************************************
	 * Test case for addDonarDetails()
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 ************************************/

	@Ignore
	@Test
	public void testAddFlightDetails1() throws FlightException, ClassNotFoundException, SQLException, IOException {
		// increment the number next time you test for positive test case
		assertEquals(1001, dao.addFlight(donor));
	}

	/************************************
	 * Test case for addDonarDetails()
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws NumberFormatException 
	 * 
	 ************************************/

	@Test
	public void testAddDonarDetails2() throws FlightException, NumberFormatException, ClassNotFoundException, SQLException, IOException {

		donor.setFlightName("Shashwathi");
		donor.setSeatsCount("3");
		donor.setFlightTime("10:30");
		donor.setFlightOrigin("wakhanda");
		donor.setFlightDestination("nowhere");
		donor.setTicketPrice("1000");
		donor.setSeatType("A");
		assertTrue("Data Inserted successfully",
				Integer.parseInt(dao.addFlight(donor)) > 100000);

	}

	/****************************************************
	 * Test case for viewById()
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 ******************************************************/

	@Test
	public void testById() throws FlightException, ClassNotFoundException, SQLException, IOException {
		assertNotNull(dao.viewFlight("100021"));
	}

	@Ignore
	@Test
	public void testById1() throws FlightException, ClassNotFoundException, SQLException, IOException {
		assertEquals("C", dao.viewFlight("100022").getSeatType());
	}
	
	/****************************************************
	 * Test case for deleteFlight()
	 * @throws FlightException 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 ******************************************************/
	
	@Test
	public boolean testRemoveFlight() throws ClassNotFoundException, SQLException, IOException, FlightException
	{
		assertNull("true",dao.deleteFlight("100021"));
		return true;
	}
}
