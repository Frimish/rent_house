package com.itany.rent.entity;

import java.io.Serializable;
import java.util.Date;

import com.itany.rent.constant.Constant;

/**
 * 网站用户
 * @author ldl
 * @date 2018年5月9日 下午2:10:52
 * @version 1.0
 */
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6993111863044828026L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String loginname;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 角色
	 */
	private String role;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 头像
	 */
	private String imageUrl;
	/**
	 * 最近登录日期
	 */
	private Date loginDate;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 状态
	 * @see Constant#STATUS_ENABLE
	 * @see Constant#STATUS_DISABLE
	 */
	private Integer status;
	
	public User(Integer id, String nickname, String password, String phone,
			String imageUrl, Date createDate, Integer status) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.createDate = createDate;
		this.status = status;
	}
	public User() {
		super();
	}
	
	public User(String password, String phone) {
		this.password = password;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getStatus() {
		return status;
	}
	/**
	 * 状态
	 * @see Constant#STATUS_ENABLE
	 * @see Constant#STATUS_DISABLE
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
