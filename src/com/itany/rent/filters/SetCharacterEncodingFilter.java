package com.itany.rent.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itany.rent.constant.Constant;

/**
 * post请求字符集过滤器
 * @author ldl
 * @date 2018年5月9日 下午2:50:55
 * @version 1.0
 */
@WebFilter(
	filterName="encodingFilter", 
	urlPatterns="/*", 
	initParams = {
		@WebInitParam(name=Constant.FILTER_ENCODING_KEY, value="UTF-8"), 
		@WebInitParam(name=Constant.FILTER_ALLOWORIGIN_KEY, value="true")
		})
public class SetCharacterEncodingFilter implements Filter{
    
	private String encoding;//字符集
	private boolean allowOrigin;//是否允许跨域访问
	
	@Override
	public void destroy() {
		this.encoding = null;
		this.allowOrigin = false;
    }

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		String servletPath = request.getServletPath();
		System.out.println("servletPath=" + servletPath);
		//一般处理方式
		request.setCharacterEncoding(this.encoding);
		response.setCharacterEncoding(this.encoding);
		if(allowOrigin){//允许跨域访问
			response.setContentType("application/json");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
			response.setHeader("Access-Control-Allow-Credentials", "true");
		}
		chain.doFilter(request, response);
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter(Constant.FILTER_ENCODING_KEY);
	    if(this.encoding == null){
	    	this.encoding = Constant.FILTER_CHARSET_UTF8;
	    }
	    String initParameter = filterConfig.getInitParameter(Constant.FILTER_ALLOWORIGIN_KEY);
	    if(initParameter != null){
	    	allowOrigin = initParameter.equalsIgnoreCase("true");
	    }
    }

}
