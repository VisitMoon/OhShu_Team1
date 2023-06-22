package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OhShu.DAO.FoodMainDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.FoodMainVO;

public class FoodMainDAOImpl implements FoodMainDAO {

	private static final FoodMainDAO instance = new FoodMainDAOImpl();

	private FoodMainDAOImpl() {
	}

	public static FoodMainDAO getInstance() {
		return instance;
	}

	@Override
	public FoodMainVO selectFood(int food_no) {

		String sql = "SELECT food_no\r\n"
				+ "			,food_location\r\n"
				+ "			,food_source\r\n"
				+ "			,food_name\r\n"
				+ "			,food_sub_title\r\n"
				+ "			,food_address\r\n"
				+ "			,food_x\r\n"
				+ "			,food_y\r\n"
				+ "			,food_tel\r\n"
				+ "			,food_home_url\r\n"
				+"			,food_info\r\n"
				+ "			,food_img\r\n"
				+ "			FROM food WHERE food_no = ?\r\n"
 				;
		
		FoodMainVO food = null;

		try (
				Connection conn = DataBaseUtil.getConnection(); // DBCP2Util, DataBaseUtil
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, food_no);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				food = new FoodMainVO();
				
				food.setFood_no(rs.getInt("food_no"));
				food.setFood_location(rs.getString("food_location"));
				food.setFood_source(rs.getString("food_source"));
				food.setFood_name(rs.getString("food_name"));
				food.setFood_sub_title(rs.getString("food_sub_title"));
				food.setFood_address(rs.getString("food_address"));
				food.setFood_x(rs.getString("food_x"));
				food.setFood_y(rs.getString("food_y"));
				food.setFood_tel(rs.getString("food_tel"));
				food.setFood_home_url(rs.getString("food_home_url"));
				food.setFood_info(rs.getString("food_info"));
				food.setFood_img(rs.getString("food_img"));
			
			}
			rs.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return food;
	}

	
	
	
	/*


	@Override
	public int seletCountAllBoard() {
		int result = 0;
		String sql = "SELECT COUNT(1) \r\n" + "    FROM board ";
		try {
			Connection conn = DBCP2Util.getConnection();// DBCP2Util, DataBaseUtil
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<BoardVO> selectAllBoardByPage(PageMaker pageMaker) {
		String sql = "SELECT \r\n" + "        * \r\n" + "    FROM (\r\n"
				+ "            SELECT /*+ INDEX (board index_board_bno_pk)\r\n"
				+ "                    ROWNUM as rn\r\n" + "                    ,b_no\r\n"
				+ "                    ,title\r\n" + "                    ,content\r\n"
				+ "                    ,reg_date\r\n" + "                    ,up_date\r\n"
				+ "                    ,(SELECT id FROM member WHERE m_no=1042) as id\r\n"
				+ "                FROM board\r\n"
				+ "                WHERE ROWNUM <= ( ? * ? )   -- page 1=10, 2=20, 3=30  page * 10, 10: 페이지당 게시글 갯수\r\n"
				+ "            )\r\n" + "    WHERE rn > ( ( ? - 1 ) * ? )";

		List<BoardVO> list = null;

		try (Connection conn = DBCP2Util.getConnection(); // DBCP2Util, DataBaseUtil
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, pageMaker.getCri().getPageNum());
			pstmt.setInt(2, pageMaker.getCri().getAmount());
			pstmt.setInt(3, pageMaker.getCri().getPageNum());
			pstmt.setInt(4, pageMaker.getCri().getAmount());

			ResultSet rs = pstmt.executeQuery();

			list = new ArrayList<>();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setB_no(rs.getInt("b_no"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));
				vo.setReg_date(rs.getDate("reg_date"));
				vo.setUp_date(rs.getDate("up_date"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}







	 */




}
