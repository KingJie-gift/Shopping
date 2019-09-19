package entity;

import java.sql.Date;

public class Buy {

	private int buy_id;//购买记录编号
	private Enter enter;//用户表(外键)
	private double bug_money;//购买总金额
	private int bug_type;//签收状态    0:未发货1:发货2:签收3:未签收4:派送中
	private Date buy_date;//购买时间
	private Address address;
	public int getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(int buy_id) {
		this.buy_id = buy_id;
	}
	public Enter getEnter() {
		return enter;
	}
	public void setEnter(Enter enter) {
		this.enter = enter;
	}
	public double getBug_money() {
		return bug_money;
	}
	public void setBug_money(double bug_money) {
		this.bug_money = bug_money;
	}
	public int getBug_type() {
		return bug_type;
	}
	public void setBug_type(int bug_type) {
		this.bug_type = bug_type;
	}
	public Date getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
