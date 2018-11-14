package com.itany.rent.service.proxy;

import com.itany.jdbc.transaction.TransactionManager;
import com.itany.rent.entity.User;
import com.itany.rent.exception.ServiceException;
import com.itany.rent.exception.UserNotFoundException;
import com.itany.rent.exception.UserStatusInvalidException;
import com.itany.rent.factory.ObjectFactory;
import com.itany.rent.service.UserService;

public class UserServiceProxy implements UserService{

	private UserService userService;
	
	@Override
	public User login(User user) throws UserNotFoundException, UserStatusInvalidException {
		TransactionManager tr = (TransactionManager) ObjectFactory.getObject("transaction");
		userService = (UserService) ObjectFactory.getObject("userServiceTarget");
		User u = null;
		try {
			tr.beginTransaction();
			u = userService.login(user);
			tr.commit();
		}catch (UserNotFoundException e) {
			tr.rollback();
			throw e;
		}catch (UserStatusInvalidException e) {
			tr.rollback();
			throw e;
		}
		catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			throw new ServiceException("服务器忙，请稍后再试",e);
		}
		
		return u;
	}

	@Override
	public void regist(String phone, String password) {
		TransactionManager tr = (TransactionManager) ObjectFactory.getObject("transaction");
		userService = (UserService) ObjectFactory.getObject("userServiceTarget");
		try {
			tr.beginTransaction();
			tr.commit();
			userService.regist(phone, password);
			tr.rollback();
		}
		catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			throw new ServiceException("手机号已被注册",e);
		}
	}

	@Override
	public void uploadHeadImage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyNickname(User user) {
		userService = (UserService) ObjectFactory.getObject("userServiceTarget");
		userService.modifyNickname(user);
		
	}

	@Override
	public void modifyPassword(User user) {
		userService = (UserService) ObjectFactory.getObject("userServiceTarget");
		userService.modifyPassword(user);
	}

}
