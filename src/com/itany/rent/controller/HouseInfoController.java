package com.itany.rent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itany.mvc.annotation.RequestMapping;
import com.itany.mvc.annotation.ResponseBody;
import com.itany.mvc.util.CommonsMultipartFile;
import com.itany.rent.constant.Constant;
import com.itany.rent.entity.HouseInfo;
import com.itany.rent.entity.User;
import com.itany.rent.util.AjaxResult;
import com.itany.rent.util.CommonUtil;
import com.itany.rent.util.PageInfo;
import com.itany.rent.vo.HouseInfoQuery;


/**
 * 房源信息相关请求
 * @author ldl
 * @date 2018年5月9日 下午2:33:00
 * @version 1.0
 */
@RequestMapping("/houseInfo")
public class HouseInfoController {

	@RequestMapping("/add")
	@ResponseBody
	public AjaxResult add(HttpServletRequest request, HttpServletResponse response, List<CommonsMultipartFile> multiFiles) {
		AjaxResult ar = AjaxResult.isOk();
		
		String userIdStr = request.getParameter("userId");
		User loginUser = CommonUtil.getLoginUser(userIdStr);
		
		//小区名称
		String communityName = request.getParameter("communityName");
		//所属地区的id
		String areaIdStr = request.getParameter("areaId");
		//门牌号,几幢几单元几室等等;
		//例:1幢,1单元,107室,得到的值为"1,1,107"
		String roomNo = request.getParameter("roomNo");
		//租赁方式:整租,合租
		String rentType = request.getParameter("rentType");
		//户型:几室几厅;
		//例:用户输入"三室两厅一厨一卫",得到的值为"3,2,1,1"
		String houseType = request.getParameter("houseType");
		//面积m2
		String acreageStr = request.getParameter("acreage");
		//租金:元/月(不含小数)
		String rentStr = request.getParameter("rent");
		//付款方式:月付,半年付,一年付...
		String payType = request.getParameter("payType");
		//楼层信息, 第几层,共几层
		//例:用户输入"第3层,共12层",得到的值为"3,12"
		String floorInfo = request.getParameter("floorInfo");
		//房屋状态: 装修:毛坯,简装,精装,豪装(豪华装); 方向:南,西南,东,东南,北,东北,西,西北,南北,东西
		//例:简装,东南
		String houseState = request.getParameter("houseState");
		//标题
		String title = request.getParameter("title");
		//房屋配套的设备等:床,冰箱,电视,空调,洗衣机,热水器,家具,宽带,可做饭,独立卫生间...全无
		//例:床,冰箱,电视,空调,洗衣机,热水器
		String equips = request.getParameter("equips");
		//详细介绍
		String detail = request.getParameter("detail");
		//联系人
		String linkman = request.getParameter("linkman");
		//手机号码
		String phone = request.getParameter("phone");
		//用户输入的验证码
		String userCode = request.getParameter("userCode");
		//验证码对应的key
		String key = request.getParameter("codeKey");
		//可通过此方法验证是否正确CommonUtil.checkCodeIgnoreCase
		
		//TODO: 实际操作
		
		//模拟数据
		if(!multiFiles.isEmpty()){
			for (CommonsMultipartFile f : multiFiles) {
				System.out.println("file:" + f);
			}
		}
		ar.setMsg("发布成功");
		
		return ar;
	}
	
