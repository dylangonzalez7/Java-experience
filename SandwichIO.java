import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.*;


public class SandwichIO {
	
	public static void writeToOrderFile(Order order) {
		try {
			Date now = new Date();
            DateFormat defaultDate = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
            String time = defaultDate.format(now);
            String orderLine = time + " " + order.getCustomerName() + " " + order.getSandwich() + "\n";

            FileWriter fileWriter = new FileWriter("orderline.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(orderLine);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}