package service;

import dao.EnterDaoL;
import entity.Enter;

public class EnterServiceL {

	public Enter selectLogin(String enter_telephone, String enter_password){
		return new EnterDaoL().selectLogin(enter_telephone, enter_password);
	}

	public int addEnter(Enter enter){
		return new EnterDaoL().addEnter(enter);
	}
	public int pattPhone(String phone) {
		return new EnterDaoL().pattPhone(phone);
	}
	public int codeId(String id) {
		return new EnterDaoL().codeId(id);
	}
	public int loginAdmin(String enter_name, String enter_password) {
		return new EnterDaoL().loginAdmin(enter_name, enter_password);
	}
}
