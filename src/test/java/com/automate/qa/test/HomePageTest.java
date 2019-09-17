package com.automate.qa.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
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

public class HomePageTest extends TestBase {
	
	TestUtil testUtil;
	HomePage home;
	Chapter1 chap1;
	Chapter2 chap2;
	Chapter3 chap3;
	Chapter4 chap4;
	Chapter8 chap8;
	String sheetName = "home";
	Logger mylog = LogManager.getLogger(HomePageTest.class.getName());

	public HomePageTest() {
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
	
	@Test(dataProvider = "getSearchBoxData")
	public void testBox(String checkBox) {
		
		home.inputBox(checkBox);
		mylog.info("checking input box");
	}
	
	@Test(priority = 1)
	public void validateTitle() {
		
		String title = home.getTitle();
		Assert.assertEquals(title, "Selenium: Beginners Guide");
	}
	
	@Test(priority = 2,groups = "Chapters")
	public void validateChap1Link() {
		
		chap1 = home.getChapter1();
		
	}
	
	@Test(priority = 3,groups = "Chapters")
	public void validateChap2link() {
		
		chap2 = home.getChapter2();
	}
	
	@Test(priority = 4,groups = "Chapters")
	public void validateChap3Link() {
		
		chap3 = home.getChapter3();
	}
	
	@Test(priority = 5,groups = "Chapters")
	public void validateChap4Link() {
		chap4 = home.getChapter4();
	}
	
	@Test(priority = 6,groups = "Chapters" ,enabled = false)
	public void validateChap8Link() {
		
		chap8 = home.getChapter8();
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
