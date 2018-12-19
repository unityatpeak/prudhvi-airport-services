package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.PassengerDaoImpl;
import exception.PassengerException;
import passenger.Passenger;

public class PassengerDaoTest {

	static PassengerDaoImpl dao;
	static Passenger donor;

	@BeforeAll
	public static void initialize() {
		System.out.println("in before class");
		dao = new PassengerDaoImpl();
		donor = new Passenger();
	}

	@Test
	public void testAddDonarDetails() throws PassengerException, ClassNotFoundException, SQLException, IOException {

		assertNotNull(dao.addPassenger(donor));

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
	public void testAddDonarDetails1() throws PassengerException, ClassNotFoundException, SQLException, IOException {
		// increment the number next time you test for positive test case
		assertEquals(1001, dao.addPassenger(donor));
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
	public void testAddDonarDetails2() throws PassengerException, NumberFormatException, ClassNotFoundException, SQLException, IOException {

		donor.setPassengerName("Shashwathi");
		donor.setPassengerAge("30");
		donor.setPassengerContact("8754765474");
		donor.setTimeMinRange("10:00");
		donor.setTimeMaxRange("12:00");
		donor.setPassengerOrigin("London");
		donor.setPassengerDestination("Mumbai");
		assertTrue("Data Inserted successfully",
				Integer.parseInt(dao.addPassenger(donor)) > 1000);

	}
	
	/****************************************************
	 * Test case for viewById()
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 ******************************************************/

	@Test
	public void testById() throws PassengerException, ClassNotFoundException, SQLException, IOException {
		assertNotNull(dao.viewPassengerDetails("112"));
	}

	@Ignore
	@Test
	public void testById1() throws PassengerException, ClassNotFoundException, SQLException, IOException {
		assertEquals("Ramana", dao.viewPassengerDetails("112").getPassengerName());
	}

	
}
