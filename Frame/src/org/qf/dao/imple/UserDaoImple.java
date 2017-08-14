package org.qf.dao.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.qf.dao.UserDao;
import org.qf.entity.User;
import org.qf.utils.C3P0Utils;

public class UserDaoImple implements UserDao{

	private QueryRunner qr;
	
	public UserDaoImple() {
		qr=new QueryRunner(C3P0Utils.ds);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try {
			qr.update(
					"insert into user(name,pass,lasttime) values(?,?,now())",
					user.getName(),user.getPass());
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			qr.update(
					"update user set pass=?,lasttime=now() where name=?",
					user.getPass(),user.getName());
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			qr.update("delete from user where name=?",user.getName());
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public User selectUser(User user) {
		// TODO Auto-generated method stub
		try {
				return qr.query("select * from user where name=? and pass=?", new BeanHandler<User>(User.class)
						,new Object[]{user.getName(),user.getPass()});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		try {
			return qr.query("select * from user", new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
}
