package dao;

import dao.impl.Show_InfoDaoImplL;
import entity.Commodity;
import entity.Commodity_info;
import entity.Show_info;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Show_InfoDaoL extends BaseDaoL implements Show_InfoDaoImplL {
    @Override
    public Show_info listByIdImage(int id) {
        this.executeQuery("SELECT * FROM`show_info` WHERE `Show_info_cid` = ? LIMIT 1 ",new Object[]{id});
        Show_info image = null;
        try {
            while (rs.next()){
                image = new Show_info();
                image.setShow_info_id(rs.getInt("Show_info_id"));
                Commodity_info commodity_info = new Commodity_info();
                commodity_info.setCommodity_info_id(rs.getInt("Show_info_cid"));
                image.setCommodity(commodity_info);
                image.setShow_info_url(rs.getString("Show_info_url"));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return image;
    }

    @Override
    public List<Show_info> getShow_infoById(int id) {
        this.executeQuery("SELECT * FROM show_info WHERE Show_info_cid = ?",new Object[]{id});
        List<Show_info> list = new ArrayList<Show_info>();
        try {
            while (rs.next()){
                Show_info image = new Show_info();
                image.setShow_info_id(rs.getInt("Show_info_id"));
                Commodity_info commodity_info = new Commodity_info();
                commodity_info.setCommodity_info_id(rs.getInt("Show_info_cid"));
                image.setCommodity(commodity_info);
                image.setShow_info_url(rs.getString("Show_info_url"));
                list.add(image);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

	@Override
	public int selectShow_infoId(int id) {
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
	public int delShow_info(int id) {
		return this.executeUpdate("DELETE FROM buyshow WHERE buyshow_id = ?",new Object[]{id});
	}

	public int delImg(int id){
        return this.executeUpdate("DELETE FROM show_info WHERE Show_info_id = ?",new Object[]{id});
    }

    @Override
    public Show_info getIdImg(int id) {
        this.executeQuery("SELECT * FROM show_info WHERE Show_info_cid = ? ORDER BY Show_info_id DESC limit 1",new Object[]{id});
        Show_info image = null;
        try {
            while (rs.next()){
                image = new Show_info();
                image.setShow_info_id(rs.getInt("Show_info_id"));
                Commodity_info commodity_info = new Commodity_info();
                commodity_info.setCommodity_info_id(rs.getInt("Show_info_cid"));
                image.setCommodity(commodity_info);
                image.setShow_info_url(rs.getString("Show_info_url"));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return image;
    }

    @Override
    public int insert(Show_info show_info) {
        return this.executeUpdate("INSERT INTO show_info VALUES(NULL,?,?)",new Object[]{show_info.getCommodity().getCommodity_info_id(),show_info.getShow_info_url()});
    }


}
