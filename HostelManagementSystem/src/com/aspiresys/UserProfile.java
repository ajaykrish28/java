package com.aspiresys;

import java.util.*;
class Profile{
	Scanner scanner = new Scanner(System.in);
	
	String sql,emailId;
	UserNav userNav= new UserNav();
	UserQueries userQueries = new UserQueries();
	UserMess userMess = new UserMess();
 void getDetails(String email) {
	{
		
		sql =" select * from  AdminProfile where emailId ='"+email+"' ;";
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "UserProfileAccess");
		emailId= email;
		ProfilemenuList(emailId);
//		System.out.println( "view  database");
//		System.out.println(sql );
		
	}}
 
void ProfilemenuList(String emailId) {
	System.out.println(" Enter 1 to view Menu");
//	System.out.println(" Enter 2 for Queries");
	System.out.println(" Enter 3 to Navigation Bar");

	String option =scanner.nextLine();
	if(option.equals("1")) {
		
		getDetails( emailId);
	}
//	else if(option.equals("2")) {
//		 dataValidation();
//	}
	else if(option.equals("3")) {
		emailId =emailId;
		userNav.main(emailId);
	}
	
	
	
}
void userProfileUpdate() {}
 }



public class UserProfile {
String emailId ;
	public static void main(String emailId) {
		emailId =emailId;
		Profile profile= new Profile();
		profile. getDetails( emailId) ;

	}

}
