package com.aspiresys;

import java.util.Scanner;

class AdminRoomsDatabase{
	Scanner scanner = new Scanner(System.in);
	String sql,RoomNo,value,people;
	void roomView() {
	
		sql =" select * from  RoomDetails;";
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "ViewRoomData");
		System.out.println( "view  database");
		System.out.println(sql );

	}
	void roomModify() {
		System.out.println("Enter the User Room number Data in Database" );

		RoomNo= scanner.nextLine() ;
		
		
		System.out.println("Enter the value" );
		value= scanner.nextLine() ;
		sql="Update  RoomDetails set people='" +value+"' where roomNo  = "+"'"+RoomNo+"'";
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "AdminUpdateRoom");
		System.out.println( "Update to database");
		System.out.println(sql );
	
	}
	void roomDelete() {
		System.out.println("Enter the Room Number for Delete" );
		
		RoomNo= scanner.nextLine() ;
		sql="delete from RoomDetails where roomNo = "+"'"+RoomNo+"'";
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "AdminDeleteRoom");
		System.out.println( "Update to database");
		System.out.println(sql );
	}
	void roomAdd() {
		System.out.println("Ready to insert the data");
		System.out.println("Enter the Room Number" );
		RoomNo= scanner.nextLine() ;
		System.out.println("Enter the People Status" );
		people= scanner.nextLine() ;

		sql ="insert into RoomDetails Values("+"'"+RoomNo+"',"+"'"+people+"'"+");";
		Jdbc_coonection jdbc =new Jdbc_coonection();
		jdbc.databaseConnection(sql, "AdminAddRoom");
		System.out.println( "Update to database");
		System.out.println(sql );
		
	}
}


class RoomOption{
	void optionValue() {
	Scanner scanner = new Scanner(System.in);
	
	AdminRoomsDatabase adminRoomsDatabase= new AdminRoomsDatabase();
	System.out.println(" Enter 1 to view the Room Database");
	System.out.println(" Enter 2 to Insert the new room to Database");
	System.out.println(" Enter 3 to Delete the room to Database");
	System.out.println(" Enter 4 to Add the room to Database");
	
	String option =scanner.nextLine();
	if(option.equals("1")) {
		
		adminRoomsDatabase.roomView();
	}
	else if(option.equals("2")) {
		adminRoomsDatabase.roomModify();
	}
	else if(option.equals("3")) {
		adminRoomsDatabase.roomDelete();
	}
	else if(option.equals("4")) {
		adminRoomsDatabase.roomAdd();
	}
	else {
		System.out.println("Please Enter the Correct Value ");
		optionValue();
	}
	scanner.close();
}}








public class AdminRooms {

	public static void main(String[] args) {
		System.out.println("................ADMIN ROOMS.....................");
		RoomOption option= new RoomOption();
		option.optionValue();
	}

}
