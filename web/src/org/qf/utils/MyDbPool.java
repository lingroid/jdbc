package org.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 自定义数据库连接池
 * */
public class MyDbPool {

	private static String path,url,name,pass;
	//存储当前的连接对象
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
			
			//加载驱动
			Class.forName(path);
			
			//获取连接对象
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
	//获取连接对象
	public static Connection getConn() {
		if(list.size()>0){
			return list.remove(0);
		}
		else {
			throw new RuntimeException("谁让你不关闭");
		}
	}
	//销毁连接对象，其实就再次添加进来
	public static void destroy(Connection conn) {
		list.add(list.size(), conn);
	}
	
	
	
	
}
