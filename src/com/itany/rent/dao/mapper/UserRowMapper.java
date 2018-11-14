package com.itany.rent.dao.mapper;

import java.sql.ResultSet;

import com.itany.jdbc.util.RowMapper;
import com.itany.rent.entity.User;

public class UserRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs) throws Exception {
		return new User(
					rs.getInt("id"), 
					rs.getString("nickname"), 
					rs.getString("password"), 
					rs.getString("phone"), 
					rs.getString("imageUrl"), 
					rs.getDate("createDate"), 
					rs.getInt("status")
			   );
	}

}
