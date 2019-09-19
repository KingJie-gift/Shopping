package entity;

public class Buyshow {

	private int buyshow_id;//订单明细编号
	private Buy buy;//订单编号(外键)
	private Commodity_info commodity;//商品表（外键）
	private int buyshow_count;//购买数量
	private double buyshow_price;//购买价格
	private Abapt abapt_id;
	public int getBuyshow_id() {
		return buyshow_id;
	}
	public void setBuyshow_id(int buyshow_id) {
		this.buyshow_id = buyshow_id;
	}
	public Buy getBuy() {
		return buy;
	}
	public void setBuy(Buy buy) {
		this.buy = buy;
	}
	public Commodity_info getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity_info commodity) {
		this.commodity = commodity;
	}
	public int getBuyshow_count() {
		return buyshow_count;
	}
	public void setBuyshow_count(int buyshow_count) {
		this.buyshow_count = buyshow_count;
	}
	public double getBuyshow_price() {
		return buyshow_price;
	}
	public void setBuyshow_price(double buyshow_price) {
		this.buyshow_price = buyshow_price;
	}

	public Abapt getAbapt_id() {
		return abapt_id;
	}

	public void setAbapt_id(Abapt abapt_id) {
		this.abapt_id = abapt_id;
	}
}
