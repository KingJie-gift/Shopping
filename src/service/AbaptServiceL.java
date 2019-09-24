package service;

import dao.AbaptDaoL;
import entity.Abapt;

import java.util.List;

public class AbaptServiceL {
    public List<Abapt> getListAb(int id) {
        return new AbaptDaoL().getListAb(id);
    }
}
