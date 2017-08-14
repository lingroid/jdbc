package org.qf.study3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Test1 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		//Savepoint sp=null;
		//1、导入jar包
		try {
			//2、注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//3、连接数据库
			conn=DriverManager.getConnection(
					"JDBC:mysql://localhost:3306/db_study4?characterEncoding=gbk",
					"root", "root");
			
			//4、获取操作SQL语句的对象
			stmt=conn.createStatement();
			//开启事务
			conn.setAutoCommit(false);
			//sp=conn.setSavepoint();
			//5、执行SQL
			stmt.execute("insert into b_log(a_id,money,msg,type,time) values('',100,'',1,now())");	
			stmt.execute("insert into b_log(a_id,money,msg,type,time) values('',10,'',1,now())");	
			//提交事务
			conn.commit();
			//conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//回滚事务
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			//6、释放资源
			try {
				if(conn!=null){
					conn.close();
				}
				if(stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
}
