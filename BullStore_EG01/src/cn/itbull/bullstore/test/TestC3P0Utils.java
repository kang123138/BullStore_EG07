package cn.itbull.bullstore.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.itbull.bullstore.utils.C3P0Utils;

public class TestC3P0Utils {
	
	@Test
	public void test() throws SQLException {
		
		Connection conn = C3P0Utils.getConnection();
		System.out.println(conn);
		
	}

}
