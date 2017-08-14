package org.qf.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {

	//数据库连接池
	public static DataSource ds;
	static{
		//通过C3P0实现数据库连接池
		ds=new ComboPooledDataSource();
	}
	/**
	 * 获取连接对象
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
