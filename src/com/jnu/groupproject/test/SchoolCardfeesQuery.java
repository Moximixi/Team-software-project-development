package com.jnu.groupproject.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.jnu.groupproject.noticeclass.DianFeiQuery;

public class SchoolCardfeesQuery {

	@Test
	public void testSchoolCardfeesQuery()throws Exception,FileNotFoundException,IOException {
		//测试数据2222
		String roomaccount="2222";
		DianFeiQuery dianFei=new DianFeiQuery(roomaccount);
		Assert.assertEquals("106.97",dianFei.getQueryResult());
	}

}
