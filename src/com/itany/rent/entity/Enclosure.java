package com.itany.rent.entity;

import java.io.Serializable;

/**
 * 附件
 * @author ldl
 * @date 2018年5月9日 下午2:08:14
 * @version 1.0
 */
public class Enclosure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4666313567962660736L;
	private Integer id;
	private String path;//文件相对路径
	private Integer houseInfoId;//房源信息id
	private Integer status;//状态
	public Enclosure() {
		super();
	}
	public Enclosure(Integer id, String path, Integer houseInfoId) {
		this.id = id;
		this.path = path;
		this.houseInfoId = houseInfoId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
