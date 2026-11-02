package com.FoodDeliveryManagementSystem.service; 
import com.FoodDeliveryManagementSystem.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
public class JsonManager { 
	public static void saveOrder(Order order) throws IOException { 
		ObjectMapper mapper = new ObjectMapper(); 
		OrderData data = new OrderData(order);
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("order.json"), data);  
		System.out.println("Order saved successfully to order.json");  
		} 
	}
