package entity;

public class Show_info {

	private int show_info_id;//图片编号
	private String show_info_url;//图片路径
	private Commodity_info commodity;//商品信息表(外键)
	public int getShow_info_id() {
		return show_info_id;
	}
	public void setShow_info_id(int show_info_id) {
		this.show_info_id = show_info_id;
	}
	public String getShow_info_url() {
		return show_info_url;
	}
	public void setShow_info_url(String show_info_url) {
		this.show_info_url = show_info_url;
	}
	public Commodity_info getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity_info commodity) {
		this.commodity = commodity;
	}
	
}
