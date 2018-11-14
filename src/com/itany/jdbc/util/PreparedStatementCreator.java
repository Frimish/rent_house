package com.itany.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 回调接口，暴露Connection，用于创建PreeparedStatement
 * @author 李恒
 *
 */
public interface PreparedStatementCreator {
	/**
	 * 创建PreparedStatement
	 * @param con 连接
	 * @return 创建完的PreparedStatement对象
	 * @throws Exception
	 */
	public PreparedStatement createPreparedStatement(Connection con)throws Exception;
}
