package OhShu.vo;

public class StayVO {
	private int stay_no;
	private String stay_location;
	private String stay_category;
	private String stay_name;
	private String stay_sub_title;
	private String stay_address;
	private String stay_x;
	private String stay_y;
	private String stay_tel;
	private String stay_home_url;
	private String stay_img;
	public int getStay_no() {
		return stay_no;
	}
	public String getStay_location() {
		return stay_location;
	}
	public void setStay_location(String stay_location) {
		this.stay_location = stay_location;
	}
	public String getStay_category() {
		return stay_category;
	}
	public void setStay_category(String stay_category) {
		this.stay_category = stay_category;
	}
	public String getStay_name() {
		return stay_name;
	}
	public void setStay_name(String stay_name) {
		this.stay_name = stay_name;
	}
	public String getStay_sub_title() {
		return stay_sub_title;
	}
	public void setStay_sub_title(String stay_sub_title) {
		this.stay_sub_title = stay_sub_title;
	}
	public String getStay_address() {
		return stay_address;
	}
	public void setStay_address(String stay_address) {
		this.stay_address = stay_address;
	}
	public String getStay_x() {
		return stay_x;
	}
	public void setStay_x(String stay_x) {
		this.stay_x = stay_x;
	}
	public String getStay_y() {
		return stay_y;
	}
	public void setStay_y(String stay_y) {
		this.stay_y = stay_y;
	}
	public String getStay_tel() {
		return stay_tel;
	}
	public void setStay_tel(String stay_tel) {
		this.stay_tel = stay_tel;
	}
	public String getStay_home_url() {
		return stay_home_url;
	}
	public void setStay_home_url(String stay_home_url) {
		this.stay_home_url = stay_home_url;
	}
	public String getStay_img() {
		return stay_img;
	}
	public void setStay_img(String stay_img) {
		this.stay_img = stay_img;
	}
	public void setStay_no(int stay_no) {
		this.stay_no = stay_no;
	}
	@Override
	public String toString() {
		return "StayVO [stay_no=" + stay_no + ", stay_location=" + stay_location + ", stay_category=" + stay_category
				+ ", stay_name=" + stay_name + ", stay_sub_title=" + stay_sub_title + ", stay_address=" + stay_address
				+ ", stay_x=" + stay_x + ", stay_y=" + stay_y + ", stay_tel=" + stay_tel + ", stay_home_url="
				+ stay_home_url + ", stay_img=" + stay_img + "]";
	}
	
	
	

}
