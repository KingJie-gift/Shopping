package service;

import dao.Show_InfoDaoL;
import entity.Show_info;

import java.util.List;

public class Show_InfoDaoServiceL  {
    public Show_info listByIdImage(int id) {
        return new Show_InfoDaoL().listByIdImage(id);
    }
    public int delShowInfo(int id) {
    	return new Show_InfoDaoL().delShow_info(id);
    }
}
