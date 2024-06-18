

public class Order {
	private String customerName;
	private Sandwich sandwich;
	private String timeStamp;

	public Order(String customerName, Sandwich sandwich, String timeStamp) {
		this.customerName = customerName;
		this.sandwich = sandwich;
		this.timeStamp = timeStamp;
	}
	public String getCustomerName() {
		return customerName;
	}
	public Sandwich getSandwich() {
		return sandwich;
	}

	public String getTimeStamp() {
	    return timeStamp;
	}
	public String toString() {
		return timeStamp + " " + customerName + " " + sandwich;
	}
}