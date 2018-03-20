package cn.itbull.bullstore.dao;

import cn.itbull.bullstore.domain.User;

public interface UserDao {
	
	User getUserByUsernameAndPassword(User user);
	
	int saveUser(User user);

}
