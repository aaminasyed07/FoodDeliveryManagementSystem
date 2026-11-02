package com.FoodDeliveryManagementSystem.model;
	public class Delivery {  
		private int deliveryId; 
		private String status;  
		public Delivery(int deliveryId) {    
			this.deliveryId = deliveryId;  
			this.status = "Preparing";  
			}  
		public void updateStatus(String status) {   
			this.status = status;  
			System.out.println("Delivery Status: " + status);   
			}  
		public String getStatus() { 
			return status;   
			} 
		}
	
