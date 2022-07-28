package com.OpenCart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.base.BaseTest;
import com.OpenCart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic:Design login page for demo app")
@Story("US1:Develop feature with all login page scenarios")
public class LoginPageTest extends BaseTest{
	
	
	@Description("login Page TitleTest")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void logiPageTitleTest() {
		String title= loginPage.getLoginPageTitle();
		System.out.println("login page title is  : " +title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("login Page url test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=2)
	public void loginPageUrlTest() {
		String url =loginPage.getLoginPageUrl();
		System.out.println("login page url is  : " + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL));
	}
	
	@Description("login Page ForgotPassword linktest")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Description("login Test")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
}
