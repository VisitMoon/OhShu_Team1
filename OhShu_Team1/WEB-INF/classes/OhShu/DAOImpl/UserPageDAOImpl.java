package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import OhShu.DAO.UserPageDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.FoodVO;
import OhShu.vo.StayVO;
import OhShu.vo.TourVO;
import OhShu.vo.UserTableVO;

public class UserPageDAOImpl implements UserPageDAO{
   private static final UserPageDAO instance = new UserPageDAOImpl();
   
   public static UserPageDAO getInstance() {
      return instance;
   }
   
   public UserTableVO selectUserInfo(String user_id){
      String sql = "select * from user_tb where user_id = ?";
      
      UserTableVO vo = null;
      
      try(
            Connection conn = DataBaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ){
            pstmt.setString(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            
            
            if( rs.next() ) {
               vo = new UserTableVO();
               vo.setUser_id(rs.getString("user_id"));
               vo.setUser_pwd(rs.getString("user_pwd"));
               vo.setUser_name(rs.getString("user_name"));
               vo.setUser_age(rs.getInt("user_age"));
               vo.setUser_jumin(rs.getString("user_jumin"));
            }
            rs.close();
            
         
            
         }catch(Exception e) {
            e.printStackTrace();
         }
         return vo;
   }
   
   public int updateUserPwd(String user_id, String current_pwd, String changed_pwd) {
      int result = 0;
      
      String sql = "UPDATE user_tb SET user_pwd = ? WHERE user_id = ? AND user_pwd = ?";
      
      try( Connection conn = DataBaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
         pstmt.setString(1, changed_pwd);
         pstmt.setString(2,  user_id);
         pstmt.setString(3,  current_pwd);
         
         result = pstmt.executeUpdate();
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      
      return result;
   }
   
   public List<FoodVO> selectUserFoodJoayo(String user_id){
      String sql = "SELECT f.food_no, f.food_location, f.food_source, f.food_name \r\n"
            + "FROM food f \r\n"
            + "WHERE f.food_no in (\r\n"
            + "  SELECT fj.food_no \r\n"
            + "  FROM food_joayo fj \r\n"
            + "  WHERE fj.user_id = ?)";
      
      FoodVO vo = null;
      List<FoodVO> list = new ArrayList<FoodVO>();
      
      try(Connection conn = DataBaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
         pstmt.setString(1,  user_id);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            vo = new FoodVO();
            vo.setFood_no(rs.getInt("food_no"));
            vo.setFood_location(rs.getString("food_location"));
            vo.setFood_source(rs.getString("food_source"));
            vo.setFood_name(rs.getString("food_name"));
            
            list.add(vo);
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
   public List<TourVO> selectUserTourJoayo(String user_id){
      String sql = "SELECT t.tour_no, t.tour_location, t.tour_category, t.tour_name \r\n"
            + "FROM tour t\r\n"
            + "WHERE t.tour_no in (\r\n"
            + "  SELECT tj.tour_no \r\n"
            + "  FROM tour_joayo tj \r\n"
            + "  WHERE tj.user_id =?)";
      
      TourVO vo = null;
      List<TourVO> list = new ArrayList<TourVO>();
      
      try(Connection conn = DataBaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
         pstmt.setString(1,  user_id);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            vo = new TourVO();
            vo.setTour_no(rs.getInt("tour_no"));
            vo.setTour_location(rs.getString("tour_location"));
            vo.setTour_category(rs.getString("tour_category"));
            vo.setTour_name(rs.getString("tour_name"));
            
            list.add(vo);
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
   public List<StayVO> selectUserStayJoayo(String user_id){
      String sql = "SELECT s.stay_no, s.stay_location, s.stay_category, s.stay_name \r\n"
            + "FROM stay s\r\n"
            + "WHERE s.stay_no in (\r\n"
            + "  SELECT sj.stay_no \r\n"
            + "  FROM stay_joayo sj \r\n"
            + "  WHERE sj.user_id = ?)";
      
      StayVO vo = null;
      List<StayVO> list = new ArrayList<StayVO>();
      
      try(Connection conn = DataBaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
         pstmt.setString(1,  user_id);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            vo = new StayVO();
            vo.setStay_no(rs.getInt("stay_no"));
            vo.setStay_location(rs.getString("stay_location"));
            vo.setStay_category(rs.getString("stay_category"));
            vo.setStay_name(rs.getString("stay_name"));
            
            list.add(vo);
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
}