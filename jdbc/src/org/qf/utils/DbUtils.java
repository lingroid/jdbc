package org.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*���ݿ⹤����
 * һ�㷽�����Ǿ�̬����*/
public class DbUtils {

	private static Connection conn;
	private static Statement stmt;
	//��̬�����
	static{
		//1��ע������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡ���ݿ����Ӷ���
	private static void getConn(String url,String name,String psw){
		try {
			conn=DriverManager.getConnection(url, name, psw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡSQL��������
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
	//��ʼ��
	public static void init(String url,String name,String psw){
		getConn(url, name, psw);
		getSm();
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
