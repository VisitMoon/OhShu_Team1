package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OhShu.DAO.FoodDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.FoodVO;



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
		            vo.setFood_name(rs.getString("tour_name"));
		            vo.setFood_sub_title(rs.getString("tour_sub_title"));
		            vo.setFood_address(rs.getString("tour_address"));
		            vo.setFood_x(rs.getString("tour_x"));
		            vo.setFood_y(rs.getString("tour_y"));
		            vo.setFood_tel(rs.getString("tour_tel"));
		            vo.setFood_home_url(rs.getString("tour_home_url"));
		            vo.setFood_img(rs.getString("tour_img"));
					
					
				}
				rs.close();
				
			
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return vo;
		}

	}