package service;

import dao.Commodity_infoDaoL;
import entity.Abapt;
import entity.Brand;
import entity.Commodity_info;
import entity.Commodity_small;
import entity.Show_info;

import java.util.List;

public class Commodity_infoServiceL {
    public List<Commodity_info> getIndexTime() {
        return new Commodity_infoDaoL().getIndexTime();
    }
    public List<Commodity_info> getRecommend() {
        return new Commodity_infoDaoL().getRecommend();
    }
    public List<Commodity_info> getByLimit(int indexPage, int row,int type,int small) {
        return new Commodity_infoDaoL().getByLimit(indexPage,row,type,small);
    }
    public int sumCountAll() {
        return new Commodity_infoDaoL().sumCountAll();
    }

    public List<Commodity_info> dayShow() {
        return new Commodity_infoDaoL().dayShow();
    }

    public Commodity_info commById(int id) {
        return new Commodity_infoDaoL().commById(id);
    }
    
    public List<Commodity_info> selectAll(int indexPage, int row, int id) {
    	return new Commodity_infoDaoL().selectAll(indexPage, row, id);
    }
    
    public int selectCount(int id) {
    	return new Commodity_infoDaoL().selectCount(id);
    }
    
    public int delShowInfo(int id) {
    	return new Commodity_infoDaoL().delShowInfo(id);
    }
    
    public int updateCommodity(int id) {
    	return new Commodity_infoDaoL().updateCommodity(id);
    }
    
    public int updateSJCommodity(int id) {
    	return new Commodity_infoDaoL().updateSJCommodity(id);
    }
    
    public List<Commodity_info> selAll(int indexPage, int row, int id) {
    	return new Commodity_infoDaoL().selAll(indexPage, row, id);
    }
    
    public Commodity_info selFindId(int id) {
    	return new Commodity_infoDaoL().selFindId(id);
    }
    
    public Show_info selectShow(int id) {
    	return new Commodity_infoDaoL().selectShow(id);
    }
    
    public int deleteShow(int id) {
    	return new Commodity_infoDaoL().deleteShow(id);
    }
    
    public String selectUrl(int id) {
    	return new Commodity_infoDaoL().selectUrl(id);
    }
    
    public Commodity_info selectId(int id) {
    	return new Commodity_infoDaoL().selectId(id);
    }
    
    public int update(Commodity_info comm){
    	return new Commodity_infoDaoL().update(comm);
    }
    
    public int insert(Commodity_info comm) {
    	return new Commodity_infoDaoL().insert(comm);
    }
    
    public List<Brand> selectB() {
    	return new Commodity_infoDaoL().selectB();
    }
    
    public List<Commodity_small> selectC() {
    	return new Commodity_infoDaoL().selectC();
    }
    
    public List<Abapt> selectA() {
    	return new Commodity_infoDaoL().selectA();
    }
    
    public int selectNewId() {
    	return new Commodity_infoDaoL().selectNewId();
    }
    
    public int insertAbapt(int abaptId, int commId) {
    	return new Commodity_infoDaoL().insertAbapt(abaptId, commId);

    }
    public String getTitleByid(int id) {
        return new Commodity_infoDaoL().getTitleByid(id);
    }
    
    public int selectTJCount(String name, int id) {
    	return new Commodity_infoDaoL().selectTJCount(name, id);
    }
    
    public List<Commodity_info> selectTJAll(int indexPage, int row,String name, int id) {
    	return new Commodity_infoDaoL().selectTJAll(indexPage, row, name, id);
    }
    
    public List<Commodity_info> selectSJAll(int indexPage, int row,String name, int id) {
    	return new Commodity_infoDaoL().selectSJAll(indexPage, row, name, id);
    }
    
    public int selectSJCount(String name, int id) {
    	return new Commodity_infoDaoL().selectSJCount(name, id);
    }
}
