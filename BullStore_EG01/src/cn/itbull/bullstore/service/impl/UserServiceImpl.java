package cn.itbull.bullstore.service.impl;

import cn.itbull.bullstore.dao.impl.UserDaoImpl;
import cn.itbull.bullstore.domain.User;
import cn.itbull.bullstore.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User login(User user) {
		
		UserDaoImpl dao = new UserDaoImpl();
		
		User loginUser = dao.getUserByUsernameAndPassword(user);
		
		return loginUser;
	}

	@Override
	public boolean regist(User user) {
		
		UserDaoImpl dao = new UserDaoImpl();
		
		int count = dao.saveUser(user);
		
		System.out.println(count);
		
//		if(count > 0) {
//			return true;
//		}else {
//			return false;
//		}
		
		return count > 0;
		
	}

}
