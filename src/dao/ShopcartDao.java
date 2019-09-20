package dao;

import dao.impl.ShopcartDaoImpl;
import entity.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopcartDao extends BaseDao implements ShopcartDaoImpl {
    @Override
    public List<Shopcart> getShopcart(int id) {
        this.executeQuery("SELECT * FROM  `shopcart` WHERE Shopcart_enter_id = ?",new Object[]{id});
        List<Shopcart> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Shopcart shopcart = new Shopcart();
                getAll(shopcart);
                list.add(shopcart);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public int addShopcart(Shopcart shopcart) {
        return this.executeUpdate("INSERT INTO shopcart VALUES(NULL,?,?,?,?,DEFAULT)",new Object[]{
           shopcart.getEnter().getEnter_id(),shopcart.getCommodity().getCommodity_info_id(),shopcart.getShopcart_num(),shopcart.getAbapt().getAbapt_id()
        });
    }

    @Override
    public int delShopcart(int id) {
        return this.executeUpdate("DELETE FROM shopcart WHERE Shopcart_id = ?",new Object[]{id});
    }

    @Override
    public Shopcart shById(int id) {
        this.executeQuery("SELECT * FROM `shopcart` WHERE Shopcart_id = ?",new Object[]{id});
        Shopcart shopcart = null;
        try {
            while (rs.next()) {
                shopcart = new Shopcart();
                getAll(shopcart);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return shopcart;
    }

    private void getAll(Shopcart shopcart) throws SQLException {
        shopcart.setShopcart_id(rs.getInt("shopcart_id"));
        Enter enter = new Enter();
        enter.setEnter_id(rs.getInt("shopcart_enter_id"));
        shopcart.setEnter(enter);
        Commodity_info commodity_info = new Commodity_infoDao().commById(rs.getInt("Shopcart_ Bug _id"));
        shopcart.setCommodity(commodity_info);
        shopcart.setShopcart_num(rs.getInt("shopcart_num"));
        shopcart.setShopcart_date(rs.getDate("shopcart_date"));
        Abapt abapt = new AbaptDao().getAbapt(rs.getInt("Shopcart_abapt"));
        shopcart.setAbapt(abapt);
    }
}
