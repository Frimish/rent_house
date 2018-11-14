package com.itany.rent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itany.mvc.annotation.RequestMapping;
import com.itany.mvc.annotation.ResponseBody;
import com.itany.rent.entity.Area;
import com.itany.rent.util.AjaxResult;

/**
 * 地区相关请求
 * @author ldl
 * @date 2018年5月9日 下午2:33:06
 * @version 1.0
 */
@RequestMapping("/area")
public class AreaController {

	/**
	 * 获取根据parentId获取其子地区
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/findByParentId")
	@ResponseBody
	public AjaxResult findByParentId(HttpServletRequest request, HttpServletResponse response) {
		AjaxResult ar = AjaxResult.isOk();
		String parentIdStr = request.getParameter("parentId");
		
		//TODO: 实际操作
		
		//模拟数据
		List<Area> list = new ArrayList<Area>();
		for (int i = 0; i < 5; i++) {
			Area a = new Area(i+1, "地区" + (i+1), Integer.parseInt(parentIdStr));
			list.add(a);
		}
		
		
		ar.setObj(list);
		ar.setMsg("查询成功");
		
		return ar;
	}
	
	/**
	 * 根据地区id查询其所属地区信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/findParentById")
	@ResponseBody
	public AjaxResult findParentById(HttpServletRequest request, HttpServletResponse response) {
		AjaxResult ar = AjaxResult.isOk();
		String idStr = request.getParameter("id");
		
		//TODO: 实际操作
		//serviceimpl实现类里调用daoimpl的实现类里的方法
		//serviceproxy代理类里调用serviceimpl实现类的方法
//		try{
//		//controller里调用serviceproxy里面的方法
//			ar.setObj(area);
//			ar.setSuccess(true);
//			ar.setMsg("sucess!查询成功");
//		}catch (Exception e) {
//			// TODO: handle exception
//			ar.setSuccess(false);
//			ar.setMsg("fail!操作失败");
//		}
		
		//模拟数据
		Area a = new Area(3, "地区3", 2);
		ar.setObj(a);
		ar.setMsg("查询成功");
		
		return ar;
	}
	
}
