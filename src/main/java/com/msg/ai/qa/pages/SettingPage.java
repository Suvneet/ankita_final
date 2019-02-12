package com.msg.ai.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.testbase;

public class SettingPage extends testbase {
	
	@FindBy(xpath = "//div[@class='settings-heading' and contains(text(),'Users:')]") //Verify user header
	WebElement user_header;
	
	@FindBy(xpath = "//div[@class='top-menus']/ul/li/a[text()='Users']") //Check Users tab
	WebElement users_tab;
	
	@FindBy(xpath = "//div[@class='top-menus']/ul/li/a[text()='Personal']") //Check Personals tab
	WebElement personal_tab;
	
	@FindBy(xpath = "//*[@id=\\\"mainContainer\\\"]/div/div/div/div[1]/div[2]/div/button/child::span") //Add user
	WebElement addUser_tab;
	
	// Initializing the Page factory:
	public SettingPage() {
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public String validateSettingPageTitle(){
		String title = driver.getTitle();
		return title;
	};
	
	public boolean checkUserHeader(){
		return user_header.isDisplayed();
	};
		
	public boolean check_users_tab(){
		return users_tab.isDisplayed();
	};
		
	public boolean check_Personal_tab(){
		return personal_tab.isDisplayed();
	};
	
	public AddUser clickOnAddUser() throws InterruptedException {
		Thread.sleep(3000);
		addUser_tab.click();
		Thread.sleep(3000);
		return new AddUser();
	}
	
}
	