package org.qf.study4;

import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.qf.utils.C3P0Utils;

public class DbUtils_Test {

	public static void main(String[] args) {
		//创建操作SQL对象
		QueryRunner qr=new QueryRunner(C3P0Utils.ds);
		try {
			//执行非select语句--statement
			qr.update("insert into user(name) values('放学1')");
			//PreparedStatement
			qr.update("insert into user(name) values(?)","放学2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

