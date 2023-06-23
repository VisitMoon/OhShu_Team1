package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OhShu.DAO.StayMainDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.StayVO;

public class StayMainDAOImpl implements StayMainDAO{
	
	private final static StayMainDAO instance = new StayMainDAOImpl();
	
	private StayMainDAOImpl() {
		
	}
	public static StayMainDAO getInstance() {
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
				+ "        ,stay_img\r\n"
				+ "		   ,stay_info\r\n"
				+ "		   FROM stay WHERE stay_no = ?"
				;
		
		StayVO stay = null;
		
		try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, stay_no);
			ResultSet rs = pstmt.executeQuery();
			
			
			if( rs.next() ) {
				stay = new StayVO();
				stay.setStay_no(rs.getInt("stay_no"));
				stay.setStay_location(rs.getString("stay_location"));
				stay.setStay_category(rs.getString("stay_category"));
				stay.setStay_name(rs.getString("stay_name"));
				stay.setStay_sub_title(rs.getString("stay_sub_title"));
				stay.setStay_address(rs.getString("stay_address"));
				stay.setStay_x(rs.getString("stay_x"));
				stay.setStay_y(rs.getString("stay_y"));
				stay.setStay_tel(rs.getString("stay_tel"));
				stay.setStay_home_url(rs.getString("stay_home_url"));
				stay.setStay_info(rs.getString("stay_info"));
				stay.setStay_img(rs.getString("stay_img"));
				
				
			}
			rs.close();
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stay;
	}

}