package dao;

import dao.impl.CommodityDaoImpl;
import entity.Commodity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityDao extends BaseDao implements CommodityDaoImpl {

    @Override
    public List<Commodity> getListByAll() {
        this.executeQuery("SELECT * FROM `commodity`",null);
        List<Commodity> list = new ArrayList<>();
        try {
            while (rs.next()){
                Commodity comm = new Commodity(rs.getInt("commodity_id"),rs.getString("commodity_name"));
                list.add(comm);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public Commodity commById(int id) {
        Commodity comm = null;
        this.executeQuery("SELECT * FROM `commodity` WHERE commodity_id = ?",new Object[]{id});
        try {
            while (rs.next()){
                comm = new Commodity(rs.getInt("commodity_id"),rs.getString("commodity_name"));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return comm;
    }

    @Override
    public int commId() {
        this.executeQuery("SELECT commodity_id FROM commodity  WHERE commodity_name = '儿童奶粉'",null);
        int count = 0 ;
        try {
            while (rs.next()){
                count = rs.getInt(1);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return count;
    }
}
