package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection conn;
	
	public static Connection getConnection(){
		if (conn == null) {
			String url = "jdbc:mysql://localhost:3306/ jdbcdemo";
			String userName = "root";
			String password = "root";
			try {
				conn = DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
}
