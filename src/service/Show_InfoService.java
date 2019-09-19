package service;

import dao.Show_InfoDao;
import entity.Show_info;

import java.util.List;

public class Show_InfoService {
    public List<Show_info> getShow_infoById(int id) {
        return new Show_InfoDao().getShow_infoById(id);
    }
    public Show_info listByIdImage(int id) {
        return new Show_InfoDao().listByIdImage(id);
    }
}
