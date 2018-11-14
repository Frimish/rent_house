package com.itany.rent.constant;

/**
 * 常量接口
 * @author ldl
 * @date 2018年5月9日 下午1:29:48
 * @version 1.0
 */
public interface Constant {
	/**
	 * 字符集过滤器 获取参数的key
	 */
	String FILTER_ENCODING_KEY = "encoding";
	/**
	 * 字符集过滤器 是否允许跨域的key
	 */
	String FILTER_ALLOWORIGIN_KEY = "allowOrigin";
	/**
	 * 过滤器默认字符集
	 */
	String FILTER_CHARSET_UTF8 = "UTF-8";
	
	/**
	 * session中保存用户信息的key
	 */
	String SESSSION_USER_KEY = "user";
	
	/**
	 * 启用状态
	 */
	int STATUS_ENABLE = 1;
	/**
	 * 禁用状态
	 */
	int STATUS_DISABLE = -1;
	
	/**
	 * 分页-默认的初始页码
	 */
	int DEFAULT_PAGE_NO = 1;
	/**
	 * 分页-默认每页显示的数据条数
	 */
	int DEFAULT_PAGE_SIZE = 2;
	
	/**
	 * 用户角色admin
	 */
	String USER_ROLE_ADMIN = "admin";
	/**
	 * 用户角色normal
	 */
	String USER_ROLE_NORMAL = "normal";
	
	/**
	 * 获取文件上传路径的前缀
	 */
	String UPLOAD_PATH_PREFIX = "environment";
	/**
	 * 获取文件上传路径的后缀
	 */
	String UPLOAD_PATH_SUFFIX = ".path";
	/**
	 * 获取文件请求路径的key
	 */
	String FILE_DIR_KEY = "fileDir";
	
	/**
	 * 存放(获取)图片上验证码的key
	 */
	String DEFAULT_CODE_KEY = "code";
	/**
	 * 图片转码前缀
	 */
	String IMAGE_BASE64 = "data:image/jpeg;base64,";
	
}
