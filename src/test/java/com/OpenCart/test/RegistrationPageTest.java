package com.OpenCart.test;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OpenCart.base.BaseTest;
import com.OpenCart.utils.Constants;
import com.OpenCart.utils.ExcelUtil;

/**
 * Registeration page Test cases 
 * @author SowmyaBG
 *
 */

public class RegistrationPageTest extends BaseTest{

	
	@BeforeClass
	public void setUpRegister() {
		registPage=loginPage.navigatetoRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		Object regData[][]=ExcelUtil.getSheetData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	public String getRandomGenerator() {
		Random randomGenerator = new Random();
		String email="testautomation1" + randomGenerator.nextInt(1000)+"@gmail.com";
		return email;
	}
	
	@Test(dataProvider="getRegisterData")
	public  void userRegistrationTest(String firstname,String lastname,
										String phone,String password,String	subscribe) {
		Assert.assertTrue(registPage.accountRegistration(firstname,lastname,getRandomGenerator(),
														phone,password,subscribe));
	}
	
}