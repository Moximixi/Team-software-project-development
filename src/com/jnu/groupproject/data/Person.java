package com.jnu.groupproject.data;

import java.io.Serializable;
import java.sql.Date;
/*
 * 个人用户信息类
 * */
public class Person implements Serializable {
	private String name;
	private String sex;
	private int num;//学号
	private int room;//宿舍号
	private int birth;

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
