package service;

import dao.BuyShowDao;
import entity.Buyshow;

import java.util.List;

public class ByShowService {
    public int byShow(Buyshow buyshow) {
        return new BuyShowDao().byShow(buyshow);
    }
    public List<Buyshow> byShowInfo(int id) {
        return new BuyShowDao().byShowInfo(id);
    }
}
