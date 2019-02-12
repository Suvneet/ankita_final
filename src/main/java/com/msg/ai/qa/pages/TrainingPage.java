package com.msg.ai.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.testbase;

public class TrainingPage extends testbase{
	
	@FindBy(xpath = "//h1[text()='Training']") //Verify training header
	WebElement training_header;
	
	//Setting icon xpath
	String setting_icon_xpath = "//*[@id=\\\"main-navigation\\\"]/div[2]/ul/li[5]/a";

	
	// Initializing the Page Objects:
	public TrainingPage() {
		PageFactory.initElements(driver, this);		
	}
	
	
	//Actions
	public String validateTrainingPageTitle(){
		String title = driver.getTitle();
		return title;
	};
	
	public boolean checkTraingHeader(){
		return training_header.isDisplayed();
	};
		
	public SettingPage clickOnSettingIcon() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"main-navigation\"]/div[*]/ul/li[5]/a")).click();
		Thread.sleep(3000);
		return new SettingPage();
	}
	

}
