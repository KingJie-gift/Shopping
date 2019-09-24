package dao;

import dao.impl.BuyDaoImplw;
import entity.Address;
import entity.Buy;

import java.sql.SQLException;

public class BuyDaow extends BaseDaow implements BuyDaoImplw {
    @Override
    public int addByComm(Buy buy) {
        return this.executeUpdate("INSERT INTO buy VALUES(NULL,?,?,0,NOW(),?)",new Object[]{buy.getEnter().getEnter_id(),buy.getBug_money(),buy.getAddress().getAddress_id()});
    }

    @Override
    public int selByShow() {
        int count = 0 ;
        this.executeQuery("SELECT * FROM buy ORDER BY bug_id DESC LIMIT 1",null);
        try {
            while (rs.next()){
                count = rs.getInt("Bug_id");
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return count;
    }

    @Override
    public Buy getListByAll(int id) {
        this.executeQuery("SELECT * FROM  buy  WHERE Bug_id= ?", new Object[]{id});
        Buy buy = null ;
        try {
            while (rs.next()){
                buy = new Buy();
                buy.setBug_money(rs.getDouble("Bug_money"));
                buy.setBuy_date(rs.getDate("Buy_date"));
                buy.setBug_type(rs.getInt("Bug_type"));
                buy.setBuy_id(rs.getInt("Bug_id"));
                Address address = new AddressDaow().getAddressBuyId(rs.getInt("buy_address_id"));
                buy.setAddress(address);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return buy;
    }
}
