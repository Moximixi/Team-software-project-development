package com.jnu.groupproject.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 存取数据到文件类
 * */
public class FileHelper {
	private String fileName;
	public FileHelper() {

	}
	public FileHelper(String fileName) {
		this.fileName=fileName;
	}
	//将person对象保存到文件中
	public void saveObjToFile(Person p) {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(p);
			oos.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//文件中读出对象,并且返回Person对象
	public Person getObjFromFile() {
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName));
			Person person=(Person)ois.readObject();
			return person;
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
