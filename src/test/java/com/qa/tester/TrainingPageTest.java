package com.qa.tester;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.msg.ai.qa.pages.HomePage;
import com.msg.ai.qa.pages.LoginPage;
import com.msg.ai.qa.pages.TrainingPage;
import com.qa.base.testbase;

public class TrainingPageTest extends testbase {
	
	LoginPage loginPage;
	HomePage homePage;
	TrainingPage training_page;

	public TrainingPageTest() {
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
	public void TrainingPageTitleTest(){
		String trainingPageTitle = training_page.validateTrainingPageTitle();
		Assert.assertEquals(trainingPageTitle, "Training - AI Studio");
	}
	
	@Test(priority=2, enabled=false)
	public void checkTraingHeaderTest(){
		boolean flag = training_page.checkTraingHeader();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, enabled=true)
	public void clickOnSettingIcon() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"main-navigation\"]/div[*]/ul/li[5]/a")).click();
		Thread.sleep(3000);
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
