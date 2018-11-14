package com.itany.rent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itany.mvc.annotation.RequestMapping;
import com.itany.mvc.annotation.ResponseBody;
import com.itany.rent.factory.ObjectFactory;
import com.itany.rent.service.UserService;
import com.itany.rent.util.AjaxResult;
import com.itany.rent.util.CommonUtil;

@RequestMapping("/user")
public class UserController {
	
	
	private UserService userService;

	@RequestMapping("/regist")
	@ResponseBody
	public AjaxResult regist(HttpServletRequest request, HttpServletResponse response) {
		AjaxResult ar = AjaxResult.isOk();
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String userCode = request.getParameter("userCode");
		String key = request.getParameter("codeKey");
		
        if (!isMobile(phone)) {
            ar.setMsg("非法手机号");
            ar.setSuccess(false);
            return ar;
        }
        
		if(!CommonUtil.checkCodeIgnoreCase(key, userCode)){
			ar.setMsg("注册失败");
			ar.setSuccess(false);
			return ar;
		}

		try{
			userService = (UserService) ObjectFactory.getObject("userService");
			userService.regist(phone, password);
			ar.setMsg("注册成功");
			ar.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			ar.setMsg(e.getMessage());
			ar.setSuccess(false);
		}

		
		return ar;
	}
	

}
