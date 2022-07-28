package com.OpenCart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.OpenCart.factory.DriverFactory;
import com.OpenCart.pages.AccountsPage;
import com.OpenCart.pages.LoginPage;
import com.OpenCart.pages.RegistrationPage;

public class BaseTest {

	DriverFactory df;
	public WebDriver driver ;
	public Properties prop;
	
	public LoginPage loginPage;
	public AccountsPage accPage;
	public RegistrationPage registPage;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop=df.init_prop();
		driver =df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	
}
