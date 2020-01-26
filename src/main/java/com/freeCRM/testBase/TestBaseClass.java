package com.freeCRM.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaseClass {
	
	Properties prop;
	public static WebDriver driver;
	
	public TestBaseClass() throws Exception
	{
		prop = new Properties();
		File file = new File("E:\\Projects\\FreeCRM\\src\\main\\java\\com\\freeCRM\\utils\\config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
	}
	
	public void initialization()
	{
		if(prop.getProperty("browser").equalsIgnoreCase("chrome") )
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
			driver = new ChromeDriver();
		}
		else
			if(prop.getProperty("browser").equalsIgnoreCase("firefox") )
			{
				System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriver"));
				driver = new FirefoxDriver();
			}
		
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
