package com.automate.qa.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automate.qa.base.TestBase;
import com.automate.qa.pages.Chapter1;
import com.automate.qa.pages.Chapter2;
import com.automate.qa.pages.Chapter3;
import com.automate.qa.pages.Chapter4;
import com.automate.qa.pages.Chapter8;
import com.automate.qa.pages.HomePage;
import com.automate.qa.util.TestUtil;

public class Chapter1Test extends TestBase {
	

	TestUtil testUtil;
	HomePage home;
	Chapter1 chap1;
	Chapter2 chap2;
	Chapter3 chap3;
	Chapter4 chap4;
	Chapter8 chap8;
	String sheetName = "home";
	Logger mylog = LogManager.getLogger(Chapter1Test.class.getName());
	
	public Chapter1Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		
		testUtil = new TestUtil();
		home = new HomePage();
		chap1 = new Chapter1();
		chap2 = new Chapter2();
		chap3 = new Chapter3();
		chap4 = new Chapter4();
		chap8 = new Chapter8();
	}

	@DataProvider
	public Object[][] getSearchBoxData() {
		
		Object data[][]= testUtil.getTestData(sheetName);	
		mylog.info("initiating browser");
		return data;
	}
	
	@Test
	public void testGit() {
		System.out.println("git is working");
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
