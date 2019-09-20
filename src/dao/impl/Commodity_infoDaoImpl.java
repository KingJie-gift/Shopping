package dao.impl;

import entity.Abapt;
import entity.Commodity_info;

import java.util.List;

public interface Commodity_infoDaoImpl {
//    index显示页面
    public List<Commodity_info> getIndexTime();

//    显示推荐
    public List<Commodity_info> getRecommend();

//    进日团购
    public List<Commodity_info> getByLimit(int indexPage,int row,int type,int small,String like,int prent_id,int commType,int day);
//    查看所有数据进行分组
    public int sumCountAll(int id,int prent_id,String like,int commType,int type,int day);

//    明日预告以数据进行展示

    public List<Commodity_info> dayShow();

//    根据id查询商品信息
    public Commodity_info commById(int id);

//    查询用户最多的编号
    public List<Integer> getComm();

//    使用分类进行查询
    public List<Commodity_info> getListComm(String comm);

//    显示推荐的商品
    public List<Commodity_info> getTShopping(int id);
//销售成功销量加1
    public int rowById(int id);
}
