package com.itany.rent.entity;

import java.io.Serializable;

/**
 * 查看的人与房源的联系
 * @author ldl
 * @date 2018年5月9日 上午11:39:43
 * @version 1.0
 */
public class ViewHouse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1710190054789037331L;
	private Integer id;
	private Integer houseInfoId;
	private Integer userId;
	public ViewHouse() {
		super();
	}
	public ViewHouse(Integer id, Integer houseInfoId, Integer userId) {
		super();
		this.id = id;
		this.houseInfoId = houseInfoId;
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
