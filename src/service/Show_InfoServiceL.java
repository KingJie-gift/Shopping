package service;

import dao.Show_InfoDaoL;
import entity.Show_info;

import java.util.List;

public class Show_InfoServiceL {
    public List<Show_info> getShow_infoById(int id) {
        return new Show_InfoDaoL().getShow_infoById(id);
    }
}
