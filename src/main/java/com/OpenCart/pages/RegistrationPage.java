package com.OpenCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.OpenCart.utils.Constants;
import com.OpenCart.utils.ElementUtil;

/**
 * Registration page cases 
 * @author SowmyaBG
 *
 */

public class RegistrationPage {

private ElementUtil elementUtil;
	
	//1.By locators	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo  = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	
	private By agree= By.name("agree");
	private By continueButton= By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMessage = By.cssSelector("div#content h1");
	
	private By logoutLink = By.linkText("Logout");
	private By registerLink= By.linkText("Register");
	
	//2.constructor
	public RegistrationPage(WebDriver driver) {
		elementUtil =new ElementUtil(driver);
	}
	
	//3.public page actions (methods)
	public boolean accountRegistration(String firstName,String lastName,
									String email,String phone,
									String password,String subscribe) {
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, phone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equals("yes")) {
			elementUtil.doClick(subscribeYes);
		}else {
			elementUtil.doClick(subscribeNo);
		}
		
		elementUtil.doClick(agree);
		elementUtil.doClick(continueButton);
		String msg=elementUtil.waitForElementVisible(successMessage, 5).getText();
		System.out.println("account creation : " +msg);
		
		if(msg.contains(Constants.REGISTER_SUCCESS_MESSAGE)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}
		return false;
	
}
}