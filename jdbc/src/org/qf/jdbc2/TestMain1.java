package org.qf.jdbc2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.qf.utils.DbUtils;

public class TestMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʼ�����ݿ⹤������Ϣ
		DbUtils.init("JDBC:mysql://localhost:3306/db_study3",
				"root","root");
		//������ӵ��û�����
		User user=new User();
		Random rm=new Random();
		user.setPassWord(rm.nextInt(100000)+100000+"");
		char c=(char) (rm.nextInt(26)+65);
		user.setUserName(c+"");
		//ִ����������
		DbUtils.update("insert into user(userName,passWord) values('"+user.getUserName()+"','"+user.getPassWord()+"')");
		//��ȡ��ѯ���
		ResultSet rs=DbUtils.query("select * from User");
		ArrayList<User> list=new ArrayList<>();
		//����ѯ�����ӵ�������
		try {
			while(rs.next()){
				User us1=new User();
				us1.setId(rs.getInt("id"));
				us1.setUserName(rs.getString("userName"));
				us1.setPassWord(rs.getString("passWord"));
				list.add(us1);
			}
			//�رս����
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//������
		System.out.println(list);
		
	}

}
