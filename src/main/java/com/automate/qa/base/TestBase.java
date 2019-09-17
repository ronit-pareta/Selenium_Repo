package com.automate.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.automate.qa.util.WebElementListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebElementListener eventListener;
	
	
	public TestBase() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\SeleniumPOM\\src\\main\\java\\com\\automate\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
		public static void initialization(){
			
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "D:\\chromedriver.exe");	
				driver = new FirefoxDriver(); 
			}
			
			//setting listener
			
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebElementListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
		
		
	

	
}
