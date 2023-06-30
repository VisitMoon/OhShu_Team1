package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OhShu.DAO.StayMainDAO;
import OhShu.Util.DBCP2Util;
import OhShu.vo.StayMainVO;

public class StayMainDAOImpl implements StayMainDAO{
	
	private final static StayMainDAO instance = new StayMainDAOImpl();
	
	private StayMainDAOImpl() {
		
	}
	public static StayMainDAO getInstance() {
		return instance;
	}
	
	@Override
	public StayMainVO selectStayJoayoRank(int rank) {

		String sql = "SELECT stay.stay_no,stay_name, stay.stay_img,joayo_amount\r\n"
				+ "FROM stay\r\n"
				+ "JOIN (\r\n"
				+ "    SELECT stay_no, SUM(joayo) as joayo_amount\r\n"
				+ "    FROM stay_joayo\r\n"
				+ "    GROUP BY stay_no\r\n"
				+ "    ORDER BY joayo_amount DESC\r\n"
				+ ") ranking_table\r\n"
				+ "ON stay.stay_no = ranking_table.stay_no\r\n"
				+ "WHERE ranking_table.joayo_amount = ("
				+ "SELECT joayo_amount FROM (\r\n"
				+ "    SELECT stay_no, SUM(joayo) as joayo_amount, ROW_NUMBER() OVER(ORDER BY SUM(joayo) DESC) as rank_idx\r\n"
				+ "    FROM stay_joayo\r\n"
				+ "    GROUP BY stay_no\r\n"
				+ ")\r\n"
				+ "WHERE rank_idx = ?)";
		
		StayMainVO stay = null;

		try (
				Connection conn = DBCP2Util.getConnection(); // DBCP2Util, DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, rank);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				stay = new StayMainVO();
				
				stay.setStay_no(rs.getInt("stay_no"));
				stay.setStay_name(rs.getString("stay_name"));		
				stay.setStay_img(rs.getString("stay_img"));
				stay.setJoayo_amount(rs.getInt("joayo_amount"));
			}
			rs.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stay;
	}

}