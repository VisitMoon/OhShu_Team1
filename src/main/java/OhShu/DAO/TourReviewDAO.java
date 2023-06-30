package OhShu.DAO;

import java.util.List;

import OhShu.vo.FoodReviewVO;
import OhShu.vo.TourReviewVO;

public interface TourReviewDAO {

	int insertTourReview(TourReviewVO tourReview);

	void deleteTourReview(int review_no);

	int updateTourReview(TourReviewVO tourReview);

	List<TourReviewVO> selectTourReview(int tourNo);
}
