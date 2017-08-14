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
	//保存属性集信息
	public static void save() {
		//创建对象
		Properties properties=new Properties();
		//设置要保存的内容
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
	//读取属性集信息
	public static void read() {
		Properties properties=new Properties();
		try {
			//从指定的文件中获取内容
			properties.load(new FileInputStream("dbconfig.properties"));
			System.out.println("用户名："+properties.getProperty("username"));
			System.out.println("密码："+properties.getProperty("pass"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
