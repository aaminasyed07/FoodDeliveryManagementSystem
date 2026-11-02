package com.FoodDeliveryManagementSystem.service;

import com.FoodDeliveryManagementSystem.model.Delivery;
import com.FoodDeliveryManagementSystem.model.Order; 

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OrderProcessor { 
	public static void processOrder(final Order order) { 
		System.out.println("\nORDER PROCESSING"); 
		// 1. Thread: check the order.  
		Thread checkThread = new Thread(new Runnable() {   
			@Override   
			public void run() { 
				System.out.println("Thread: Checking order...");  
				try {        
					Thread.sleep(500);    
					} catch (InterruptedException e) {  
						Thread.currentThread().interrupt();
						}    
				}   
			});        checkThread.start();
			
			 try {  
				 checkThread.join();    
				 } catch (InterruptedException e) {       
					 Thread.currentThread().interrupt();  
					 System.out.println("Order checking was interrupted."); 
					 return;   
					 }    
			 // 2. Runnable: restaurant prepares the food.   
			 Runnable restaurantTask = new Runnable() {   
				 @Override        
				 public void run() {  
					 System.out.println("Runnable: Restaurant is preparing food..."); 
					 try {           
						 Thread.sleep(700); 
						 } catch (InterruptedException e) {  
							 Thread.currentThread().interrupt(); 
								 }  
					 }     
				 };	
				 // 3. Callable: return a delivery assignment message.   
				 Callable<String> deliveryTask = new Callable<String>() { 
					 @Override     
					 public String call() throws Exception {    
						 Thread.sleep(700);  
						 return "Delivery partner assigned";  
						 }    
					 }; 
					 
					 // 4. ExecutorService runs tasks using a fixed thread pool.  
					 ExecutorService executor = Executors.newFixedThreadPool(2);  
					 try {         
						 Future<?> restaurantFuture = executor.submit(restaurantTask);    
						 Future<String> deliveryFuture = executor.submit(deliveryTask); 
						 
						 restaurantFuture.get();  
						 System.out.println("Callable: " + deliveryFuture.get()); 
						 
						 // 5. CompletableFuture updates the delivery status asynchronously. 
						 
						 final Delivery delivery = new Delivery(order.getOrderId()); 
						 CompletableFuture<Void> deliveryUpdate =   
								 CompletableFuture.supplyAsync(() -> { 
									 try {       
										 Thread.sleep(500);  
										 } catch (InterruptedException e) {   
											 Thread.currentThread().interrupt();     
											 }              
									 return "Out for delivery";  
									 }, executor).thenAccept(status -> { 
										 delivery.updateStatus(status);
										 order.setStatus(status);     
										 });
						 
						 deliveryUpdate.join();   
						 System.out.println("Order status: " + order.getStatus());  
						 System.out.println("Order processing completed!");   
						 } catch (Exception e) {    
							 System.out.println("Processing error: " + e.getMessage());  
							 order.setStatus("Processing error");   
							 } finally {      
								 executor.shutdown();    
								 } 
					          }
	
						 
					 
				 
	   
}