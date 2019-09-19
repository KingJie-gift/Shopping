package service;

import dao.EnterDao;
import entity.Enter;

public class EnterService {

	public Enter selectLogin(String enter_telephone, String enter_password){
		return new EnterDao().selectLogin(enter_telephone, enter_password);
	}

	public int addEnter(Enter enter){
		return new EnterDao().addEnter(enter);
	}
	public int pattPhone(String phone) {
		return new EnterDao().pattPhone(phone);
	}
	public int codeId(String id) {
		return new EnterDao().codeId(id);
	}
}
