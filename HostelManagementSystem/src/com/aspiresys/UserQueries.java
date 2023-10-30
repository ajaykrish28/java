package com.aspiresys;

import java.util.*;

class QueriesUpdate{
	String emailID,regNo,subject,discribe,sql,emailId;
	Scanner scanner = new Scanner(System.in);
	void emailValidation() {
		System.out.println(" Enter Email Id");
		emailID=scanner.nextLine();
		 if(  emailID.isEmpty()) {
				System.out.println("Enter the Proper user Name");
				emailValidation();			}
			else {
				regNoValidation();
				
			}
	}
	void regNoValidation() {
		System.out.println(" Enter Register Number");
		regNo=scanner.nextLine();
		 if(  regNo.isEmpty()) {
				System.out.println("Enter the Proper user Name");
				regNoValidation();			}
			else {
				subjectValidation();
				
			}}
	void subjectValidation() {
		System.out.println(" Enter Subject");
		subject=scanner.nextLine();
		 if(  subject.isEmpty()) {
				System.out.println("Enter the Proper user Name");
				subjectValidation();			}
			else {
				discribe();
				
			}}
	void discribe() {
		System.out.println(" Enter Discribe");
		discribe=scanner.nextLine();
		 if(  discribe.isEmpty()) {
				System.out.println("Enter the Proper user Name");
				discribe();			}
			else {
				updateQueries();
				
			}}
	void updateQueries() {
		
		sql="insert into  UserQueryDetails Values("+"'"+emailID+"',"+"'"+regNo+"',"+"'"+subject+"',"+"'"+discribe+"'"+");";
		
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "UserQueryDetails");
		System.out.println(sql);
		System.out.println(" Successfully Updated");
		
	}
	void Choice(String email) {

	
    UserNav  userNav = new UserNav ();
	System.out.println(" Enter 1 to Queries");
	System.out.println(" Enter 2 to Navigation Bar");
//	System.out.println(" Enter 3 to Delete the Data in Database");
//	System.out.println(" Enter 4 to Delete the Data in Database");
	String option =scanner.nextLine();
	if(option.equals("1")) {
		
		emailValidation();	}
	else if(option.equals("2")) {
		email=email;
		userNav.main(email);
	}
//	else if(option.equals("3")) {
//		studentDataManagement.deleteData();
//	}
//	else if(option.equals("4")) {
//		studentDataManagement.updateData();
//	}
	else {
		System.out.println("Please Enter the Correct Value ");
		Choice(emailID);
		
	}
	
	scanner.close();}
	
}
public class UserQueries {

	public static void main(String email) {
		System.out.println(".......................User Queries page............................");
		QueriesUpdate queriesUpdate=new QueriesUpdate();
		queriesUpdate.Choice(email);
	}

}
