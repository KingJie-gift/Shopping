package dao;

import dao.impl.Commodity_smallDaoImplw;
import entity.Commodity_small;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Commodity_smallDaow extends BaseDaow implements Commodity_smallDaoImplw {
    @Override
    public List<Commodity_small> commBySmall(int id) {
        this.executeQuery("SELECT * FROM `commodity_small` WHERE `commodity_id`=?",new Object[]{id});
        List<Commodity_small> list = new ArrayList<>();
        try {
            while (rs.next()){
                Commodity_small comm = new Commodity_small(rs.getInt("commodity_small_id"),rs.getString("commodity_small_name"),new CommodityDaow().commById(rs.getInt("commodity_id")));
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
    public int delSmall() {
        return this.executeUpdate("DELETE FROM `commodity_small` WHERE commodity_id = (\n" +
                "\n" +
                "\tSELECT commodity_id FROM `commodity` WHERE commodity_name = '儿童奶粉')",null);
    }



    @Override
    public int addSmall(String small, int id) {
        return this.executeUpdate("update commodity_small VALUES(NULL,?,?)",new Object[]{small,id});
    }

    @Override
    public List<Integer> commByNum() {
        List<Integer> list = new ArrayList<>();
        this.executeQuery("SELECT commodity_small_id FROM commodity_small WHERE commodity_id = 1",null);
        try {
            while (rs.next()){
                list.add(rs.getInt("commodity_small_id"));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public int addCommBy(String id, int row) {
        return this.executeUpdate("UPDATE commodity_small SET  commodity_small_name = ? WHERE commodity_small_id = ?",new Object[]{id,row});
    }
}
