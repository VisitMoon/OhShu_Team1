package OhShu.Util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
<<<<<<< HEAD
import javax.naming.Context;
import javax.naming.InitialContext;
=======

>>>>>>> de65e1e02633c47509047f606420c9789275cf7f

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBCP2Util {

<<<<<<< HEAD
	public static BasicDataSource ds;
=======
	private static BasicDataSource ds;
>>>>>>> de65e1e02633c47509047f606420c9789275cf7f

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			// Look up our data source
			ds = (BasicDataSource) envCtx.lookup("jdbc/oracle");
<<<<<<< HEAD
=======

>>>>>>> de65e1e02633c47509047f606420c9789275cf7f
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

<<<<<<< HEAD

	public static void distoryConnention() throws SQLException {
		ds.close();
	}



=======
	public static void destroyConnection() throws SQLException {
		ds.close();
	}
>>>>>>> de65e1e02633c47509047f606420c9789275cf7f
}
