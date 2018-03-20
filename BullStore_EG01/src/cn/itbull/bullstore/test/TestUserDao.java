package cn.itbull.bullstore.test;

import org.junit.Test;

import cn.itbull.bullstore.dao.impl.UserDaoImpl;
import cn.itbull.bullstore.domain.User;

public class TestUserDao {
	
	@Test
	public void test() {
		
		UserDaoImpl dao = new UserDaoImpl();
		
		User user = new User(null,"admin","123123",null);
		
		User loginUser = dao.getUserByUsernameAndPassword(user);
		
		System.out.println(loginUser);
	}
	
	@Test
	public void testSaveUser() {
		
		UserDaoImpl dao = new UserDaoImpl();
		
		User user = new User(null,"admin","123123","admin@sina.com");
		
		int count = dao.saveUser(user);
		
		System.out.println(count);
	}

}
