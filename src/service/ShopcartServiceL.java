package service;

import dao.ShopcartDaoL;
import entity.Shopcart;

import java.util.List;

public class ShopcartServiceL {
    public List<Shopcart> getShopcart(int id) {
        return new ShopcartDaoL().getShopcart(id);
    }
    public int addShopcart(Shopcart shopcart) {
        return new ShopcartDaoL().addShopcart(shopcart);
    }
    public int delShopcart(int id) {
        return new ShopcartDaoL().delShopcart(id);
    }
    public int selectShopcartId(int id) {
    	return new ShopcartDaoL().selectShopcartId(id);
    }
}
