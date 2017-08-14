package org.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * ���ݿ⹤����
 * �ṩ����SQL�ķ���
 * */
public class DbHelp {
	//����ȫ�ֱ�������¼������Ϣ
	private static String path,url,name,pass;
	//��¼���Ӷ���
	private static Connection conn;
	//��¼����SQL����
	private static Statement stmt;
	
	static{
		//��ȡ�����ļ���Ϣ
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		path=rb.getString("driverpath");
		url=rb.getString("dburl");
		name=rb.getString("username");
		pass=rb.getString("pass");
		try {
			//ע������
			Class.forName(path);
			//�������ݿ�
			conn=DriverManager.getConnection(url, name, pass);
			//��ȡ����SQL����
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
	 * Ĭ�Ͽ�������ȷ�����ݵ�������*/
	public static boolean execute(String... sqls) {
		boolean res=false;
		try {
			//��������
			conn.setAutoCommit(false);
			for(int i=0;i<sqls.length;i++){
				stmt.executeUpdate(sqls[i]);
			}
			conn.commit();//�ύ����
			res=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				//�ع�����
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
	 * ִ�з�select��䣬�����ؽ��
	 * @param sql Ҫִ�е�sql���
	 * @return boolean true:�ɹ���false:ʧ��*/
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
	 * ִ��select���,����ֹSQLע��*/
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
	 * ִ��select���,��ֹSQLע��*/
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
	 * �ر���Դ*/
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
