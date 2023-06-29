package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import OhShu.DAO.FoodDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.FoodReviewVO;
import OhShu.vo.FoodVO;
import OhShu.vo.FoodReviewVO;



	public class FoodDAOImpl implements FoodDAO{
		private final static FoodDAO instance = new FoodDAOImpl();
		private FoodDAOImpl() {
			
		}
		public static FoodDAO getInstance() {
			return instance;
		}
		@Override
		public FoodVO selectFood(int food_no) {
			
			
			
			String sql="SELECT food_no\r\n"
					+ "        ,food_location\r\n"
					+ "        ,food_source\r\n"
					+ "        ,food_name\r\n"
					+ "        ,food_sub_title\r\n"
					+ "        ,food_address\r\n"
					+ "        ,food_x\r\n"
					+ "        ,food_y\r\n"
					+ "        ,food_tel\r\n"
					+ "        ,food_home_url\r\n"
					+ "        ,food_info\r\n"
					+ "        ,food_img\r\n"
					+ "		   FROM food WHERE food_no = ?"
					;
			
			FoodVO vo = null;
			try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, food_no);
				ResultSet rs = pstmt.executeQuery();
				
				
				if( rs.next() ) {
					vo = new FoodVO();
					vo.setFood_no(rs.getInt("food_no"));
					vo.setFood_location(rs.getString("food_location"));
		            vo.setFood_source(rs.getString("food_source"));
		            vo.setFood_name(rs.getString("food_name"));
		            vo.setFood_sub_title(rs.getString("food_sub_title"));
		            vo.setFood_address(rs.getString("food_address"));
		            vo.setFood_x(rs.getString("food_x"));
		            vo.setFood_y(rs.getString("food_y"));
		            vo.setFood_tel(rs.getString("food_tel"));
		            vo.setFood_home_url(rs.getString("food_home_url"));
		            vo.setFood_info(rs.getString("food_info"));
		            vo.setFood_img(rs.getString("food_img"));
					
					
				}
				rs.close();
				
			
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return vo;
		}

		public List<FoodVO> selectFoodList(){
			
			String sql="SELECT food_no\r\n"
					+ "        ,food_location\r\n"
					+ "        ,food_source\r\n"
					+ "        ,food_name\r\n"
					+ "        ,food_sub_title\r\n"
					+ "        ,food_address\r\n"
					+ "        ,food_x\r\n"
					+ "        ,food_y\r\n"
					+ "        ,food_tel\r\n"
					+ "        ,food_home_url\r\n"
					+ "        ,food_info\r\n"
					+ "        ,food_img\r\n"
					+ "			FROM food";
			
			FoodVO vo = null;
			List<FoodVO> list = new ArrayList<FoodVO>();
			try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				ResultSet rs = pstmt.executeQuery();
				
				
				while( rs.next() ) {
					vo = new FoodVO();
					vo.setFood_no(rs.getInt("food_no"));
					vo.setFood_location(rs.getString("food_location"));
		            vo.setFood_source(rs.getString("food_source"));
		            vo.setFood_name(rs.getString("food_name"));
		            vo.setFood_sub_title(rs.getString("food_sub_title"));
		            vo.setFood_address(rs.getString("food_address"));
		            vo.setFood_x(rs.getString("food_x"));
		            vo.setFood_y(rs.getString("food_y"));
		            vo.setFood_tel(rs.getString("food_tel"));
		            vo.setFood_home_url(rs.getString("food_home_url"));
		            vo.setFood_info(rs.getString("food_info"));
		            vo.setFood_img(rs.getString("food_img"));
					
					list.add(vo);
				}
				rs.close();
				
			
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public List<FoodReviewVO> getFoodReviewList(int food_no){
			String sql = "SELECT  review_no, time, user_id, food_no, review_content "
					+ "		FROM food_review\r\n"
					+ "		WHERE food_no = ?"
					+ "                 )";
			
			List<FoodReviewVO> list = new ArrayList<FoodReviewVO>();
			FoodReviewVO vo = null;
			
			try(
					Connection conn = DataBaseUtil.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					){
					pstmt.setInt(1,food_no);
					ResultSet rs = pstmt.executeQuery();
					
					
					while( rs.next() ) {
						vo = new FoodReviewVO();
						vo.setReview_no(rs.getInt("review_no"));
						vo.setTime(rs.getString("time"));
						vo.setUser_id(rs.getString("user_id"));
						vo.setFood_no(rs.getInt("food_no"));
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