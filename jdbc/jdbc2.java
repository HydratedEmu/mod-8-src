package jdbc;

import java.sql.*;

public class jdbc2 {

	public static void main(String[] args) throws SQLException{
		String url = "jdbc:mysql://localhost:3306/warehouse1";
		String userName = "root";
		String password = "yourPAss";
		String query = "select * from Parts";
		
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
				String PartsData = " ";
				for(int i = 1; i <= 5; i++) {
					PartsData += result.getString(i) + " ||";
					
				}// end for-loop
				System.out.println(PartsData);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	} //end main()
} // jdbc.java
