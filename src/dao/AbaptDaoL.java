package dao;

import dao.impl.AbaptDaoImplL;
import entity.Abapt;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbaptDaoL extends BaseDaoL implements AbaptDaoImplL {

    @Override
    public List<Abapt> getListAb(int id) {
        List<Abapt> list = new ArrayList<Abapt>();
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
