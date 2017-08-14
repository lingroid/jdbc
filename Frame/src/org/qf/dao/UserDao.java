package org.qf.dao;

import java.util.List;

import org.qf.entity.User;

public interface UserDao {
	//新增用户
	boolean addUser(User user);
	//修改用户
	boolean updateUser(User user);
	//删除用户
	boolean deleteUser(User user);
	//查询单个
	User selectUser(User user);
	//查询多个
	List<User> selectAllUser();
}
