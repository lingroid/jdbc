package org.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DbHelper {

	private static String path;
	private static String url;
	private static String name;
	private static String psw;
	private static Connection conn;
	private static Statement stmt;
	static{
		//获取配置文件信息
		ResourceBundle bundle=ResourceBundle.getBundle("org/qf/utils/dbinfo");
		path=bundle.getString("driverpath");
		url=bundle.getString("dburl");
		name=bundle.getString("user");
		psw=bundle.getString("pass");
		try {
			Class.forName(path);
			conn=DriverManager.getConnection(url, name, psw);
			stmt=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//执行非select语句
		public static int update(String sql){
			try {
				return stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		//执行select语句
		public static ResultSet query(String sql){
			try {
				return stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		//销毁，释放资源
		public static void destroy(){
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
