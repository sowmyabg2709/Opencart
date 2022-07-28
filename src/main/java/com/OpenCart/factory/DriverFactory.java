package com.OpenCart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author SowmyaBG
 *
 */

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	private OptionsManager optionsManager;
	/**
	 * 
	 * @param browserName
	 * this method will return webdriver
	 * @return
	 */
	public static String highlight =null;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	public WebDriver init_driver(Properties prop) {
		
		highlight=prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);
		String browserName=prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions())); 
			//driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));
			//driver = new FirefoxDriver();
		}
		else {
			System.out.println("please pass the correct browser : " +browserName);
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url").trim());
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	/**
	 * 
	 * @return this method will return properties object
	 */
	
	public Properties init_prop() {
		FileInputStream ip=null;
		prop = new Properties();
		
		String env =System.getProperty("env");
		System.out.println("Running on Env :-->" +env);
		
		if(env==null) {
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
			switch (env) {
			case "qa":				
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");			
				break;
			case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
			case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
			default:
				break;
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
		try {
			
			prop.load(ip);
		} catch (FileNotFoundException e) {		
			System.out.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/**Take screenshot method**/
	   public String getScreenshot() {
		File src= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination =new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return path;
	   }


	

}
