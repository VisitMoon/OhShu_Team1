package OhShu.ServiceImpl;

import java.util.List;

import OhShu.DAO.MainDAO;
import OhShu.DAOImpl.MainDAOImpl;
import OhShu.service.MainService;
import OhShu.Util.PageMaker;
import OhShu.Servlet.vo.BoardVO;



public class MainServiceImpl implements MainService {
	
	private static final MainService instance = new MainServiceImpl();
	private final MainDAO dao = MainDAOImpl.getInstance();
	
	private MainServiceImpl() {	}
	
	public static MainService getInstance() {
		return instance;
	}
	
	@Override
	public List<BoardVO> getAllBoard(){
		return dao.selectAllBoard();
	}
	
	@Override
	public int getCountAllBoard(){
		return dao.seletCountAllBoard();
	}


	@Override
	public List<BoardVO> getAllBoardByPage(PageMaker pageMaker) {
		return dao.selectAllBoardByPage(pageMaker);
	}

}
