package dao;

import dao.BaseDaow;
import dao.impl.BackStatusDaoImpl;
import entity.*;
import service.Commodity_infoServicew;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BackStatusDao extends BaseDaow implements BackStatusDaoImpl {

    @Override
    public List<Buy> buyshows(int indexPage , int row , int type) {
        String sql = "SELECT * FROM buy WHERE 1=1 ";
        if(type != -1 ){
            sql += " and Bug_type = " +type +" ";
        }
        sql += " ORDER BY Bug_id DESC limit ?,? ";
        this.executeQuery(sql,new Object[]{indexPage,row});
        List<Buy> buyshows = new ArrayList<>();
        try {
            while (rs.next()){
                Buy buy = new Buy();
                buy.setBuy_id(rs.getInt("Bug_id"));
                buy.setBug_money(rs.getDouble("Bug_money"));
                buy.setBug_type(rs.getInt("Bug_type"));
                buy.setBuy_date(rs.getDate("Buy_date"));
                buy.setAddress(new AddressDaow().getAddressBuyId(rs.getInt("buy_address_id")));
                buyshows.add(buy);
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }finally {
            this.closeAll();
        }
        return buyshows;
    }

    public int sumPagexx(int type){
        int count = 0;
        String sql = "SELECT count(*) FROM buy WHERE 1=1 ";
        if(type != -1 ){
            sql += " and Bug_type =  "+type;
        }
        this.executeQuery(sql,null);
        try {
            while (rs.next()){
                count = rs.getInt(1);
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }finally {
            this.closeAll();
        }
        return count;
    }

    @Override
    public List<Buyshow> getBuyShowInfos(int id) {
        this.executeQuery("SELECT * FROM buyshow  WHERE buyshow_Bug_id  = ?",new Object[]{id});
        List<Buyshow> buyshows = new ArrayList<>();
        try {
            while (rs.next()){
                Buyshow buyshow = new Buyshow();
                buyshow.setBuyshow_price(rs.getInt("sum_money"));
                Commodity_info commodity_info = new Commodity_infoServicew().commById(rs.getInt("buyshow_commodity _id"));
                buyshow.setCommodity(commodity_info);
                buyshow.setBuyshow_count(rs.getInt("buyshow_count"));
                Buy buy = new BuyDaow().getListByAll(rs.getInt("buyshow_Bug_id"));
                Abapt abapt = new AbaptDaow().getAbapt(rs.getInt("abapt_id"));
                buyshow.setAbapt_id(abapt);
                buyshow.setBuy(buy);
                buyshows.add(buyshow);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return buyshows;
    }

    @Override
    public int updateBuyShowInfoxxx(int type, int id) {
        return this.executeUpdate("UPDATE buy SET Bug_type = ? WHERE Bug_id =?",new Object[]{type,id});
    }
}
