package dao;

import dao.impl.Commodity_smallDaoImplL;
import entity.Commodity_small;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Commodity_smallDaoL extends BaseDaoL implements Commodity_smallDaoImplL {
    @Override
    public List<Commodity_small> commBySmall(int id) {
        this.executeQuery("SELECT * FROM `commodity_small` WHERE `commodity_id`=?",new Object[]{id});
        List<Commodity_small> list = new ArrayList<Commodity_small>();
        try {
            while (rs.next()){
                Commodity_small comm = new Commodity_small();
                comm.setCommodity_small_id(rs.getInt(1));
                comm.setCommodity_small_name(rs.getString(2));
                comm.setCommodity(new CommodityDaoL().commById(rs.getInt("commodity_id")));
                list.add(comm);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public int delSmall() {
        return this.executeUpdate("DELETE FROM `commodity_small` WHERE commodity_id = (\n" +
                "\n" +
                "\tSELECT commodity_id FROM `commodity` WHERE commodity_name = '儿童奶粉')",null);
    }



    @Override
    public int addSmall(String small, int id) {
        return this.executeUpdate("INSERT commodity_small VALUES(NULL,?,?)",new Object[]{small,id});
    }

	@Override
	public List<String> selectTong(String tong) {
		List<String> list=new ArrayList<String>();
		String sql="SELECT commodity_small_name FROM commodity_small WHERE commodity_small_id IN(SELECT commodity_small_id FROM `commodity_small` WHERE commodity_id IN (SELECT commodity_id FROM `commodity` WHERE commodity_name = ?))";
		Object[] param={tong};
		executeQuery(sql, param);
		try {
			while(rs.next()){
				list.set(0, rs.getString(1));
				list.set(1, rs.getString(2));
				list.set(2, rs.getString(3));
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
	public List<Commodity_small> selectComm() {
		List<Commodity_small> list=new ArrayList<Commodity_small>();
		String sql="SELECT commodity_small_id,commodity_small_name FROM `commodity_small`";
		executeQuery(sql, null);
		try {
			while(rs.next()){
				Commodity_small sm=new Commodity_small();
				sm.setCommodity_small_id(rs.getInt(1));
				sm.setCommodity_small_name(rs.getString(2));
				list.add(sm);
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
	public int getaddzl(Commodity_small sm) {
        String sql="INSERT `commodity_small` VALUES(null,?,?)";
        Object[] param={sm.getCommodity_small_name(),sm.getCommodity().getCommodity_id()};
		return executeUpdate(sql, param);
	}

	@Override
	public int getDelete(int id) {
		String sql="delete from commodity_small where commodity_small_id=?";
		Object[] param={id};
		return executeUpdate(sql, param);
	}

	@Override
	public int getdel(int id) {
		String sql="DELETE FROM commodity_info WHERE commodity_small_id=?";
		Object[] param={id};
		return executeUpdate(sql, param);
	}
}
