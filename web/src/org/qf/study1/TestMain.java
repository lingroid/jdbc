package org.qf.study1;

import org.qf.utils.MyDbUtils;

public class TestMain {

	public static void main(String[] args) {
		String sql= "insert into student (name,age,sex,time)values('Ð¡»ª',34,'b',now())";
		String sql1= "insert into student (name,age,sex,time)values('Ð¡qqg',34,'b',now())";
		MyDbUtils.execute(sql,sql1);
		System.out.println("ok");
		MyDbUtils.close();
		

	}

}
