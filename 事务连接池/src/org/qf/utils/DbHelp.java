package org.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 数据库工具类
 * 提供操作SQL的方法
 * */
public class DbHelp {
	//声明全局变量，记录配置信息
	private static String path,url,name,pass;
	//记录连接对象
	private static Connection conn;
	//记录操作SQL对象
	private static Statement stmt;
	
	static{
		//获取配置文件信息
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		path=rb.getString("driverpath");
		url=rb.getString("dburl");
		name=rb.getString("username");
		pass=rb.getString("pass");
		try {
			//注册驱动
			Class.forName(path);
			//连接数据库
			conn=DriverManager.getConnection(url, name, pass);
			//获取操作SQL对象
			stmt=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * 默认开启事务，确保数据的完整性*/
	public static boolean execute(String... sqls) {
		boolean res=false;
		try {
			//开启事务
			conn.setAutoCommit(false);
			for(int i=0;i<sqls.length;i++){
				stmt.executeUpdate(sqls[i]);
			}
			conn.commit();//提交事务
			res=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				//回滚事务
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 执行非select语句，并返回结果
	 * @param sql 要执行的sql语句
	 * @return boolean true:成功，false:失败*/
	public static boolean execute(String sql) {
		boolean res=false;
		try {
			stmt.execute(sql);
			res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 执行select语句,不防止SQL注入*/
	public static ResultSet query(String sql) {
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 执行select语句,防止SQL注入*/
	public static ResultSet query(String sql,String... values) {
		ResultSet rs=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			for(int i=0;i<values.length;i++){
				ps.setString(i+1, values[i]);
			}
			rs=ps.executeQuery();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 关闭资源*/
	public static void close() {
		try {
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
