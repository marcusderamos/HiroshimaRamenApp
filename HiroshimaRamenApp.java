import java.util.Scanner;

// Class for holding delivery details for date and time.
class DeliveryDetails {
	protected String deliveryDate; // Stores the date of delivery.
    	protected String deliveryTime; // Stores the time of delivery.

// Constructor initializes delivery details with date and time.
public DeliveryDetails(String date, String time) {
	deliveryDate = date;
	deliveryTime = time;
	}

// Method to display delivery details.
	public void displayDeliveryDetails() {
		System.out.println("Delivery Date: " + deliveryDate);
		System.out.println("Delivery Time: " + deliveryTime);
	}
}

// Class representing a ramen order, including the type of ramen and delivery details.
class RamenOrder extends DeliveryDetails {
    	private String ramenChoice; // Stores the chosen ramen.

// Constructor initializes a ramen order with choice, date, and time.
public RamenOrder(String choice, String date, String time) {
	super(date, time); // Call to superclass constructor to set date and time.
	ramenChoice = choice;
	}

// Method to display the summary of the ramen order.
public void displayOrderSummary() {
	System.out.println("\nYour Order :");
	System.out.println("Ramen Choice: " + ramenChoice);
	super.displayDeliveryDetails(); // Displays the inherited delivery details.
    	}
}

// Main class to run the Hiroshima Ramen App.
public class HiroshimaRamenApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hiroshima Ramen App!");

	// Ramen options for the user.
	String[] ramens = {"Miso Ramen", "Spicy Miso Ramen", "Tonkatsu Ramen", "Spicy Tonkatsu Ramen"};
        	System.out.println("Please choose your ramen:");
	for (int i = 0; i < ramens.length; i++) {
		System.out.println((i + 1) + ". " + ramens[i]);
	}

	int ramenIndex = scanner.nextInt() - 1;
	scanner.nextLine(); // newline to clear the input
	while (ramenIndex < 0 || ramenIndex >= ramens.length) {
		System.out.println("Invalid option. Please choose a correct option:");
		ramenIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // newline again.
        }

        // Get delivery date from the user.
	System.out.println("Please enter delivery date (DD/MM/YYYY):");
	String deliveryDate = scanner.nextLine();

	// Delivery time. 
	String deliveryTime = "";
	boolean validSelection = false;
	while (!validSelection) {
		System.out.println("Please choose delivery time: \n1. Lunch delivery 12:00 PM - 3:00 PM \n2. Dinner delivery 6:00 PM - 8:00 PM");
	String deliveryTimeChoice = scanner.nextLine().trim();
		switch (deliveryTimeChoice) {
			case "1":
				deliveryTime = "12:00 PM - 3:00 PM"; // Set lunch time.
				validSelection = true;
				break;
			case "2":
				deliveryTime = "6:00 PM - 8:00 PM"; // Set dinner time
				validSelection = true;
				break;
                	default:
 				System.out.println("Invalid choice. Please select 1 for Lunch or 2 for Dinner.");
                    	// Loop continues for invalid input, forcing the user to input the correct time.
	}
}

	RamenOrder order = new RamenOrder(ramens[ramenIndex], deliveryDate, deliveryTime);
	order.displayOrderSummary(); // Display the complete order summary.
	System.out.println("Thank you for choosing Hiroshima Ramen!");

        scanner.close(); // Close the scanner
	}
}
