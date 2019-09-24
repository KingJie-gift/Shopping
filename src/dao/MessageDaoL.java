package dao;

import java.sql.SQLException;

import dao.impl.MessageImplL;

public class MessageDaoL extends BaseDaoL implements MessageImplL{

	@Override
	public int selectMessageId(int id) {
		int count=0;
		String sql="SELECT Message_id FROM `message` WHERE Message_commodity_info_id=?";
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
	public int delMessage(int id) {
		return this.executeUpdate("DELETE FROM message WHERE Message_id = ?",new Object[]{id});
	}

}
