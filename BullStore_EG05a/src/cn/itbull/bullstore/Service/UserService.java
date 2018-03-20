package cn.itbull.bullstore.Service;

import cn.itbull.bullstore.domain.User;

public interface UserService {
	
	// 登录方法
	public User login(User user);
	
	// 注册方法
	public boolean register(User user);
}
