package com.FoodDeliveryManagementSystem.model;
public abstract class Person {  
	protected int id; 
	protected String name;  
	public Person(int id, String name) {    
		this.id = id;   
		this.name = name;  
		}   
	public abstract void displayDetails(); 
	public String getName() { 
		return name;  
		}
	} 