package com.aspiresys;
import java.util.*;
class AdminQueriesDatabase{
	String sql,value;
	Scanner scanner = new Scanner (System.in);
	AdminNav  adminNav  =new AdminNav ();
	void viewQueries() {
		sql=" select * from  UserQueryDetails;";
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "AdminQueryDetails");
		System.out.println(sql);
	}
	void choice() {
		
		System.out.println("Enter 1 for View Quires");
		System.out.println("Enter 2 for Navigate Bar");
		System.out.println();
		value=scanner.nextLine();
		if(value.equals("1")) {
			
			viewQueries();
		}
		else if(value.equals("2")) {
			adminNav.main(null);
		}	
	}
	
}
public class AdminQueries {

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(".......ADMIN QUERIES.........");
		AdminQueriesDatabase adminQueriesDatabase = new AdminQueriesDatabase();
		adminQueriesDatabase.choice();
	}

}
