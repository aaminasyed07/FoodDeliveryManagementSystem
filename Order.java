package com.FoodDeliveryManagementSystem.model;
	public class Order {  
		private int orderId; 
		private Customer customer; 
		private Restaurant restaurant; 
		private MenuItem item; 
		private int quantity;  
		private double total;  
		private String paymentType; 
		private String status;
		public Order(int orderId, Customer customer,   
				Restaurant restaurant, MenuItem item, 
				int quantity) { 
			this.orderId = orderId;  
			this.customer = customer;     
			this.restaurant = restaurant;  
			this.item = item;  
			this.quantity = quantity;  
			this.total = item.getPrice() * quantity;  
			this.status = "Order Placed";  
			}  
		public int getOrderId() { return orderId; } 
		public Customer getCustomer() { return customer; }  
		public Restaurant getRestaurant() { return restaurant; } 
		public MenuItem getItem() { return item; } 
		public int getQuantity() { return quantity; } 
		public double getTotal() { return total; } 
		public String getPaymentType() { return paymentType; } 
		public String getStatus() { return status; }
		public void setPaymentType(String paymentType) {  
			this.paymentType = paymentType;
			}  
		public void setStatus(String status) {   
			this.status = status;  
			}  
		public void displayBill() {  
			System.out.println("Customer : " + customer.getName());  
			System.out.println("Restaurant : " + restaurant.getName());  
			System.out.println("Item : " + item.getName());  
			System.out.println("Price : " + item.getPrice());   
			System.out.println("Quantity : " + quantity); 
			System.out.println("--------------------------");  
			System.out.println("TOTAL : " + total);   
			} 
		}
     
