package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDaow {

	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public void getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeAll(){
		try {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void executeQuery(String sql,Object[] param){
		getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i+1, param[i]);
				}
			}
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int executeUpdate(String sql,Object[] param){
		int count=0;
		getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i+1, param[i]);
				}
			}
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return count;
	}

	public static void main(String[] args) {
		BaseDaow baseDao = new BaseDaow();
		baseDao.getConnection();
		System.out.println(baseDao.conn);
	}
}
