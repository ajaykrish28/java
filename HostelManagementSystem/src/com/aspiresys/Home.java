package com.aspiresys;
import java .util.*;
import java.sql.*;
public class Home {



		// TODO Auto-generated constructor stub
		public static void main(String args []) {
			System.out.println("<..............HOSTEL MANAGEMENT SYSTEM...............>");	
		System.out.println("..............HOME PAGE...............");
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("Enter 1 for login");
		System.out.println("Enter 2 for Register");
		String option= scanner.nextLine();
		if(option.equals("1")) {
			System.out.println(" login page");	
			Login login =new Login();
			login.main(args);
		}
		else if(option.equals("2")) {
			System.out.println(" Register page");
			Register register =new Register();
			register.main(args);
		}
		
		else {
		System.out.println("Please give the valid information");}
		scanner.close();
		
	}

}
