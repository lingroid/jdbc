package org.qf.service;

import java.util.List;

import org.qf.entity.User;

public interface UserService {

		//注册
		boolean addUser(User user);
		//修改密码
		boolean updateUser(User user);
		//注销
		boolean deleteUser(User user);
		//登录验证
		boolean selectUser(User user);
		//查看全部用户
		List<User> selectAllUser();
}
