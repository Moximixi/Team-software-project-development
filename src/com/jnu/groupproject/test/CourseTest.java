package com.jnu.groupproject.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jnu.groupproject.view.Course;

public class CourseTest {
	
	Course course;
    @Before
    public void setUp() throws Exception {  course=new Course();}
    @After
    public void tearDown() throws Exception {   }

    @Test
    public void getSetName() throws Exception {
        String name="团队开发";
        course.setName(name);
        Assert.assertEquals(name, course.getName());
    }
    
    @Test
    public void getSetNum() throws Exception {
        String num="00000011";
        course.setNum(num);
        Assert.assertEquals(num, course.getNum());
    }
    
    @Test
    public void getSetCredit() throws Exception {
        String credit="2";
        course.setCredit(credit);
        Assert.assertEquals(credit, course.getCredit());
    }
    
    @Test
    public void getSetClassTime() throws Exception {
        String classTime="周二 - 6,7节";
        course.setClassTime(classTime);
        Assert.assertEquals(classTime, course.getClassTime());
    }

}
