package org.qf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 数据库连接池*/
public class DBCPUtils {

	//数据库连接池
	public static DataSource ds;
	static{
		//属性集类
		Properties properties=new Properties();
		try {
			//加载配置文件
			properties.load(new FileInputStream("dbcpconfig.properties"));
			//实例化数据库连接池
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
	 * 通过连接池获取连接对象*/
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
