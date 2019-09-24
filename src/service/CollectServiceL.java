package service;

import dao.CollectDaoL;
import entity.Collect;

import java.util.List;

public class CollectServiceL {
    public int addCollect(Collect collect) {
        return new CollectDaoL().addCollect(collect);
    }
    public Collect coll(int id,int commId) {
        return new CollectDaoL().coll(id,commId);
    }
    public int delColl(int id) {
        return new CollectDaoL().delColl(id);
    }
    public int selectCollectId(int id) {
    	return new CollectDaoL().selectCollectId(id);
    }
}
