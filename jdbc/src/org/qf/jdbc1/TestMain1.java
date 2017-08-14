package org.qf.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JAVA�����в������ݿ�
 * ͨ��JDBC����*/
public class TestMain1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//ʹ��JDBC
		//1��ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2���������ݿ�
		Connection conn=DriverManager.getConnection(
				"JDBC:mysql://localhost:3306/db_study3",//Ҫ���ӵ����ݿ�ĵ�ַ
				"root", "root");//�û���������
		//3����ȡ����SQL����
		Statement sm=conn.createStatement();
		//4��ִ��SQL���
		//����User�������ھʹ���
		sm.execute("create table if not exists user(id int primary key auto_increment,userName varchar(20) not null,passWord varchar(32))");
		//��������
		sm.execute("insert into user(userName,passWord) values('huadong','123456')");
		//��ѯUser�������
		//5����ȡ��ѯ�Ľ����
		ResultSet rs=sm.executeQuery("select * from user");
		//ѭ���Ĵӽ�����л�ȡ��ѯ���
		while(rs.next()){
			//һ�����������0��ʼ�����Ǵ˴�Ϊ���������������1��ʼ
			System.out.println("id:"+rs.getInt(1)+"�˺ţ�"+rs.getString(2)+"���룺"+rs.getString(3));
		}
		//6���ر�
		rs.close();
		sm.close();
		conn.close();
	}

}
