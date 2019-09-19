package service;

import dao.Show_InfoDao;
import entity.Show_info;

import java.util.List;

public class Show_InfoDaoService  {
    public Show_info listByIdImage(int id) {
        return new Show_InfoDao().listByIdImage(id);
    }
}
