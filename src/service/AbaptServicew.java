package service;

import dao.AbaptDaow;
import entity.Abapt;

import java.util.List;

public class AbaptServicew {
    public List<Abapt> getListAb(int id) {
        return new AbaptDaow().getListAb(id);
    }
    public Abapt getAbapt(int id){
        return new AbaptDaow().getAbapt(id);
    }
}
