package OhShu.Util;

import java.sql.Connection;
import java.sql.SQLException;
<<<<<<< HEAD
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
=======

>>>>>>> 2f6c0df1d89b48c8b53e619ed595bc1f06fea67a
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBCP2Util {
<<<<<<< HEAD

	public static BasicDataSource ds;

=======
	private static BasicDataSource ds;
>>>>>>> 2f6c0df1d89b48c8b53e619ed595bc1f06fea67a
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
<<<<<<< HEAD

			// Look up our data source
			ds = (BasicDataSource) envCtx.lookup("jdbc/oracle");


=======

			ds = (BasicDataSource) envCtx.lookup("jdbc/myoracle");
>>>>>>> 2f6c0df1d89b48c8b53e619ed595bc1f06fea67a
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD

=======
	
>>>>>>> 2f6c0df1d89b48c8b53e619ed595bc1f06fea67a

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

<<<<<<< HEAD

	public static void distoryConnention() throws SQLException {
		ds.close();
	}



=======
	public static void distroyConnection() throws SQLException {
		ds.close();
	}

>>>>>>> 2f6c0df1d89b48c8b53e619ed595bc1f06fea67a
}
