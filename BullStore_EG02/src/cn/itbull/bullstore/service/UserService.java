package cn.itbull.bullstore.service;

import cn.itbull.bullstore.domain.User;

public interface UserService {

	/**
	 * 登录方法
	 */
	User login(User user);

	/**
	 * 注册的方法
	 */
	boolean register(User user);
}
