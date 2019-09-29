package service;

import java.util.List;

import dao.CommodityDaoZ;
import entity.Commodity;

public class CommodityServiceZ {

	public List<Commodity> getqcAll() {
		return new CommodityDaoZ().getqcAll();
	}
	public int CommodityAdd(Commodity comm) {
		return new CommodityDaoZ().CommodityAdd(comm);
	}
	public int getcount(String name) {
		return new CommodityDaoZ().getcount(name);
	}
	public Commodity getfone(int id) {
		return new CommodityDaoZ().getfone(id);
	}
	
	public int updateComm(Commodity comm) {
		return new CommodityDaoZ().updateComm(comm);
	}
}
