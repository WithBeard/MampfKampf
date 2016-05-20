package com.example.mampfkampf;

import java.util.ArrayList;
import java.util.List;

public class MampfkampfController {
	private List<String> users;
	private List<String> restaurants;

	public MampfkampfController(){
		users = new ArrayList<String>();
		restaurants = new ArrayList<String>();
		
		users.add("Hans");
		users.add("Wurst");
		
		restaurants.add("fress");
		restaurants.add("mampf");
		restaurants.add("kau");
		
	}
	
	public List<String> getUsers(){
		return users;
	}
	public List<String> getRestaurants(){
		return restaurants;
	}
}
