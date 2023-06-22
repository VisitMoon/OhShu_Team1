package OhShu.DAO;

import java.util.List;

import OhShu.Util.PageMaker;
import OhShu.Servlet.vo.BoardVO;

public interface MainDAO {
	
	
	 // 메인 VO 만들어야함

	List<BoardVO> selectAllBoard();

	int seletCountAllBoard();

	List<BoardVO> selectAllBoardByPage(PageMaker pageMaker);

}
