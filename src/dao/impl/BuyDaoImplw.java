package dao.impl;

import entity.Buy;

import java.util.List;

public interface BuyDaoImplw {
//    添加购买数据
    public int addByComm(Buy buy);
//    获取最近的一条数据
    public int selByShow();
//    查看当前用户已购买商品
    public Buy getListByAll(int id);
}
