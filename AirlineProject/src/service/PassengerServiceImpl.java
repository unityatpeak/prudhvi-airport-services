package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import dao.IPassengerDao;
import dao.PassengerDaoImpl;
import exception.PassengerException;
import passenger.GetTicket;
import passenger.Passenger;
import passenger.Ticket;

public class PassengerServiceImpl implements IPassengerService
 {
	IPassengerDao iPassengerDao = new PassengerDaoImpl();
	@Override
	public String addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException, IOException
	{
		String passengerSeq;
		passengerSeq=iPassengerDao.addPassenger(passenger);
		return passengerSeq;		
	}
	

	@Override
	public Passenger viewPassenger(String passengerId) throws ClassNotFoundException, SQLException, IOException
	{
		Passenger passenger;
		passenger = iPassengerDao.viewPassengerDetails(passengerId);		
		return passenger;
	}
	
	
	@Override
	public GetTicket bookTicket(Ticket ticket) throws ClassNotFoundException, SQLException, IOException {
		GetTicket getTicket = new GetTicket();
		getTicket = iPassengerDao.bookTicket(ticket);
		return getTicket;
	}

	
	public void validatePassenger(Passenger passenger) throws PassengerException
	{
		List<String> validationErrors = new ArrayList<String>();
		
		if(!(isValidName(passenger.getPassengerName())))
		{
			validationErrors.add("\n passenger name should be in alphabets and min 3 characters long");
		}
		
		if(!(isValidAge(passenger.getPassengerAge())))
		{
			validationErrors.add("\n passenger age should be above 10 \n");
		}
		
		if(!(isValidPhoneNumber(passenger.getPassengerContact())))
		{
			validationErrors.add("\n passenger contact must be 10digit \n");
		}
		if(!(isValidOrigin(passenger.getPassengerOrigin())))
		{
			validationErrors.add("\n passenger origin should be a string \n");
		}
		if(!(isValidDestination(passenger.getPassengerDestination())))
		{
			validationErrors.add("\n passenger destination should be string \n");
		}
		if(!(isValidTime(passenger.getTimeMinRange())))
		{
			validationErrors.add("\n passenger time should be between 00 and 24 \n");
		}
		
		if(!validationErrors.isEmpty())
			throw new PassengerException(validationErrors+" ");
	}
	

	private boolean isValidName(String donorName)
	{
		Pattern pat1 = Pattern.compile("^[A-Za-z]{3,}$");
		Matcher mat1 = pat1.matcher(donorName);
		return mat1.matches();
	} 
	
	private boolean isValidPhoneNumber(String passengerContact)
	{
		Pattern pat2 = Pattern.compile("^[6-9][0-9]{9}$");
		Matcher mat2 = pat2.matcher(passengerContact);
		return mat2.matches();
	}
	
	private boolean isValidAge(String passengerAge)
	{
		Pattern pat4 = Pattern.compile("^[1-9][0-9]$");
		Matcher mat4 = pat4.matcher(passengerAge);
		return mat4.matches();
	}
	private boolean isValidOrigin(String passengerOrigin)
	{
		Pattern pat5 = Pattern.compile("[A-Z][a-z]{2,}");
		Matcher mat5 = pat5.matcher(passengerOrigin);
		return mat5.matches();
	}
	private boolean isValidDestination(String passengerDestination)
	{
		Pattern pat6 = Pattern.compile("[A-Z][a-z]{2,}");
		Matcher mat6 = pat6.matcher(passengerDestination);
		return mat6.matches();
	}
	private boolean isValidTime(String timeMinRange)
	{
		Pattern pat7 = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
		Matcher mat7 = pat7.matcher(timeMinRange);
		return mat7.matches();
	}
	
	public boolean validatePassengerId(String passengerId)//validate variables separately which will be used later
	{
		Pattern pat3 = Pattern.compile("[0-9]{1,4}");
		Matcher mat3 = pat3.matcher(passengerId);
		if (mat3.matches())
			return true;
		else 
			return false;
	}


	@Override
	public void cancelTicket(String customerId) throws ClassNotFoundException, SQLException, IOException {
		iPassengerDao = new PassengerDaoImpl();
		iPassengerDao.cancelTicket(customerId);
	}


	

}