	@RequestMapping("/modify")
	@ResponseBody
	public AjaxResult modify(HttpServletRequest request, HttpServletResponse response, List<CommonsMultipartFile> multiFiles) {
		AjaxResult ar = AjaxResult.isOk();
		String userIdStr = request.getParameter("userId");
		User loginUser = CommonUtil.getLoginUser(userIdStr);
		
		//小区名称
		String communityName = request.getParameter("communityName");
		//所属地区的id
		String areaIdStr = request.getParameter("areaId");
		//门牌号,几幢几单元几室等等;
		//例:1幢,1单元,107室,得到的值为"1,1,107"
		String roomNo = request.getParameter("roomNo");
		//租赁方式:整租,合租
		String rentType = request.getParameter("rentType");
		//户型:几室几厅;
		//例:用户输入"三室两厅一厨一卫",得到的值为"3,2,1,1"
		String houseType = request.getParameter("houseType");
		//面积m2
		String acreageStr = request.getParameter("acreage");
		//租金:元/月(不含小数)
		String rentStr = request.getParameter("rent");
		//付款方式:月付,半年付,一年付...
		String payType = request.getParameter("payType");
		//楼层信息, 第几层,共几层
		//例:用户输入"第3层,共12层",得到的值为"3,12"
		String floorInfo = request.getParameter("floorInfo");
		//房屋状态: 装修:毛坯,简装,精装,豪装(豪华装); 方向:南,西南,东,东南,北,东北,西,西北,南北,东西
		//例:简装,东南
		String houseState = request.getParameter("houseState");
		//标题
		String title = request.getParameter("title");
		//房屋配套的设备等:床,冰箱,电视,空调,洗衣机,热水器,家具,宽带,可做饭,独立卫生间...全无
		//例:床,冰箱,电视,空调,洗衣机,热水器
		String equips = request.getParameter("equips");
		//详细介绍
		String detail = request.getParameter("detail");
		//联系人
		String linkman = request.getParameter("linkman");
		//手机号码
		String phone = request.getParameter("phone");
		//用户输入的验证码
		String userCode = request.getParameter("userCode");
		//验证码对应的key
		String key = request.getParameter("codeKey");
		//可通过此方法验证是否正确CommonUtil.checkCodeIgnoreCase
		//房源信息主键
		String idStr = request.getParameter("id");
		//需要删除的图片的id
		String[] removeImages = request.getParameterValues("removeImages");
		
		//TODO: 实际操作
		
		//模拟数据
		if(!multiFiles.isEmpty()){
			for (CommonsMultipartFile f : multiFiles) {
				System.out.println("file:" + f);
			}
		}
		if(null != removeImages){
			for (String imageIdStr : removeImages) {
				System.out.println("imageIdStr=" + imageIdStr);
			}
		}
		ar.setMsg("修改成功");
		
		return ar;
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public AjaxResult remove(HttpServletRequest request, HttpServletResponse response) {
		AjaxResult ar = AjaxResult.isOk();
		String idStr = request.getParameter("id");
		String userIdStr = request.getParameter("userId");
		User loginUser = CommonUtil.getLoginUser(userIdStr);
		
		//TODO: 实际操作
		
		//模拟数据
		ar.setMsg("删除成功");
		
		return ar;
	}
	
	//修改之前的查询使用
	@RequestMapping("/findById")
	@ResponseBody
	public AjaxResult findById(HttpServletRequest request, HttpServletResponse response) {
		AjaxResult ar = AjaxResult.isOk();
		String idStr = request.getParameter("id");
		String userIdStr = request.getParameter("userId");
		User loginUser = CommonUtil.getLoginUser(userIdStr);
		
		//TODO: 实际操作
		
		//模拟数据
		HouseInfo info = new HouseInfo(Integer.parseInt(idStr), "测试小区", null, 16, "2,2,402", "整租", "3,2,1", 89.0, 1600, "月付", "4,12", "简装,东南", "床,冰箱,电视,空调,洗衣机,热水器", "简装设置齐全", "详细描述", "abc", "12345678901", Constant.STATUS_ENABLE, null, Integer.parseInt(userIdStr));
		ar.setObj(info);
		ar.setMsg("查询成功");
		
		return ar;
	}
	
	//他人查看使用
	@RequestMapping("/lookById")
	@ResponseBody
	public AjaxResult lookById(HttpServletRequest request, HttpServletResponse response) {
		AjaxResult ar = AjaxResult.isOk();
		String idStr = request.getParameter("id");
		String userIdStr = request.getParameter("userId");
		
		//TODO: 实际操作
		
		//模拟数据
		HouseInfo info = new HouseInfo(Integer.parseInt(idStr), "测试小区", null, 16, "3,2,402", "整租", "3,2,1", 89.0, 1600, "月付", "4,12", "简装,东南", "床,冰箱,电视,空调,洗衣机,热水器", "简装设置齐全", "详细描述", "abc", "12345678901", Constant.STATUS_ENABLE, null, Integer.parseInt(userIdStr));
		ar.setObj(info);
		ar.setMsg("查询成功");
		
		return ar;
	}
	
	@RequestMapping("/findMyHouseInfos")
	@ResponseBody
	public AjaxResult findMyHouseInfos(HttpServletRequest request, HttpServletResponse response) {
		AjaxResult ar = AjaxResult.isOk();
		String pageNoStr = request.getParameter("pageNo");
		String userIdStr = request.getParameter("userId");
		User loginUser = CommonUtil.getLoginUser(userIdStr);
		
		//TODO: 实际操作
		
		//模拟数据
		int total = 1;//根据条件查询得到的总数据量
		int pageSize = Constant.DEFAULT_PAGE_SIZE;//每页最多显示的数据量
		List<HouseInfo> list = new ArrayList<HouseInfo>();//当前页的数据
		for (int i = 0; i < pageSize; i++) {
			HouseInfo info = new HouseInfo(i+1, "测试小区"+(i+1), null, 16, "3,2,402", "整租", "3,2,1", 89.0, 1600, "月付", "4,12", "简装,东南", "床,冰箱,电视,空调,洗衣机,热水器", "简装设置齐全", "详细描述", "abc", "12345678901", Constant.STATUS_ENABLE, null, Integer.parseInt(userIdStr));
			list.add(info);
		}
		PageInfo<HouseInfo> pageInfo = new PageInfo<HouseInfo>(total, Integer.parseInt(pageNoStr), pageSize, list);
		ar.setMsg("查询成功");
		ar.setObj(pageInfo);
		
		return ar;
	}
	
	@RequestMapping("/find")
	@ResponseBody
	public AjaxResult findHouseInfos(HttpServletRequest request, HttpServletResponse response) {
		AjaxResult ar = AjaxResult.isOk();
		String pageNoStr = request.getParameter("pageNo");
		HouseInfoQuery houseInfoQuery = new HouseInfoQuery();
		//条件
		//地区:all,鼓楼,秦淮,栖霞,江宁,浦口,六合,玄武,建邺,雨花台,溧水,高淳
		String areaParentId = request.getParameter("areaParentId");
		
		//租金范围:all,<1000,1000-2000,2000-4000,4000,6000,6000-8000,8000-12000,>12000
		String rentBegin = request.getParameter("rentBegin");
		String rentEnd = request.getParameter("rentEnd");
		
		//面积范围:<50,50-70,70-90,90-110,110-150,>150
		String acreageBegin = request.getParameter("acreageBegin");
		String acreageEnd = request.getParameter("acreageEnd");
		
		//房型:all,一室1,二室2,三室3,四室4,五室5,五室以上>=6, houseType中的部分值,参考值的格式 3,2,1,1(三室两厅一厨一卫)
		String houseTypeOne = request.getParameter("houseType");
		
		//筛选:
		//朝向:南,西南,东,东南,北,东北,西,西北,南北,东西, houseState中的部分值,参考值的格式 简装,东南
		String houseStateOne = request.getParameter("houseState");
		
		//楼层:低楼层1 1-4层,中楼层2 5-8,高楼层3 >=9, floorInfo中的部分值,参考值的格式10,12(第几层,共几层)
		String floorInfoOne = request.getParameter("floorInfo");
		
		//租赁方式:全部,整租,合租 //使用父类的属性
		String rentType = request.getParameter("rentType");
		
		//排序:默认,最新1,租金低2,面积3,地铁距离近4
		String sort = request.getParameter("sort");
		
		
		//TODO: 实际操作
		
		//模拟数据
		int total = 1;//根据条件查询得到的总数据量
		int pageSize = Constant.DEFAULT_PAGE_SIZE;//每页最多显示的数据量
		List<HouseInfo> list = new ArrayList<HouseInfo>();//当前页的数据
		for (int i = 0; i < pageSize; i++) {
			HouseInfo info = new HouseInfo(i+1, "测试小区"+(i+1), null, 16, "3,2,402", "整租", "3,2,1", 89.0, 1600, "月付", "4,12", "简装,东南", "床,冰箱,电视,空调,洗衣机,热水器", "简装设置齐全", "详细描述", "abc", "12345678901", Constant.STATUS_ENABLE, null, 1);
			list.add(info);
		}
		PageInfo<HouseInfo> pageInfo = new PageInfo<HouseInfo>(total, Integer.parseInt(pageNoStr), pageSize, list);
		ar.setMsg("查询成功");
		ar.setObj(pageInfo);
		
		return ar;
	}
	
}
