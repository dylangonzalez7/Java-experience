import java.util.Scanner;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SandwichApp {
	
	public static boolean isValidIntRange(int value, int min, int max) {
		return value >= min && value <= max;
	}
	
	
	//Arrays for ingredients
    private static String[] bread = {"White Bread", "Wheat Bread", "French Bread", "Organic Bread"};
    private static double[] bread_prices = {1.5, 1.6, 1.8, 2.0};
    private static String[] vegetable = {"red onions", "olives", "pickles", "lettuce", "green peppers", "tomatoes", "cheese"};
    private static double[] vegetable_prices = {0.05, 0.10, 0.10, 0.20, 0.25, 0.30, 0.50};
    private static String[] meat = {"Ham", "Roasted Chicken Breast", "Turkey Breast", "Roast Beef"};
    private static double[] meat_prices = {1.0, 1.1, 1.2, 1.5};

    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueOrder = true;
        while (continueOrder) {
            selectSandwich();
            System.out.print("Continue to order more sandwiches? (y/n): ");
            String input = scnr.nextLine();
            continueOrder = input.equalsIgnoreCase("y");
        }
    }

    private static void selectSandwich() {
        System.out.println("=== Select Sandwich Bread: ===\n");
        for (int i = 0; i < bread.length; i++) {
            System.out.println((i + 1) + " " + bread[i] + " $" + bread_prices[i]);
        }
        int breadChoice = getIntInput("\nSelect a bread [1, " + bread.length + "]: ", 1, bread.length);

        ArrayList<String> selectedVegetables = selectVegetables();

        System.out.println("\n=== Select Sandwich Meat: ===\n");
        for (int i = 0; i < meat.length; i++) {
            System.out.println((i + 1) + " " + meat[i] + " $" + meat_prices[i]);
        }
        int meatChoice = getIntInput("\nSelect meat [1, " + meat.length + "]: ", 1, meat.length);

        scnr.nextLine(); 
        
        System.out.print("Enter customer's name: ");
        String customerName = scnr.nextLine();

        double totalPrice = bread_prices[breadChoice - 1];
        for (String vegetable : selectedVegetables) {
            totalPrice += getVegetablePrice(vegetable);
        }
        totalPrice += meat_prices[meatChoice - 1];

        Sandwich sandwich = new Sandwich(bread[breadChoice - 1], selectedVegetables, meat[meatChoice - 1], totalPrice);
        Order order = new Order(customerName, sandwich, DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()));
        System.out.println(order);
        SandwichIO.writeToOrderFile(order);
    }

    private static ArrayList<String> selectVegetables() {
        ArrayList<String> selectedVegetables = new ArrayList<>();
        while (true) {
            System.out.println("\n=== Select Sandwich Vegetables: ===\n");
            for (int i = 0; i < vegetable.length; i++) {
                System.out.println((i + 1) + " " + vegetable[i] + " $" + vegetable_prices[i]);
            }
            System.out.println(vegetable.length + 1 + " Quit vegetable selection");
            int choice = getIntInput("\nSelect vegetables: [1, " + (vegetable.length + 1) + "]: ", 1, vegetable.length + 1);
            if (choice == vegetable.length + 1) {
                break;
            } else {
                selectedVegetables.add(vegetable[choice - 1]);
            }
        }
        return selectedVegetables;
    }
    private static int getIntInput(String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            while (!scnr.hasNextInt()) {
                System.out.println("Error! Please enter a valid integer.");
                System.out.print(prompt);
                scnr.next();
            }
            input = scnr.nextInt();
            if (isValidIntRange(input, min, max)) {
                break;
            } else {
                System.out.println("Error! Number must be between " + min + " and " + max + ".");
            }
        }
        return input;
    }

    private static double getVegetablePrice(String vegetables) {
        for (int i = 0; i < vegetable.length; i++) {
            if (vegetable[i].equals(vegetables)) {
                return vegetable_prices[i];
            }
        }
        return 0.0;
    }
}