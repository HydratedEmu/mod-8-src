package jdbc;

import java.sql.*;

public class jdbc {

	public static void main(String[] args) throws SQLException{
		String url = "jdbc:mysql://localhost:3306/university";
		String userName = "root";
		String password = "yourPass";
		String query = "select * from EngineeringSudents";
		
		// tests to see if we have required SQL drivers
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// try-catch for any connections
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			
			while(result.next()) {
				String UniversityData = "";
				for(int i = 1; i <= 6; i++) {
					UniversityData += result.getString(i) + ":";
					
				}// end for-loop
				System.out.println(UniversityData);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	} //end main()
} // jdbc.java
