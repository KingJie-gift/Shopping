package service;

import dao.ShopcartDaow;
import entity.Shopcart;

import java.util.List;

public class ShopcartServicew {
    public List<Shopcart> getShopcart(int id) {
        return new ShopcartDaow().getShopcart(id);
    }
    public int addShopcart(Shopcart shopcart) {
        return new ShopcartDaow().addShopcart(shopcart);
    }
    public int delShopcart(int id) {
        return new ShopcartDaow().delShopcart(id);
    }
    public Shopcart shById(int id) {
        return new ShopcartDaow().shById(id);
    }
}
