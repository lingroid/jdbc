package org.qf.entity;

import java.sql.Date;

/**
 * 实体类--对应的数据库表user*/
public class User {

	private int id;
	private String name;
	private String pass;
	private Date lasttime;
	
	public User(int id, String name, String pass, Date lasttime) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.lasttime = lasttime;
	}
	
	public User() {
		super();
	}
	

	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", lasttime=" + lasttime + "]\r\n";
	}
	
	
	
}
