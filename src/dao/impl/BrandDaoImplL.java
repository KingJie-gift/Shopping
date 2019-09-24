package dao.impl;

import entity.Brand;
import entity.Commodity;

import java.util.List;

public interface BrandDaoImplL {
//    查询使用最多使用的品牌
    public List<Brand> listBrand();
//  	后台显示奶粉品牌
  public List<Brand> getBrandAll();
//		后台显示玩具品牌
public List<Brand> getBrandAll2();
//		后台显示童衣品牌
public List<Brand> getBrandAll3();

//查询所有品牌品牌
public List<Brand> selectAll();

//查询所有种类
public List<Commodity> selectComm();

//添加品牌
public int getBrandAdd(Brand b);

//删除
public int getdelete(int id);

//根据品牌删商品
public int getdeletesp(int id);

}
