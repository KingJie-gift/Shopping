package entity;

import java.sql.Date;

public class Shopcart {

	private int shopcart_id;//购物车编号
	private Enter enter;//用户信息（外键）
	private Commodity_info commodity;//商品信息（外键）
	private int shopcart_num;//购买数量
	private Abapt abapt;
	private Date shopcart_date;//加入时间
	public int getShopcart_id() {
		return shopcart_id;
	}
	public void setShopcart_id(int shopcart_id) {
		this.shopcart_id = shopcart_id;
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
	public int getShopcart_num() {
		return shopcart_num;
	}
	public void setShopcart_num(int shopcart_num) {
		this.shopcart_num = shopcart_num;
	}
	public Date getShopcart_date() {
		return shopcart_date;
	}
	public void setShopcart_date(Date shopcart_date) {
		this.shopcart_date = shopcart_date;
	}

	public Abapt getAbapt() {
		return abapt;
	}

	public void setAbapt(Abapt abapt) {
		this.abapt = abapt;
	}
}
