package com.msg.ai.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.testbase;


public class LoginPage extends testbase{
	
	//Page Factory - OR:
	@FindBy(xpath="//img[@class='img-responsive' and @src='/images/login-graphic.png']")
	WebElement aiLogo;
	
	@FindBy(xpath="//input[@placeholder='Enter Email' and @class='el-input__inner']")
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Enter Password' and @class='el-input__inner']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='el-button btn-submit el-button--default']//span[text()='Log in']")
	WebElement loginBtn;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean validateAiLogo(){
		return aiLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException{;
		email.sendKeys(un);
		Thread.sleep(1500);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		loginBtn.click();	
		Thread.sleep(5000);
		return new HomePage();
	}
}
