package org.qf.study5;

import java.sql.SQLException;

import javax.imageio.stream.IIOByteBuffer;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.qf.utils.DBCPUtils;

public class Dbutils_Test {

	private QueryRunner qr=new QueryRunner(DBCPUtils.ds);
	private Object[][] arr={{"����",45},{"����",34},{"��������",12},{"����",36}};
	@Test
	public void update() throws SQLException
	{
		//��������
		qr.update("insert into user1 (name) values('����')");
		qr.update("insert into user1 (name) values(?)","��˯");
		
		//������������Ӷ������
		Object[][] values=new Object[4][2];
		for(int i=0;i<arr.length;i++){
			values[i] = new Object[]{arr[i][0],arr[i][1]};
		}
		
		//������
		qr.batch("insert into user1 (name,age) values(?,?)", arr);
		//ɾ������
		qr.update("delete from user1 where id=?",1);
		//�޸�
		
		qr.update("update user1 set name=? where age=?","123",20);
	}
/*	public void batch(String sql,Object[][] values) throws SQLException {
		for(int i=0;i<values.length;i++){
			qr.update(sql,values[i]);
		}
	}*/
}
