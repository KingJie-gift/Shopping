package dao;

import dao.impl.AbaptDaoImplw;
import entity.Abapt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbaptDaow extends BaseDaow implements AbaptDaoImplw {

    @Override
    public List<Abapt> getListAb(int id) {
        List<Abapt> list = new ArrayList<>();
        this.executeQuery("SELECT * FROM abapt WHERE abapt_id IN (\n" +
                "\tSELECT abapt_id FROM abapt_commodity WHERE commodity_id = ?\n" +
                ")",new Object[]{id});
        try {
            while (rs.next()){
                Abapt abapt = new Abapt();
                abapt.setAbapt_id(rs.getInt("abapt_id"));
                abapt.setAbapt_name(rs.getString("abapt_name"));
                list.add(abapt);
            }
        }catch (SQLException sql) {
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public Abapt getAbapt(int id) {
        this.executeQuery("SELECT * FROM abapt WHERE abapt_id = ?",new Object[]{id});
        Abapt abapt = null;
        try {
            while (rs.next()){
                abapt = new Abapt();
                abapt.setAbapt_id(rs.getInt("abapt_id"));
                abapt.setAbapt_name(rs.getString("abapt_name"));
            }
        }catch (SQLException sql) {
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return abapt;
    }
}
