package org.qf.jdbc4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.qf.jdbc3.DbUtils;

/**��ʾSQLע��*/
public class InjectMain1 {

	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("�������˺ź�����");
		String zh=scanner.nextLine();
		String mm=scanner.nextLine();
		//SQL����ע��
//		String sql="select * from User where userName='"+
//				zh+"' and passWord='"+mm+"'";
//		System.out.println(sql);
//		//��ͨ��ѯ������SQLע���Σ��
//		ResultSet rs=DbUtils.executeQuery(sql);
		//��ֹSQLע��
		String sql="select * from User where userName=? and passWord=?";
		//ʹ�ü��ϴ��ݲ���
//		ArrayList<String> parmas=new ArrayList<>();
//		parmas.add(zh);
//		parmas.add(mm);
//		ResultSet rs=DbUtils.executeDQL(sql, parmas);
		//ʹ�ÿɱ�������ݲ���
		ResultSet rs=DbUtils.executeDQL(sql,zh,mm);
		if(rs.next()){
			System.out.println("��½�ɹ�");
		}
		else {
			System.out.println("��½ʧ��");
		}
		
	}
}
