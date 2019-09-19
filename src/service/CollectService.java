package service;

import dao.CollectDao;
import entity.Collect;

import java.util.List;

public class CollectService {
    public int addCollect(Collect collect) {
        return new CollectDao().addCollect(collect);
    }
    public Collect coll(int id,int commId) {
        return new CollectDao().coll(id,commId);
    }
    public int delColl(int id) {
        return new CollectDao().delColl(id);
    }
    public List<Collect> getEnterAllById(int id) {
        return new CollectDao().getEnterAllById(id);
    }
}
