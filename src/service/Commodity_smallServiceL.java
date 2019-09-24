package service;

import java.util.List;

import dao.Commodity_smallDaoL;
import entity.Commodity_small;

public class Commodity_smallServiceL {

	public List<String> selectTong(String tong) {
		return new Commodity_smallDaoL().selectTong(tong);
	}
	
	public List<Commodity_small> selectComm() {
		return new Commodity_smallDaoL().selectComm();
	}
	public int getaddzl(Commodity_small sm) {
		return new Commodity_smallDaoL().getaddzl(sm);
	}
	public int getDelete(int id) {
		return new Commodity_smallDaoL().getDelete(id);
	}
	public int getdel(int id) {
		return new Commodity_smallDaoL().getdel(id);
	}
}
