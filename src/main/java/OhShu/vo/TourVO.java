package OhShu.vo;

public class TourVO {
	private int tour_no;
	private String tour_location;
	private String tour_category;
	private String tour_name;
	private String tour_sub_title;
	private String tour_address;
	private String tour_x;
	private String tour_y;
	private String tour_tel;
	private String tour_home_url;
	private String tour_info;
	private String tour_img;

	@Override
	public String toString() {
		return "tourVO [tour_no=" + tour_no + ", tour_location=" + tour_location + ", tour_category=" + tour_category
				+ ", tour_name=" + tour_name + ", tour_sub_title=" + tour_sub_title + ", tour_address=" + tour_address
				+ ", tour_x=" + tour_x + ", tour_y=" + tour_y + ", tour_tel=" + tour_tel + ", tour_home_url="
				+ tour_home_url + ", tour_info=" + tour_info + ", tour_img=" + tour_img + "]";
	}

	public int getTour_no() {
		return tour_no;
	}

	public void setTour_no(int tour_no) {
		this.tour_no = tour_no;
	}

	public String getTour_location() {
		return tour_location;
	}

	public void setTour_location(String tour_location) {
		this.tour_location = tour_location;
	}

	public String getTour_category() {
		return tour_category;
	}

	public void setTour_category(String tour_category) {
		this.tour_category = tour_category;
	}

	public String getTour_name() {
		return tour_name;
	}

	public void setTour_name(String tour_name) {
		this.tour_name = tour_name;
	}

	public String getTour_sub_title() {
		return tour_sub_title;
	}

	public void setTour_sub_title(String tour_sub_title) {
		this.tour_sub_title = tour_sub_title;
	}

	public String getTour_address() {
		return tour_address;
	}

	public void setTour_address(String tour_address) {
		this.tour_address = tour_address;
	}

	public String getTour_x() {
		return tour_x;
	}

	public void setTour_x(String tour_x) {
		this.tour_x = tour_x;
	}

	public String getTour_y() {
		return tour_y;
	}

	public void setTour_y(String tour_y) {
		this.tour_y = tour_y;
	}

	public String getTour_tel() {
		return tour_tel;
	}

	public void setTour_tel(String tour_tel) {
		this.tour_tel = tour_tel;
	}

	public String getTour_home_url() {
		return tour_home_url;
	}

	public void setTour_home_url(String tour_home_url) {
		this.tour_home_url = tour_home_url;
	}

	public String getTour_info() {
		return tour_info;
	}

	public void setTour_info(String tour_info) {
		this.tour_info = tour_info;
	}

	public String getTour_img() {
		return tour_img;
	}

	public void setTour_img(String tour_img) {
		this.tour_img = tour_img;
	}

}
