package com.aspiresys;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//changes starts

class StudentDataManagement{
	Scanner scanner = new Scanner(System.in);
	 String name,emailId,phoneNo,fatherName,motherName,CollegeName,department,aadharNo,roomNo ,Address,sql,dob,deleteEmail,regNo,column ,value,registerNo;
	void viewData() {
		System.out.println("hiii");
		sql =" select * from  AdminProfile;";
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "ViewStudentData");
		System.out.println( "view  database");
		System.out.println(sql );
		
	}
	void validationName(){
		 System.out.println("Enter Name");
		 name =scanner.nextLine();
		 Pattern pattern = Pattern.compile("\\D+"); // \D matches non-digit characters
	        Matcher matcher = pattern.matcher(name);
	        //constrain for Empty method 1
		if(!matcher.matches()|| name.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationName();			}
		else {
			validationRegNo();
			
		}
	}
	void validationRegNo() {

		 System.out.println("Enter Register Number");
		 regNo =scanner.nextLine();
		 System.out.println(regNo);

		if( regNo.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationRegNo();			}
		else {
			validationDob();
			
		}
	}
	void validationDob() {
		System.out.println("Enter Date of birth");
		 dob =scanner.nextLine();

		if( dob.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationDob();			}
		else {
			
			validationFatherName();
			
		}
		 
		 
	}
	void validationFatherName() {
		 System.out.println("Enter Father Name");
		 fatherName =scanner.nextLine();
		 Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
	        Matcher matcher = pattern.matcher(fatherName);
	        //constrain for Empty method 1
		if(!matcher.matches()|| fatherName.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationFatherName();			}
		else {
			validationMotherName();
			
		}
	}
	void validationMotherName() {
		 System.out.println("Enter  Mother Name");
		 motherName =scanner.nextLine();
		 Pattern pattern = Pattern.compile("^[a-zA-Z]+$"); 
	        Matcher matcher = pattern.matcher(motherName);
	        //constrain for Empty method 1
		if(!matcher.matches()|| motherName.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationMotherName();			}
		else {
			validationAadharNo();
			
		}
	}
	void validationAadharNo() {

		 System.out.println("Enter Aadhar number");
		 aadharNo =scanner.nextLine();
//		 Pattern pattern = Pattern.compile(); 
//	        Matcher matcher = pattern.matcher(aadharNo);
	        //constrain for Empty method 1
		if(aadharNo.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationAadharNo();			}
		else {
			validationEmail() ;
			
		}
	}
	void validationEmail() {
		 System.out.println("Enter Email ID");
		 emailId =scanner.nextLine();
		  //constrain for email
			String emailPattern = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9]+\\.)+[A-Za-z]+$";
	        Pattern patternEmail = Pattern.compile(emailPattern);
	        Matcher matcherEmail =  patternEmail.matcher(emailId);
	      
	    	if(!matcherEmail.matches()|| emailId.isEmpty()) {
				System.out.println("Please Enter the Email Id");
				validationEmail();
			}
	    	else {
	    		validationPhoneNo();
				
			}
	}
	void validationPhoneNo() {
		 System.out.println("Enter Phone number");
		 phoneNo =scanner.nextLine();
			String phonePattern = "^[6-9]\\d{9}$";
	        Pattern patternPassword = Pattern.compile(phonePattern);
	        Matcher matcherpassword=  patternPassword.matcher(phoneNo);
	    	if(!matcherpassword.matches()||phoneNo.isEmpty()) {
				System.out.println("Enter the Proper password");
				validationPhoneNo();
				}
	    	else {
	    		validationAddress();
				
			}
			
		
	}

	void validationAddress() {
		 System.out.println("Enter Address");
		 Address =scanner.nextLine();
//		 Pattern pattern = Pattern.compile("\\D+"); 
//	        Matcher matcher = pattern.matcher(Address);
	        //constrain for Empty method 1
		if(Address.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationAddress();			}
		else {
			validationCollegeName();
			
		}
	}
	void validationCollegeName() {

		 System.out.println("Enter College Name");
		 CollegeName =scanner.nextLine();
		 Pattern pattern = Pattern.compile("^[a-zA-Z]+$"); 
	        Matcher matcher = pattern.matcher(CollegeName);
	        //constrain for Empty method 1
		if(!matcher.matches()|| CollegeName.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationCollegeName();			}
		else {
			validationDepartmentName();
			
		}
	}
	
	void validationDepartmentName() {

		 System.out.println("Enter Department Name");
		 department =scanner.nextLine();
		 Pattern pattern = Pattern.compile("^[a-zA-Z]+$"); // \D matches non-digit characters
	        Matcher matcher = pattern.matcher( department);
	        //constrain for Empty method 1
		if(!matcher.matches()||  department.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationDepartmentName();			}
		else {
			validationRoomNo();
			
		}
	}
	
	void validationRoomNo() {
		System.out.println("Enter Room number");
		 roomNo =scanner.nextLine();
//		 Pattern pattern = Pattern.compile(""); 
//	        Matcher matcher = pattern.matcher(name);
	        //constrain for Empty method 1
		if( roomNo.isEmpty()) {
			System.out.println("Enter the Proper user Name");
			validationRoomNo();			}
		else {
		System.out.println("Successfully complete");
		insertData();
		}
	}
	
