package cn.itbull.bullstore.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0工具类
 */
public class C3P0Utils {

	// 获取数据库连接
	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	public static ComboPooledDataSource getDataSource() {
		return ds;
	}

	// 获取数据库连接
	public static Connection getConnection() throws SQLException {
		Connection conn = ds.getConnection();
		return conn;
	}

	// 释放资源的方法
	public static void release(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
