package com.itany.rent.dao;

import com.itany.rent.entity.User;

/**
 * 对t_user表的操作
 * @author User
 *
 */
public interface UserDao {

	/**
	 * 根据电话和密码查询用户信息
	 * @param user 封装了查询参数的对象
	 * @return 查询结果  null 没有结果
	 */
	public User  selectByPhoneAndPassword(User user);
	User selectByPhone(String phone);
	void updateNickNameById(int id,String nickName);
	void updatePasswordById(int id,String newPassword);
	void insertUser(String phone,String password);
	
}
