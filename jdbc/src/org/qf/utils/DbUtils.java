package org.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*数据库工具类
 * 一般方法都是静态方法*/
public class DbUtils {

	private static Connection conn;
	private static Statement stmt;
	//静态代码块
	static{
		//1、注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取数据库连接对象
	private static void getConn(String url,String name,String psw){
		try {
			conn=DriverManager.getConnection(url, name, psw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取SQL操作对象
	private static void getSm() {
		if(conn!=null){
			try {
				stmt=conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//初始化
	public static void init(String url,String name,String psw){
		getConn(url, name, psw);
		getSm();
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
