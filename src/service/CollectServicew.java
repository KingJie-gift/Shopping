package service;

import dao.CollectDaow;
import entity.Collect;

import java.util.List;

public class CollectServicew {
    public int addCollect(Collect collect) {
        return new CollectDaow().addCollect(collect);
    }
    public Collect coll(int id,int commId) {
        return new CollectDaow().coll(id,commId);
    }
    public int delColl(int id) {
        return new CollectDaow().delColl(id);
    }
    public List<Collect> getEnterAllById(int id) {
        return new CollectDaow().getEnterAllById(id);
    }
}
