package com.aspiresys;

import java .util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
 class LoginDetails{
	 UserNav userNav = new UserNav();
	AdminNav adminNav = new AdminNav();
	 
	 String emailId,password;
	 Scanner scanner = new Scanner(System.in);
	void validationEmail() {

		System.out.println("Enter the Email ID");
		 emailId = scanner.nextLine();
        //constrain for email
		String emailPattern = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9]+\\.)+[A-Za-z]+$";
        Pattern patternEmail = Pattern.compile(emailPattern);
        Matcher matcherEmail =  patternEmail.matcher(emailId);
    	if(!matcherEmail.matches()||emailId .isEmpty()) {
			System.out.println(" Please Enter the Email Id");
			validationEmail();
		}
    	else {
    		validationPassword();
    	}
		
	}
void validationPassword() {
	System.out.println("Enter the Password");
	 password = scanner.nextLine();
    //constrain for password
//	String passwordPattern = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9]+\\.)+[A-Za-z]+$";
	String passwordPattern = "^[6-9]\\d{9}$";
	
    Pattern patternPassword = Pattern.compile(passwordPattern);
    Matcher matcherpassword=  patternPassword.matcher(password);
	if(!matcherpassword.matches()||password.isEmpty()) {
		System.out.println(" Please Enter the Proper password");
		validationPassword();}
	else {
		database();
	}
	
}
void database() {

Connection con = null;
try {

	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms", "root", "Yash1428@!");
	Statement st = con.createStatement();
	 boolean isAdmin = checkAdmin(con, emailId, password);
     boolean isUser = checkUser(con, emailId, password);
     
     if (isAdmin) {
         System.out.println("Admin login successful!");
         adminNav.main(null);

         
     } else if (isUser) {
         System.out.println("User login successful!");
         userNav.main(emailId);
     } else {
         System.out.println("Login failed. Invalid credentials.");
         validationEmail();    }

}

catch (SQLException e) {
    e.printStackTrace();
} 

}
private static boolean checkAdmin(Connection connection, String emailId, String password) throws SQLException {
    String query = "SELECT * FROM  AdminLogin WHERE emailId  = ? AND password = ?";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, emailId);
        preparedStatement.setString(2, password);
        System.out.println(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
       
    }
   
}

private static boolean checkUser(Connection connection, String username, String password) throws SQLException {
    String query = "SELECT * FROM RegisterDetails  WHERE emailId  = ? AND password = ?";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
	}
 
	 






public class Login {

	public static void main(String[] args) {
		
		System.out.println("......................LOGIN PAGE.......................");
		LoginDetails loginDetails= new LoginDetails();
		loginDetails.validationEmail();
	}
}
