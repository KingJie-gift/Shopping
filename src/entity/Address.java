package entity;

public class Address {
	
	private int address_id;//地址编号
	private Enter enter;//关联用户编号（外键）
	private String address_info;//省份/城市/区县/街道
	private String address_detalied;//详细地址
	private String address_postal;//邮政编码
	private String address_name;//收件人姓名
	private String address_telephone;//收件人手机号
	private int address_default;//默认地址 1默认地址 0 为默认
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public Enter getEnter() {
		return enter;
	}
	public void setEnter(Enter enter) {
		this.enter = enter;
	}
	public String getAddress_info() {
		return address_info;
	}
	public void setAddress_info(String address_info) {
		this.address_info = address_info;
	}
	public String getAddress_detalied() {
		return address_detalied;
	}
	public void setAddress_detalied(String address_detalied) {
		this.address_detalied = address_detalied;
	}
	public String getAddress_postal() {
		return address_postal;
	}
	public void setAddress_postal(String address_postal) {
		this.address_postal = address_postal;
	}
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getAddress_telephone() {
		return address_telephone;
	}
	public void setAddress_telephone(String address_telephone) {
		this.address_telephone = address_telephone;
	}
	public int getAddress_default() {
		return address_default;
	}
	public void setAddress_default(int address_default) {
		this.address_default = address_default;
	}
	
}
