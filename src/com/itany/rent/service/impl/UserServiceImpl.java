package com.itany.rent.service.impl;

import java.io.Console;

import com.itany.jdbc.exception.DataAccessException;
import com.itany.rent.constant.Constant;
import com.itany.rent.dao.UserDao;
import com.itany.rent.entity.User;
import com.itany.rent.exception.ServiceException;
import com.itany.rent.exception.UserNotFoundException;
import com.itany.rent.exception.UserStatusInvalidException;
import com.itany.rent.factory.ObjectFactory;
import com.itany.rent.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Override
	public User login(User user) throws UserNotFoundException, UserStatusInvalidException {
		userDao = (UserDao) ObjectFactory.getObject("userDao");
		User u = userDao.selectByPhoneAndPassword(user);
		if( u == null )
		{
			// 不正常情况 | 向上（调用者）传递信号
			throw new UserNotFoundException("用户名/密码错误");
		}
		
		if( Constant.STATUS_DISABLE ==  u.getStatus() )
		{
			throw new UserStatusInvalidException("用户账户处于禁用状态");
		}
		
		return u;
	}

	@Override
	public void regist(String phone, String password) {
		userDao = (UserDao) ObjectFactory.getObject("userDao");
		if(userDao.selectByPhone(phone) == null){
			userDao.insertUser(phone, password);
		}else{
			throw new ServiceException("手机号已被注册");
		}
	}

	@Override
	public void uploadHeadImage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyNickname(User user) {
		userDao = (UserDao) ObjectFactory.getObject("userDao");
		userDao.updateNickNameById(user.getId(), user.getNickname());
		
	}

	@Override
	public void modifyPassword(User user) {
		userDao = (UserDao) ObjectFactory.getObject("userDao");
		userDao.updatePasswordById(user.getId(), user.getPassword());
		
	}

}
