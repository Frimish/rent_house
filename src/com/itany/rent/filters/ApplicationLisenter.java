package com.itany.rent.filters;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.itany.rent.constant.Constant;
import com.itany.rent.util.CommonUtil;

/**
 * 项目启动监听器
 * @author ldl
 * @date 2018年5月9日 下午2:51:20
 * @version 1.0
 */
@WebListener
public class ApplicationLisenter implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent context) {
		CommonUtil.setContext(null);
	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		ServletContext application = context.getServletContext();
		CommonUtil.setContext(application);
		String contextPath = CommonUtil.getContextPath();
		application.setAttribute(Constant.FILE_DIR_KEY, contextPath);
		System.out.println("获取文件请求路径=" + contextPath);
	}

}
