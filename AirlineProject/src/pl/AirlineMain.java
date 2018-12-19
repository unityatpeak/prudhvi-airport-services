package pl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import exception.FlightException;
import exception.PassengerException;
import passenger.Flight;
import passenger.GetTicket;
import passenger.Passenger;
import passenger.Ticket;
import service.FlightServiceImpl;
import service.IFlightService;
import service.IPassengerService;
import service.PassengerServiceImpl;

public class AirlineMain
{
	static Scanner sc = new Scanner(System.in);
	static IPassengerService iPassengerService = null;
	static IFlightService iFlightService = null;
	static PassengerServiceImpl passengerServiceImpl = null;
	static FlightServiceImpl flightServiceImpl = null;
	static Logger logger = Logger.getRootLogger();
		

		public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, FlightException
		{
			
			PropertyConfigurator.configure("resources//log4j.properties");
			System.out.println(" enter 1 for passenger , enter 2 for admin :");
			int opt = sc.nextInt();
			boolean login = true;
			while(login)
			{
				switch(opt)
				{
					case 1:
						getPassenger();
						login = false;
						break;
					case 2:
						getAdmin();
						login = false;
						break;
					default:
						System.out.println(" you have not choose correct option ");
						break;
				}
			}
		}
		
		static void getPassenger() throws ClassNotFoundException, SQLException, IOException
		{
			Passenger passenger = null;
			String passengerId = null;
			
			int option=0;
			boolean pass = true;
			while(pass)
			{
				System.out.println("CAPGEMINI AIR SERVICES");
				System.out.println("----------------------------\n");
				System.out.println(" 1.Add Passenger ");
				System.out.println(" 2.View Passenger Details ");
				System.out.println(" 3.Book Ticket ");
				System.out.println(" 4.Cancel Ticket ");
				System.out.println(" 5. Exit");
				System.out.println(" ------------------");
				System.out.println("select an option :");
				
				option = sc.nextInt();
				switch(option)
				{
					case 1:
						while(passenger==null)
						{
							passenger = populatePassenger();
						}
						try
						{
							iPassengerService = new PassengerServiceImpl();
							
							passengerId = iPassengerService.addPassenger(passenger);
							
							System.out.println("donator details has been successfully added");
							System.out.println("donator id : "+passengerId);
						}
						catch(Exception e1)
						{
							System.err.println("error :"+e1.getMessage());
						}
						finally
						{
							passengerId=null;
							passengerServiceImpl=null;
							passenger=null;
						}
					
						break;
					case 2:
						System.out.println(" enter id of passenger you want details ");
						passengerId = sc.next();
						try
						{
							passenger= new Passenger();
							iPassengerService = new PassengerServiceImpl();
							passengerServiceImpl = new PassengerServiceImpl();
						
							if(passengerServiceImpl.validatePassengerId(passengerId))
							{
								passenger= iPassengerService.viewPassenger(passengerId);
								System.out.println(passenger);
							}
							else
							{
								System.out.println("passenger id failed in validation ");
							}
						}
						catch(Exception exc)
						{
							System.err.println("error:"+exc.getMessage());
						}
						break;
					case 3:
						Ticket ticket = new Ticket();
						GetTicket getTicket = new GetTicket();
						System.out.println("enter details to book ticket ");
						String customerId = null;
						String origin=null;
						String destination = null;
						System.out.println("enter customerID : ");
						ticket.setPassengerId(sc.next());
						System.out.println(" enter origin : ");
						ticket.setOrigin(sc.next());
						System.out.println("enter destination : ");
						ticket.setDestination(sc.next());
						try {
						iPassengerService = new PassengerServiceImpl();
						getTicket = iPassengerService.bookTicket(ticket);
						System.out.println(getTicket);
						}
						catch(Exception e)
						{
							System.err.println(e.getMessage());
						}
						pass = false;
						break;
						
					case 4:
						iPassengerService = new PassengerServiceImpl();
						passengerServiceImpl = new PassengerServiceImpl();
						System.out.println(" enter passenger id to cancel ticket :");
						passengerId = null;
						passengerId = sc.next();
						if(passengerServiceImpl.validatePassengerId(passengerId))
						{
							try
							{
								iPassengerService.cancelTicket(passengerId);
								System.out.println(" ticket successfullt cancelled ");
								System.out.println(" Your money will be refunded in 3-7 days ");
							}
							catch(Exception pe)
							{
								System.out.println(pe.getMessage());
							}
						}
					case 5:
						System.exit(0);
					default:
						pass = false;
						break;
				}
			}
		}
		static void getAdmin() throws FlightException, ClassNotFoundException, SQLException, IOException
		{
			Flight flight = null;
			String flightId = null;
			
			int option1=0;
			boolean pass1 = true;
			while(pass1)
			{
				System.out.println("CAPGEMINI AIRLINES");
				System.out.println("----------------------------\n");
				System.out.println(" 1.Add Flight ");
				System.out.println(" 2.View Flight Details ");
				System.out.println(" 3.Remove Flight ");
				System.out.println(" 4. Exit");
				System.out.println(" ------------------");
				System.out.println("select an option :");
				
				option1 = sc.nextInt();
				switch(option1)
				{
					case 1:
						while(flight==null)
						{
							flight = populateFlight();
						}
						try
						{
							iFlightService = new FlightServiceImpl();
							
							flightId = iFlightService.addFlight(flight);
							
							System.out.println("flight details has been successfully added");
							System.out.println("flight id : "+flightId);
						}
						catch(Exception e1)
						{
							System.err.println("error :"+e1.getMessage());
						}
						finally
						{
							flightId=null;
							passengerServiceImpl=null;
							flight=null;
						}
					
						break;
					case 2:
						System.out.println(" enter id of flight you want details ");
						flightId = sc.next();
						flight = new Flight();
						iFlightService = new FlightServiceImpl();
						flightServiceImpl = new FlightServiceImpl();

						if(flightServiceImpl.validateFlightId(flightId))
						{
							flight= iFlightService.viewFlight(flightId);
							System.out.println(flight);
						}
						else
						{
							System.out.println("flight id failed in validation ");
						}
						break;
					case 3:
						System.out.println("enter id of flight you want to delete: ");
						flightId=null;
						flightId = sc.next();
						flight = new Flight();
						iFlightService = new FlightServiceImpl();
						flightServiceImpl = new FlightServiceImpl();

						if(flightServiceImpl.validateFlightId(flightId))
						{
							try {
									iFlightService.deleteFlight(flightId);
									System.out.println(" flight deleted successfully ......");
								}
							catch(Exception fe)
							{
								System.err.println(fe.getMessage());
							}
							
						}
						pass1=false;
						break;
					default:
						System.exit(0);
						break;
				}
			}
		}
		
