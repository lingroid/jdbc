package org.qf.study2;

import org.qf.utils.DbHelp;

public class Transaction_Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql1="update b_account set money=money-20,updatetime=now() where name='—Ó≥¨Œ∞'";
		String sql2="insert into b_log(a_id,money,time,type,msg) values('',-20,now(),3,'»°«Æ')";
		String sql3="update b_account set money=money+20,updatetime=now() where name='∂°ª‘'";
		String sql4="insert into b_log(a_id,money,time,type,msg) values('',20,now(),2,'¥Ê«Æ')";
		DbHelp.execute(sql1,sql2,sql3,sql4);
		DbHelp.close();
	}

}
