package dao;

import dao.impl.Show_InfoDaoImpl;
import entity.Commodity;
import entity.Commodity_info;
import entity.Show_info;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Show_InfoDao extends BaseDao implements Show_InfoDaoImpl {
    @Override
    public Show_info listByIdImage(int id) {
        this.executeQuery("SELECT * FROM`show_info` WHERE `Show_info_cid` = ? LIMIT 1 ",new Object[]{id});
        Show_info image = null;
        try {
            while (rs.next()){
                image = new Show_info();
                image.setShow_info_id(rs.getInt("Show_info_id"));
                Commodity_info commodity_info = new Commodity_info();
                commodity_info.setCommodity_info_id(rs.getInt("Show_info_cid"));
                image.setCommodity(commodity_info);
                image.setShow_info_url(rs.getString("Show_info_url"));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return image;
    }

    @Override
    public List<Show_info> getShow_infoById(int id) {
        this.executeQuery("SELECT * FROM show_info WHERE Show_info_cid = ?",new Object[]{id});
        List<Show_info> list = new ArrayList<>();
        try {
            while (rs.next()){
                Show_info image = new Show_info();
                image.setShow_info_id(rs.getInt("Show_info_id"));
                Commodity_info commodity_info = new Commodity_info();
                commodity_info.setCommodity_info_id(rs.getInt("Show_info_cid"));
                image.setCommodity(commodity_info);
                image.setShow_info_url(rs.getString("Show_info_url"));
                list.add(image);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }
}
