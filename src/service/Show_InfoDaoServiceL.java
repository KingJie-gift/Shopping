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
    public List<Show_info> getShow_infoById(int id){
        return new Show_InfoDaoL().getShow_infoById(id);
    }
    public int delImg(int id){
        return new Show_InfoDaoL().delImg(id);
    }
    public Show_info getIdImg(int id){
        return new Show_InfoDaoL().getIdImg(id);
    }
    public int insert(Show_info show_info) {
        return new Show_InfoDaoL().insert(show_info);
    }
}
