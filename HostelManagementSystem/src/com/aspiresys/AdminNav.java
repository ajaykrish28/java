package com.aspiresys;

import java.util.*;




class Navigate{
	
	
	AdminProfile adminProfile= new AdminProfile();
	AdminRooms adminRooms =new AdminRooms();
	AdminQueries adminQueries= new AdminQueries();
	Home home =new Home();
	
	
	
	Scanner scanner = new Scanner(System.in);
	void nav() {
		System.out.println(" Enter 1 to Admin Profile Page");
		System.out.println(" Enter 2 to Admin Room Page");
		System.out.println(" Enter 3 to Admin Queries Pages");
		System.out.println(" Enter 4 to LogOut");
		String option =scanner.nextLine();
		if(option.equals("1")) {
			
			adminProfile.main(null);
		}
		else if(option.equals("2")) {
			adminRooms.main(null);
		}
		else if(option.equals("3")) {
			adminQueries.main(null);
		}
		else if(option.equals("4")) {
			home.main(null);
		}
		else {
			System.out.println("Please Enter the Correct Value ");
			nav();
		}
		
		scanner.close();
		
	}
	
}

public class AdminNav {

	
	
	
	public static void main(String[] args) {
		
		System.out.println(".................ADMIN NAVIGATION.....................");
		Navigate navigate=new Navigate();
		
		navigate.nav();	
		}
	

}
