package org.qf.study1;

import org.qf.utils.DbHelp;

/**创建2个表*/
public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql1="create table if not exists b_Account (id int(8) primary key,name varchar(50),money int,createtime date,updatetime date)";
		String sql2="create table if not exists b_log(id int primary key auto_increment,a_id int(8),money int,msg varchar(50),time date)";
		DbHelp.execute(sql1);
		DbHelp.execute(sql2);
		
	}

}
