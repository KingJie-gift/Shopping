package dao;

import dao.impl.CounselingDaoImplw;
import entity.Counseling;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CounselingDaow extends BaseDaow implements CounselingDaoImplw {

    public int getAllCount(){
        this.executeQuery("SELECT COUNT(*) FROM `counseling`",null);
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
    public Counseling getById(int id) {
        Counseling counseling = null;
        this.executeQuery("SELECT * FROM `counseling` where id = ?",new Object[]{id});
        try {
            while (rs.next()) {
                counseling = new Counseling();
                counseling.setId(rs.getInt("id"));
                counseling.setTitle(rs.getString("title"));
                counseling.setUrlImg(rs.getString("urlImg"));
                counseling.setDatetime(rs.getDate("datatime"));
                counseling.setContent(rs.getString("content"));
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            this.closeAll();
        }
        return counseling;
    }

    @Override
    public List<Counseling> getAllContent(int indexPage,int row) {
        this.executeQuery("SELECT * FROM `counseling` limit ?,?",new Object[]{indexPage,row});
        List<Counseling> list = new ArrayList<>();
        try {
            while (rs.next()){
                Counseling counseling = new Counseling();
                counseling.setId(rs.getInt("id"));
                counseling.setTitle(rs.getString("title"));
                counseling.setUrlImg(rs.getString("urlImg"));
                counseling.setDatetime(rs.getDate("datatime"));
                counseling.setContent(rs.getString("content"));
                list.add(counseling);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }
}
