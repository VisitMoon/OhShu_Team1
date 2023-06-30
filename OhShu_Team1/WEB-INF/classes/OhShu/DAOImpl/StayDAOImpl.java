package OhShu.DAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import OhShu.DAO.StayDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.StayReviewVO;
import OhShu.vo.StayVO;

public class StayDAOImpl implements StayDAO{
	private final static StayDAO instance = new StayDAOImpl();
	private StayDAOImpl() {
		
	}
	public static StayDAO getInstance() {
		return instance;
	}
	@Override
	public StayVO selectStay(int stay_no) {
		
		
		
		String sql="SELECT stay_no\r\n"
				+ "        ,stay_location\r\n"
				+ "        ,stay_category\r\n"
				+ "        ,stay_name\r\n"
				+ "        ,stay_sub_title\r\n"
				+ "        ,stay_address\r\n"
				+ "        ,stay_x\r\n"
				+ "        ,stay_y\r\n"
				+ "        ,stay_tel\r\n"
				+ "        ,stay_home_url\r\n"
				+ "        ,stay_info\r\n"
				+ "        ,stay_img\r\n"
				+ "		   FROM stay WHERE stay_no = ?"
				;
		
		StayVO vo = null;
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setInt(1, stay_no);
			ResultSet rs = pstmt.executeQuery();
			
			
			if( rs.next() ) {
				vo = new StayVO();
				vo.setStay_no(rs.getInt("stay_no"));
				vo.setStay_location(rs.getString("stay_location"));
	            vo.setStay_category(rs.getString("stay_category"));
	            vo.setStay_name(rs.getString("stay_name"));
	            vo.setStay_sub_title(rs.getString("stay_sub_title"));
	            vo.setStay_address(rs.getString("stay_address"));
	            vo.setStay_x(rs.getString("stay_x"));
	            vo.setStay_y(rs.getString("stay_y"));
	            vo.setStay_tel(rs.getString("stay_tel"));
	            vo.setStay_home_url(rs.getString("stay_home_url"));
	            vo.setStay_info(rs.getString("stay_info"));
	            vo.setStay_img(rs.getString("stay_img"));
				
				
			}
			rs.close();
			
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	@Override
	public List<StayVO> getStayList(){
		
		String sql="SELECT stay_no\r\n"
				+ "        ,stay_location\r\n"
				+ "        ,stay_category\r\n"
				+ "        ,stay_name\r\n"
				+ "        ,stay_sub_title\r\n"
				+ "        ,stay_address\r\n"
				+ "        ,stay_x\r\n"
				+ "        ,stay_y\r\n"
				+ "        ,stay_tel\r\n"
				+ "        ,stay_home_url\r\n"
				+ "        ,stay_info\r\n"
				+ "        ,stay_img\r\n"
				+ "			FROM stay";
		
		StayVO vo = null;
		List<StayVO> list = new ArrayList<StayVO>();
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			ResultSet rs = pstmt.executeQuery();
			
			
			while( rs.next() ) {
				vo = new StayVO();
				vo.setStay_no(rs.getInt("stay_no"));
				vo.setStay_location(rs.getString("stay_location"));
	            vo.setStay_category(rs.getString("stay_category"));
	            vo.setStay_name(rs.getString("stay_name"));
	            vo.setStay_sub_title(rs.getString("stay_sub_title"));
	            vo.setStay_address(rs.getString("stay_address"));
	            vo.setStay_x(rs.getString("stay_x"));
	            vo.setStay_y(rs.getString("stay_y"));
	            vo.setStay_tel(rs.getString("stay_tel"));
	            vo.setStay_home_url(rs.getString("stay_home_url"));
	            vo.setStay_info(rs.getString("stay_info"));
	            vo.setStay_img(rs.getString("stay_img"));
				
				list.add(vo);
			}
			rs.close();
			
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<StayReviewVO> getStayReviewList(int stay_no){
		String sql = "SELECT  review_no, time, user_id, stay_no, review_content "
				+ "		FROM stay_review\r\n"
				+ "		WHERE stay_no = ?"
				+ "                 )";
		
		List<StayReviewVO> list = new ArrayList<StayReviewVO>();
		StayReviewVO vo = null;
		
		try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1,stay_no);
				ResultSet rs = pstmt.executeQuery();
				
				
				while( rs.next() ) {
					vo = new StayReviewVO();
					vo.setReview_no(rs.getInt("review_no"));
					vo.setTime(rs.getString("time"));
					vo.setUser_id(rs.getString("user_id"));
					vo.setStay_no(rs.getInt("stay_no"));
					vo.setReview_content(rs.getString("review_content"));
					
					list.add(vo);
				}
				rs.close();
				
			
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
	}
}