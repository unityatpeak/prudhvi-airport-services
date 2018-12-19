package dao;

import java.io.IOException;
import java.sql.SQLException;

import exception.FlightException;
import passenger.Flight;

public interface IFlightDao {
	
	public String addFlight(Flight flight) throws ClassNotFoundException, SQLException, IOException;
	public Flight viewFlight(String flightId) throws ClassNotFoundException, SQLException, IOException;
	public String deleteFlight(String flightId) throws ClassNotFoundException, SQLException, IOException, FlightException;
}