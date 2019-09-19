package dao.impl;

import entity.Show_info;

import java.util.List;

public interface Show_InfoDaoImpl {
//    根据宝贝编号查找图片
    public Show_info listByIdImage(int id);

//    根据一个商品查询所有的图片
    public List<Show_info> getShow_infoById(int id);
}
