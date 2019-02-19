package com.qa.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.qa.util.TestUtil;

public class testbase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public testbase() {
		try {
			prop = new Properties();
			InputStream ip = this.getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(ip);	
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//@Parameters("browser")
	//@Test
	public static void initialization() throws InterruptedException{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suvneet.Singh\\Downloads\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Suvneet.Singh\\Downloads\\geckodriver.exe");	
			driver = new FirefoxDriver();
		}	
		else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Suvneet.Singh\\Downloads\\IEDriverServer.exe");	
			driver = new InternetExplorerDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
	}
	
	public static void waitForPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	public void failed(String methodname) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try{
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Suvneet.Singh\\eclipse-workspace\\ankita-master\\ankita-master"+"/Failed_screenshot/" + System.currentTimeMillis() +methodname+ ".png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}
	 
}
