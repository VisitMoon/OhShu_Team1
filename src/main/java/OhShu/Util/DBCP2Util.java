package OhShu.Util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBCP2Util {
	private static BasicDataSource ds;
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (BasicDataSource) envCtx.lookup("jdbc/myoracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void distroyConnection() throws SQLException {
		ds.close();
	}

}
