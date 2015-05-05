package panel;

import java.sql.*;
import java.util.ArrayList;


public class Gateway {

	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	public Gateway(){
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://devcloud.fulgentcorp.com:3306/imp859",
					"imp859", "Ix2p0j0f7MuL5wstjoVy");
			st = conn.createStatement();			
		} catch (SQLException e) {
			System.out.println("Data Base Connection Error");
		}
	}
	
	public void readDB(ArrayList<UserModel> users){
		try {
			rs = st.executeQuery("select * from user_table");
			while(rs.next()){
				String userFirstName = rs.getString("firstName");
				String userLastName = rs.getString("lastName");
				String userEmail = rs.getString("email");
				String userName = rs.getString("userName");
				String userPassword = rs.getString("password");
				char[] passArray = userPassword.toCharArray();
				String userPhoneNum = rs.getString("phoneNum");
				String userAddress = rs.getString("address");
				String userAppt = rs.getString("appointment");
				String userMessage = rs.getString("message");
				int userType = rs.getInt("type");
				if(userType == 0){
					PatientModel pm = new PatientModel(userFirstName, userLastName,
							userName, passArray, userEmail, userAddress, userPhoneNum, this);
					users.add(pm);
				} else if(userType == 1){
					DoctorModel dm = new DoctorModel(userFirstName, userLastName,
							userName, passArray, userEmail, userAddress, userPhoneNum);
					users.add(dm);
				} else if(userType == 2){
					NurseModel nm = new NurseModel(userFirstName, userLastName,
							userName, passArray, userEmail, userAddress, userPhoneNum);
					users.add(nm);
				} else if(userType == 3){
					StaffModel sm = new StaffModel(userFirstName, userLastName,
							userName, passArray, userEmail, userAddress, userPhoneNum, this);
					users.add(sm);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error reading from database");
		}
	}
	
	public void insertDB(int userType, String first, String last, String user_name,
			String pw, String userEmail, String pn, String add){
		try {
			PreparedStatement ps = conn.prepareStatement("insert into user_table "
					+ "(firstName, lastName, email, userName, password, phoneNum,"
					+ "address, appointment, message, type)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, first);
			ps.setString(2, last);
			ps.setString(3, userEmail);
			ps.setString(4, user_name);
			ps.setString(5, pw);
			ps.setString(6, pn);
			ps.setString(7, add);
			ps.setString(8, "");
			ps.setString(9, "");
			ps.setInt(10, userType);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Insert into DB error");
		}
	}
	
	public void updateAppt(String appt, String user){
		try {
			PreparedStatement ps = conn.prepareStatement("update user_table set "
					+ "appointment = ? where userName = ?");
			ps.setString(1, appt);
			ps.setString(2, user);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Update DB error");
		}
	}
	
	public void updateMessage(String msg, String user){
		try{
			PreparedStatement ps = conn.prepareStatement("update user_table set "
					+ "message = ? where userName = ?");
			ps.setString(1, msg);
			ps.setString(2, user);
			ps.executeUpdate();
			ps.close();
		} catch(SQLException e){
			System.out.println("Update DB error");
		}
	}
	
}
