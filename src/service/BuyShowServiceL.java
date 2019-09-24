package service;

import dao.BuyShowDaoL;

public class BuyShowServiceL {

	public int selectBuyShow(int id) {
		return new BuyShowDaoL().selectBuyShow(id);
	}
	
	public int delBuyShow(int id) {
		return new BuyShowDaoL().delBuyShow(id);
	}
}
