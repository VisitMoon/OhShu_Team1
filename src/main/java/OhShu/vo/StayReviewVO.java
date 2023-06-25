package OhShu.vo;

public class StayReviewVO {
	private int review_no;
	private String time;
	private String user_id;
	private int stay_no;
	private String review_content;
	
	
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getStay_no() {
		return stay_no;
	}
	public void setStay_no(int stay_no) {
		this.stay_no = stay_no;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	
	@Override
	public String toString() {
		return "StayReviewVO [review_no=" + review_no + ", time=" + time + ", user_id=" + user_id + ", stay_no="
				+ stay_no + ", review_content=" + review_content + "]";
	}
	
	
	
	
	
}