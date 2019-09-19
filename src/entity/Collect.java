package entity;

public class Collect {

	private int collect_id;//收藏编号
	private Enter enter;//用户编号 （外键）
	private Commodity_info commodity;//商品信息编号（外键）
	public int getCollect_id() {
		return collect_id;
	}
	public void setCollect_id(int collect_id) {
		this.collect_id = collect_id;
	}
	public Enter getEnter() {
		return enter;
	}
	public void setEnter(Enter enter) {
		this.enter = enter;
	}
	public Commodity_info getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity_info commodity) {
		this.commodity = commodity;
	}
	
	
}
