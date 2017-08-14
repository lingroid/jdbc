package org.qf.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


/**
 * 数据库工具类
 * 实现对数据库的操作
 * 1、动态加载驱动
 * 2、连接数据库
 * 3、获取操作SQL对象
 * 4、执行SQL
 * 5、获取查询结果
 * 6、释放资源
 * */
public class DbUtils {

	private static String path,url,name,pass;//分别记录配置文件信息
	private static Connection connection;//数据库连接对象
	private static Statement statement;//操作SQL对象
	
	static{
		//获取配置文件信息,并将配置信息赋值到全局变量
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		path=rb.getString("path");
		url=rb.getString("url");
		name=rb.getString("name");
		pass=rb.getString("pass");
		try {
			//1、动态加载驱动
			Class.forName(path);
			//2、连接数据库
			connection=DriverManager.getConnection(url, name, pass);
			//3、获取操作SQL对象
			statement=connection.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//执行DDL语句
	public static boolean executeDDL(String sql) {
		boolean res=false;
		try {
			//执行sql语句
			statement.execute(sql);
			res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	//执行DML语句，insert、update、delete
	public static boolean executeDML(String sql) {
		boolean res=false;
		try {
			//根据返回的受影响的行数，验证是否成功
			if(statement.executeUpdate(sql)>0)
			{
				res=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	//执行DQL语句，select,可以防止SQL注入
	public static ResultSet executeDQL(String sql,ArrayList<String> params){
		ResultSet rs=null;
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			for(int i=0;i<params.size();i++){
				ps.setString(i+1, params.get(i));
			}
			rs=ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	//执行DQL语句，select,可以防止SQL注入
		public static ResultSet executeDQL(String sql,String... params){
			ResultSet rs=null;
			try {
				PreparedStatement ps=connection.prepareStatement(sql);
				for(int i=0;i<params.length;i++){
					ps.setString(i+1, params[i]);
				}
				rs=ps.executeQuery();
			}catch(Exception e){
				e.printStackTrace();
			}
			return rs;
		}
	//执行DQL语句，select
	public static ResultSet executeQuery(String sql) {
		ResultSet rs=null;
		try {
			rs=statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//销毁，释放资源
	public static void destroy() {
		try {
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	//暂时先不写
	private static ArrayList<HashMap<String, Object>> query(String sql) {
		ArrayList<HashMap<String, Object>> list=new ArrayList<>();
		ResultSet rs=executeQuery(sql);
		try {
			while (rs.next()) {
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
