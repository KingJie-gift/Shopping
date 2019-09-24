package dao.impl;

import entity.Abapt;
import entity.Brand;
import entity.Commodity;
import entity.Commodity_info;
import entity.Commodity_small;
import entity.Show_info;

import java.sql.Date;
import java.util.List;

public interface Commodity_infoDaoImplL {
//    index显示页面
    public List<Commodity_info> getIndexTime();

//    显示推荐
    public List<Commodity_info> getRecommend();

//    进日团购
    public List<Commodity_info> getByLimit(int indexPage, int row, int type, int small);
//    查看所有数据进行分组
    public int sumCountAll();

//    明日预告以数据进行展示

    public List<Commodity_info> dayShow();

//    根据id查询商品信息
    public Commodity_info commById(int id);

//    查询用户最多的编号
    public List<Integer> getComm();
    
//	后台奶粉显示商品    
public List<Commodity_info> selectAll(int indexPage, int row, int id);

// 后台查询奶粉品牌的总数
public int selectCount(int id);

// 删除商品的图片
public int delShowInfo(int id);

//删除商品
public int delCommodity(int id);

//查询其他商品
public List<Commodity_info> selAll(int indexPage, int row, int id);

//根据id查询商品信息
public Commodity_info selFindId(int id);

//查询显示商品图片
public Show_info selectShow(int id);

//删除对应商品图片
public int deleteShow(int id);

//查询删除图片的路径
public String selectUrl(int id);

//修改查询对象
public Commodity_info selectId(int id);

//修改商品信息
public int update(Commodity_info comm);

//添加商品信息
public int insert(Commodity_info comm);

//查询全部品牌
public List<Brand> selectB();

//查询全部种类
public List<Commodity_small> selectC();

//查询全部试用人群
public List<Abapt> selectA();

//查询最新添加的商品
public int selectNewId();

//添加使用人群多读多
public int insertAbapt(int abaptId, int commId);

}
