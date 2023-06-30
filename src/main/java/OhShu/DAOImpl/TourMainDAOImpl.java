package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OhShu.DAO.TourMainDAO;
import OhShu.Util.DBCP2Util;
import OhShu.vo.TourMainVO;

public class TourMainDAOImpl implements TourMainDAO{
	
	private final static TourMainDAO instance = new TourMainDAOImpl();
	
	private TourMainDAOImpl() {}
	
	public static TourMainDAO getInstance() {
		return instance;
	}
	
	@Override
	public TourMainVO selectTourJoayoRank(int rank) {
		
		String sql = "SELECT tour.tour_no,tour_name, tour.tour_img,joayo_amount\r\n"
				+ "FROM tour\r\n"
				+ "JOIN (\r\n"
				+ "    SELECT tour_no, SUM(joayo) as joayo_amount\r\n"
				+ "    FROM tour_joayo\r\n"
				+ "    GROUP BY tour_no\r\n"
				+ "    ORDER BY joayo_amount DESC\r\n"
				+ ") ranking_table\r\n"
				+ "ON tour.tour_no = ranking_table.tour_no\r\n"
				+ "WHERE ranking_table.joayo_amount = ("
				+ "SELECT joayo_amount FROM (\r\n"
				+ "    SELECT tour_no, SUM(joayo) as joayo_amount, ROW_NUMBER() OVER(ORDER BY SUM(joayo) DESC) as rank_idx\r\n"
				+ "    FROM tour_joayo\r\n"
				+ "    GROUP BY tour_no\r\n"
				+ ")\r\n"
				+ "WHERE rank_idx = ?)";
		
		TourMainVO vo = null;
		
		try (
				Connection conn = DBCP2Util.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, rank);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new TourMainVO();
				vo.setTour_no(rs.getInt("tour_no"));
	            vo.setTour_name(rs.getString("tour_name"));
	            vo.setTour_img(rs.getString("tour_img"));
	            vo.setJoayo_amount(rs.getInt("joayo_amount"));
	            System.out.println(vo.toString());
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
}
