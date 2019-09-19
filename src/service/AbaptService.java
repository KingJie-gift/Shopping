package service;

import dao.AbaptDao;
import entity.Abapt;

import java.util.List;

public class AbaptService {
    public List<Abapt> getListAb(int id) {
        return new AbaptDao().getListAb(id);
    }
    public Abapt getAbapt(int id){
        return new AbaptDao().getAbapt(id);
    }
}
