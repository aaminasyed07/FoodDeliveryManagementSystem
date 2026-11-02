package com.FoodDeliveryManagementSystem.model;
public class FoodItem extends MenuItem { 
	public FoodItem(int id, String name, double price) {  
		super(id, name, price);  
		}  
	@Override  
	public void displayItem() { 
		System.out.println(   
				id + " - " + name + " -   " + price 
				);
	}
}