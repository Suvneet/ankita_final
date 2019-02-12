package com.qa.tester;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.msg.ai.qa.pages.HomePage;
import com.msg.ai.qa.pages.LoginPage;
import com.msg.ai.qa.pages.SettingPage;
import com.msg.ai.qa.pages.TrainingPage;
import com.qa.base.testbase;

public class SettingPageTest extends testbase{
	
	LoginPage loginPage;
	HomePage homePage;
	TrainingPage training_page;
	TrainingPageTest training_test;
	SettingPage settingpage;
	

	public SettingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("Userid"), prop.getProperty("password"));
		homePage.clickDesiredbot();
	}
	
	
	@Test(priority=1, enabled=false)
	public void SettingPageTitleTest(){
		String trainingPageTitle = settingpage.validateSettingPageTitle();
		Assert.assertEquals(trainingPageTitle, "List of Members - AI Studio");
	}
	
	@Test(priority=2, enabled=false)
	public void checkSettingHeaderTest(){
		boolean flag = settingpage.checkUserHeader();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, enabled=false)
	public void checkUserTabTest(){
		boolean flag = settingpage.check_users_tab();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4, enabled=false)
	public void checkProfileTabTest(){
		boolean flag = settingpage.check_Personal_tab();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=5, enabled=true)
	public void clickOnSettingIcon() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-navigation\"]/div[*]/ul/li[5]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/div/div/div[1]/div[2]/div/button/child::span")).click();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
