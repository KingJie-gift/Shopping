package dao;

import dao.impl.CollectDaoImpl;
import entity.Collect;
import entity.Commodity_info;
import entity.Enter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectDao extends BaseDao implements CollectDaoImpl {
    @Override
    public int addCollect(Collect collect) {
        return this.executeUpdate("INSERT INTO collect VALUES(NULL,?,?,now())",new Object[]{collect.getEnter().getEnter_id(),collect.getCommodity().getCommodity_info_id()});
    }

    @Override
    public Collect coll(int id,int commId) {
        this.executeQuery("SELECT * FROM collect WHERE Collect_enter_id = ? AND Collect_commodity_info_id = ?",new Object[]{id,commId});
        Collect collect = null;
        try {
           while (rs.next()){
               collect = new Collect();
               getPublic(collect);
           }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return collect;
    }

    @Override
    public int delColl(int id) {
        return this.executeUpdate("DELETE FROM collect WHERE Collect_id = ?",new Object[]{id});
    }

    @Override
    public List<Collect> getEnterAllById(int id) {
        this.executeQuery("SELECT * FROM `collect` WHERE Collect_enter_id = ?",new Object[]{id});
        List<Collect> list = new ArrayList<>();
        try {
            while (rs.next()){
                Collect collect = new Collect();
                getPublic(collect);
                list.add(collect);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    private void getPublic(Collect collect) throws SQLException {
        collect.setCollect_id(rs.getInt("Collect_id"));
        Commodity_info commodity_info = new Commodity_infoDao().commById(rs.getInt("Collect_commodity_info_id"));
        collect.setCommodity(commodity_info);
        Enter enter = new Enter();
        enter.setEnter_id(rs.getInt("Collect_enter_id"));
        collect.setEnter(enter);
    }
}
