package passenger;

//this class is to generate ticket
public class GetTicket {

	private double ticketId;
	private String passengerId;
	private String origin;
	private String destination;
	private String flightTime;
	private int price;
	
	//Generate getters and setters for declared variables
	
	
	public String getOrigin() {
		return origin;
	}
	public double getTicketId() {
		return ticketId;
	}
	public void setTicketId(double tId) {
		this.ticketId = tId;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	
	
	//override toString method to get details when object is printed
	@Override
	public String toString() {
		return "GetTicket [ticketId=" + ticketId + ", passengerId=" + passengerId + ", origin=" + origin
				+ ", destination=" + destination + ", flightTime=" + flightTime + ", price=" + price + "]";
	}
	
	
	
}