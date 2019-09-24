package service;

import dao.Show_InfoDaow;
import entity.Show_info;

import java.util.List;

public class Show_InfoServicew {
    public List<Show_info> getShow_infoById(int id) {
        return new Show_InfoDaow().getShow_infoById(id);
    }
    public Show_info listByIdImage(int id) {
        return new Show_InfoDaow().listByIdImage(id);
    }
}
