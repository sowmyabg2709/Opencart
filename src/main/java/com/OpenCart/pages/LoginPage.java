package com.OpenCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.OpenCart.utils.Constants;
import com.OpenCart.utils.ElementUtil;

import io.qameta.allure.Step;
/**
 * Login page  
 * @author SowmyaBG
 *
 */

public class LoginPage {
	
	private ElementUtil elementUtil;
	private WebDriver driver;
	
	//1.By locators
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit']");
	private By forgotPasswordLink=By.xpath("//div[@class='form-group']/a[text()='Forgotten Password']11");
	private By registerLink = By.linkText("Register");
	private By loginErrorMessage= By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	//2.constructor 	
		public LoginPage(WebDriver driver) {
			this.driver= driver;	
			elementUtil =new ElementUtil(driver);
		} 
		
	//3.public page actions (methods)		
		public String getLoginPageTitle() {
			return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
		}
		
		public String getLoginPageUrl() {
			return elementUtil.getPageUrl();
		}
	
		public boolean isForgotPwdLinkExist() {
			return elementUtil.doISDisplayed(forgotPasswordLink);
		}
		
		public AccountsPage doLogin(String un, String pwd) {
			elementUtil.doSendKeys(username, un);
			elementUtil.doSendKeys(password, pwd);
			elementUtil.doClick(loginButton);
			return new AccountsPage(driver);
		}
		
		@Step("login with username: {0} and password: {1}")
		public boolean  doLoginWrongData(String un,String pwd) {
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return elementUtil.doISDisplayed(loginErrorMessage);
			 
		}
		
		@Step("navigating to register page")
		public RegistrationPage navigatetoRegisterPage() {
			elementUtil.doClick(registerLink);
			return new RegistrationPage(driver);
		}
}
