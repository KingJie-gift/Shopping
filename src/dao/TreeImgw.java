package dao;

import entity.TreeImg;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreeImgw extends BaseDaow {
    public List<TreeImg> count(){
        List<TreeImg> list = new ArrayList<>();
        list.add(new TreeImg("未发货",countSql("SELECT COUNT(*) FROM buy WHERE Bug_type = 0")));
        list.add(new TreeImg("发货",countSql("SELECT COUNT(*) FROM buy WHERE Bug_type = 1")));
        list.add(new TreeImg("派送中",countSql("SELECT COUNT(*) FROM buy WHERE Bug_type = 2")));
        list.add(new TreeImg("未签收",countSql("SELECT COUNT(*) FROM buy WHERE Bug_type = 3")));
        list.add(new TreeImg("签收",countSql("SELECT COUNT(*) FROM buy WHERE Bug_type = 4")));
        return list;
    }
//    执行sql语句
    public int countSql(String sql){
        int count = 0 ;
        this.executeQuery(sql,null);
        try {
            while (rs.next()){
                count = rs.getInt(1);
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }finally {
            this.closeAll();
        }
        return count;
    }
}
