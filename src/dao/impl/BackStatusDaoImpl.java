package dao.impl;

import entity.Buy;
import entity.Buyshow;

import java.util.List;

public interface BackStatusDaoImpl {
    //查看某一个发货类型的状态进行分页
    public List<Buy> buyshows(int indexPage,int row ,int type);
//查看某一个发货类型的状态进行分页
    public int sumPagexx(int type);

//    根据这个编号查看商品购买的详情
    public List<Buyshow> getBuyShowInfos(int id);
//    更新购物状态
    public int updateBuyShowInfoxxx(int type,int id);
}
