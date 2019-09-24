package service;

import dao.Show_InfoDaow;
import entity.Show_info;

public class Show_InfoDaoServicew {
    public Show_info listByIdImage(int id) {
        return new Show_InfoDaow().listByIdImage(id);
    }
}
