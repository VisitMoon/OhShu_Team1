package OhShu.vo;

public class TourJoayoVO {
	private String user_id;
	private int tour_no;
	private int joayo;


	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getTour_no() {
		return tour_no;
	}
	public void setTour_no(int tour_no) {
		this.tour_no = tour_no;
	}
	public int getJoayo() {
		return joayo;
	}
	public void setJoayo(int joayo) {
		this.joayo = joayo;
	}
	
	@Override
	public String toString() {
		return "TourJoayoVO [user_id=" + user_id + ", tour_no=" + tour_no + ", joayo=" + joayo + "]";
	}

}
