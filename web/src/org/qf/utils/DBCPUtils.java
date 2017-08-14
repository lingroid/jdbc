package org.qf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * ���ݿ����ӳ�*/
public class DBCPUtils {

	//���ݿ����ӳ�
	public static DataSource ds;
	static{
		//���Լ���
		Properties properties=new Properties();
		try {
			//���������ļ�
			properties.load(new FileInputStream("dbcpconfig.properties"));
			//ʵ�������ݿ����ӳ�
			ds=BasicDataSourceFactory.createDataSource(properties);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ͨ�����ӳػ�ȡ���Ӷ���*/
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
