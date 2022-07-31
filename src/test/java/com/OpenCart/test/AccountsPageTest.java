package com.OpenCart.test;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OpenCart.base.BaseTest;
import com.OpenCart.utils.Constants;

/**
 * Accounts page Test cases 
 * @author SowmyaBG
 *
 */

public class AccountsPageTest extends BaseTest{

	@BeforeClass
	public void accPageSetUp() {
	accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test
	public void accountPageTitleTest() {
		String title=accPage.getaccountPageTitle();
		System.out.println("Accountpage title is " + title);
		Assert.assertEquals(title,Constants.ACCOUNTS_PAGE_TITLE,"Account page title is not correct");
	}
	
	@Test
	public void accPageHeaderTest() {
		String header=accPage.getAccountPageHeader();
		System.out.println("account page header is : " +header);
		Assert.assertEquals(header, Constants.ACCOUNTS_PAGE_HEADER,"Account page header is not correct");		
	}
	
	@Test
	public void accountSectionListTest() {
		List<String> sectList=accPage.getAccountSection();
		sectList.stream().forEach(e->System.out.println(e));
		Collections.sort(Constants.EXP_ACC_SECLIST);
		Assert.assertEquals(sectList, Constants.EXP_ACC_SECLIST);
	}
	
}
