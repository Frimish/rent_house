package com.itany.rent.dao.mapper;

import java.sql.ResultSet;

import com.itany.jdbc.util.RowMapper;
import com.itany.rent.entity.Area;
import com.itany.rent.entity.User;

public class AreaRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs) throws Exception {
		return new Area(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getInt("parentId")
		   );
	}

}
