package com.itany.rent.service;

import com.itany.rent.entity.User;
import com.itany.rent.exception.UserNotFoundException;
import com.itany.rent.exception.UserStatusInvalidException;

/**
 * 用户核心业务
 * @author User
 *
 */
public interface UserService {

	public User login(User user) throws UserNotFoundException, UserStatusInvalidException;
	void regist(String phone,String password);
	
}
