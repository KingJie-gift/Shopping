package entity;

public class Commodity {

	private int commodity_id;//种类编号
	private String commodity_name;//商品种类名
	public int getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}
	public String getCommodity_name() {
		return commodity_name;
	}
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}

	public Commodity(int commodity_id, String commodity_name) {
		this.commodity_id = commodity_id;
		this.commodity_name = commodity_name;
	}
	public Commodity(){}
}
