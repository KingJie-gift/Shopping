package service;

import dao.MessageDaoL;

public class MessageServiceL {

	public int selectMessageId(int id) {
		return new MessageDaoL().selectMessageId(id);
	}
	
	public int delMessage(int id) {
		return new MessageDaoL().delMessage(id);
	}
}
