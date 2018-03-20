package cn.itbull.bullstore.dao.impl;

import cn.itbull.bullstore.dao.UserDao;
import cn.itbull.bullstore.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getUserByUernameAndPassword(User user) {
		return this.getBean("select * from bs_user where username = ? and password = ?",user.getUsername(),user.getPassword());
	}

	@Override
	public int saveUser(User user) {
		return this.update("insert into bs_user(username,password,email) values(?,?,?)", user.getUsername(),user.getPassword(),null);
	}

}
