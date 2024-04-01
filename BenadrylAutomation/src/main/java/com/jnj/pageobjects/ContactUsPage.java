/**
 * @author Vaibhav Nagvekar
 * @date 27-Mar-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class ContactUsPage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//h1[@id='content-main']")
	private WebElement title;

	@FindBy(xpath = "//h2[normalize-space()='Frequently Asked Questions']")
	private WebElement header;

	@FindBy(xpath = "//a[@href='https://www.fda.gov/drugs/safe-disposal-medicines/disposal-unused-medicines-what-you-should-know']")
	private WebElement fdaLink;

	@FindBy(xpath = "//a[normalize-space()='dosing guide']")
	private WebElement dosingGuideLink;

	@FindBy(xpath = "//strong[normalize-space()='SEE ALL FAQS']")
	private WebElement faqLink;

	@FindBy(xpath = "//h2[normalize-space()='Stay Connected']")
	private WebElement stayConnectedHeader;

	private WebElement getContact(String value) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + value + "']"));
	}

	private WebElement clickOnSocialMediaLinks(String value) {
		return driver.findElement(By.xpath("//div[@id='main-content']//li[" + value + "]//a"));
	}

	private WebElement clickOnTab(String value) {
		return driver.findElement(By.xpath("//a[@href='#" + value + "']"));
	}

	private WebElement getTabDetails(String value) {
		return driver.findElement(By.xpath("//div[@id='" + value + "']//div[@class='field__item even']"));
	}

	/**
	 * Function to verify url and title
	 * 
	 * @param expectedUrl   pass expected URL
	 * @param expectedTitle pass expected title
	 */
	public void verifyUrlAndTitle(String expectedUrl, String expectedTitle) {
		Action.verifyPageUrl(expectedUrl);
		String actualTitle = title.getText();
		Action.printAndAssert(actualTitle, expectedTitle);
	}

	/**
	 * Function to verify tab and the content inside each tab
	 * 
	 * @param expectedHeader pass expected Header
	 * @param tab            pass expected tab
	 * @param tabDetails     pass tab details
	 */
	public void checkTabs(String expectedHeader, String tab, String tabDetails) {
		Action.explicitWait(header, 30);
		String actualHeader = header.getText();
		Action.printAndAssert(actualHeader, expectedHeader);
		Action.performActionwithExtentInfoLog(clickOnTab(tab), "click", "Clicking on : " + clickOnTab(tab).getText());
		Action.waitFor(2000);
		String actualTabdetails = getTabDetails(tab).getText();
		Action.printAndAssert(actualTabdetails, tabDetails);
	}

	/**
	 * Function to verify links inside the tab
	 * 
	 * @param tab         pass expected tab
	 * @param expectedUrl pass expected Url
	 */
	public void checkTabLinks(String tab, String expectedUrl) {
		Action.performActionwithExtentInfoLog(clickOnTab(tab), "click", "Clicking on : " + clickOnTab(tab).getText());
		if (tab.equalsIgnoreCase("can-i-use-benadryl-past-the-expiration-date")) {
			Action.explicitWaitForElementTobeclickable(fdaLink, 30);
			Action.performActionwithExtentInfoLog(fdaLink, "click", "Clicking on : " + fdaLink.getText());
			Action.switchToNewWindow(driver);
			String actualUrl = driver.getCurrentUrl();
			Action.printAndAssert(actualUrl, expectedUrl);
		} else {
			Action.explicitWaitForElementTobeclickable(dosingGuideLink, 30);
			Action.performActionwithExtentInfoLog(dosingGuideLink, "click",
					"Clicking on : " + dosingGuideLink.getText());
			String actualUrl = driver.getCurrentUrl();
			Action.printAndAssert(actualUrl, expectedUrl);
		}
	}

	/**
	 * Function to verify "SEE ALL FAQS" link
	 * 
	 * @param expectedUrl pass expected Url
	 */
	public void verifyFaq(String expectedUrl) {
		Action.performActionwithExtentInfoLog(faqLink, "click", "Clicking on : " + faqLink.getText());
		Action.verifyPageUrl(expectedUrl);
	}

	/**
	 * Function to verify contact heading
	 * 
	 * @param con pass contact text
	 */
	public void verifyContactDetails(String con) {
		Action.explicitWait(getContact(con), 30);
		String actualHeader = getContact(con).getText();
		Action.printAndAssert(actualHeader, con);
	}

	/**
	 * Function to verify stay connected - social media links
	 * 
	 * @param expectedHeader pass expected Header
	 * @param link           pass link
	 * @param expectedUrl    pass expected Url
	 */
	public void verifyStayConnectedlinks(String expectedHeader, String link, String expectedUrl) {
		Action.explicitWait(stayConnectedHeader, 30);
		String actualHeader = stayConnectedHeader.getText();
		Action.printAndAssert(actualHeader, expectedHeader);
		Action.explicitWaitForElementTobeclickable(clickOnSocialMediaLinks(link), 30);
		Action.performActionwithExtentInfoLog(clickOnSocialMediaLinks(link), "click",
				"Clicking on : " + clickOnSocialMediaLinks(link).getText());
		Action.switchToNewWindow(driver);
		String actualUrl = driver.getCurrentUrl();
		Action.printAndAssert(actualUrl, expectedUrl);
	}
}
