package service;

import dao.BuyShowDaow;
import entity.Buyshow;

import java.util.List;

public class ByShowServicew {
    public int byShow(Buyshow buyshow) {
        return new BuyShowDaow().byShow(buyshow);
    }
    public List<Buyshow> byShowInfo(int id) {
        return new BuyShowDaow().byShowInfo(id);
    }
}
