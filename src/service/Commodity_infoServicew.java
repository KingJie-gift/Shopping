package service;

import dao.Commodity_infoDaow;
import entity.Commodity_info;

import java.util.List;

public class Commodity_infoServicew {
    public List<Commodity_info> getIndexTime() {
        return new Commodity_infoDaow().getIndexTime();
    }
    public List<Commodity_info> getRecommend() {
        return new Commodity_infoDaow().getRecommend();
    }
    public List<Commodity_info> getByLimit(int indexPage, int row,int type,int small,String like,int prent_id,int commType,int day) {
        return new Commodity_infoDaow().getByLimit(indexPage,row,type,small,like,prent_id,commType,day);
    }
    public int sumCountAll(int id,int prent_id,String like , int commType,int type,int dya) {
        return new Commodity_infoDaow().sumCountAll(id,prent_id,like,commType,type,dya);
    }

    public List<Commodity_info> dayShow() {
        return new Commodity_infoDaow().dayShow();
    }

    public Commodity_info commById(int id) {
        return new Commodity_infoDaow().commById(id);
    }
    public List<Commodity_info> getListComm(String comm) {
        return new Commodity_infoDaow().getListComm(comm);
    }

    public List<Commodity_info> getTShopping(int id) {

        return new Commodity_infoDaow().getTShopping(id);
    }
    public int rowById(int id) {
        return new Commodity_infoDaow().rowById(id);
    }
}
