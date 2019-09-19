package dao.impl;

import entity.Shopcart;

import java.util.List;

public interface ShopcartDaoImpl  {
//    根据id查询购物车
    public List<Shopcart> getShopcart(int id);

//    添加购物车
    public int addShopcart(Shopcart shopcart);

//    删除商品
    public int delShopcart(int id);
}
