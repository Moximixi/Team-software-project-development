package com.jnu.groupproject.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.jnu.groupproject.noticeclass.CollegeNotice;
import com.jnu.groupproject.noticeclass.CollegeNoticeOperater;
import com.jnu.groupproject.noticeclass.DianFeiQuery;
import com.jnu.groupproject.noticeclass.NoticeSerializeOperater;
import com.jnu.groupproject.noticeclass.SchoolCardQuery;

public class ElectricityAndSchoolCardfeesQueryAndNoticePullTest {
	/*
	@Test
	public void testElectricityfeesQuery() throws Exception,FileNotFoundException,IOException{
		//测试数据2222
		String roomaccount="";
		DianFeiQuery dianFei=new DianFeiQuery(roomaccount);
		Assert.assertEquals("",dianFei.getQueryResult());
	}
	
	@Test
	public void testSchoolCardfeesQuery()throws Exception,FileNotFoundException,IOException {
		//测试数据2016054250 136159
		String account="",password="";
		SchoolCardQuery schoolcardquery=new SchoolCardQuery(account,password);
		Assert.assertEquals("",schoolcardquery.getQueryResult());
	}
	*/
	
	@Test
	public void testNoticePull()throws Exception,FileNotFoundException,IOException {
		//测试数据  https://rwxy.jnu.edu.cn/11063/list.htm
		//路径
		String collegenoticepath="./src/com/jnu/groupproject/data/collegenotice.dat";
		//声明定义工具类
		CollegeNoticeOperater collegenoticeoperater=new CollegeNoticeOperater();
		//序列化
		NoticeSerializeOperater<CollegeNotice> noticeserializeoperater=new NoticeSerializeOperater<CollegeNotice>();
		//反序列化
		ArrayList<CollegeNotice>  collegeDesnotices=noticeserializeoperater.load(collegenoticepath);
		Assert.assertEquals("",""+collegeDesnotices.size());
	}
	
}
