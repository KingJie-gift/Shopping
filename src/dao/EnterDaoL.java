package dao;

import java.sql.SQLException;

import dao.impl.EnterDaoImplL;
import entity.Enter;

public class EnterDaoL extends BaseDaoL implements EnterDaoImplL {

//	登入
	public Enter selectLogin(String enter_telephone, String enter_password){
		Enter e=null;
		String sql="SELECT * FROM `enter`WHERE enter_telephone=? AND enter_password=?";
		Object[] param={enter_telephone,enter_password};
		this.executeQuery(sql,param);
		try {
			if(rs.next()){
				e=new Enter();
				e.setEnter_id(rs.getInt("enter_id"));
				e.setEnter_name(rs.getString("enter_name"));
				e.setEnter_truename(rs.getString("enter_truename"));
				e.setEnter_password(rs.getString("enter_password"));
				e.setEnter_telephone(rs.getString("enter_telephone"));
				e.setEnter_card_id(rs.getString("enter_card_id"));
				e.setEnter_gender(rs.getString("enter_gender"));
				e.setEnter_url(rs.getString("enter_url"));
				e.setEnter_type(rs.getInt("enter_type"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			closeAll();
		}
		return e;
	}


// 用户注册
	public int addEnter(Enter enter){
		String sql = "INSERT INTO enter VALUES(NULL,?,?,?,?,?,?,DEFAULT,DEFAULT)";
		return this.executeUpdate(sql,new Object[]{enter.getEnter_name(),enter.getEnter_truename(),enter.getEnter_password(),enter.getEnter_telephone(),enter.getEnter_card_id(),enter.getEnter_gender()});
	}

	@Override
	public int pattPhone(String phone) {
		int count = 0 ;
		System.out.println(phone);
		this.executeQuery("SELECT COUNT(*) FROM enter WHERE enter_telephone = ?",new Object[]{phone});
		try{
			while (rs.next()) {
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
	public int codeId(String id) {
		int count = 0 ;
		this.executeQuery("SELECT COUNT(*) FROM enter WHERE enter_card_id = ?",new Object[]{id});
		try{
			while (rs.next()) {
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
	public int loginAdmin(String enter_name, String enter_password) {
		int count=0;
		String sql="SELECT COUNT(*) FROM `enter` WHERE enter_name=? AND enter_password=? AND enter_type=2";
		Object[] param={enter_name,enter_password};
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
