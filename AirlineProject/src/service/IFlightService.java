package service;

import java.io.IOException;
import java.sql.SQLException;

import passenger.Flight;

public interface IFlightService {
	
	public String addFlight(Flight flight) throws ClassNotFoundException, SQLException, IOException;
	public Flight viewFlight(String flightId) throws ClassNotFoundException, SQLException, IOException;
	public void deleteFlight(String flightId) throws ClassNotFoundException, SQLException, IOException;
}