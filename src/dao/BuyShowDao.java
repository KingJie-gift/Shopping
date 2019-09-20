package dao;

import dao.impl.BuyShowDaoImpl;
import entity.*;
import service.Commodity_infoService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyShowDao extends BaseDao implements BuyShowDaoImpl {

    @Override
    public int byShow(Buyshow buyshow) {
//        INSERT INTO buyShow VALUES(NULL,?,?,?,?,?,?)
        return this.executeUpdate("INSERT INTO buyshow VALUES(NULL,?,?,?,?,?,?)",new Object[]{
                buyshow.getBuy().getBuy_id(),buyshow.getCommodity().getCommodity_info_id(),buyshow.getBuyshow_count(),buyshow.getBuyshow_price(),buyshow.getAbapt_id().getAbapt_id(),buyshow.getSum_money()
        });
    }

    @Override
    public List<Buyshow> byShowInfo(int id) {
        this.executeQuery("SELECT * FROM  buyshow  WHERE buyshow_Bug_id IN(\n" +
                "\tSELECT Bug_id FROM  buy  WHERE Bug_enter_cid= ?\n" +
                " ORDER BY buyshow_id DESC )",new Object[]{id});
        List<Buyshow> buyshows = new ArrayList<>();
        try {
            while (rs.next()){
                Buyshow buyshow = new Buyshow();
                buyshow.setBuyshow_price(rs.getInt("sum_money"));
                Commodity_info commodity_info = new Commodity_infoService().commById(rs.getInt("buyshow_commodity _id"));
                buyshow.setCommodity(commodity_info);
                buyshow.setBuyshow_count(rs.getInt("buyshow_count"));
                Buy buy = new BuyDao().getListByAll(rs.getInt("buyshow_Bug_id"));
                Abapt abapt = new AbaptDao().getAbapt(rs.getInt("abapt_id"));
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
}
