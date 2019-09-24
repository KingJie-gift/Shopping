package dao;

import dao.impl.Commodity_infoDaoImplL;
import dao.impl.Commodity_smallDaoImplL;
import entity.Abapt;
import entity.Brand;
import entity.Commodity;
import entity.Commodity_info;
import entity.Commodity_small;
import entity.Show_info;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Commodity_infoDaoL extends BaseDaoL implements Commodity_infoDaoImplL {
    @Override
    public List<Commodity_info> getIndexTime() {
        this.executeQuery("SELECT commodity_info_id,commodity_num, commodity_info_name,commodity_info_money,commodity_info_Jmoney FROM `commodity_info` ORDER BY commodity_num DESC LIMIT 8",null);
        return getList();
    }

    @Override
    public List<Commodity_info> getRecommend() {
        this.executeQuery("SELECT commodity_info_id,commodity_num, commodity_info_name,commodity_info_money,commodity_info_Jmoney FROM `commodity_info` ORDER BY commodity_num LIMIT 30",null);
        return getList();
    }

    @Override
    public List<Commodity_info> getByLimit(int indexPage, int row,int type,int small) {

        String sql = "";
        if(type==1){
            if(small==-1){
                sql = "SELECT * FROM `commodity_info`  ORDER BY  commodity_num DESC LIMIT ? ,?";
            }else {
                sql = "SELECT * FROM `commodity_info` WHERE commodity_small_id =? ORDER BY  commodity_num DESC LIMIT ? ,?";
            }
        }else if(type==2){
            if(small==-1){
                sql = "SELECT * FROM `commodity_info`  ORDER BY  commodity_num DESC LIMIT ? ,?";
            }else {
                sql = "SELECT * FROM `commodity_info` WHERE commodity_small_id =? ORDER BY  commodity_info_money LIMIT ?,?";
            }
        }else if(type==3){
            if(small==-1){
                sql = "SELECT * FROM `commodity_info`  ORDER BY  commodity_num DESC LIMIT ? ,?";
            }else {
                sql = "SELECT * FROM `commodity_info` WHERE commodity_small_id =? ORDER BY  commodity_millbrand_id LIMIT ?,?";
            }
        }
        System.out.println(sql);
        this.executeQuery(sql,new Object[]{small,indexPage,row});
        return getList();
    }

    @Override
    public int sumCountAll() {
        this.executeQuery("SELECT COUNT(*) FROM commodity_info",null);
        int count = 0 ;
        try {
            while (rs.next()){
               count = rs.getInt(1);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return count;
    }

    @Override
    public List<Commodity_info> dayShow() {
        this.executeQuery("SELECT * FROM `commodity_info` ORDER BY  commodity_num LIMIT 3",null);
        return getList();
    }

    @Override
    public Commodity_info commById(int id) {
        this.executeQuery("SELECT * FROM commodity_info WHERE commodity_info_id = ?",new Object[]{id});
        Commodity_info comm = null;
        try{
            while (rs.next()){
                comm = new Commodity_info();
                comm.setCommodity_info_id(rs.getInt("commodity_info_id"));
                comm.setCommodity_info_name(rs.getString("commodity_info_name"));
                comm.setCommodity_info_money(rs.getInt("commodity_info_money"));
                comm.setCommodity_info_Jmoney(rs.getInt("commodity_info_Jmoney"));
                comm.setCommodity_show(rs.getString("commodity_show"));
                comm.setCommodity_num(rs.getString("commodity_num"));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return comm;
    }

    @Override
    public List<Integer> getComm() {
        this.executeQuery("SELECT commodity_millbrand_id  FROM commodity_info GROUP BY `commodity_millbrand_id` ORDER BY COUNT(commodity_millbrand_id) DESC LIMIT 3",null);
        List<Integer> list = new ArrayList<Integer>();
        try {
            while (rs.next()){
                list.add(rs.getInt("commodity_millbrand_id"));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    private List<Commodity_info> getList() {
        List<Commodity_info> list = new ArrayList<Commodity_info>();
        try {
            while (rs.next()){
                Commodity_info commodity_info = new Commodity_info();
                commodity_info.setCommodity_info_id(rs.getInt("commodity_info_id"));
                commodity_info.setCommodity_info_name(rs.getString("commodity_info_name"));
                commodity_info.setCommodity_info_money(rs.getInt("commodity_info_money"));
                commodity_info.setCommodity_info_Jmoney(rs.getInt("commodity_info_Jmoney"));
                commodity_info.setCommodity_num(rs.getString("commodity_num"));
                list.add(commodity_info);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

	@Override
	public List<Commodity_info> selectAll(int indexPage, int row, int id) {
		List<Commodity_info> list=new ArrayList<Commodity_info>();
		String sql="SELECT * FROM `commodity_info` WHERE commodity_millbrand_id=? limit ?,?";
		Object[] param={id,(indexPage-1)*row,row};
		executeQuery(sql, param);
		try {
			while(rs.next()){
				Commodity_info c=new Commodity_info();
				c.setCommodity_info_id(rs.getInt("commodity_info_id"));
				c.setCommodity_info_name(rs.getString("commodity_info_name"));
				c.setCommodity_info_money(rs.getDouble("commodity_info_money"));
				c.setCommodity_num(rs.getString("commodity_num"));
				c.setCommodity_millyield(rs.getDate("commodity_millyield"));
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
	public List<Commodity_info> selAll(int indexPage, int row, int id) {
		List<Commodity_info> list=new ArrayList<Commodity_info>();
		String sql="SELECT * FROM commodity_info WHERE commodity_millbrand_id NOT IN (SELECT Brand_id FROM brand WHERE Commod_id = 1)AND commodity_small_id IN (SELECT commodity_small_id FROM `commodity_small` WHERE commodity_id = ?) limit ?,?";
		Object[] param={id,id,(indexPage-1)*row,row};
		executeQuery(sql, param);
		try {
			while(rs.next()){
				Commodity_info c=new Commodity_info();
				c.setCommodity_info_id(rs.getInt("commodity_info_id"));
				c.setCommodity_info_name(rs.getString("commodity_info_name"));
				c.setCommodity_info_money(rs.getDouble("commodity_info_money"));
				c.setCommodity_num(rs.getString("commodity_num"));
				c.setCommodity_millyield(rs.getDate("commodity_millyield"));
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
	public int selectCount(int id) {
		int count=0;
		String sql="SELECT COUNT(*) FROM `commodity_info` WHERE commodity_millbrand_id=?";
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
	public int delShowInfo(int id) {
		String sql="DELETE FROM `show_info` WHERE Show_info_cid=?";
		Object[] param={id};
		return executeUpdate(sql, param);
	}

	@Override
	public int delCommodity(int id) {
		String sql="DELETE FROM `commodity_info` WHERE commodity_info_id=?";
		Object[] param={id};
		return executeUpdate(sql, param);
	}

	@Override
	public Commodity_info selFindId(int id) {
		this.executeQuery("SELECT * FROM commodity_info WHERE commodity_info_id = ?",new Object[]{id});
        Commodity_info comm = null;
        try{
            while (rs.next()){
                comm = new Commodity_info();
                comm.setCommodity_info_id(rs.getInt("commodity_info_id"));
                comm.setCommodity_info_name(rs.getString("commodity_info_name"));
                comm.setCommodity_info_money(rs.getInt("commodity_info_money"));
                comm.setCommodity_info_Jmoney(rs.getInt("commodity_info_Jmoney"));
                comm.setCommodity_info_KG(rs.getString("commodity_info_KG"));
                comm.setCommodity_show(rs.getString("commodity_show"));
                comm.setCommodity_num(rs.getString("commodity_num"));
                comm.setCommodity_milladdress(rs.getString("commodity_milladdress"));
                comm.setCommodity_millname(rs.getString("commodity_millname"));
                comm.setCommodity_millphone(rs.getString("commodity_millphone"));
                comm.setCommodity_millelement(rs.getString("commodity_millelement"));
                comm.setCommodity_millstock(rs.getString("commodity_millstock"));
                comm.setCommodity_milldate(rs.getInt("commodity_milldate"));
                comm.setCommodity_millyield(rs.getDate("commodity_millyield"));
                comm.setCommodity_milltype(rs.getString("commodity_milltype"));  
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return comm;
	}

	public int update(Commodity_info comm){
		String sql="update `commodity_info` set commodity_info_name=?,commodity_info_money=?,commodity_info_Jmoney=?,commodity_info_KG=?,commodity_show=?,commodity_num=?,commodity_millyield=? where commodity_info_id=?";
		Object[] param={comm.getCommodity_info_name(),comm.getCommodity_info_money(),comm.getCommodity_info_Jmoney(),comm.getCommodity_info_KG(),comm.getCommodity_show(),comm.getCommodity_num(),comm.getCommodity_millyield(),comm.getCommodity_info_id()};
		return executeUpdate(sql, param);
	}

	
	
	@Override
	public Show_info selectShow(int id) {
		Show_info show=null;
		String sql="SELECT Show_info_id,Show_info_url FROM `show_info` WHERE Show_info_cid=?";
		Object[] param={id};
		executeQuery(sql, param);
		try {
			if(rs.next()){
				show=new Show_info();
				show.setShow_info_id(rs.getInt("show_info_id"));
				show.setShow_info_url(rs.getString("show_info_url"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return show;
	}

	
	@Override
	public int deleteShow(int id) {
		String sql="DELETE FROM `show_info` WHERE Show_info_id=?";
		Object[] param={id};
		return executeUpdate(sql, param);
	}

	@Override
	public String selectUrl(int id) {
		String url=null;
		String sql="SELECT Show_info_url FROM `show_info` WHERE Show_info_cid=?";
		Object[] param={id};
		executeQuery(sql, param);
		try {
			if(rs.next()){
				url=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return url;
	}

	@Override
	public Commodity_info selectId(int id) {
		 Commodity_info comm = null;
		 String sql="SELECT * FROM `commodity_info` WHERE commodity_info_id=?";
		 Object[] param={id};
		 executeQuery(sql, param);
	            try {
					while (rs.next()){
					    comm = new Commodity_info();
					    comm.setCommodity_info_id(rs.getInt("commodity_info_id"));
					    comm.setCommodity_info_name(rs.getString("commodity_info_name"));
					    comm.setCommodity_info_money(rs.getInt("commodity_info_money"));
					    comm.setCommodity_info_Jmoney(rs.getInt("commodity_info_Jmoney"));
					    comm.setCommodity_info_KG(rs.getString("commodity_info_KG"));
					    comm.setCommodity_show(rs.getString("commodity_show"));
					    comm.setCommodity_num(rs.getString("commodity_num"));
					    comm.setCommodity_millyield(rs.getDate("commodity_millyield"));
					  }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					closeAll();
				}
	        
	        return comm;
	}

	@Override
	public int insert(Commodity_info comm) {
		String sql="INSERT `commodity_info` (commodity_info_id,commodity_info_name,commodity_info_money,commodity_info_Jmoney,commodity_info_KG,commodity_show,commodity_num,commodity_millyield,commodity_millbrand_id,commodity_small_id) VALUES(null,?,?,?,?,?,?,?,?,?)";
		Object[] param={comm.getCommodity_info_name(),comm.getCommodity_info_money(),comm.getCommodity_info_Jmoney(),comm.getCommodity_info_KG(),comm.getCommodity_show(),comm.getCommodity_num(),comm.getCommodity_millyield(),comm.getBrand().getBrand_id(),comm.getCommodity_small().getCommodity_small_id()};
		return executeUpdate(sql, param);
	}

	@Override
	public List<Brand> selectB() {
		List<Brand> list=new ArrayList<Brand>();
		String sql="SELECT Brand_id,Brand_name FROM `brand`";
		executeQuery(sql, null);
		try {
			while(rs.next()){
				Brand b=new Brand();
				b.setBrand_id(rs.getInt(1));
				b.setBrand_name(rs.getString(2));
				list.add(b);
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
	public List<Commodity_small> selectC() {
		List<Commodity_small> list=new ArrayList<Commodity_small>();
		String sql="SELECT commodity_small_id,commodity_small_name FROM `commodity_small`";
		executeQuery(sql, null);
		try {
			while(rs.next()){
				Commodity_small c=new Commodity_small();
				c.setCommodity_small_id(rs.getInt(1));
				c.setCommodity_small_name(rs.getString(2));
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
	public List<Abapt> selectA() {
		List<Abapt> list=new ArrayList<Abapt>();
		String sql="SELECT abapt_id,abapt_name FROM `abapt`";
		executeQuery(sql, null);
		try {
			while(rs.next()){
				Abapt a=new Abapt();
				a.setAbapt_id(rs.getInt(1));
				a.setAbapt_name(rs.getString(2));
				list.add(a);
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
	public int selectNewId() {
		int count=0;
		String sql="SELECT commodity_info_id FROM `commodity_info` ORDER BY  commodity_info_id DESC LIMIT 1";
		executeQuery(sql, null);
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
	public int insertAbapt(int abaptId, int commId) {
		String sql="INSERT `abapt_commodity` VALUES(null,commodity_id=?,abapt_id=?)";
		Object[] param={commId,abaptId};
		return executeUpdate(sql, param);
	}

	

	

	

	

	

	
}
