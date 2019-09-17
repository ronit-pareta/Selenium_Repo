package com.automate.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automate.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "Chapter1")
	WebElement chapter1Link;
	
	@FindBy(linkText = "Chapter2")
	WebElement chap2Link;
	
	@FindBy(linkText = "Chapter3")
	WebElement chap3Link;
	
	@FindBy(linkText = "Chapter4")
	WebElement chap4Link;
	
	@FindBy(linkText = "Chapter8")
	WebElement chap8Link;
	
	@FindBy(xpath = "//input[@id='q']")
	WebElement inputBox;
	
	public Chapter1 getChapter1() {
		
		chapter1Link.click();
		return new Chapter1();
	}
	public Chapter2 getChapter2() {
		
		chap2Link.click();
		return new Chapter2();
	}
	public Chapter3 getChapter3() {
		
		chap3Link.click();
		return new Chapter3();
	}
	public Chapter4 getChapter4() {
		
		chap4Link.click();
		return new Chapter4();
	}
	
	public Chapter8 getChapter8() {
		
		chap8Link.click();
		return new Chapter8();
	}
	public String getTitle() {
		
		return driver.getTitle();
	}
	public void inputBox(String str) {
		 inputBox.sendKeys(str);
	}
	
	
}
