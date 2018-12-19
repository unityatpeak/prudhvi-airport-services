package passenger;

public class Passenger {

	private String passengerId;
	private String passengerName;
	private String passengerAge;
	private String passengerContact;
	private String timeMinRange;
	private String timeMaxRange;
	private String passengerOrigin;
	private String passengerDestination;
	
	
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerContact() {
		return passengerContact;
	}
	public void setPassengerContact(String passengerContact) {
		this.passengerContact = passengerContact;
	}
	public String getTimeMinRange() {
		return timeMinRange;
	}
	public void setTimeMinRange(String timeMinRange) {
		this.timeMinRange = timeMinRange;
	}
	public String getTimeMaxRange() {
		return timeMaxRange;
	}
	public void setTimeMaxRange(String timeMaxRange) {
		this.timeMaxRange = timeMaxRange;
	}
	public String getPassengerOrigin() {
		return passengerOrigin;
	}
	public void setPassengerOrigin(String passengerOrigin) {
		this.passengerOrigin = passengerOrigin;
	}
	public String getPassengerDestination() {
		return passengerDestination;
	}
	public void setPassengerDestination(String passengerDestination) {
		this.passengerDestination = passengerDestination;
	}
	
	
	@Override
	public String toString()
	{
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerContact=" + passengerContact + ", timeMinRange=" + timeMinRange
				+ ", timeMaxRange=" + timeMaxRange + ", passengerOrigin=" + passengerOrigin + ", passengerDestination="
				+ passengerDestination + "]";
	}
}
