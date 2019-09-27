package dao.impl;

import java.util.List;

import entity.Counseling;

public interface CounselingDaoImplg {
	public int getCount();
	//查询全部新闻信息
	public List<Counseling> getAll(int pageindex,int pageSize);
    //添加新闻信息
    public  int getAdd(Counseling c);
    //删除新闻信息
   public int getDelete(int id);
    //修改新闻信息id
    public Counseling getfone(int id);
    //修改新闻信息
    public int getUpdate(Counseling c);
}
