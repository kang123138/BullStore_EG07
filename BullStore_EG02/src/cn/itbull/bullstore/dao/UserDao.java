package cn.itbull.bullstore.dao;

import cn.itbull.bullstore.domain.User;

public interface UserDao {
	User getUserByUernameAndPassword(User user);

	int saveUser(User user);
}
