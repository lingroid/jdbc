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
		//��ȡ�����ļ���Ϣ
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
	//ִ�з�select���
		public static int update(String sql){
			try {
				return stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		//ִ��select���
		public static ResultSet query(String sql){
			try {
				return stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		//���٣��ͷ���Դ
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
