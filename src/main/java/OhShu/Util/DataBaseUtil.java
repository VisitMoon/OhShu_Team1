package OhShu.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtil {
	
	// DriverManager
	// Connection
	// Statement, PrepareStatement
	// ResultSet
	private static Connection connection;
	
	static {
		
		try {
			connection = connectionDB();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void destroyConnection() {
		if(connection != null) {
			try	{	connection.close();
					connection = null;
				}catch (SQLException e) {
				e.printStackTrace();
				}
		}
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		System.out.println("connection -" + connection);
		if(connection == null || connection.isClosed()) {
			connection = connectionDB();
		}
			
		
		return connection;
	}
	public static Connection connectionDB() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "c##OhSHu";
		String pwd= "OhShu";
		return DriverManager.getConnection(url,id,pwd);
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{


	}
	

}
