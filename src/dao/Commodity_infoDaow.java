package dao;

import dao.impl.Commodity_infoDaoImplw;
import entity.Commodity_info;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Commodity_infoDaow extends BaseDaow implements Commodity_infoDaoImplw {
    @Override
    public List<Commodity_info> getIndexTime() {
        this.executeQuery("SELECT commodity_info_id,commodity_num, commodity_info_name,commodity_info_money,commodity_info_Jmoney FROM `commodity_info` ORDER BY commodity_num DESC LIMIT 8", null);
        return getList();
    }

    @Override
    public List<Commodity_info> getRecommend() {
        this.executeQuery("SELECT commodity_info_id,commodity_num, commodity_info_name,commodity_info_money,commodity_info_Jmoney FROM `commodity_info` ORDER BY commodity_num LIMIT 30", null);
        return getList();
    }

    @Override
    public List<Commodity_info> getByLimit(int indexPage, int row, int type, int comm, String like,int prent_id,int commType,int day) {
        String sql = "";
        if(comm!=-1){
            sql = "SELECT * FROM `commodity_info` WHERE commodity_small_id ="+comm+" ORDER BY  commodity_num DESC LIMIT ? ,?";
        }
        if(prent_id!=-1){
            sql = "SELECT * FROM commodity_info WHERE commodity_small_id IN (\n" +
                    "SELECT commodity_small_id FROM `commodity_small` WHERE commodity_id IN (\n" +
                    "\tSELECT commodity_id FROM `commodity` WHERE commodity_id = "+prent_id+")\n" +
                    "\t) ORDER BY  commodity_num DESC LIMIT ? ,?";
        }

        if(like!="-1"){
            if(commType==1){
                String add = name(like);
                sql = "SELECT * FROM commodity_info WHERE " + add +" ORDER BY  commodity_num DESC LIMIT ? ,?";
            }else if(commType==2) {
                String add = brend(like);
                sql = "SELECT * FROM commodity_info WHERE  commodity_millbrand_id IN (\n" +
                        "\tSELECT Brand_id FROM `brand` WHERE "+add+"\n" +
                        ") ORDER BY  commodity_num DESC LIMIT ? ,?";
            }
        }

        if(type!=-1){
            if(type==1){
                sql = "SELECT * FROM commodity_info ORDER BY commodity_num DESC LIMIT ?,?";
            }else if(type==2){
                sql = "SELECT * FROM commodity_info ORDER BY commodity_info_money LIMIT ?,?";
            }else if(type==3){
                sql = "SELECT * FROM commodity_info ORDER BY commodity_millyield DESC  LIMIT ?,?";
            }
        }
        if(day!=-1){
            sql = "SELECT * FROM commodity_info WHERE commodity_day = 1 LIMIT ?,?";
        }
        System.out.println(sql);
//        String sql = "";
//        if (type == 1) {
//            if (comm == -1) {
//                if (like != "-1") {
//                    sql = "SELECT * FROM commodity_info WHERE  commodity_info_name LIKE '%" + like + "%' ORDER BY  commodity_num DESC LIMIT ? ,?";
//                } else {
//                    sql = "SELECT * FROM `commodity_info`  ORDER BY  commodity_num DESC LIMIT ? ,?";
//                }
//            } else {
//                if (like != "-1") {
//                    sql = "SELECT * FROM commodity_info WHERE  commodity_info_name LIKE '%" + like + "%' ORDER BY  commodity_num DESC LIMIT ? ,?";
//                } else {
//                    sql = "SELECT * FROM `commodity_info` WHERE commodity_small_id =" + comm + " ORDER BY  commodity_num DESC LIMIT ? ,?";
//                }
//
//            }
//        } else if (type == 2) {
//            if (comm == -1) {
//                if (like != "-1") {
//                    sql = "SELECT * FROM commodity_info WHERE  commodity_info_name LIKE '%" + like + "%' ORDER BY  commodity_num DESC LIMIT ? ,?";
//                }else {
//                    sql = "SELECT * FROM `commodity_info`  ORDER BY  commodity_num DESC LIMIT ? ,?";
//                }
//            } else {
//                if (like != "-1") {
//                    sql = "SELECT * FROM commodity_info WHERE  commodity_info_name LIKE '%" + like + "% ORDER BY  commodity_info_money LIMIT ?,?";
//                } else {
//                    sql = "SELECT * FROM `commodity_info` WHERE commodity_small_id =" + comm + " ORDER BY  commodity_info_money LIMIT ?,?";
//                }
//            }
//        } else if (type == 3) {
//            if (comm == -1) {
//                if (like != "-1") {
//                    sql = "SELECT * FROM commodity_info WHERE  commodity_info_name LIKE '%" + like + "%' ORDER BY  commodity_num DESC LIMIT ? ,?";
//                }else {
//                    sql = "SELECT * FROM `commodity_info`  ORDER BY  commodity_num DESC LIMIT ? ,?";
//                }
//            } else {
//                if (like != "-1") {
//                    sql = "SELECT * FROM commodity_info WHERE  commodity_info_name LIKE '%" + like + "%' ORDER BY  commodity_millbrand_id LIMIT ?,?";
//                } else {
//                    sql = "SELECT * FROM `commodity_info` WHERE commodity_small_id =" + comm + " ORDER BY  commodity_millbrand_id LIMIT ?,?";
//                }
//
//            }
//        }
        System.out.println(sql);
        this.executeQuery(sql, new Object[]{indexPage, row});
        return getList();
    }

    private String name(String like) {
        String [] or =  like.split(" ");
        String add = "";
        for (int i = 0 ; i < or.length ; i ++ ){
            if((i+1)<or.length){
                add += "commodity_info_name LIKE '%" + or[i] + "%'  or " ;
            }else {
                add += " commodity_info_name LIKE '%" + or[i] + "%' ";
            }
        }
        System.out.println(add);
        return add;
    }

    private String brend(String like) {
        String [] or =  like.split(" ");
        String add = "";
        for (int i = 0 ; i < or.length ; i ++ ){
            if((i+1)<or.length){
                add += " Brand_name LIKE '%"+ or[i] +"%'  or " ;
            }else {
                add += " Brand_name LIKE '%"+ or[i] +"%'  ";
            }
        }
        return add;
    }

    //id 根据类别进行查询
    @Override
    public int sumCountAll(int comm,int prent_id,String like,int commType,int type,int day) {

        String sql = "SELECT COUNT(*) FROM commodity_info";
        if(comm!=-1){
            sql = "SELECT COUNT(*) FROM commodity_info WHERE commodity_small_id = "+comm;
        }
        if(prent_id!=-1){
            sql = "SELECT count(*) FROM commodity_info WHERE commodity_small_id IN (\n" +
                    "SELECT commodity_small_id FROM `commodity_small` WHERE commodity_id IN (\n" +
                    "\tSELECT commodity_id FROM `commodity` WHERE commodity_id = "+prent_id+")\n" +
                    "\t)";
        }
        if(like!="-1"){
            if(commType==1){
                String add = name(like);
                sql = "SELECT count(*) FROM commodity_info WHERE " + add;
            }else if(commType==2) {
                String add = brend(like);
                sql = "SELECT COUNT(*) FROM commodity_info WHERE  commodity_millbrand_id IN (\n" +
                        "\tSELECT Brand_id FROM `brand` WHERE "+add+"\n" +
                        ")";
            }
        }

        if(type!=-1){
            if(type==1){
                sql = "SELECT count(*) FROM commodity_info ORDER BY commodity_num";
            }else if(type==2){
                sql = "SELECT count(*) FROM commodity_info ORDER BY commodity_info_money";
            }else if(type==3){
                sql = "SELECT count(*) FROM commodity_info ORDER BY commodity_millyield";
            }
        }
        if(day!=-1){
            sql = "SELECT COUNT(*) FROM commodity_info WHERE commodity_day = 1";
        }

        System.out.println(sql);
        this.executeQuery(sql,null);
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException exe) {
            exe.printStackTrace();
        } finally {
            this.closeAll();
        }
        return count;
    }

    @Override
    public List<Commodity_info> dayShow() {
        this.executeQuery("SELECT * FROM commodity_info WHERE commodity_tomorrow = 1 ORDER BY commodity_num DESC LIMIT 3 ", null);
        return getList();
    }

    @Override
    public Commodity_info commById(int id) {
        this.executeQuery("SELECT * FROM commodity_info WHERE commodity_info_id = ?", new Object[]{id});
        Commodity_info comm = null;
        try {
            while (rs.next()) {
                comm = new Commodity_info();
                comm.setCommodity_info_id(rs.getInt("commodity_info_id"));
                comm.setCommodity_info_name(rs.getString("commodity_info_name"));
                comm.setCommodity_info_money(rs.getInt("commodity_info_money"));
                comm.setCommodity_info_Jmoney(rs.getInt("commodity_info_Jmoney"));
                comm.setCommodity_show(rs.getString("commodity_show"));
                comm.setCommodity_num(rs.getString("commodity_num"));
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            this.closeAll();
        }
        return comm;
    }

    @Override
    public List<Integer> getComm() {
        this.executeQuery("SELECT commodity_millbrand_id  FROM commodity_info GROUP BY `commodity_millbrand_id` ORDER BY COUNT(commodity_millbrand_id) DESC LIMIT 3", null);
        List<Integer> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(rs.getInt("commodity_millbrand_id"));
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public List<Commodity_info> getListComm(String comm) {
        this.executeQuery("SELECT * FROM commodity_info WHERE commodity_small_id IN(\n" +
                "\tSELECT commodity_small_id FROM `commodity_small` WHERE commodity_id IN (\n" +
                "\t\tSELECT commodity_id FROM `commodity` WHERE commodity_name = ?\n" +
                "\t)\n" +
                ") LIMIT 5 ",new Object[]{comm});
        return this.getList();
    }

    @Override
    public List<Commodity_info> getTShopping(int id) {
        this.executeQuery("SELECT * FROM commodity_info WHERE commodity_small_id IN (\n" +
                "\tSELECT commodity_small_id FROM commodity_info WHERE commodity_info_id = ?\n" +
                ") AND commodity_info_id < "+id+" LIMIT 6",new Object[]{id});
        return this.getList();
    }

    @Override
    public int rowById(int id) {
        return this.executeUpdate("UPDATE commodity_info SET commodity_num=commodity_num+1  WHERE commodity_info_id= ?",new Object[]{id});
    }

    private List<Commodity_info> getList() {
        List<Commodity_info> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Commodity_info commodity_info = new Commodity_info();
                commodity_info.setCommodity_info_id(rs.getInt("commodity_info_id"));
                commodity_info.setCommodity_info_name(rs.getString("commodity_info_name"));
                commodity_info.setCommodity_info_money(rs.getInt("commodity_info_money"));
                commodity_info.setCommodity_info_Jmoney(rs.getInt("commodity_info_Jmoney"));
                commodity_info.setCommodity_num(rs.getString("commodity_num"));
                list.add(commodity_info);
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            this.closeAll();
        }
        return list;
    }
}
