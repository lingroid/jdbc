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
 * ���ݿ⹤����
 * ʵ�ֶ����ݿ�Ĳ���
 * 1����̬��������
 * 2���������ݿ�
 * 3����ȡ����SQL����
 * 4��ִ��SQL
 * 5����ȡ��ѯ���
 * 6���ͷ���Դ
 * */
public class DbUtils {

	private static String path,url,name,pass;//�ֱ��¼�����ļ���Ϣ
	private static Connection connection;//���ݿ����Ӷ���
	private static Statement statement;//����SQL����
	
	static{
		//��ȡ�����ļ���Ϣ,����������Ϣ��ֵ��ȫ�ֱ���
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		path=rb.getString("path");
		url=rb.getString("url");
		name=rb.getString("name");
		pass=rb.getString("pass");
		try {
			//1����̬��������
			Class.forName(path);
			//2���������ݿ�
			connection=DriverManager.getConnection(url, name, pass);
			//3����ȡ����SQL����
			statement=connection.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ִ��DDL���
	public static boolean executeDDL(String sql) {
		boolean res=false;
		try {
			//ִ��sql���
			statement.execute(sql);
			res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	//ִ��DML��䣬insert��update��delete
	public static boolean executeDML(String sql) {
		boolean res=false;
		try {
			//���ݷ��ص���Ӱ�����������֤�Ƿ�ɹ�
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
	//ִ��DQL��䣬select,���Է�ֹSQLע��
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
	//ִ��DQL��䣬select,���Է�ֹSQLע��
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
	//ִ��DQL��䣬select
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
	//���٣��ͷ���Դ
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
	
	
	
	
	//��ʱ�Ȳ�д
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
