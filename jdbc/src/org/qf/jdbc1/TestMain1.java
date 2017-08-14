package org.qf.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JAVA程序中操作数据库
 * 通过JDBC操作*/
public class TestMain1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//使用JDBC
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、连接数据库
		Connection conn=DriverManager.getConnection(
				"JDBC:mysql://localhost:3306/db_study3",//要连接的数据库的地址
				"root", "root");//用户名和密码
		//3、获取操作SQL对象
		Statement sm=conn.createStatement();
		//4、执行SQL语句
		//创建User表，不存在就创建
		sm.execute("create table if not exists user(id int primary key auto_increment,userName varchar(20) not null,passWord varchar(32))");
		//插入数据
		sm.execute("insert into user(userName,passWord) values('huadong','123456')");
		//查询User表的内容
		//5、获取查询的结果集
		ResultSet rs=sm.executeQuery("select * from user");
		//循环的从结果集中获取查询结果
		while(rs.next()){
			//一般情况索引从0开始，但是此处为二版情况，索引从1开始
			System.out.println("id:"+rs.getInt(1)+"账号："+rs.getString(2)+"密码："+rs.getString(3));
		}
		//6、关闭
		rs.close();
		sm.close();
		conn.close();
	}

}
