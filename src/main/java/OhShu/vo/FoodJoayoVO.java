package OhShu.vo;

public class FoodJoayoVO {
	private String user_id;
	private int food_no;
	private int joayo;
	
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
	public int getJoayo() {
		return joayo;
	}
	public void setJoayo(int joayo) {
		this.joayo = joayo;
	}
	@Override
	public String toString() {
		return "FoodJoayoVO [user_id=" + user_id + ", food_no=" + food_no + ", joayo=" + joayo + "]";
	}
}
