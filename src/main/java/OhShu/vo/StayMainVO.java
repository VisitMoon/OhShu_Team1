package OhShu.vo;

public class StayMainVO {
	private int stay_no;
	private String stay_name;
	private String stay_img;
	private int joayo_amount;
	public int getStay_no() {
		return stay_no;
	}
	public void setStay_no(int stay_no) {
		this.stay_no = stay_no;
	}
	public String getStay_name() {
		return stay_name;
	}
	public void setStay_name(String stay_name) {
		this.stay_name = stay_name;
	}
	public String getStay_img() {
		return stay_img;
	}
	public void setStay_img(String stay_img) {
		this.stay_img = stay_img;
	}
	public int getJoayo_amount() {
		return joayo_amount;
	}
	public void setJoayo_amount(int joayo_amount) {
		this.joayo_amount = joayo_amount;
	}
	@Override
	public String toString() {
		return "StayMainVO [stay_no=" + stay_no + ", stay_name=" + stay_name + ", stay_img=" + stay_img
				+ ", joayo_amount=" + joayo_amount + "]";
	}
	
}
