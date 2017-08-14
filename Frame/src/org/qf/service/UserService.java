package org.qf.service;

import java.util.List;

import org.qf.entity.User;

public interface UserService {

		//ע��
		boolean addUser(User user);
		//�޸�����
		boolean updateUser(User user);
		//ע��
		boolean deleteUser(User user);
		//��¼��֤
		boolean selectUser(User user);
		//�鿴ȫ���û�
		List<User> selectAllUser();
}
