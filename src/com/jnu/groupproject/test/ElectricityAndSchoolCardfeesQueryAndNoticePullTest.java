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
	
	@Test
	public void testElectricityfeesQuery() throws Exception,FileNotFoundException,IOException{
		//测试数据2222
		String roomaccount="2222";
		DianFeiQuery dianFei=new DianFeiQuery(roomaccount);
		Assert.assertEquals("106.97",dianFei.getQueryResult());
	}
	
	@Test
	public void testSchoolCardfeesQuery()throws Exception,FileNotFoundException,IOException {
		//测试数据2016052390 960406
		String account="2016052390",password="960406";
		SchoolCardQuery schoolcardquery=new SchoolCardQuery(account,password);
		Assert.assertEquals("37.38元",schoolcardquery.getQueryResult());
	}
	
	
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
		Assert.assertEquals("223",""+collegeDesnotices.size());
	}
	
}
