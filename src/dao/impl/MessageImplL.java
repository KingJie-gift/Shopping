package dao.impl;

public interface MessageImplL {
	//查询商品评论表编号
	public int selectMessageId(int id);
	//删除评论信息
	public int delMessage(int id);
}
