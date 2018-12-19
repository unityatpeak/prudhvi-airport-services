package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.FlightDaoImpl;
import dao.IFlightDao;
import exception.FlightException;
import passenger.Flight;

public class FlightServiceImpl implements IFlightService
 {
	IFlightDao iFlightDao = new FlightDaoImpl();
	@Override
	public String addFlight(Flight flight) throws ClassNotFoundException, SQLException, IOException
	{
		String flightSeq;
		flightSeq=iFlightDao.addFlight(flight);
		return flightSeq;
		
	}
	
	@Override
	public Flight viewFlight(String flightId) throws ClassNotFoundException, SQLException, IOException {
		Flight flight;
		flight = iFlightDao.viewFlight(flightId);		
		return flight;
	}

	@Override
	public void deleteFlight(String flightId) throws ClassNotFoundException, SQLException, IOException, FlightException
	{
		iFlightDao.deleteFlight(flightId);
	}

	public void validateFlight(Flight flight) throws FlightException
	{
		List<String> validationErrors = new ArrayList<String>();
		
		if(!(isValidName(flight.getFlightName())))
		{
			validationErrors.add("\n flight name should be in alphabets and min 3 characters long");
		}
		if(!(isValidSeatsCount(flight.getSeatsCount())))
		{
			validationErrors.add("\n seat count should be less than 100 \n");
		}
		if(!(isValidTicketPrice(flight.getTicketPrice())))
		{
			validationErrors.add("\n ticket price must be 3 or 4 digits only \n");
		}
		if(!(isValidSeatType(flight.getSeatType())))
		{
			validationErrors.add("\n seat type should be a either A or B or C \n");
		}
		if(!(isValidOrigin(flight.getFlightOrigin())))
		{
			validationErrors.add("\n Flight origin should be string \n");
		}
		if(!(isValidDestination(flight.getFlightDestination())))
		{
			validationErrors.add("\n Flight destination should be string \n");
		}
		if(!(isValidTime(flight.getFlightTime())))
		{
			validationErrors.add("\n Flight time should be between 0 to 24 hours \n");
		}
		
		if(!validationErrors.isEmpty())
			throw new FlightException(validationErrors+" ");
	}
	private boolean isValidName(String flightName)
	{
		Pattern pat1 = Pattern.compile("^[A-Za-z]{3,}$");
		Matcher mat1 = pat1.matcher(flightName);
		return mat1.matches();
	} 
	
	private boolean isValidSeatsCount(String seatsCount)
	{
		Pattern pat2 = Pattern.compile("[1-9][0-9]$");
		Matcher mat2 = pat2.matcher(seatsCount);
		return mat2.matches();
	}
	
	private boolean isValidTicketPrice(String ticketPrice)
	{
		Pattern pat4 = Pattern.compile("^[1-9][0-9]{2,3}$");
		Matcher mat4 = pat4.matcher(ticketPrice);
		return mat4.matches();
	}
	private boolean isValidOrigin(String flightOrigin)
	{
		Pattern pat5 = Pattern.compile("[A-Z][a-z]{2,}");
		Matcher mat5 = pat5.matcher(flightOrigin);
		return mat5.matches();
	}
	private boolean isValidDestination(String flightDestination)
	{
		Pattern pat6 = Pattern.compile("[A-Z][a-z]{2,}");
		Matcher mat6 = pat6.matcher(flightDestination);
		return mat6.matches();
	}
	private boolean isValidTime(String flightTime)
	{
		Pattern pat7 = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
		Matcher mat7 = pat7.matcher(flightTime);
		return mat7.matches();
	}
	private boolean isValidSeatType(String seatType)
	{
		Pattern pat8 = Pattern.compile("[ABC]");
		Matcher mat8 = pat8.matcher(seatType);
		return mat8.matches();
	}
	
	public boolean validateFlightId(String flightId)//validate variables separately which will be used later
	{
		Pattern pat3 = Pattern.compile("[1-9][0-9]{5,6}");
		Matcher mat3 = pat3.matcher(flightId);
		if (mat3.matches())
			return true;
		else 
			return false;
	}


	
}