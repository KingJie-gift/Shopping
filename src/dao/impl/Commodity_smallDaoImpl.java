package dao.impl;

import entity.Commodity_small;

import java.util.List;

public interface Commodity_smallDaoImpl  {
//    使用大商品查询子商品
    public List<Commodity_small> commBySmall(int id);

//    删除子奶粉信息
    public int delSmall();

//    添加奶粉信息
    public int addSmall(String small , int id );
//    查询奶粉
    public List<Integer> commByNum();

//    更新
    public int addCommBy(String id, int row);
}
