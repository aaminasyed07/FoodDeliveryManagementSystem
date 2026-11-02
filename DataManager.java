package com.FoodDeliveryManagementSystem.service;
 import com.FoodDeliveryManagementSystem.model.Order; 
 import com.FoodDeliveryManagementSystem.model.Restaurant; 
 import java.util.ArrayList; 
 import java.util.Comparator; 
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 public class DataManager { 
	 private static final Map<Integer, Restaurant> restaurants =       
			 new HashMap<Integer, Restaurant>();  
	 private static final List<Order> orders = new ArrayList<Order>(); 
	 public static void addRestaurant(Restaurant restaurant) {   
		 restaurants.put(restaurant.getId(), restaurant);
		 }  
	 public static Restaurant searchRestaurant(int id) { 
		 return restaurants.get(id);  
		 } 
	 public static void displayRestaurants() {  
		 List<Restaurant> sorted = new ArrayList<Restaurant>(restaurants.values());  
		 sorted.sort(Comparator.comparing(Restaurant::getName));   
		 for (Restaurant restaurant : sorted) { 
			 System.out.println(restaurant.getId() + " - " + restaurant.getName()); 
			 }  
		 } 
	 public static void addOrder(Order order) {    
		 orders.add(order);  
		 } 
	 public static Order searchOrder(int id) {  
		 for (Order order : orders) {   
			 if (order.getOrderId() == id) {
				 return order;  
				 }    
			 }    
		 return null;  
		 } 
	 public static int getOrderCount() {  
		 return orders.size();  
		 }
	 }


