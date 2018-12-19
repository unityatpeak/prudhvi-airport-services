package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import exception.FlightException;
import passenger.Flight;
import passenger.Passenger;
import util.DBConnection;

public class FlightDaoImpl implements IFlightDao
 {
	
	Logger logger=Logger.getRootLogger();
	public FlightDaoImpl()
	{
		
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	
	@Override
	public String addFlight(Flight flight) throws ClassNotFoundException, SQLException, IOException
	{
		
		Connection connection = DBConnection.getConnection();

		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st = connection.createStatement();
		String flightId = null;
		int queryResult = 0;
		try {
			pst = connection.prepareStatement(QueryMapper.ADD_FLIGHT_QUERY);
			
			pst.setString(1, flight.getFlightName());
			pst.setString(2, flight.getSeatsCount());
			pst.setString(3, flight.getFlightTime());
			pst.setString(4, flight.getFlightOrigin());
			pst.setString(5, flight.getFlightDestination());
			pst.setString(6 , flight.getSeatType());
			pst.setString(7, flight.getTicketPrice());
			
			pst.executeUpdate();

			rs = st.executeQuery(QueryMapper.GET_FLIGHT_ADDED_QUERY);
			while(rs.next()) {
				flightId = rs.getString(1);
			}
			
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new FlightException("Inserting donor details failed ");

			}
			else
			{
				logger.info("Donor details added successfully:");
				return flightId;
			}
		} catch (Exception sq) {
			logger.error(sq);
			System.err.println(sq.getMessage());
		} finally {
			rs.close();
		}
		return null;
	}
	
	@Override
	public Flight viewFlight(String flightId) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = DBConnection.getConnection();
		Statement st = connection.createStatement();
		PreparedStatement pst = null;
		Flight flight = new Flight();
		ResultSet rs = null;
		int queryResult=0;
		try
		{
		pst = connection.prepareStatement(QueryMapper.VIEW_FLIGHT_DETAILS_QUERY);
		pst.setString(1, flightId);
		rs = pst.executeQuery();
		while(rs.next())
		{
			flight.setFlightId(rs.getString(1));
			flight.setFlightName(rs.getString(2));
			flight.setSeatsCount(rs.getString(3));
			flight.setTicketPrice(rs.getString(7));
			flight.setFlightTime(rs.getString(4));
			flight.setFlightOrigin(rs.getString(5));
			flight.setFlightDestination(rs.getString(6));
			flight.setSeatType(rs.getString(8));
		}
		
		if(queryResult==0)
		{
			logger.error("Insertion failed ");
			throw new FlightException("Inserting donor details failed ");

		}
		else
		{
			logger.info("Donor details added successfully:");
			return flight;
		}

		}
		catch(Exception fe)
		{
			logger.error(fe);
			System.out.println(fe.getMessage());
		}
		return flight;
	}
	
	@Override
	public String deleteFlight(String flightId) throws ClassNotFoundException, SQLException, IOException, FlightException
	{
		Connection connection = DBConnection.getConnection();
		Statement st = connection.createStatement();
		PreparedStatement pst = null;
		Flight flight = new Flight();
		ResultSet rs = null;
		int queryResult=0;
		pst = connection.prepareStatement(QueryMapper.DELETE_FLIGHT_QUERY);
		pst.setString(1, flightId);
		rs = pst.executeQuery();
		
		if(queryResult==0)
			try {
				{
					logger.error("Insertion failed ");
					throw new FlightException("Inserting donor details failed ");

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
		{
			logger.info("Donor details added successfully:");
		}
		return null;
	}
}