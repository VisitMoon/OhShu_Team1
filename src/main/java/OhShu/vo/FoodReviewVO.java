package OhShu.vo;

import java.util.Date;

public class FoodReviewVO {
		private int review_no;
		private Date time;
		private String user_id;
		private int food_no;
		private String review_content;
		
		
		public int getReview_no() {
			return review_no;
		}
		public void setReview_no(int review_no) {
			this.review_no = review_no;
		}
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public int getFood_no() {
			return food_no;
		}
		public void setFood_no(int food_no) {
			this.food_no = food_no;
		}
		public String getReview_content() {
			return review_content;
		}
		public void setReview_content(String review_content) {
			this.review_content = review_content;
		}
		@Override
		public String toString() {
			return "FoodReviewVO [review_no=" + review_no + ", time=" + time + ", user_id=" + user_id + ", food_no="
					+ food_no + ", review_content=" + review_content + "]";
		}
		
		
		
}
