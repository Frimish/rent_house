package com.itany.rent.vo;

import com.itany.rent.entity.HouseInfo;

/**
 * 查询使用
 * @author ldl
 * @date 2018年5月9日 下午2:03:42
 * @version 1.0
 */
public class HouseInfoQuery extends HouseInfo {

	// 条件
	// 地区:all,鼓楼,秦淮,栖霞,江宁,浦口,六合,玄武,建邺,雨花台,溧水,高淳
	private Integer areaParentId;

	// 租金范围:all,<1000,1000-2000,2000-4000,4000,6000,6000-8000,8000-12000,>12000
	private Integer rentBegin;
	private Integer rentEnd;

	// 面积范围:<50,50-70,70-90,90-110,110-150,>150
	private Double acreageBegin;
	private Double acreageEnd;
	
	// 房型:all,一室,二室,三室,四室,五室以上, houseType中的部分值
	private String houseTypeOne;

	// 筛选:
	//朝向:南,西南,东,东南,北,东北,西,西北,南北,东西, houseState中的部分值
	private String houseStateOne;
	//楼层:低楼层,中楼层,高楼层, floorInfo中的部分值
	private String floorInfoOne;
	//品牌:全部,链家,自如
//	private String sign;//使用父类的属性
	//租赁方式:全部,整租,合租
//	private String rentType;//使用父类的属性

	// 近地铁, 其他表示:靠近地铁,-1表示:不靠近地铁
	private String nearMetro;
	// 精装修, houseState中的部分值
	private String houseStateTwo;
	// 随时看房?
//	private Integer lookAtAnyTime;//可随时看房1,不可-1, //使用父类的属性
	// 独立阳台?
//	private Integer balcony;//1是独立阳台,-1不是, //使用父类的属性
	// 独卫?
//	private Integer toilet;//1是独卫,-1不是, //使用父类的属性

	// 排序:
	//默认0,最新1,租金低2,面积3,地铁距离近4
	private Integer sort;

	public HouseInfoQuery() {
		super();
	}

	public Integer getAreaParentId() {
		return areaParentId;
	}

	public void setAreaParentId(Integer areaParentId) {
		this.areaParentId = areaParentId;
	}

	public Integer getRentBegin() {
		return rentBegin;
	}

	public void setRentBegin(Integer rentBegin) {
		this.rentBegin = rentBegin;
	}

	public Integer getRentEnd() {
		return rentEnd;
	}

	public void setRentEnd(Integer rentEnd) {
		this.rentEnd = rentEnd;
	}

	public Double getAcreageBegin() {
		return acreageBegin;
	}

	public void setAcreageBegin(Double acreageBegin) {
		this.acreageBegin = acreageBegin;
	}

	public Double getAcreageEnd() {
		return acreageEnd;
	}

	public void setAcreageEnd(Double acreageEnd) {
		this.acreageEnd = acreageEnd;
	}

	public String getHouseTypeOne() {
		return houseTypeOne;
	}

	public void setHouseTypeOne(String houseTypeOne) {
		this.houseTypeOne = houseTypeOne;
	}
	/**
	 * 朝向
	 * @return
	 */
	public String getHouseStateOne() {
		return houseStateOne;
	}
	/**
	 * 朝向
	 * @param houseStateOne
	 */
	public void setHouseStateOne(String houseStateOne) {
		this.houseStateOne = houseStateOne;
	}
	/**
	 * 楼层
	 * @return
	 */
	public String getFloorInfoOne() {
		return floorInfoOne;
	}
	/**
	 * 楼层
	 * @param floorInfoOne
	 */
	public void setFloorInfoOne(String floorInfoOne) {
		this.floorInfoOne = floorInfoOne;
	}

	public String getNearMetro() {
		return nearMetro;
	}

	public void setNearMetro(String nearMetro) {
		this.nearMetro = nearMetro;
	}

	public String getHouseStateTwo() {
		return houseStateTwo;
	}

	public void setHouseStateTwo(String houseStateTwo) {
		this.houseStateTwo = houseStateTwo;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