		static public Passenger populatePassenger()
		{
			Passenger passenger = new Passenger();
			System.out.println(" Enter passenger details ");
			System.out.println("---*---*---*---*---*---*---*---*---");
			
			System.out.println(" Enter passenger name        : ");
			passenger.setPassengerName(sc.next());
			
			System.out.println(" Enter Passenger Age         : ");
			passenger.setPassengerAge(sc.next());
			
			System.out.println(" Enter Passenger contact     : ");
			passenger.setPassengerContact(sc.next());
			
			System.out.println(" Enter min time range        : ");
			passenger.setTimeMinRange(sc.next());
			
			System.out.println(" Enter max time range        : ");
			passenger.setTimeMaxRange(sc.next());
			
			System.out.println(" enter passenger origin loc  : ");
			passenger.setPassengerOrigin(sc.next());
			
			System.out.println(" enter passenger destination loc : ");
			passenger.setPassengerDestination(sc.next());
			
			passengerServiceImpl = new PassengerServiceImpl();
			try
			{
				passengerServiceImpl.validatePassenger(passenger);
				return passenger;
			}
			catch(PassengerException pe)
			{
				System.out.println(" invalid data : ");
				System.err.println(pe.getMessage());
			}
			return null;
		}
		
		static public Flight populateFlight()
		{
			Flight flight = new Flight();
			System.out.println(" Enter flight details ");
			System.out.println("---*---*---*---*---*---*---*---*---");
			
			System.out.println(" Enter flight name        : ");
			flight.setFlightName(sc.next());
			
			System.out.println(" Enter number of seats    : ");
			flight.setSeatsCount(sc.next());
			
			System.out.println(" Enter flight time        : ");
			flight.setFlightTime(sc.next());
			
			System.out.println(" Enter flight origin loc  : ");
			flight.setFlightOrigin(sc.next());
			
			System.out.println(" Enter flight destination loc: ");
			flight.setFlightDestination(sc.next());

			System.out.println(" Enter flight ticket price in EURO   : ");
			flight.setTicketPrice(sc.next());
			
			System.out.println(" Enter seat type             : ");
			flight.setSeatType(sc.next());
			
			
			flightServiceImpl = new FlightServiceImpl();
			try
			{
				flightServiceImpl.validateFlight(flight);
				return flight;
			}
			catch(FlightException pe)
			{
				System.out.println(" invalid data : ");
				System.err.println(pe.getMessage());
			}
			return null;
		}
	
}