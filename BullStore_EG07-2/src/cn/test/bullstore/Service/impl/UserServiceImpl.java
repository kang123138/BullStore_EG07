package cn.itbull.bullstore.Service.impl;

import cn.itbull.bullstore.Service.UserService;
import cn.itbull.bullstore.dao.impl.UserDaoImpl;
import cn.itbull.bullstore.domain.User;

public class UserServiceImpl implements UserService {

	private UserDaoImpl dao = new UserDaoImpl();
	@Override
	public User login(User user) {
		return dao.getUserByUsernameAndPassword(user);
	}

	@Override
	public boolean register(User user) {
		 return dao.saveUser(user) > 0;
	}

}
