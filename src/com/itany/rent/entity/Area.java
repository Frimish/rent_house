package com.itany.rent.entity;

import java.io.Serializable;

/**
 * 地区
 * @author ldl
 * @date 2018年5月9日 下午2:07:47
 * @version 1.0
 */
public class Area implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8655316347054998496L;
	private Integer id;
	private String name;
	private Integer parentId;
	public Area(Integer id, String name, Integer parentId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}
	public Area() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
}
