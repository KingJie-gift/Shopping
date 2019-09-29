package dao.impl;

import java.util.List;

import entity.Commodity;

public interface CommodityDaoImplZ {

	//全查种类
	public List<Commodity> getqcAll();
	//添加种类
	public int CommodityAdd(Commodity comm);
    //查重
	public int getcount(String name);
	
	//修改
	public Commodity getfone(int id);
	
	public int updateComm(Commodity comm);
	 
	
}
