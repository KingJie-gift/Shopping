package util;

import dao.BaseDao;
import dao.BrandDao;
import dao.CommodityDao;
import dao.Commodity_smallDao;
import entity.*;
import org.omg.CORBA.INTERNAL;
import service.Commodity_infoService;
import service.Show_InfoDaoService;
import servlet.Commodity_infoServlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Text extends BaseDao {
    public static void main(String[] args) {

//        *
//        *
//
//        Text text = new Text();
//        List<Integer> list  = text.getIntegers();
//        for(Integer integer:list){
//            text.retDel(integer);
//        }
//        List<Integer> list = text.getAll();
//        Random random = new Random();
//
//        for(Integer integer : list){
//            text.addUpdate(random.nextInt(9+1),integer);
//        }

//        List<Brand> brands = brandDao.listBrand();
//        System.out.println(brands.size());
//        for (Brand b:brands) {
//            System.out.println(b.getBrand_name());
//
//        }


//        Text text = new Text();

//        List<Integer> list = text.getAll();
//        for(Integer in:list){
//            text.addApapt(in,1);
//            text.addApapt(in,2);
//            text.addApapt(in,3);
//        }
    }


//    添加数据
    public int addApapt(int comm , int apt){
        return this.executeUpdate("INSERT INTO abapt_commodity VALUES(NULL,?,?)",new Object[]{comm,apt});
    }

    //获取所以商品的编号
    public List<Integer> getAll(){
        this.executeQuery("SELECT commodity_info_id FROM commodity_info",null);
        List<Integer> list = new ArrayList<>();
        try {
            while (rs.next()){
                list.add(rs.getInt(1));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    private List<Integer> getIntegers() {
        List<Integer> list = new ArrayList<>();
        this.executeQuery("(SELECT commodity_info_id FROM commodity_info \n" +
                "LEFT JOIN show_info " +
                "ON commodity_info.`commodity_info_id` = show_info.`Show_info_cid`\n" +
                "WHERE show_info_id IS NULL)",null);
        try {
            while (rs.next()){
                list.add(rs.getInt(1));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    //    查找图片表对于为空的表
    public List<Integer> delImage(){
        return getIntegers();
    }

//    删除数据
    public int retDel(int id){
        return this.executeUpdate("DELETE FROM commodity_info WHERE commodity_info_id = ?",new Object[]{id});
    }
//    start执行
    public void yesDel(){
        Text text = new Text();
        List<Integer> del = text.delImage();
        for (Integer in : del){
//            删除数据
            System.out.println(text.retDel(in));
        }
    }
//    随机数进行增加数据
    public int addUpdate(int id , int row){
        return this.executeUpdate("update commodity_info SET commodity_millbrand_id = ? WHERE commodity_info_id = ?",new Object[]{id,row});
    }
}
