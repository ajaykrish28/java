package com.aspiresys;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class ValidationRegister{
	Scanner scanner = new Scanner (System.in);
	String name,password,emailId,sql;
	 void userNameValidation(){

//			System.out.println("You are in the Register Page");
			System.out.println("Enter the User Name");
			name = scanner.nextLine();
			String nameTrim = name.trim();
			 Pattern pattern = Pattern.compile("\\D+"); // \D matches non-digit characters
		        Matcher matcher = pattern.matcher(name);
		        //constrain for Empty method 1
			if(nameTrim.length()==0 ||!matcher.matches()) {
				System.out.println("Enter the Proper user Name");
				userNameValidation();			}
			else {
				emailValidation();
				
			}
	 }
	 void emailValidation(){
		 System.out.println("Enter the Email ID");
		 emailId = scanner.nextLine();
	        //constrain for email
			String emailPattern = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9]+\\.)+[A-Za-z]+$";
	        Pattern patternEmail = Pattern.compile(emailPattern);
	        Matcher matcherEmail =  patternEmail.matcher(emailId);
	      //constrain for Empty method 2
	    	if(!matcherEmail.matches()|| emailId.isEmpty()) {
				System.out.println("Please Enter the Email Id");
				emailValidation();
			}
	    	else {
	    		passwordValidation();
				
			}
	 }
	 void passwordValidation(){

			System.out.println("Enter the Password");
			 password = scanner.nextLine();
	        //constrain for password
			String passwordPattern = "^[6-9]\\d{9}$";
	        Pattern patternPassword = Pattern.compile(passwordPattern);
	        Matcher matcherpassword=  patternPassword.matcher(password);
	    	if(!matcherpassword.matches()|| password.isEmpty()) {
				System.out.println("Enter the Proper password");
				passwordValidation();
				}
			
			System.out.println("Enter the Confirm PAssword");
			String ConfirmPassword = scanner.nextLine();
			if(ConfirmPassword.isEmpty()) {
				System.out.println("Confirm password should not be empty");
			}
			
			//..........condition
			if(password .equals(ConfirmPassword)) {
				System.out.println("Sucessfully Registerd");
				updateDatabase();
			}
			else {
				System.out.println("password and confirm password is not match");
				passwordValidation();}
	 }
	 void updateDatabase() {
//		 if() {
//			 
//		 }
		 sql ="insert into RegisterDetails Values("+"'"+name+"',"+"'"+emailId+"',"+"'"+password+"'"+");";
		 Jdbc_coonection jdbc =new Jdbc_coonection();
		 jdbc.databaseConnection(sql, "RegisterPage");
		 System.out.println( "Update to database");
		 System.out.println(sql );
	 }
	 
}


public class Register {

	public static void main(String[] args) {

		
		System.out.println("..............................................Register Page................................................................");
		ValidationRegister validationReg = new ValidationRegister();
		
		validationReg.userNameValidation();
		
		}
	
	 

	}

	

