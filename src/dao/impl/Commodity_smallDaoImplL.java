package dao.impl;

import entity.Commodity_small;

import java.util.List;

public interface Commodity_smallDaoImplL  {
//    使用大商品查询子商品
    public List<Commodity_small> commBySmall(int id);

//    删除子奶粉信息
    public int delSmall();

//    添加奶粉信息
    public int addSmall(String small, int id);
    
//    查询童衣种类
    public List<String> selectTong(String tong);
    
// 	查询全部商品种类
    public List<Commodity_small> selectComm();
    
   //添加商品种类
    public int getaddzl(Commodity_small sm);
    
    //删除商品种类
    public int getDelete(int id);
    //删除商品
    public int getdel(int id);
    
}
