package cn.itbull.bullstore.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 这是操作C3P0的工具类
 */
public class C3P0Utils {
	
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	// 获取数据源
	
	public static ComboPooledDataSource getDataSource() {
		return ds;
	}

	// 获取数据库连接
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	// 释放资源
	public static void release(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
	
}
