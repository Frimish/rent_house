package com.itany.rent.dao.impl;

import com.itany.jdbc.util.JDBCTemplate;
import com.itany.rent.dao.UserDao;
import com.itany.rent.dao.mapper.UserRowMapper;
import com.itany.rent.entity.User;

public class UserDaoImpl implements UserDao{

	JDBCTemplate jt = new JDBCTemplate();
	
   @Override
    public void insertUser(String phone, String password) {
        String sql = new StringBuffer()
        .append(" insert ")
        .append(" into ")
        .append("   t_user ")
        .append("   (phone,password) ")
        .append(" values ")
        .append("   (?,?) ").toString();
        jt.update(sql,new Object[]{phone,password});
        
    }
	
	@Override
	public User selectByPhoneAndPassword(User user) {
		
		String sql = new StringBuffer()
				.append(" select ")
				.append(" 	id,")
				.append(" 	loginname,")
				.append(" 	nickname,")
				.append(" 	password,")
				.append(" 	phone,")
				.append(" 	role,")
				.append(" 	email,")
				.append(" 	imageUrl,")
				.append(" 	loginDate,")
				.append(" 	createDate,")
				.append(" 	status")
				.append(" from ")
				.append("   t_user ")
				.append(" where ")
				.append("   phone = ? and password = ? ")
				.toString();
		return (User) jt.query4Object(sql, new UserRowMapper(), new Object[]{user.getPhone(),user.getPassword()});
	}


	@Override
	public User selectByPhone(String phone) {
		String sql = new StringBuffer()
		.append(" select ")
		.append("	id, ")
		.append("	phone, ")
		.append("	password ")
		.append(" from ")
		.append("	t_user ")
		.append(" where ")
		.append("	phone=? ")
		.toString();
		return (User) (jt.query4Object(sql, new UserRowMapper(), new Object[]{phone}));
	}


	@Override
	public void updateNickNameById(int id, String nickName) {
		String sql = new StringBuffer()
		.append(" update ")
		.append(" 	t_user ")
		.append(" set ")
		.append("	nickname=? ")
		.append(" where ")
		.append("	id=? ")
		.toString();
		jt.update(sql, new Object[]{nickName,id});
		
	}


	@Override
	public void updatePasswordById(int id, String newPassword) {
		String sql = new StringBuffer()
		.append(" update ")
		.append(" 	t_user ")
		.append(" set ")
		.append("	password=? ")
		.append(" where ")
		.append("	id=? ")
		.toString();
		jt.update(sql, new Object[]{newPassword,id});
		
	}

}
