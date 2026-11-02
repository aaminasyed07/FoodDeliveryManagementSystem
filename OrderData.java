package com.FoodDeliveryManagementSystem.service;
import com.FoodDeliveryManagementSystem.model.Order;

public class OrderData {  
	public int orderId;
	public String customerName;   
	public String email;  
	public String restaurant; 
	public String item; 
	public int quantity; 
	public double total;  
	public String paymentType; 
	public String status;    
	public OrderData() {  
		// Required by Jackson.  
		}  
	public OrderData(Order order) {   
		this.orderId = order.getOrderId(); 
		this.customerName = order.getCustomer().getName(); 
		this.email = order.getCustomer().getEmail(); 
		this.restaurant = order.getRestaurant().getName(); 
		this.item = order.getItem().getName();   
		this.quantity = order.getQuantity(); 
		this.total = order.getTotal();  
		this.paymentType = order.getPaymentType();  
		this.status = order.getStatus();  
		}
	
	}
