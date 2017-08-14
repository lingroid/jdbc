package org.qf.dao;

import java.util.List;

import org.qf.entity.User;

public interface UserDao {
	//�����û�
	boolean addUser(User user);
	//�޸��û�
	boolean updateUser(User user);
	//ɾ���û�
	boolean deleteUser(User user);
	//��ѯ����
	User selectUser(User user);
	//��ѯ���
	List<User> selectAllUser();
}
