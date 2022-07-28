package com.OpenCart.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OpenCart.base.BaseTest;

public class LoginNegativeTest extends BaseTest{

	
	@DataProvider()
	public Object [][] loginNegativeData() {
		return new Object [][] {{"test@gmail.com","test123"},
									{"  ", "test45"},
									{"  ", "  "}};
	}
	
	@Test(dataProvider="loginNegativeData")
	public void loginNegativeTest(String un,String pwd) {
		loginPage.doLogin(un, pwd) ;
	}
}
