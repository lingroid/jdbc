package org.qf.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.junit.Test;
import org.qf.entity.User;
import org.qf.utils.C3P0Utils;

public class TestMain1 {
	private QueryRunner qr=new QueryRunner(C3P0Utils.ds);
	
	//@Test
	public void test1() throws SQLException{
		 User user=qr.query(
				"select name,pass from user where name=? and pass=?",
				new ResultSetHandler<User>(){
					@Override
					public User handle(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						if(rs.next()){
							return new User(rs.getString("name"), rs.getString("pass"));
						}
						return null;
					}},
				new Object[]{"ÕÅÈý","123456"});
		 System.out.println(user); 
	}
	//@Test
	public void test2() throws SQLException{
		Object[] arr=qr.query("select * from user ", new ArrayHandler());
		System.out.println(Arrays.toString(arr));
	}
	//@Test
	public void test3() throws SQLException{
		List<Object[]> list=qr.query("select * from user", new ArrayListHandler());
		for(Object[] arr:list){
			System.out.println(Arrays.toString(arr));
		}
	}
	@Test
	public void test4() throws SQLException{
		User user=qr.query("select * from user", new BeanHandler<>(User.class));
		System.out.println(user);
		System.out.println("***************");
	}
	@Test
	public void test5() throws SQLException{
		List<User> list=qr.query("select * from user", new BeanListHandler<>(User.class));
		System.out.println(list);
	}
	@Test
	public void test6() throws SQLException{
		List<Object> list2=qr.query("select name from user",new ColumnListHandler());
		Map<Object, Map<String,Object>> map=qr.query("select * from user",new KeyedHandler("pass"));
		
		
		
		System.out.println(list2);
	}
}
