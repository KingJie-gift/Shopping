package service;

import dao.BuyDao;
import entity.Buy;

public class BuyService {
    public int addByComm(Buy buy) {
        return new BuyDao().addByComm(buy);
    }
    public int selByShow() {
        return new BuyDao().selByShow();
    }
}
