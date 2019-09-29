package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.impl.CommodityDaoImplZ;
import entity.Commodity;

public class CommodityDaoZ extends BaseDaoL implements CommodityDaoImplZ{

	@Override
	public List<Commodity> getqcAll() {
         List<Commodity> list=new ArrayList<Commodity>();
         String sql="SELECT * FROM `commodity`";
         executeQuery(sql, null);
         try {
			while (rs.next()) {
				Commodity c=new Commodity();
				c.setCommodity_id(rs.getInt(1));
				c.setCommodity_name(rs.getString(2));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}

	@Override
	public int CommodityAdd(Commodity comm) {
		String sql="INSERT INTO commodity VALUES(NULL,?)";
        Object[] para={comm.getCommodity_name()};
		return executeUpdate(sql, para);
	}

	@Override
	public int getcount(String name) {
		// TODO Auto-generated method stub
		int count=0;
		String  sql="SELECT COUNT(*) FROM `commodity` WHERE commodity_name=?";
		Object[] param={name};
		executeQuery(sql, param);
		try {
			if (rs.next()) {
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
	
	
	public Commodity getfone(int id) {
		Commodity c=null;
        String sql="SELECT * FROM `commodity` where commodity_id=?";
        Object[]para={id};
        executeQuery(sql, para);
        try {
			while (rs.next()) {
				c=new Commodity();
				c.setCommodity_id(rs.getInt(1));
				c.setCommodity_name(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return c;
	}
	@Override
	public int updateComm(Commodity comm) {
		// TODO Auto-generated method stub
		String sql="UPDATE commodity SET commodity_name=? WHERE commodity_id=?";
		Object[] param={comm.getCommodity_name(),comm.getCommodity_id()};
		return executeUpdate(sql, param);
	}
	
}
