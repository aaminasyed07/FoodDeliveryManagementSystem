package com.FoodDeliveryManagementSystem.model;
	import java.util.ArrayList;
	public class Restaurant { 
		private int id;  
		private String name; 
		private ArrayList<MenuItem> menuItems;  
		public Restaurant(int id, String name) { 
			this.id = id;   
			this.name = name; 
			menuItems = new ArrayList<>();  
			}  
		public int getId() { return id; }  
		public String getName() { return name; } 
		public void addMenuItem(MenuItem item) {   
			menuItems.add(item);  
			}  
		public void displayMenu() {  
			for (MenuItem item : menuItems) {  
				item.displayItem(); 
				}  
			}  
		public MenuItem searchMenuItem(int id) {  
			for (MenuItem item : menuItems) {  
				if (item.getId() == id) 
					return item;  
				}     
			return null;  
			}  
		public ArrayList<MenuItem> getMenuItems() {  
			return menuItems;   
			}
		}
	
