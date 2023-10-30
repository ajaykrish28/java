package com.aspiresys;

import java.util.*;
class MessDetails{
	String sql,data,subject,reason,emailId;
	Scanner scanner = new Scanner(System.in);
	
	void viewMessInfo() {
		sql =" select * from  MessMenu ;";
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "ViewMessMenu");
		System.out.println(sql);
		
	}
	void dataValidation() {
		System.out.println(" Enter Date");
		 data =scanner.nextLine();
		 if(  data.isEmpty()) {
				System.out.println("Enter the Proper user Name");
				dataValidation();			}
			else {
				sujectValidation();
				
			}
	}
	void sujectValidation() {
		System.out.println(" Enter Subject");
		
	subject=scanner.nextLine();
	 if(  subject.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			sujectValidation();			}
		else {
			reasonValiatation();
			
		}}
	void reasonValiatation() {
		System.out.println(" Enter Discription");
		 reason=scanner.nextLine();
		 if(  reason.isEmpty()) {
				System.out.println("Enter the Proper user Name");
				sujectValidation();			}
			else {
				queryMess();				
			}
	}
	void queryMess() {
		sql ="insert into MessQueries Values("+"'"+data+"',"+"'"+subject+"',"+"'"+reason+"'"+");";
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "UserMessQueries");
		System.out.println(sql);
		
	
	}
	void choice(String emailID) {
		
		
		UserNav userNav= new UserNav();
		System.out.println(" Enter 1 to view Menu");
		System.out.println(" Enter 2 for Queries");
		System.out.println(" Enter 3 to Navigation Bar");

		String option =scanner.nextLine();
		if(option.equals("1")) {
			
			viewMessInfo();
		}
		else if(option.equals("2")) {
			 dataValidation();
		}
		else if(option.equals("3")) {
			emailId =emailID;
			userNav.main(emailId);
		}
		
		else {
			System.out.println("Please Enter the Correct Value ");
			choice(emailId);
		}
		
		scanner.close();
		
	}
}




public class UserMess {
	String emailId;
	public static void main(String email) {
		// TODO Auto-generated method stub
     email=email;
		System.out.println("Student Mess");
		MessDetails messDetails = new MessDetails();
		messDetails.choice(email);

	}

}
