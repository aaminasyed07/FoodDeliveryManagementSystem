package com.FoodDeliveryManagementSystem.model;
public class Customer extends Person {
	private String email;   
	public Customer(int id, String name, String email) { 
		super(id, name); 
		this.email = email; 
		} 
	public String getEmail() {  
		return email;   
		}  
	@Override  
	public void displayDetails() {  
		System.out.println("Customer Name: " + name);   
		System.out.println("Email: " + email);  
		}
	} 