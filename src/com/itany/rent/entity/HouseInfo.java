package com.itany.rent.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 房源信息
 * @author ldl
 * @date 2018年5月9日 下午2:13:39
 * @version 1.0
 */
public class HouseInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1023190595083809553L;
	private Integer id;
	private String communityName;//小区名称
	private Area area;//所在地区
	private Integer areaId;//所在地区主键
	private String roomNo;//门牌号,几幢几单元几室等等;例:1幢,1单元,107室
	private String rentType;//租赁方式:整租,合租
	private String houseType;//户型:几室几厅;例:3,2,1,1(三室两厅一厨一卫)
	private Double acreage;//面积m2
	
	private Integer rent;//租金:元/月(不含小数)
	private String payType;//付款方式:月付,半年付,一年付..
	//例:11,12
	private String floorInfo;//楼层信息, 第几层,共几层
	//例:简装,东南
	private String houseState;//房屋状态:毛坯,简装,精装,豪装(豪华装);方向:南,西南,东,东南,北,东北,西,西北,南北,东西
	private String equips;//房屋配套的设备等:床,冰箱,电视,空调,洗衣机,热水器,家具,宽带,可做饭,独立卫生间...全无
	
	private String title;//标题
	private String detail;//详细介绍
	
	private String linkman;//联系人
	private String phone;//手机号码
	private Integer status;//状态
	private User user;//发布者
	private Integer userId;//发布者id
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	
	private String sign;//品牌
	private Integer metroDistance;//距离地铁的距离,单位米;-1表示不靠近地铁
	private Integer lookAtAnyTime;//可随时看房1,不可-1
	private Integer balcony;//1是独立阳台,-1不是
	private Integer toilet;//1是独卫,-1不是
	
	private Integer count;//多少人看过
	
	private List<Enclosure> images = new ArrayList<Enclosure>();//房源相关图片
	
	

	public HouseInfo() {
	}
	public HouseInfo(Integer id, String communityName, Area area,
			Integer areaId, String roomNo, String rentType, String houseType,
			Double acreage, Integer rent, String payType, String floorInfo,
			String houseState, String equips, String title, String detail,
			String linkman, String phone, Integer status, User user, Integer userId) {
		this.id = id;
		this.communityName = communityName;
		this.area = area;
		this.areaId = areaId;
		this.roomNo = roomNo;
		this.rentType = rentType;
		this.houseType = houseType;
		this.acreage = acreage;
		this.rent = rent;
		this.payType = payType;
		this.floorInfo = floorInfo;
		this.houseState = houseState;
		this.equips = equips;
		this.title = title;
		this.detail = detail;
		this.linkman = linkman;
		this.phone = phone;
		this.status = status;
		this.user = user;
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRentType() {
		return rentType;
	}
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public Double getAcreage() {
		return acreage;
	}
	public void setAcreage(Double acreage) {
		this.acreage = acreage;
	}
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getFloorInfo() {
		return floorInfo;
	}
	public void setFloorInfo(String floorInfo) {
		this.floorInfo = floorInfo;
	}
	public String getHouseState() {
		return houseState;
	}
	public void setHouseState(String houseState) {
		this.houseState = houseState;
	}
	public String getEquips() {
		return equips;
	}
	public void setEquips(String equips) {
		this.equips = equips;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Enclosure> getImages() {
		return images;
	}
	public void setImages(List<Enclosure> images) {
		this.images = images;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Integer getMetroDistance() {
		return metroDistance;
	}
	public void setMetroDistance(Integer metroDistance) {
		this.metroDistance = metroDistance;
	}
	public Integer getLookAtAnyTime() {
		return lookAtAnyTime;
	}
	public void setLookAtAnyTime(Integer lookAtAnyTime) {
		this.lookAtAnyTime = lookAtAnyTime;
	}
	public Integer getBalcony() {
		return balcony;
	}
	public void setBalcony(Integer balcony) {
		this.balcony = balcony;
	}
	public Integer getToilet() {
		return toilet;
	}
	public void setToilet(Integer toilet) {
		this.toilet = toilet;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