void insertData() {


System.out.println("Ready to insert the data");

sql ="insert into AdminProfile Values("+"'"+name+"',"+"'"+emailId+"',"+"'"+regNo+"',"+"'"+dob+"',"+"'"+phoneNo+"',"+  "'"+fatherName+"',"+ "'"+motherName+"',"+"'"+CollegeName+"',"+ "'"+department+"',"+ "'"+aadharNo+"',"+  "'"+Address+"',"+"'"+roomNo+"'"+");";
Jdbc_coonection jdbc =new Jdbc_coonection();
jdbc.databaseConnection(sql, "AdminStudentData");
System.out.println( "Update to database");
System.out.println(sql );

 
 
}		
void deleteData() {
	System.out.println("Enter the User Email Id for Delete Data in Database" );
	
	deleteEmail= scanner.nextLine() ;
	sql="delete from AdminProfile where emailId = "+"'"+deleteEmail+"'";
	Jdbc_coonection jdbc =new Jdbc_coonection();
	jdbc.databaseConnection(sql, "AdminDeleteStudentData");
	System.out.println( "Update to database");
	System.out.println(sql );
	
}
void updateData() {	System.out.println("Enter the User Register number Data in Database" );

registerNo= scanner.nextLine() ;
System.out.println("Enter the Colume name" );
column= scanner.nextLine() ;
System.out.println("Enter the value" );
value= scanner.nextLine() ;
sql="Update  AdminProfile set "+ column +"='" +value+"' where regNo = "+"'"+registerNo+"'";
Jdbc_coonection jdbc =new Jdbc_coonection();
jdbc.databaseConnection(sql, "AdminUpdateStudentData");
System.out.println( "Update to database");
System.out.println(sql );}

	
}
class Option{
	void optionValue() {
	Scanner scanner = new Scanner(System.in);
	
	StudentDataManagement studentDataManagement= new StudentDataManagement();
	System.out.println(" Enter 1 to view the Database");
	System.out.println(" Enter 2 to Insert the new Data to Database");
	System.out.println(" Enter 3 to Delete the Data in Database");
	System.out.println(" Enter 4 to Delete the Data in Database");
	String option =scanner.nextLine();
	if(option.equals("1")) {
		
		studentDataManagement.viewData();
	}
	else if(option.equals("2")) {
		studentDataManagement.validationName();
	}
	else if(option.equals("3")) {
		studentDataManagement.deleteData();
	}
	else if(option.equals("4")) {
		studentDataManagement.updateData();
	}
	else {
		System.out.println("Please Enter the Correct Value ");
		optionValue();
	}
	
	scanner.close();
	
}}


public class AdminProfile {


	public static void main (String args []) {

		System.out.println("........................ADMIN PROFILE....................");
		Option option= new Option();
		option.optionValue();
		
		
}
	}


