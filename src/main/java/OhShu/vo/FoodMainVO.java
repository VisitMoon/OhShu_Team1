package OhShu.vo;

public class FoodMainVO {
	
	private int food_no;
	private String food_location;
	private String food_source;
	private String food_name;
	private String food_sub_title;
	private String food_address;
	private String food_x;
	private String food_y;
	private String food_tel;
	private String food_home_url;
	private String food_info;
	private String food_img;
	
	
	public int getFood_no() {
		return food_no;
	}
	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}
	public String getFood_location() {
		return food_location;
	}
	public void setFood_location(String food_location) {
		this.food_location = food_location;
	}
	public String getFood_source() {
		return food_source;
	}
	public void setFood_source(String food_source) {
		this.food_source = food_source;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_sub_title() {
		return food_sub_title;
	}
	public void setFood_sub_title(String food_sub_title) {
		this.food_sub_title = food_sub_title;
	}
	public String getFood_address() {
		return food_address;
	}
	public void setFood_address(String food_address) {
		this.food_address = food_address;
	}
	public String getFood_x() {
		return food_x;
	}
	public void setFood_x(String food_x) {
		this.food_x = food_x;
	}
	public String getFood_y() {
		return food_y;
	}
	public void setFood_y(String food_y) {
		this.food_y = food_y;
	}
	public String getFood_tel() {
		return food_tel;
	}
	public void setFood_tel(String food_tel) {
		this.food_tel = food_tel;
	}
	public String getFood_home_url() {
		return food_home_url;
	}
	public void setFood_home_url(String food_home_url) {
		this.food_home_url = food_home_url;
	}
	public String getFood_info() {
		return food_info;
	}
	public void setFood_info(String food_info) {
		this.food_info = food_info;
	}
	public String getFood_img() {
		return food_img;
	}
	public void setFood_img(String food_img) {
		this.food_img = food_img;
	}
	
	
	@Override
	public String toString() {
		return "FoodVO [food_no=" + food_no + ", food_location=" + food_location + ", food_source=" + food_source
				+ ", food_name=" + food_name + ", food_sub_title=" + food_sub_title + ", food_address=" + food_address
				+ ", food_x=" + food_x + ", food_y=" + food_y + ", food_tel=" + food_tel + ", food_home_url="
				+ food_home_url + ", food_info=" + food_info + ", food_img=" + food_img + "]";
	}

}
