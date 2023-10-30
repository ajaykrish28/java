package com.aspiresys;

import java.sql.*;

public class Jdbc_coonection {
	
	void databaseConnection(String sql,String decision) {
		Connection con = null;
		try {

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms", "root", "Yash1428@!");
			Statement st = con.createStatement();
			
//			recent changes starts	
			if(decision.equals("AdminStudentData")) {
				int rs = st.executeUpdate(sql);
				
				System.out.println("Insert successfully" + sql);
				AdminProfile adminProfile =new AdminProfile ();
				adminProfile.main(null);
			}
			else if(decision.equals("AdminDeleteStudentData")) {
				int rs = st.executeUpdate(sql);
				
				System.out.println("deleted successfully" + sql);
				AdminProfile adminProfile =new AdminProfile ();
				adminProfile.main(null);
			}
			else if(decision.equals("AdminUpdateStudentData")) {
				int rs = st.executeUpdate(sql);
				
				System.out.println("deleted successfully" + sql);
				AdminProfile adminProfile =new AdminProfile ();
				adminProfile.main(null);
			}
			else if(decision.equals("ViewRoomData")||decision.equals("AdminUpdateRoom")||decision.equals("AdminDeleteRoom")||decision.equals("AdminAddRoom")) {
				AdminRooms adminRooms =new AdminRooms ();
				if(decision.equals("ViewRoomData")) {
					ResultSet rs = st.executeQuery(sql);
					while(rs.next()) {
						System.out.println("Room Number is "+ rs.getString(1));
						System.out.println("People Count is "+ rs.getString(2));
						
					}
					
					System.out.println("Insert successfully" + sql);
					
					adminRooms .main(null);
				}
				
				else if(decision.equals("AdminUpdateRoom")) {
					int rs = st.executeUpdate(sql);
					
					System.out.println("Updated successfully" + sql);
					adminRooms .main(null);
					
				}
				else if(decision.equals("AdminDeleteRoom")) {
					int rs = st.executeUpdate(sql);
					
					System.out.println("deleted successfully" + sql);
					adminRooms .main(null);
					
				}
				else {
					int rs = st.executeUpdate(sql);
					
					System.out.println("Insert successfully" + sql);
					adminRooms .main(null);
					
					
				}
				
			}

			else if(decision.equals("ViewStudentData")) {
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					System.out.println("Name is "+ rs.getString(1));
					
				}
				
				System.out.println("Insert successfully" + sql);
				AdminProfile adminProfile =new AdminProfile ();
				adminProfile.main(null);
			}
			
			
			else if(decision.equals("UserProfile")) {
				
				
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					System.out.println("Welcome "+ rs.getString(1));
//					System.out.println("EmailId Count is "+ rs.getString(2));
					
				}
			}
			
			else if (decision.equals("UserProfileAccess")) {
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					System.out.println("Name	:"+ rs.getString(1));
					System.out.println("EmailId	:"+ rs.getString(2));
					System.out.println("Register no	:"+ rs.getString(3));
					System.out.println("DOB	:"+ rs.getString(4));
					System.out.println("Phone No	:"+ rs.getString(5));
					System.out.println("Father Name:"+ rs.getString(6));
					System.out.println("Mother Name	:"+ rs.getString(7));
					System.out.println("College Name	:"+ rs.getString(8));
					System.out.println("Department	:"+ rs.getString(9));
					System.out.println("AAdhar no:"+ rs.getString(10));
					System.out.println("Address	:"+ rs.getString(11));
					System.out.println("Room No:"+ rs.getString(12));
					
				
			}}
			else if(decision.equals("FeesStudentData")) {
				
				int rs = st.executeUpdate(sql);
				
				System.out.println("Insert successfully" + sql);
				AdminFees adminFees =new AdminFees ();
				adminFees.main(null);
			}
            else if(decision.equals("UserQueryDetails")) {
				
				int rs = st.executeUpdate(sql);
				
				System.out.println("Insert successfully" + sql);
				UserQueries userQueries =new UserQueries ();
				userQueries.main(null);
			}
else if(decision.equals("AdminQueryDetails")) {
				
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					System.out.println("EmailId`:"+ rs.getString(1));
					System.out.println("Register No:"+ rs.getString(2));
					System.out.println("subject	:"+ rs.getString(3));
					System.out.println("describ	:"+ rs.getString(4));}
				
				System.out.println("Insert successfully" + sql);
				AdminQueries adminQueries =new AdminQueries ();
				adminQueries.main(null);
			}
else if(decision.equals("ViewMessMenu")) {
	
	ResultSet rs = st.executeQuery(sql);
	while(rs.next()) {
		System.out.println("Day`:"+ rs.getString(1));
		System.out.println("......................");
		System.out.println(" Morning:"+ rs.getString(2));
		System.out.println("Afternoon	:"+ rs.getString(3));
		System.out.println("Snacks:"+ rs.getString(4));
		System.out.println("Dinner	:"+ rs.getString(5));}
	
	System.out.println("Insert successfully" + sql);
	UserMess userMess =new UserMess();
	userMess.main(null);
}
			
else if(decision.equals("UserMessQueries")) {
	int rs = st.executeUpdate(sql);
	
	System.out.println("Insert successfully" + sql);
	UserMess	userMess=new UserMess();
	userMess.main(null);
}
			else if(decision.equals("RegisterPage")) {
			int rs = st.executeUpdate(sql);
			
			System.out.println("Insert successfully" + sql);
			Login login=new Login();
			login.main(null);
		}

		}catch (Exception e) {
			System.err.println(e);

		} finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);

			}
		}
	}

	public static void main(String[] args) {

		System.out.println("Connecting to Database");
	}
}