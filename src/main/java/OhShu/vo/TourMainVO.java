package OhShu.vo;

public class TourMainVO {
	private int tour_no;
	private String tour_name;
	private String tour_img;
	private int joayo_amount;
	public int getTour_no() {
		return tour_no;
	}
	public void setTour_no(int tour_no) {
		this.tour_no = tour_no;
	}
	public String getTour_name() {
		return tour_name;
	}
	public void setTour_name(String tour_name) {
		this.tour_name = tour_name;
	}
	public String getTour_img() {
		return tour_img;
	}
	public void setTour_img(String tour_img) {
		this.tour_img = tour_img;
	}
	public int getJoayo_amount() {
		return joayo_amount;
	}
	public void setJoayo_amount(int joayo_amount) {
		this.joayo_amount = joayo_amount;
	}
	@Override
	public String toString() {
		return "TourMainVO [tour_no=" + tour_no + ", tour_name=" + tour_name + ", tour_img=" + tour_img
				+ ", joayo_amount=" + joayo_amount + "]";
	}
	
}
