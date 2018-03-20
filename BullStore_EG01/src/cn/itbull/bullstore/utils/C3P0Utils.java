package cn.itbull.bullstore.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0的工具类，主要提供获取链接，释放连接。
 */
public class C3P0Utils {
	
	// 创建一个数据库连接池对象
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	
	/**
	 * 获取数据源
	 */
	public static ComboPooledDataSource getDataSource() {
		return ds;
	}

	/**
	 * 获取数据库链接
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	/**
	 * 释放数据库链接的方法
	 */
	public static void releaseConn(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
