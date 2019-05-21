package com.jnu.groupproject.test;

import org.junit.Assert;
import org.junit.Test;

public class CalcuateTest {

	@Test
	public void testAdd() {
		Calcuate calcuate = new Calcuate();
		int result = calcuate.add(2, 3);
		Assert.assertEquals("加法有问题", 5, result);
		/*
		 * "加法有问题"：期望值和实际值不一致时，显示的信息
		 * 5 ：期望值
		 * result ：实际值
		 */
	}

	@Test
	public void testSubtract() {
		Calcuate calcuate = new Calcuate();
		int result = calcuate.subtract(12, 2); 
		Assert.assertEquals("减法有问题", 10, result); //故意设置减法期望值为10000
	}

	@Test
	public void testMultiply() {
		Calcuate calcuate = new Calcuate();
		int result = calcuate.multiply(2, 3);
		Assert.assertEquals("乘法有问题", 6, result);
	}

	@Test
	public void testDivide() {
		Calcuate calcuate = new Calcuate();
		int result = calcuate.divide(6, 3);
		Assert.assertEquals("除法有问题", 2, result);
	}

}
