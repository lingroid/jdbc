package org.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * �Զ������ݿ����ӳ�
 * */
public class MyDbPool {

	private static String path,url,name,pass;
	//�洢��ǰ�����Ӷ���
	private static List<Connection> list;
	
	static{
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		path=rb.getString("driverpath");
		url=rb.getString("dburl");
		name=rb.getString("username");
		pass=rb.getString("pass");
		//list=new ArrayList<>();
		list=Collections.synchronizedList(new ArrayList<Connection>());
		try {
			
			//��������
			Class.forName(path);
			
			//��ȡ���Ӷ���
			for(int i=0;i<5;i++){
				list.add(DriverManager.getConnection(url,name,pass));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡ���Ӷ���
	public static Connection getConn() {
		if(list.size()>0){
			return list.remove(0);
		}
		else {
			throw new RuntimeException("˭���㲻�ر�");
		}
	}
	//�������Ӷ�����ʵ���ٴ���ӽ���
	public static void destroy(Connection conn) {
		list.add(list.size(), conn);
	}
	
	
	
	
}
