package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.itlearn.utility.BrowserFactory;
import com.itlearn.utility.ConfigDataProvider;

public class BaseTest {
	public WebDriver driver;
	public ConfigDataProvider config = new ConfigDataProvider();

	// Base test is the class that is created to use the utility package class when required in pages and test.
	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());//From BrowserFactory you will get that start application that means we have to import this BrowserFactory class here.
	// We used these three driver, config.getBrowser, and getStagingURL because in BrowserFactory class we have a method startApplication(which needs these three values.
	}
	// In After class we are calling quitBrowser to close the browser.
 @AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
}
