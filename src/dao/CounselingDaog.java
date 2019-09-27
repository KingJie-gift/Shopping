package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.impl.CounselingDaoImplg;
import entity.Counseling;

public class CounselingDaog extends BaseDaog implements CounselingDaoImplg{
	public int getCount(){
		int count=0;
		String sql="select count(*) from counseling";
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
	
	public List<Counseling> getAll(int pageindex,int pageSize){
		List<Counseling> list=new ArrayList<Counseling>();
		String sql="select * from counseling limit ?,?";
		Object[] para={(pageindex-1)*pageSize,pageSize};
		executeQuery(sql, para);
		try {
			while(rs.next()){
				Counseling c=new Counseling();
				c.setId(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setDatetime(rs.getDate(3));
				c.setUrlImg(rs.getString(4));
				if(rs.getString(5).length()>50){
					c.setContent(rs.getString(5).substring(0,50)+"...");
				}else{
					c.setContent(rs.getString(5));
				}
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
		
	 public  int getAdd(Counseling c){
	    	String sql="INSERT INTO counseling VALUE(NULL,?,now(),?,?)";
	    	Object[] para={c.getTitle(),c.getUrlImg(),c.getContent()};
	    	return executeUpdate(sql, para);
	    }
	 @Override
		public int getDelete(int id) {
			String sql="DELETE FROM counseling WHERE id=?";
			Object[] para={id};
			return executeUpdate(sql, para);
		}

		@Override
		public Counseling getfone(int id) {
			Counseling c=null;
			String sql="SELECT * FROM counseling where id=?";
			Object[] para={id};
			executeQuery(sql, para);
			try {
				while(rs.next()){
					c=new Counseling();
					c.setId(rs.getInt("id"));
	                c.setTitle(rs.getString("title"));
	                c.setUrlImg(rs.getString("urlImg"));
	                c.setDatetime(rs.getDate("datatime"));
	                c.setContent(rs.getString("content"));
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
		public int getUpdate(Counseling c) {
			String sql="UPDATE counseling SET title=?,content=? WHERE id=?";
			Object[] para={c.getTitle(),c.getContent(),c.getId()};
			return executeUpdate(sql, para);
		}

}
