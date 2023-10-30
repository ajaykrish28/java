package com.aspiresys;
import java.util.*;



class FessDetails{
	
	String  status, Month,emailId ,sql;
	Scanner scanner = new Scanner(System.in);
	AdminNav adminNav= new AdminNav();
	Home home = new Home();
	void email() {
		System.out.println("Enter the Email");
	emailId =scanner.nextLine();
	if( emailId.isEmpty()) {
		System.out.println("Enter the Proper user Name");
		email();			}
	else {
		month();
		
	}
	}
	void month() {
		System.out.println("Enter the Month(Ex: jan)");
		 Month =scanner.nextLine();
		 if( emailId.isEmpty()) {
				System.out.println("Enter the Proper user Name");
				month();			}
			else {
				paid();
				
			}
	}
	void paid() {
		System.out.println("Enter the Status");
		 status =scanner.nextLine();
		 if( status.isEmpty()) {
				System.out.println("Enter the Proper user Name");
				paid();			}
			else {
				fees();
				
			}
	}
	void fees() {
	
		sql="insert into FessDetails Values("+"'"+emailId+"',"+"'"+Month+"',"+"'"+status+"'"+");";
		System.out.println(sql);
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "FeesStudentData");
		
	}
	void choice() {
		
		System.out.println(" Enter 1 to Fees");
		System.out.println(" Enter 2 to Navigate Bar");
		
		System.out.println(" Enter 3 to LogOut");
		String option =scanner.nextLine();
		if(option.equals("1")) {
			email();		
		}
		else if(option.equals("2")) {
	
			adminNav.main(null);
	
		}
		else if(option.equals("3")) {
			home.main(null);
			
		}
		else {
			System.out.println("Please Enter the Correct Value ");
		
		}
		
		scanner.close();
		
		
}

}


public class AdminFees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FessDetails fessDetails= new FessDetails();
		fessDetails.choice();
	}

}
