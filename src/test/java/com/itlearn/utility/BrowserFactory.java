package com.itlearn.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl) // The return type is Webdriver because when you call this startApplication it will feed some value to driver(variable) mentioned few lines below.
	{
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
	         driver = new ChromeDriver(op); // driver is feeded by the Webdriver return type mentioned with startApplication. 
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
	         driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe");
	         driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser ");
		}

		
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		return driver;

	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
