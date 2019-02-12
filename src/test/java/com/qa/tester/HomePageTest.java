package com.qa.tester;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.testbase;
import com.msg.ai.qa.pages.*;

public class HomePageTest extends testbase {
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("Userid"), prop.getProperty("password"));
	}
	
	@Test(priority=1, enabled=false)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Select Bot - AI Studio");
	}
	
	@Test(priority=2, enabled=false)
	public void verifyHeaderofThePageTest(){
		boolean flag = homePage.checkheader();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, enabled=true)
	public void selectDesiredBotTest() throws InterruptedException{
		homePage.clickDesiredbot();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
