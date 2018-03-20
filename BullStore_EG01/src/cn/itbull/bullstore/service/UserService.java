package cn.itbull.bullstore.service;

import cn.itbull.bullstore.domain.User;

public interface UserService {
	
	User login(User user);
	
	boolean regist(User user);

}
