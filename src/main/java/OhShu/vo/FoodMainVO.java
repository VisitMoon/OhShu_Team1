package OhShu.vo;

public class FoodMainVO {
	private int food_no;
	private String food_name;
	private String food_img;
	private int joayo_amount;
	public int getFood_no() {
		return food_no;
	}
	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_img() {
		return food_img;
	}
	public void setFood_img(String food_img) {
		this.food_img = food_img;
	}
	public int getJoayo_amount() {
		return joayo_amount;
	}
	public void setJoayo_amount(int joayo_amount) {
		this.joayo_amount = joayo_amount;
	}
	@Override
	public String toString() {
		return "FoodMainVO [food_no=" + food_no + ", food_name=" + food_name + ", food_img=" + food_img
				+ ", joayo_amount=" + joayo_amount + "]";
	}
	
}
