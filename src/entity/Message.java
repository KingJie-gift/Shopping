package entity;

import java.sql.Date;

public class Message {

	
	private int message_id;//评论表编号
	private Commodity_info commodity;//商品信息（外键）
	private String message_info;//评论内容
	private Date message_time;//评论时间
	private int message_type;//评论状态  1:好评2:中评3:差评
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public Commodity_info getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity_info commodity) {
		this.commodity = commodity;
	}
	public String getMessage_info() {
		return message_info;
	}
	public void setMessage_info(String message_info) {
		this.message_info = message_info;
	}
	public Date getMessage_time() {
		return message_time;
	}
	public void setMessage_time(Date message_time) {
		this.message_time = message_time;
	}
	public int getMessage_type() {
		return message_type;
	}
	public void setMessage_type(int message_type) {
		this.message_type = message_type;
	}

	
}
