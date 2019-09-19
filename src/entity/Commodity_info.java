package entity;

import java.sql.Date;

public class Commodity_info {

	private int commodity_info_id;//商品编号
	private String commodity_info_name;//商品名
	private double commodity_info_money;//商品价格
	private double commodity_info_Jmoney;//进货价格
	private Commodity_small commodity_small;//商品小种类编号（外键）
	private String commodity_info_KG;//产品规格
	private String commodity_show;//产品描述
	private String commodity_num;//购买数量
	private String commodity_milladdress;//产品产地
	private String commodity_millname;//厂名
	private String commodity_millphone;//厂家联系电话
	private String commodity_millelement;//商品配料
	private String commodity_millstock;//储存方法
	private int commodity_milldate;//保质期
	private Date commodity_millyield;//生产日期
	private Brand brand;//品牌  (外键)
	private String commodity_milltype;//包装类型
	private Enter enter;//用户编号（外键）
	private int commodity_droptype;//删除状态  0正常 1删除
	public int getCommodity_info_id() {
		return commodity_info_id;
	}
	public void setCommodity_info_id(int commodity_info_id) {
		this.commodity_info_id = commodity_info_id;
	}
	public String getCommodity_info_name() {
		return commodity_info_name;
	}
	public void setCommodity_info_name(String commodity_info_name) {
		this.commodity_info_name = commodity_info_name;
	}
	public double getCommodity_info_money() {
		return commodity_info_money;
	}
	public void setCommodity_info_money(double commodity_info_money) {
		this.commodity_info_money = commodity_info_money;
	}
	public double getCommodity_info_Jmoney() {
		return commodity_info_Jmoney;
	}
	public void setCommodity_info_Jmoney(double commodity_info_Jmoney) {
		this.commodity_info_Jmoney = commodity_info_Jmoney;
	}
	public Commodity_small getCommodity_small() {
		return commodity_small;
	}
	public void setCommodity_small(Commodity_small commodity_small) {
		this.commodity_small = commodity_small;
	}
	public String getCommodity_info_KG() {
		return commodity_info_KG;
	}
	public void setCommodity_info_KG(String commodity_info_KG) {
		this.commodity_info_KG = commodity_info_KG;
	}
	public String getCommodity_show() {
		return commodity_show;
	}
	public void setCommodity_show(String commodity_show) {
		this.commodity_show = commodity_show;
	}
	public String getCommodity_num() {
		return commodity_num;
	}
	public void setCommodity_num(String commodity_num) {
		this.commodity_num = commodity_num;
	}
	public String getCommodity_milladdress() {
		return commodity_milladdress;
	}
	public void setCommodity_milladdress(String commodity_milladdress) {
		this.commodity_milladdress = commodity_milladdress;
	}
	public String getCommodity_millname() {
		return commodity_millname;
	}
	public void setCommodity_millname(String commodity_millname) {
		this.commodity_millname = commodity_millname;
	}
	public String getCommodity_millphone() {
		return commodity_millphone;
	}
	public void setCommodity_millphone(String commodity_millphone) {
		this.commodity_millphone = commodity_millphone;
	}
	public String getCommodity_millelement() {
		return commodity_millelement;
	}
	public void setCommodity_millelement(String commodity_millelement) {
		this.commodity_millelement = commodity_millelement;
	}
	public String getCommodity_millstock() {
		return commodity_millstock;
	}
	public void setCommodity_millstock(String commodity_millstock) {
		this.commodity_millstock = commodity_millstock;
	}
	public int getCommodity_milldate() {
		return commodity_milldate;
	}
	public void setCommodity_milldate(int commodity_milldate) {
		this.commodity_milldate = commodity_milldate;
	}
	public Date getCommodity_millyield() {
		return commodity_millyield;
	}
	public void setCommodity_millyield(Date commodity_millyield) {
		this.commodity_millyield = commodity_millyield;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getCommodity_milltype() {
		return commodity_milltype;
	}
	public void setCommodity_milltype(String commodity_milltype) {
		this.commodity_milltype = commodity_milltype;
	}
	public Enter getEnter() {
		return enter;
	}
	public void setEnter(Enter enter) {
		this.enter = enter;
	}
	public int getCommodity_droptype() {
		return commodity_droptype;
	}
	public void setCommodity_droptype(int commodity_droptype) {
		this.commodity_droptype = commodity_droptype;
	}
	
	
}
