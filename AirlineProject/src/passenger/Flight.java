package passenger;

public class Flight {
	
	private String flightName;
	private String flightId;
	private String seatsCount;
	private String flightTime;
	private String flightOrigin;
	private String flightDestination;
	private String ticketPrice;
	private String seatType;
	
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getSeatsCount() {
		return seatsCount;
	}
	public void setSeatsCount(String seatsCount) {
		this.seatsCount = seatsCount;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getFlightOrigin() {
		return flightOrigin;
	}
	public void setFlightOrigin(String flightOrigin) {
		this.flightOrigin = flightOrigin;
	}
	public String getFlightDestination() {
		return flightDestination;
	}
	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	
	
	@Override
	public String toString() {
		return "Flight [flightName=" + flightName + ", flightId=" + flightId + ", seatsCount=" + seatsCount
				+ ", flightTime=" + flightTime + ", flightOrigin=" + flightOrigin + ", flightDestination="
				+ flightDestination + ", ticketPrice=" + ticketPrice + ", seatType=" + seatType + "]";
	}
	
	
	

}
