package org.qf.jdbc3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

public class MyTest {

	//单元测试
	@Test
	public void test1(){
		//执行建表语句
		String sql1="create table if not exists Student(id int primary key auto_increment,name varchar(5) not null,age int,sex varchar(2))";
		if(DbUtils.executeDDL(sql1)){
			System.out.println("建表成功");
		}
		//创建键盘输入对象
		Scanner scanner=new Scanner(System.in);
		System.out.println("请选择操作：1、查询2、添加");
		int order=scanner.nextInt();
		switch (order) {
			case 1://查询
			{
				String sql2="select * from Student";
				ResultSet rs=DbUtils.executeQuery(sql2);
				try {
					StringBuilder builder=new StringBuilder();
					while (rs.next()) {
						builder.append("序号："+rs.getInt("id"));
						builder.append(" 姓名："+rs.getString("name"));
						builder.append(" 年龄："+rs.getInt("age"));
						builder.append(" 性别："+rs.getString("sex"));
						builder.append("\r\n");
					}
					System.err.println(builder);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			break;
			case 2://添加,中文乱码
			{
				DbUtils.executeDDL("set names gbk");
				String sql3="insert into Student(name,age,sex) values('胡汉三',20,'男')";
				if(DbUtils.executeDML(sql3)){
					System.out.println("添加成功");
				}
			}break;
		}
	}
}
