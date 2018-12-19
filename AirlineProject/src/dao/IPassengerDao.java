package dao;

import java.io.IOException;
import java.sql.SQLException;

import passenger.GetTicket;
import passenger.Passenger;
import passenger.Ticket;

public interface IPassengerDao {
		
	public String addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException, IOException;
	public Passenger viewPassengerDetails(String passengerId) throws ClassNotFoundException, SQLException, IOException;
	public GetTicket bookTicket(Ticket ticket) throws ClassNotFoundException, SQLException, IOException;
	public void cancelTicket(String customerId) throws ClassNotFoundException, SQLException, IOException;
}