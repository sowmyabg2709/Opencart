package com.OpenCart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.base.BaseTest;
import com.OpenCart.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	
	
	@Test(priority=1)
	public void logiPageTitleTest() {
		String title= loginPage.getLoginPageTitle();
		System.out.println("login page title is  : " +title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void loginPageUrlTest() {
		String url =loginPage.getLoginPageUrl();
		System.out.println("login page url is  : " + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL));
	}
	
	@Test(priority=3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
}
