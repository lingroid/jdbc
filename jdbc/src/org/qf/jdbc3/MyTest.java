package org.qf.jdbc3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

public class MyTest {

	//��Ԫ����
	@Test
	public void test1(){
		//ִ�н������
		String sql1="create table if not exists Student(id int primary key auto_increment,name varchar(5) not null,age int,sex varchar(2))";
		if(DbUtils.executeDDL(sql1)){
			System.out.println("����ɹ�");
		}
		//���������������
		Scanner scanner=new Scanner(System.in);
		System.out.println("��ѡ�������1����ѯ2�����");
		int order=scanner.nextInt();
		switch (order) {
			case 1://��ѯ
			{
				String sql2="select * from Student";
				ResultSet rs=DbUtils.executeQuery(sql2);
				try {
					StringBuilder builder=new StringBuilder();
					while (rs.next()) {
						builder.append("��ţ�"+rs.getInt("id"));
						builder.append(" ������"+rs.getString("name"));
						builder.append(" ���䣺"+rs.getInt("age"));
						builder.append(" �Ա�"+rs.getString("sex"));
						builder.append("\r\n");
					}
					System.err.println(builder);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			break;
			case 2://���,��������
			{
				DbUtils.executeDDL("set names gbk");
				String sql3="insert into Student(name,age,sex) values('������',20,'��')";
				if(DbUtils.executeDML(sql3)){
					System.out.println("��ӳɹ�");
				}
			}break;
		}
	}
}
