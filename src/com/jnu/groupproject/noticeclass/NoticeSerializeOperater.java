package com.jnu.groupproject.noticeclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

//序列化执行者
public class NoticeSerializeOperater<T> {
	private  static  final  long serialVersionUID = 1L ;
	public  void save(ArrayList<T> notices,String path) throws FileNotFoundException,IOException { 
	          // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
	        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
	                  new File(path)));
	          oo.writeObject(notices);
	          oo.close();
	   }
	      /**
	       * MethodName: DeserializePerson 
	       */
	public  ArrayList<T> load(String path) throws Exception, IOException {
	    	  ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
	                  new File(path)));
	    	  ArrayList<T> notices = (ArrayList<T>) ois.readObject();
	          return notices;
	      }
	
}

