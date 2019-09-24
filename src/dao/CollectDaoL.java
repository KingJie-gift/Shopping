package dao;

import dao.impl.CollectDaoImplL;
import entity.Collect;
import entity.Commodity_info;
import entity.Enter;

import java.sql.SQLException;

public class CollectDaoL extends BaseDaoL implements CollectDaoImplL {
    @Override
    public int addCollect(Collect collect) {
        return this.executeUpdate("INSERT INTO collect VALUES(NULL,?,?)",new Object[]{collect.getEnter().getEnter_id(),collect.getCommodity().getCommodity_info_id()});
    }

    @Override
    public Collect coll(int id,int commId) {
        this.executeQuery("SELECT * FROM collect WHERE Collect_enter_id = ? AND Collect_commodity_info_id = ?",new Object[]{id,commId});
        Collect collect = null;
        try {
           while (rs.next()){
               collect = new Collect();
               collect.setCollect_id(rs.getInt("Collect_id"));
               Commodity_info commodity_info = new Commodity_infoDaoL().commById(rs.getInt("Collect_commodity_info_id"));
               collect.setCommodity(commodity_info);
               Enter enter = new Enter();
               enter.setEnter_id(rs.getInt("Collect_enter_id"));
               collect.setEnter(enter);
           }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return collect;
    }

    @Override
    public int delColl(int id) {
        return this.executeUpdate("DELETE FROM collect WHERE Collect_id = ?",new Object[]{id});
    }

	@Override
	public int selectCollectId(int id) {
		int count=0;
		String sql="SELECT Collect_id FROM `collect` WHERE Collect_commodity_info_id=?";
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
