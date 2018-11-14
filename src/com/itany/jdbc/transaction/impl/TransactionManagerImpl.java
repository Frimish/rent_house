package com.itany.jdbc.transaction.impl;

import java.sql.Connection;

import com.itany.jdbc.exception.DataAccessException;
import com.itany.jdbc.transaction.TransactionManager;
import com.itany.jdbc.util.JDBCUtil;

public class TransactionManagerImpl implements TransactionManager {

	public void beginTransaction() {
		Connection con=null;
		try {
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
	}

	public void commit() {
		Connection con=null;
		try {
			con=JDBCUtil.getConnection();
			con.commit();
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		} finally {
			JDBCUtil.close();
		}
	}

	public void rollback() {
		Connection con=null;
		try {
			con=JDBCUtil.getConnection();
			con.rollback();
		} catch (Exception e) {
			//通知管理员，人为解决
			e.printStackTrace();
		} finally {
			JDBCUtil.close();
		}
	}

}
