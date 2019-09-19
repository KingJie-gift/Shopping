package service;

import dao.ShopcartDao;
import entity.Shopcart;

import java.util.List;

public class ShopcartService {
    public List<Shopcart> getShopcart(int id) {
        return new ShopcartDao().getShopcart(id);
    }
    public int addShopcart(Shopcart shopcart) {
        return new ShopcartDao().addShopcart(shopcart);
    }
    public int delShopcart(int id) {
        return new ShopcartDao().delShopcart(id);
    }
}
