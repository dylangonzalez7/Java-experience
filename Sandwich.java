import java.util.ArrayList;

public class Sandwich {
	
	private String bread;
	private ArrayList<String> vegetables;
	private String meat;
	private double price;
	
	public Sandwich(String bread, ArrayList<String> vegetables, String meat, double price) {
		this.bread = bread;
		this.vegetables = vegetables;
		this.meat = meat;
		this.price = price;
		
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return bread + " " +  vegetables + " " + meat + " $" + price;
		
	}

}
