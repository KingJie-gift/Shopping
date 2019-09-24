package dao;

import java.sql.SQLException;

import dao.impl.BuyShowImplL;

public class BuyShowDaoL extends BaseDaoL implements BuyShowImplL{

	@Override
	public int selectBuyShow(int id) {
		int count=0;
		String sql="SELECT buyshow_id FROM `buyshow` WHERE buyshow_commodity_id=?";
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

	@Override
	public int delBuyShow(int id) {
		return this.executeUpdate("DELETE FROM buyshow WHERE buyshow_id = ?",new Object[]{id});
	}

	
}
