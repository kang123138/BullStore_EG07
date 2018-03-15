package cn.itbull.bullstore.dao;

import cn.itbull.bullstore.domain.User;

public interface UserDao {
	
	public User getUserByUsernameAndPassword(User user);
	
	public int saveUser(User user);
}
