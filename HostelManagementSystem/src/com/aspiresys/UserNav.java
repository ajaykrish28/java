package com.aspiresys;
import java.util.*;

class Userḍetails{
	String sql ,emailId;
	UserQueries userQueries = new UserQueries();
	UserMess userMess = new UserMess();
	
	void getDetails(String email) {
		{
			System.out.println("hiii");
			sql =" select * from  AdminProfile where emailId ='"+email+"' ;";
			Jdbc_coonection jdbc =new Jdbc_coonection();
			jdbc.databaseConnection(sql, "UserProfile");
			emailId= email;
			 menuList(emailId);
//			System.out.println( "view  database");
//			System.out.println(sql );
			
		}}
		void menuList( String emailId) {

			Scanner scanner = new Scanner(System.in);
			
			UserProfile userProfile= new UserProfile();
			System.out.println(" Enter 1 to Profile");
			System.out.println(" Enter 2 to Queries");
			System.out.println(" Enter 3 to Mess");
			System.out.println(" Enter 4 to User Navigator");
			System.out.println(" Enter 5 to Home");
			String option =scanner.nextLine();
			if(option.equals("1")) {
				
				userProfile.main(emailId);
			}
			else if(option.equals("2")) {
				userQueries.main(emailId);
			}
			else if(option.equals("3")) {
				userMess.main(emailId);
			}
//			else if(option.equals("4")) {
//				studentDataManagement.updateData();
//			}
			else {
				System.out.println("Please Enter the Correct Value ");
				menuList(emailId);
			}
			
			scanner.close();
			
		
	}
}



public class UserNav {

	public static void main(String emailId) {
		String email= emailId;
	System.out.println("hiii"+email);
	Userḍetails userḍetails= new Userḍetails();
	userḍetails.getDetails(email);
	}

}
