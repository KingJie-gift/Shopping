package dao.impl;

import entity.Commodity_info;
import entity.Show_info;

import java.util.List;

public interface Show_InfoDaoImplL {
	//根据宝贝编号查找图片
    public Show_info listByIdImage(int id);

    //根据一个商品查询所有的图片
    public List<Show_info> getShow_infoById(int id);
    
    //查询商品图标表编号
  	public int selectShow_infoId(int id);
  	
  	//删除图片信息
  	public int delShow_info(int id);
  	
  	
}
