package service;

import java.util.List;

import dao.CommodityDaoL;
import entity.Commodity;
import entity.Commodity_small;

public class CommodityServiceL {
    public int commId() {
        return new CommodityDaoL().commId();
    }
    
    public List<Commodity> getListByAll() {
    	return new CommodityDaoL().getListByAll();
    }
   
}
