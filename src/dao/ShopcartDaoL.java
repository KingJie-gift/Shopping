package dao;

import dao.impl.ShopcartDaoImplL;
import entity.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopcartDaoL extends BaseDaoL implements ShopcartDaoImplL {
    @Override
    public List<Shopcart> getShopcart(int id) {
        this.executeQuery("SELECT * FROM  `shopcart` WHERE Shopcart_enter_id = ?",new Object[]{id});
        List<Shopcart> list = new ArrayList<Shopcart>();
        try {
            while (rs.next()) {
                Shopcart shopcart = new Shopcart();
                shopcart.setShopcart_id(rs.getInt("shopcart_id"));
                Enter enter = new Enter();
                enter.setEnter_id(rs.getInt("shopcart_enter_id"));
                shopcart.setEnter(enter);
                Commodity_info commodity_info = new Commodity_infoDaoL().commById(rs.getInt("Shopcart_ Bug _id"));
                shopcart.setCommodity(commodity_info);
                shopcart.setShopcart_num(rs.getInt("shopcart_num"));
                shopcart.setShopcart_date(rs.getDate("shopcart_date"));
                Abapt abapt = new AbaptDaoL().getAbapt(rs.getInt("Shopcart_abapt"));
                shopcart.setAbapt(abapt);
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
	public int selectShopcartId(int id) {
		int count=0;
		String sql="SELECT Shopcart_id FROM `shopcart` WHERE Shopcart_Bug_id=?";
		Object[] param={id};
		executeQuery(sql, param);
		try {
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return count;
	}
}
