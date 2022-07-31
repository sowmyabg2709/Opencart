package com.OpenCart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OpenCart.utils.Constants;
import com.OpenCart.utils.ElementUtil;

/**
 * Accounts page cases 
 * @author SowmyaBG
 *
 */

public class AccountsPage {

	 public WebDriver driver;
	 private ElementUtil elementUtil;
	 
	//1.By locators	 
	private By accSections = By.cssSelector("div#content h2");
	private By header = By.xpath("//ul[@class='breadcrumb']//li/following-sibling::li/a");
	private By logoutLink =By.linkText("Logout");
	//private By searchField = By.name("search");
	//private By searchButton = By.cssSelector("div#search button");
	
	//2.constructor 
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//3.public page actions (methods)
	public String getaccountPageTitle() {
		return elementUtil.waitForTitle(5, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	public String getAccountPageURL() {
		return elementUtil.getPageUrl();
	}
	
	public String  getAccountPageHeader() {
		return elementUtil.doGetText(header);
	}
	
	public List<String> getAccountSection() {
		List<String> accSecListVal= new ArrayList<String>();
		List<WebElement> accSecList=elementUtil.waitForVisibilityOfElements(accSections, 5);
		for(WebElement e:accSecList ) {
			accSecListVal.add(e.getText());
		}
		Collections.sort(accSecListVal);
		return accSecListVal;
	}
	
	public boolean isLogoutExist() {
		return elementUtil.doISDisplayed(logoutLink);
	}
	
//	public SearchResultPage doSearch(String productName) {
//		System.out.println("Searching the product : " + productName);
//		elementUtil.doSendKeys(searchField, productName);
//		elementUtil.doClick(searchButton);
//		
//		return new SearchResultPage(driver);		
//		
//	}
	
}
