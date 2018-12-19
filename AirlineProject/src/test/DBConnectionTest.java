package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.FlightDaoImpl;
import exception.FlightException;
import util.DBConnection;

public class DBConnectionTest {
	static FlightDaoImpl daotest;
	static Connection dbCon;

	@BeforeAll
	public static void initialise() {
		daotest = new FlightDaoImpl();
		dbCon = null;
	}

	@BeforeEach
	public void beforeEachTest() {
		System.out.println("----Starting DBConnection Test Case----\n");
	}

	/**
	 * Test case for Establishing Connection
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * @throws FlightException
	 **/
	@Test
	public void test() throws FlightException, ClassNotFoundException, SQLException, IOException {
		Connection dbCon = DBConnection.getConnection();
		Assert.assertNotNull(dbCon);
	}

	@AfterEach
	public void afterEachTest() {
		System.out.println("----End of DBConnection Test Case----\n");
	}

	@AfterAll
	public static void destroy() {
		System.out.println("\t----End of Tests----");
		daotest = null;
		dbCon = null;
	}

}