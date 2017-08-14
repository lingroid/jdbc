package org.qf.study3;

import org.qf.utils.MyDbUtils;

import com.mysql.jdbc.PreparedStatement;

public class C3P0_Test {

	public static void main(String[] args) {
		MyDbUtils.execute("insert into user(name) values('пноС')");
		
	}
	
}
