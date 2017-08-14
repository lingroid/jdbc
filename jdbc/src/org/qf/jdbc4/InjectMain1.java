package org.qf.jdbc4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.qf.jdbc3.DbUtils;

/**演示SQL注入*/
public class InjectMain1 {

	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入账号和密码");
		String zh=scanner.nextLine();
		String mm=scanner.nextLine();
		//SQL可以注入
//		String sql="select * from User where userName='"+
//				zh+"' and passWord='"+mm+"'";
//		System.out.println(sql);
//		//普通查询，会有SQL注入的危险
//		ResultSet rs=DbUtils.executeQuery(sql);
		//防止SQL注入
		String sql="select * from User where userName=? and passWord=?";
		//使用集合传递参数
//		ArrayList<String> parmas=new ArrayList<>();
//		parmas.add(zh);
//		parmas.add(mm);
//		ResultSet rs=DbUtils.executeDQL(sql, parmas);
		//使用可变参数传递参数
		ResultSet rs=DbUtils.executeDQL(sql,zh,mm);
		if(rs.next()){
			System.out.println("登陆成功");
		}
		else {
			System.out.println("登陆失败");
		}
		
	}
}
