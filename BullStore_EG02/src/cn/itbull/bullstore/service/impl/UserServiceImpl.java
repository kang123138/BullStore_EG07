package cn.itbull.bullstore.service.impl;

import cn.itbull.bullstore.dao.impl.UserDaoImpl;
import cn.itbull.bullstore.domain.User;
import cn.itbull.bullstore.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDaoImpl dao = new UserDaoImpl();
	@Override
	public User login(User user) {
		User loginUser = dao.getUserByUernameAndPassword(user);
		return loginUser;
	}

	@Override
	public boolean register(User user) {
		
		int count = dao.saveUser(user);
		return count > 0;
	}

}
