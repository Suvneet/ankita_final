package com.msg.ai.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.testbase;

public class HomePage extends testbase {
	
	
	//Xpath path of BOT: 
	String starting_xpath ="//*[@id=\"mainContainer\"]/div/section/main/div/div/div[2]/div[2]/div/div/div[*]/div/div/div[2]/child::h2[text()='";
	String botname= prop.getProperty("botname");
	String ending_xpath ="']/parent::div/button/span[text()='Select Bot']";
	String select_bot_xpath = starting_xpath+botname+ending_xpath;
	
	@FindBy(xpath = "//h1[text()='Select Your Account']") //Verify "Select your account header"
	WebElement select_account_header;
	
	@FindBy(xpath="//p[contains(text(),'Go ahead and select the Bot you’d like to view, modify, train or play with!')]")
	WebElement logo;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public String validateHomePageTitle(){
		String title = driver.getTitle();
		return title;
	};
		
	public boolean checkheader() {
		 return select_account_header.isDisplayed();
	}
	
	public TrainingPage clickDesiredbot() throws InterruptedException {
		Thread.sleep(2000);
		WebElement select_bot = driver.findElement(By.xpath(select_bot_xpath));
		//Thread.sleep(1000);
		select_bot.click();
		Thread.sleep(5000);
		return new TrainingPage();
	}
	
	
	
	
	

		

}
