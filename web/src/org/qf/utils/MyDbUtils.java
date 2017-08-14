package org.qf.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��װ���ݿ⹤����*/
public class MyDbUtils {

	private static Connection conn;
	private static Statement stmt;
	
	static{
		conn=DBCPUtils.getConn();
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void execute(String... sql) {
		try {
			for(int i = 0;i<sql.length;i++){
				stmt.execute(sql[i]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����Ҫ�ر�
	public static void close() {
		if(stmt!=null){
			try {
				stmt.close();
				conn.close();
				System.out.println("123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//MyDbPool.destroy(conn);
	}
	
}
