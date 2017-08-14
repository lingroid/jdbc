package org.qf.ui;

import org.qf.entity.User;
import org.qf.service.UserService;
import org.qf.service.imple.UserServiceImple;

import com.mysql.jdbc.PreparedStatement;

public class IndexMain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
//		ps.setDate(arg0, arg1);
//		ps.setTime(parameterIndex, x);
//		ps.setClob(parameterIndex, reader);
//		ps.setBlob(parameterIndex, inputStream);
		UserService us	=new UserServiceImple();
		System.out.println(us.getClass());
		if(us.addUser(new User("¼Ó½ðÉ½", "11111")))
		{
			System.out.println("OK");
		}
		System.out.println(us.selectAllUser());
	}

}
