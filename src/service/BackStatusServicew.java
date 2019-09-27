package service;

import dao.BackStatusDao;
import entity.Buy;
import entity.Buyshow;

import java.util.List;

public class BackStatusServicew {
    public List<Buy> buyshows(int indexPage, int row,int type) {
        return new BackStatusDao().buyshows(indexPage,row,type);
    }
    public int sumPagexx(int type){
        return new BackStatusDao().sumPagexx(type);
    }
    public List<Buyshow> getBuyShowInfos(int id) {
        return new BackStatusDao().getBuyShowInfos(id);
    }
    public int updateBuyShowInfoxxx(int type, int id) {
        return new BackStatusDao().updateBuyShowInfoxxx(type,id);
    }
}
