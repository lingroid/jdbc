package org.qf.service.imple;

import java.util.List;

import org.qf.dao.UserDao;
import org.qf.dao.imple.UserDaoImple;
import org.qf.entity.User;
import org.qf.service.UserService;

public class UserServiceImple implements UserService{

	private UserDao dao;
	
	public UserServiceImple() {
		super();
		dao=new UserDaoImple();
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return dao.deleteUser(user);
	}

	@Override
	public boolean selectUser(User user) {
		// TODO Auto-generated method stub
		
		return dao.selectUser(user)==null?false:true;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return dao.selectAllUser();
	}

}
