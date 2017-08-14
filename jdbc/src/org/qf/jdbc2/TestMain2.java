package org.qf.jdbc2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.qf.utils.DbHelper;
import org.qf.utils.DbUtils;

public class TestMain2 {

	public static void main(String[] args) {
		//获取查询结果
				ResultSet rs=DbHelper.query("select * from User");
				ArrayList<User> list=new ArrayList<>();
				//将查询结果添加到集合中
				try {
					while(rs.next()){
						User us1=new User();
						us1.setId(rs.getInt("id"));
						us1.setUserName(rs.getString("userName"));
						us1.setPassWord(rs.getString("passWord"));
						list.add(us1);
					}
					//关闭结果集
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//输出结果
				System.out.println(list);
	}

}
