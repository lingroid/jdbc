package org.qf.study3;

import org.junit.Test;
import org.qf.utils.MyDbUtils;

public class DBCP_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDbUtils.execute("insert into user(name) values('���')");
	}
	@Test
	public void test1(){
		MyDbUtils.execute("insert into user(name) values('������')");
	}

}
