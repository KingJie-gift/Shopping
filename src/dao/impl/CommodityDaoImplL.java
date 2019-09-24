package dao.impl;

import entity.Commodity;
import entity.Commodity_info;

import java.util.List;

public interface CommodityDaoImplL {
//    查询全部商品
    public List<Commodity> getListByAll();

    //查找Commodity_small外检
    public Commodity commById(int id);

    //查找奶粉id
    public int commId();
    
 
}
