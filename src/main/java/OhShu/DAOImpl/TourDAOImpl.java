package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import OhShu.DAO.TourDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.TourVO;



	public class TourDAOImpl implements TourDAO{
		private final static TourDAO instance = new TourDAOImpl();
		private TourDAOImpl() {
			
		}
		public static TourDAO getInstance() {
			return instance;
		}
		@Override
		public TourVO selectTour(int tour_no) {
			
			
			
			String sql="SELECT tour_no\r\n"
					+ "        ,tour_location\r\n"
					+ "        ,tour_category\r\n"
					+ "        ,tour_name\r\n"
					+ "        ,tour_sub_title\r\n"
					+ "        ,tour_address\r\n"
					+ "        ,tour_x\r\n"
					+ "        ,tour_y\r\n"
					+ "        ,tour_tel\r\n"
					+ "        ,tour_home_url\r\n"
					+ "        ,tour_tour_info\r\n"
					+ "        ,tour_img\r\n"
					+ "		   FROM tour WHERE tour_no = ?"
					;
			
			TourVO vo = null;
			try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, tour_no);
				ResultSet rs = pstmt.executeQuery();
				
				
				if( rs.next() ) {
					vo = new TourVO();
					vo.setTour_no(rs.getInt("tour_no"));
					vo.setTour_location(rs.getString("tour_location"));
		            vo.setTour_category(rs.getString("tour_category"));
		            vo.setTour_name(rs.getString("tour_name"));
		            vo.setTour_sub_title(rs.getString("tour_sub_title"));
		            vo.setTour_address(rs.getString("tour_address"));
		            vo.setTour_x(rs.getString("tour_x"));
		            vo.setTour_y(rs.getString("tour_y"));
		            vo.setTour_tel(rs.getString("tour_tel"));
		            vo.setTour_home_url(rs.getString("tour_home_url"));
		            vo.setTour_info(rs.getString("tour_info"));
		            vo.setTour_img(rs.getString("tour_img"));
					
					
				}
				rs.close();
				
			
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return vo;
		}
		
		@Override
		public List<TourVO> getTourList() {
			
			String sql="SELECT tour_no\r\n"
					+ "        ,tour_location\r\n"
					+ "        ,tour_category\r\n"
					+ "        ,tour_name\r\n"
					+ "        ,tour_sub_title\r\n"
					+ "        ,tour_address\r\n"
					+ "        ,tour_x\r\n"
					+ "        ,tour_y\r\n"
					+ "        ,tour_tel\r\n"
					+ "        ,tour_home_url\r\n"
					+ "        ,tour_info\r\n"
					+ "        ,tour_img\r\n"
					+ "			FROM tour";
			List<TourVO> list = new ArrayList<TourVO>();
			TourVO vo = null;
			try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){

				ResultSet rs = pstmt.executeQuery();
				
				
				while( rs.next() ) {
					vo = new TourVO();
					vo.setTour_no(rs.getInt("tour_no"));
					vo.setTour_location(rs.getString("tour_location"));
		            vo.setTour_category(rs.getString("tour_category"));
		            vo.setTour_name(rs.getString("tour_name"));
		            vo.setTour_sub_title(rs.getString("tour_sub_title"));
		            vo.setTour_address(rs.getString("tour_address"));
		            vo.setTour_x(rs.getString("tour_x"));
		            vo.setTour_y(rs.getString("tour_y"));
		            vo.setTour_tel(rs.getString("tour_tel"));
		            vo.setTour_home_url(rs.getString("tour_home_url"));
		            vo.setTour_info(rs.getString("tour_info"));
		            vo.setTour_img(rs.getString("tour_img"));
					
					list.add(vo);
				}
				rs.close();
				
			
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	}