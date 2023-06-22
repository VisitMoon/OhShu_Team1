package OhShu.DAOImpl;

<<<<<<< HEAD
public class TourJoayoDAOImpl {
=======
import java.sql.Connection;
import java.sql.PreparedStatement;

import OhShu.DAO.TourJoayoDAO;
import OhShu.Util.DataBaseUtil;

import OhShu.vo.TourJoayoVO;

public class TourJoayoDAOImpl implements TourJoayoDAO {
	private final static TourJoayoDAO instance = new TourJoayoDAOImpl();

	public static TourJoayoDAO getInstance() {
		return instance;
	}

	@Override
	public int InsertTourJoayo(TourJoayoVO joayo) {
		int result = 0;

		String sql = "INSERT INTO tour_joayo \r\n" + "(user_id, tour_no, joayo)\r\n" + "VALUES ('?', ?, '?')";

		try (Connection conn = DataBaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			System.out.println(pstmt);

			pstmt.setInt(3, joayo.getJoayo());

			result = pstmt.executeUpdate();
			System.out.println("result -" + result);

		} catch (Exception e) {

		}
		return result;

	}
>>>>>>> 2f6c0df1d89b48c8b53e619ed595bc1f06fea67a

}
