package com.qa.tester;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.ExtentReportListener.CustomListener;
import com.qa.base.testbase;
import com.msg.ai.qa.pages.*;

@Listeners(CustomListener.class)
public class LoginPageTest extends testbase{
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest(){
		super(); //to call constructor of the class
	} 

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browserName) throws InterruptedException{
		initialization(browserName);
		loginPage = new LoginPage();	
	}
	 

	@Test(priority=1, enabled= false)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Log in - AI Studio");
	}
	
	@Test(priority=2, enabled= true)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateAiLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, enabled= true)
	public void loginTest() throws InterruptedException{
		loginPage.login(prop.getProperty("Userid"), prop.getProperty("password"));
	}
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
