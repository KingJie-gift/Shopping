package service;


import java.util.List;

import dao.CounselingDaog;
import entity.Counseling;

public class CounselingServiceg {
	public int getCount(){
		return new CounselingDaog().getCount();
	}

	public List<Counseling> getAll(int pageindex,int pageSize){
		return new CounselingDaog().getAll(pageindex,pageSize);
	}
	public  int getAdd(Counseling c){
    	return new CounselingDaog().getAdd(c);
    }
    public int getDelete(int id) {
    	return new CounselingDaog().getDelete(id);
    }
    public Counseling getfone(int id) {
    	return new CounselingDaog().getfone(id);
    }
    public int getUpdate(Counseling c) {
    	return new CounselingDaog().getUpdate(c);
    }
}
