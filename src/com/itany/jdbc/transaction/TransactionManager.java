package com.itany.jdbc.transaction;

/**
 * 事务管理器
 * @author 李恒
 */
public interface TransactionManager {
	/**
	 * 开始事务
	 *
	 */
	public void beginTransaction();
	/**
	 * 提交事务
	 *
	 */
	public void commit();
	/**
	 * 回滚事务
	 *
	 */
	public void rollback();
}
