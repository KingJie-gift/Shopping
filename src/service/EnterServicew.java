package service;

import dao.EnterDaow;
import entity.Enter;

public class EnterServicew {

	public Enter selectLogin(String enter_telephone, String enter_password){
		return new EnterDaow().selectLogin(enter_telephone, enter_password);
	}

	public int addEnter(Enter enter){
		return new EnterDaow().addEnter(enter);
	}
	public int pattPhone(String phone) {
		return new EnterDaow().pattPhone(phone);
	}
	public int codeId(String id) {
		return new EnterDaow().codeId(id);
	}
	public Enter showBy(int id) {return new EnterDaow().showBy(id);}
	public int update(Enter enter) {
		return new EnterDaow().update(enter);
	}
}
