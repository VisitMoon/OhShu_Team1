package OhShu.vo;

public class StayJoayoVO {
	private String user_id;
	private int stay_no;
	private int joayo;
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
	public int getJoayo() {
		return joayo;
	}
	public void setJoayo(int joayo) {
		this.joayo = joayo;
	}
	@Override
	public String toString() {
		return "StayJoayoVO [user_id=" + user_id + ", stay_no=" + stay_no + ", joayo=" + joayo + "]";
	}
	
	
}
