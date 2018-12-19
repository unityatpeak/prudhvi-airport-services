package passenger;

public class Ticket {
	
	private String passengerId;
	private String origin;
	private String destination;
	
	//Generate setters and getters of variables declared
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getOrigin() {
		return origin;
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
	
	//override toString method to display this class object 
	@Override
	public String toString() {
		return "Ticket [passengerId=" + passengerId + ", origin=" + origin + ", destination=" + destination + "]";
	}
	
	

}