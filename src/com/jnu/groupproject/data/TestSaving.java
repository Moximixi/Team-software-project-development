package com.jnu.groupproject.data;

import java.sql.Date;

public class TestSaving {
	public static void main(String[] args) {
		FileHelper fh=new FileHelper("./obj.txt");//存到当前文件夹下
		
		Person p=new Person();
		p.setName("张斌");
		p.setSex("男");
		p.setNum(16);
		p.setRoom(3232);
		p.setBirth(new Date(95,5,16));
		fh.saveObjToFile(p);                               //存入person对象
		
		Person person=fh.getObjFromFile();                 //取出person对象
		System.out.println(person.toString());

	}

}
