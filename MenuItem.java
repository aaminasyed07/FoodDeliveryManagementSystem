package com.FoodDeliveryManagementSystem.model;
public abstract class MenuItem {  
	protected int id;  
	protected String name; 
	protected double price; 
	public MenuItem(int id, String name, double price) {   
		this.id = id;   
		this.name = name; 
		this.price = price;  
		}  
	public abstract void displayItem(); 
	public int getId() { return id; }   
	public String getName() { return name; }  
	public double getPrice() { return price; }
	} 
