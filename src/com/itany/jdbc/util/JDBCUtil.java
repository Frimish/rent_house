package com.itany.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.itany.jdbc.exception.DataAccessException;

/**
 * JDBC工具类
 * 使用这个类需要在类加载路径下有一个datasource.properties配置文件
 * 里面存放连接信息，连接属性参考commons-dbcp
 * @author 李恒
 *
 */
public class JDBCUtil {
	 
	private static DataSource dataSource;
	private static ThreadLocal<Connection> threadLocal;
	static{
		try {
			threadLocal=new ThreadLocal<Connection>();
			Properties p=new Properties();
			p.load(JDBCUtil.class
						   .getClassLoader()
						   .getResourceAsStream("datasource.properties"));
			
			dataSource=BasicDataSourceFactory.createDataSource(p);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("JDBCUtil初始化错误"+e);
		} 
	}
	
	/**
	 * 使用commons-dbcp连接池获得一个Connection对象，这个对象线程单例
	 * @return 跟本线程相关的Connection
	 * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
	 */
	public static Connection getConnection(){
		
		Connection con=threadLocal.get();
		if(con==null){
			try {
				con=dataSource.getConnection();
				threadLocal.set(con);
			} catch (Exception e) {
				e.printStackTrace();
				throw new DataAccessException("数据访问失败",e);
			}
		}
		return con;
	}
	
	/**
	 * 关闭资源
	 * @param con 连接
	 * @param ps 操作对象
	 * @param rs 结果集
	 */
	public static void close(Connection con,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
				threadLocal.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 关闭跟本线程相关的连接
	 *
	 */
	public static void close(){
		Connection con=threadLocal.get();
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			threadLocal.remove();
		}
	}
	
}
