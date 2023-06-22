package OhShu.service;

import java.util.List;

import OhShu.Servlet.vo.BoardVO;
import OhShu.Util.PageMaker;

public interface MainService {
	
	List<BoardVO> getAllBoard();
	
	int getCountAllBoard();
	
	List<BoardVO> getAllBoardByPage(PageMaker pageMaker);
	
}
