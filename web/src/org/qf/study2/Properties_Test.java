package org.qf.study2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		save();
		read();
	}
	//�������Լ���Ϣ
	public static void save() {
		//��������
		Properties properties=new Properties();
		//����Ҫ���������
		properties.setProperty("username", "root");
		properties.setProperty("pass", "root");
		try {
			properties.store(new FileOutputStream("dbconfig.properties"), "hello");
			System.out.println("OK");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡ���Լ���Ϣ
	public static void read() {
		Properties properties=new Properties();
		try {
			//��ָ�����ļ��л�ȡ����
			properties.load(new FileInputStream("dbconfig.properties"));
			System.out.println("�û�����"+properties.getProperty("username"));
			System.out.println("���룺"+properties.getProperty("pass"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
