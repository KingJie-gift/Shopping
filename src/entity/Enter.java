package entity;

public class Enter {

	private int enter_id;//用户编号
	private String enter_name;//用户名
	private String enter_truename;//真实姓名
	private String enter_password;//登录密码
	private String enter_telephone;//用户手机号
	private String enter_card_id;//身份证
	private String enter_gender;//性别
	private String enter_url;//存放头像路径
	private int enter_type;//用户类别：1为用户 2为管理员
	public String getEnter_truename() {
		return enter_truename;
	}
	public void setEnter_truename(String enter_truename) {
		this.enter_truename = enter_truename;
	}
	public String getEnter_card_id() {
		return enter_card_id;
	}
	public void setEnter_card_id(String enter_card_id) {
		this.enter_card_id = enter_card_id;
	}
	public String getEnter_gender() {
		return enter_gender;
	}
	public void setEnter_gender(String enter_gender) {
		this.enter_gender = enter_gender;
	}


	public int getEnter_id() {
		return enter_id;
	}
	public void setEnter_id(int enter_id) {
		this.enter_id = enter_id;
	}
	public String getEnter_name() {
		return enter_name;
	}
	public void setEnter_name(String enter_name) {
		this.enter_name = enter_name;
	}
	public String getEnter_password() {
		return enter_password;
	}
	public void setEnter_password(String enter_password) {
		this.enter_password = enter_password;
	}
	public String getEnter_telephone() {
		return enter_telephone;
	}
	public void setEnter_telephone(String enter_telephone) {
		this.enter_telephone = enter_telephone;
	}
	public String getEnter_url() {
		return enter_url;
	}
	public void setEnter_url(String enter_url) {
		this.enter_url = enter_url;
	}
	public int getEnter_type() {
		return enter_type;
	}
	public void setEnter_type(int enter_type) {
		this.enter_type = enter_type;
	}


}
