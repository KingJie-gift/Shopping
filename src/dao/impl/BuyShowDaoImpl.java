package dao.impl;

import entity.Buyshow;

import java.util.List;

public interface BuyShowDaoImpl {
//    添加购买信息
    public int byShow(Buyshow buyshow);
//    显示当前用户信息
    public List<Buyshow> byShowInfo(int id);
}
