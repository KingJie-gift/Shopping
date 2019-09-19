package dao.impl;

import entity.Collect;

import java.util.List;

public interface CollectDaoImpl {
//    添加信息
    public int addCollect(Collect collect);
//    查找信息
    public Collect coll(int id,int commId);

//    删除收藏信息
    public int delColl(int id);


//    显示收藏根据id进行查找这个用户的收藏
    public List<Collect> getEnterAllById(int id);

}
