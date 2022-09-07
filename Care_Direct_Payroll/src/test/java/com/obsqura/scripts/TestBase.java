package com.obsqura.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {

	WebDriver driver;
	
	//from config.properties
	public static Properties prop = null;
	public static void loadConfig() {
        try {
        	//Below line creates an object of Properties called 'prop'
            prop = new Properties();
          //Below line creates an object of FileInputStream called 'ip'. 
          //Give the path of the properties file which you have created
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
                    + "/config.properties");
          //Below line of code will load the property file
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser)
	{
		loadConfig();
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		
			System.setProperty(prop.getProperty("chromedriver"),prop.getProperty("chromedriverlocation"));
			driver= new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(prop.getProperty("firefoxdriver"),prop.getProperty("firefoxdriverlocation"));
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty(prop.getProperty("edgedriver"),prop.getProperty("edgedriverlocation"));
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();
	}
}
