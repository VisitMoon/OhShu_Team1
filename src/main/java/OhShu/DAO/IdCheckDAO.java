package OhShu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import OhShu.Util.DataBaseUtil;

public class IdCheckDAO {
	 public boolean checkDuplicate(String userId) throws SQLException, ClassNotFoundException {
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try {
	            con = DataBaseUtil.getConnection();
	            pstmt = con.prepareStatement("SELECT * FROM user_tb WHERE user_id = ?");
	            pstmt.setString(1, userId);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                return true;
	            }
	        } finally {
	            // open한 객체 닫아주기
	            if (rs != null) try { rs.close(); } catch(SQLException ignored) {}
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ignored) {}
	            if (con != null) try { con.close(); } catch(SQLException ignored) {}
	        }

	        return false;
	    }
	}
