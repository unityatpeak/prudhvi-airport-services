package dao;

public interface QueryMapper {
	
	//queries for passengerDaoImpl
	String ADD_PASSENGER_QUERY="insert into Passenger_Details values(PassengerId_Sequence.nextval,?,?,?,?,?,?,?)";
	String GET_PASSENGER_ADDED_QUERY = "select * from Passenger_Details order by passenger_Id";
	String VIEW_PASSENGER_DETAILS_QUERY = "select * from Passenger_Details where passenger_id=?'";
	String GET_FLIGHT_DETAILS_QUERY = "select flighttime,ticketprice from flight_details where flightorigin=? and flightdestination=? order by flightid";
	String UPDATE_PASSENGERTABLE_QUERY = "update passenger_details set ticketid =? where passenger_id=?";
	String CANCEL_TICKET_QUERY = "update passenger_details set ticketid = null where passenger_id=?";
	
	//Queries for flightDaoImpl
	String ADD_FLIGHT_QUERY = "insert into Flight_Details values(FlightId_Sequence.nextval,?,?,?,?,?,?,?)";
	String GET_FLIGHT_ADDED_QUERY = "select * from Flight_Details order by Flight_Id";
	String VIEW_FLIGHT_DETAILS_QUERY = "select * from Flight_Details where flight_Id=?";
	String DELETE_FLIGHT_QUERY = "delete from Flight_Details where flight_Id=?";

}
