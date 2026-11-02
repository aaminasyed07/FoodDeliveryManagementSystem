package com.FoodDeliveryManagementSystem.app;
import com.FoodDeliveryManagementSystem.service.DataManager; 
import com.FoodDeliveryManagementSystem.service.JsonManager;
import com.FoodDeliveryManagementSystem.service.OrderProcessor;
import com.FoodDeliveryManagementSystem.model.Customer;
import com.FoodDeliveryManagementSystem.model.FoodItem;
import com.FoodDeliveryManagementSystem.model.MenuItem;
import com.FoodDeliveryManagementSystem.model.Order;
import com.FoodDeliveryManagementSystem.model.Restaurant; 
import java.io.IOException; import java.util.Scanner;
public class Main { 

	public static void main(String[] args) {    
		Restaurant foodPalace = new Restaurant(1, "Food Palace"); 
		foodPalace.addMenuItem(new FoodItem(101, "Chicken Biryani", 180.00));
		foodPalace.addMenuItem(new FoodItem(102, "Veg Biryani", 140.00));     
		foodPalace.addMenuItem(new FoodItem(103, "Chicken Fried Rice", 160.00));  
		Restaurant pizzaHub = new Restaurant(2, "Pizza Hub");   
		pizzaHub.addMenuItem(new FoodItem(201, "Veg Pizza", 200.00));   
		pizzaHub.addMenuItem(new FoodItem(202, "Chicken Pizza", 250.00));  
		pizzaHub.addMenuItem(new FoodItem(203, "Cheese Pizza", 180.00));   
		DataManager.addRestaurant(foodPalace); 
		DataManager.addRestaurant(pizzaHub);    
		try (Scanner scanner = new Scanner(System.in)) {  
			System.out.println("=================================="); 
			System.out.println(" FOOD DELIVERY MANAGEMENT SYSTEM");       
			System.out.println("==================================");       
			System.out.print("Enter your name: ");     
			String name = scanner.nextLine().trim();   
			System.out.print("Enter your email: ");     
			String email = scanner.nextLine().trim();  
			if (name.isEmpty() || email.isEmpty()) {    
				System.out.println("Name and email cannot be empty.");  
				return;    
				}     
			Customer customer = new Customer(1, name, email); 
			System.out.println("\nAvailable Restaurants:"); 
			DataManager.displayRestaurants();   
			System.out.print("\nSelect Restaurant ID: ");
			if (!scanner.hasNextInt()) { System.out.println("Please enter a numeric    "
					+ "             restaurant ID."); return; }     
			Restaurant selectedRestaurant =  
					DataManager.searchRestaurant(scanner.nextInt());  
			if (selectedRestaurant == null) { System.out.println("Restaurant not        "
					+ "         found."); return; }  
			System.out.println("\nMenu of " + selectedRestaurant.getName());
			selectedRestaurant.displayMenu();      
			System.out.print("\nSelect Food ID: ");         
			if (!scanner.hasNextInt()) { System.out.println("Please enter a numeric        "
					+ "         food ID."); return; }      
			MenuItem selectedItem =             
					selectedRestaurant.searchMenuItem(scanner.nextInt());     
			if (selectedItem == null) { System.out.println("Food item not found."); 
			return; }  
			System.out.print("Enter quantity: "); 
			if (!scanner.hasNextInt()) {
				System.out.println("Quantity must be a whole number."); return; } 
			int quantity = scanner.nextInt(); 
			
			if (quantity <= 0) {
				System.out.println("Quantity must be greater than zero.");
		 		 return;
		}
			  Order order = new Order(1001, customer, selectedRestaurant, selectedItem,    
			  quantity);      
			  System.out.println("\n========== BILL ==========");     
			 order.displayBill();      
			 System.out.println("\nPayment Types:");      
			 System.out.println("1. UPI\n2. Card\n3. Cash on Delivery");   
			 System.out.print("Select payment type: ");    
			 
			 if (!scanner.hasNextInt()) {
				    System.out.println("Please enter 1, 2, or 3.");
				    return;
				}			 
			 int choice = scanner.nextInt(); 
			 	         String paymentType;      
			 	        switch (choice) {
			 	       case 1:
			 	           paymentType = "UPI";
			 	           break;

			 	       case 2:
			 	           paymentType = "Card";
			 	           break;

			 	       case 3:
			 	           paymentType = "Cash on Delivery";
			 	           break;

			 	       default:
			 	           paymentType = "Cash on Delivery";
			 	           System.out.println("Invalid choice; using Cash on Delivery.");
			 	           break;
			 	   }
			 	         order.setPaymentType(paymentType);      
			 	         System.out.println("Payment selected: " + paymentType);        
			 	         DataManager.addOrder(order);  
			 	         OrderProcessor.processOrder(order); 
			 	         try {   
			 	        	 JsonManager.saveOrder(order);
			 	        	 } catch (IOException e) {   
			 	        		 System.out.println("Could not save order.json: " + e.getMessage());   
			 	        		 }   
			 	         System.out.println("Thank you for using Food Delivery!");
			 	         }  
			        }
			    }
					
	
			
		
	
