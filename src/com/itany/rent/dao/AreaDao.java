package com.itany.rent.dao;

import java.util.List;

import com.itany.rent.entity.Area;

public interface AreaDao {
	public Area findParentById(String id);
	public List<Area> findByParentId(String parentid);
	
}
