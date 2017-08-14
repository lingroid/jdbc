package org.qf.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {

	//���ݿ����ӳ�
	public static DataSource ds;
	static{
		//ͨ��C3P0ʵ�����ݿ����ӳ�
		ds=new ComboPooledDataSource();
	}
	/**
	 * ��ȡ���Ӷ���
	 * */
	public static Connection getConn() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
