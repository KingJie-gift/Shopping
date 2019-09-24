package service;

import dao.CommodityDaow;

public class CommodityServicew {
    public int commId() {
        return new CommodityDaow().commId();
    }
}
