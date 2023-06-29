package OhShu.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import OhShu.Util.DataBaseUtil;

public class IdCheckDAO {
	 public boolean isUserIdDuplicate(String userId) throws SQLException, ClassNotFoundException {
		 String sql = "SELECT * FROM user_tb WHERE user_id = ?";
	        
	        try (Connection connection = DataBaseUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	             
	            preparedStatement.setString(1, userId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	                // ResultSet에 결과가 있으면 중복된 user_id가 존재
	                return true;
	            } else {
	                // ResultSet이 비어있으면 중복된 user_id가 없음
	                return false;
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}