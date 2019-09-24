package dao.impl;

import entity.Collect;

import java.util.List;

public interface CollectDaoImplL {
//    添加信息
    public int addCollect(Collect collect);
//    查找信息
    public Collect coll(int id, int commId);

//    删除收藏信息
    public int delColl(int id);
    
  //查询收藏表商品对应收藏记录
  	public int selectCollectId(int id);
  	

}
