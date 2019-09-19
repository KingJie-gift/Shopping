package service;

import dao.CommodityDao;
import entity.Commodity;

public class CommodityService {
    public int commId() {
        return new CommodityDao().commId();
    }
}
