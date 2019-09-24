package service;

import dao.BuyDaow;
import entity.Buy;

public class BuyServicew {
    public int addByComm(Buy buy) {
        return new BuyDaow().addByComm(buy);
    }
    public int selByShow() {
        return new BuyDaow().selByShow();
    }
}
