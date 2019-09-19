package entity;

public class Commodity_small {

	private int commodity_small_id;//商品小种类编号
	private String commodity_small_name;//商品小种类名
	private Commodity commodity;//种类编号（外键）
	
	public int getCommodity_small_id() {
		return commodity_small_id;
	}
	public void setCommodity_small_id(int commodity_small_id) {
		this.commodity_small_id = commodity_small_id;
	}
	public String getCommodity_small_name() {
		return commodity_small_name;
	}
	public void setCommodity_small_name(String commodity_small_name) {
		this.commodity_small_name = commodity_small_name;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Commodity_small(int commodity_small_id, String commodity_small_name, Commodity commodity) {
		this.commodity_small_id = commodity_small_id;
		this.commodity_small_name = commodity_small_name;
		this.commodity = commodity;
	}
	public Commodity_small(){}
}
