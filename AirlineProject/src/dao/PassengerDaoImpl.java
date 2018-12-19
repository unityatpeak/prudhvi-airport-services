package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import exception.PassengerException;
import passenger.GetTicket;
import passenger.Passenger;
import passenger.Ticket;
import util.DBConnection;

public class PassengerDaoImpl implements IPassengerDao
 {
	
	Logger logger=Logger.getRootLogger();
	public PassengerDaoImpl()
	{
		PropertyConfigurator.configure("resources//log4j.properties");
		
	}
	
	
	@Override
	public String addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = DBConnection.getConnection();

		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st = connection.createStatement();
		String passengerId = null;
		int queryResult = 0;
		try {
			pst = connection.prepareStatement(QueryMapper.ADD_PASSENGER_QUERY);
			pst.setString(1, passenger.getPassengerName());
			pst.setString(2, passenger.getPassengerAge());
			pst.setString(3, passenger.getPassengerContact());
			pst.setString(4, passenger.getTimeMinRange());
			pst.setString(5, passenger.getTimeMaxRange());
			pst.setString(6, passenger.getPassengerOrigin());
			pst.setString(7, passenger.getPassengerDestination());
			pst.executeUpdate();

			rs = st.executeQuery(QueryMapper.GET_PASSENGER_ADDED_QUERY);
			while(rs.next()) {
				passengerId = rs.getString(1);
			}
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new PassengerException("Inserting donor details failed ");

			}
			else
			{
				logger.info("Donor details added successfully:");
				return passengerId;
			}
		} catch (Exception sq) {
			System.err.println(sq.getMessage());
			logger.error(sq.getMessage());
		} finally {
			rs.close();
		}
		return null;
	}
	
	@Override
	public Passenger viewPassengerDetails(String passengerId) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = DBConnection.getConnection();
		Statement st = connection.createStatement();
		Passenger passenger = new Passenger();
		ResultSet rs = null;
		PreparedStatement pst = null;

		//rs = st.executeQuery();
		pst = connection.prepareStatement(QueryMapper.VIEW_PASSENGER_DETAILS_QUERY);
		pst.setString(1, passengerId);
		rs = pst.executeQuery();
		while(rs.next())
		{
		passenger.setPassengerId(rs.getString(1));
		passenger.setPassengerName(rs.getString(2));
		passenger.setPassengerAge(rs.getString(4));
		passenger.setPassengerContact(rs.getString(3));
		passenger.setTimeMinRange(rs.getString(5));
		passenger.setTimeMaxRange(rs.getString(6));
		passenger.setPassengerOrigin(rs.getString(7));
		passenger.setPassengerDestination(rs.getString(8));
		}
		
		if( passenger != null)
		{
			logger.info("Record Found Successfully");
			return passenger;
		}
		else
		{
			logger.info("Record Not Found Successfully");
			return null;
		}
	}


	@Override
	public GetTicket bookTicket(Ticket ticket) throws ClassNotFoundException, SQLException, IOException
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		ResultSet rs = null;
		GetTicket getTicket = null;
		try
			{
				pst1 = conn.prepareStatement(QueryMapper.GET_FLIGHT_DETAILS_QUERY);
				rs = pst1.executeQuery();
				getTicket = new GetTicket();
				double tId ;
				tId = (Math.random())+(((100000-1000)+1));
				pst2 = conn.prepareStatement(QueryMapper.UPDATE_PASSENGERTABLE_QUERY);
				pst2.setDouble(1, tId);
				pst2.setString(2, ticket.getPassengerId());
				pst2.executeUpdate();
				while(rs.next())
				{
					getTicket.setTicketId(tId);
					getTicket.setPassengerId(ticket.getPassengerId());
					getTicket.setOrigin(ticket.getOrigin());
					getTicket.setDestination(ticket.getDestination());
					getTicket.setFlightTime(rs.getString(1));
					getTicket.setPrice(rs.getInt(2));
				}
				
				if(getTicket.getOrigin() != null)
				{
					logger.info("Record Found Successfully");
					return getTicket;
				}
				else
				{
					logger.info("Record Not Found Successfully");
					return null;
				}
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void cancelTicket(String customerId) throws ClassNotFoundException, SQLException, IOException {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(QueryMapper.CANCEL_TICKET_QUERY);
			pst.setString(1, customerId);
			rs = pst.executeQuery();
			
			if( customerId != null)
			{
				logger.info("Record Found Successfully");
			}
			else
			{
				logger.info("Record Not Found Successfully");
			}
		}
		catch(Exception pe)
		{
			System.out.println(pe.getMessage());
		}
		
	}	

}