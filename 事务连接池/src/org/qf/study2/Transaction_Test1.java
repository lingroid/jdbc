package org.qf.study2;

import org.qf.utils.DbHelp;

public class Transaction_Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql1="update b_account set money=money-20,updatetime=now() where name='�ΰ'";
		String sql2="insert into b_log(a_id,money,time,type,msg) values('',-20,now(),3,'ȡǮ')";
		String sql3="update b_account set money=money+20,updatetime=now() where name='����'";
		String sql4="insert into b_log(a_id,money,time,type,msg) values('',20,now(),2,'��Ǯ')";
		DbHelp.execute(sql1,sql2,sql3,sql4);
		DbHelp.close();
	}

}
