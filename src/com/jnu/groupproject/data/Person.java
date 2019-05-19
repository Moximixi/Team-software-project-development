package com.jnu.groupproject.data;

import java.awt.List;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
/*
 * 个人用户信息类
 * */
public class Person implements Serializable {
	private String name;
	private String sex;
	private int num;//学号
	private int room;//宿舍号
	private int birth;
	public ArrayList webInfo=new ArrayList();
	//序列化id
	private static final long serialVersionUID = -7019320423563420643l;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	
	public String toString(){
		return this.name+" "+this.sex+" "+this.num+" "+this.birth+" "+this.room;
	}

}
