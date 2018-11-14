package com.itany.jdbc.util;

import java.sql.Connection;

/**
 * 回调接口，用于暴露Connection
 * @author 李恒
 *
 */
public interface ConnectionCallback {
	/**
	 * 使用Connection做持久化操作
	 * @param con 连接
	 * @return 处理结构
	 * @throws Exception
	 */
	public Object doInConnection(Connection con)throws Exception;
}
