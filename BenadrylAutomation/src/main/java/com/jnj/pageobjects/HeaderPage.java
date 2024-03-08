/**
 * @author Goutam Naik
 * @date 07-March-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class HeaderPage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public HeaderPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "(//*[@id='header-search-btn']/span)[1]")
	WebElement searchBtn;

	@FindBy(xpath = "(//*[@id='header-wheretobuy-btn']/a)[1]")
	WebElement whereToBuyBtn;

	@FindBy(xpath = "(//a[contains(@class,'user-locale')])[1]")
	WebElement userLocaleBtn;

	@FindBy(css = "#lightbox_pop")
	WebElement lightBoxFrame;

	@FindBy(css = "#es")
	WebElement espLocaleBtn;

	@FindBy(css = "#en")
	WebElement engLocaleBtn;

	@FindBy(id = "header-search-btn")
	WebElement search;

	@FindBy(id = "edit-apachesolr-panels-search-form")
	WebElement searchinput;

	@FindBy(id = "edit-submit")
	WebElement searchGo;

	@FindBy(xpath = "(//a[text()='English'])[1]")
	WebElement engLink;

	@FindBy(xpath = "(//a[normalize-space()='Email Sign Up & Rewards'])[1]")
	WebElement emailSignUpRewardLink;

	public WebElement getMenuItem(String menu) {
		return driver.findElement(By.xpath("//ul[@role='menubar']/li/*[text()='" + menu + "']"));
	}

	public WebElement getSubMenuItem(String menu, String subMenu) {
		return driver.findElement(By.xpath("//*[text()='" + menu + "']/following-sibling::ul/li/*[text()=\"" + subMenu
				+ "\"] [@role='menuitem']"));
	}

	/**
	 * Function to verify main menu links
	 * 
	 * @param menu        pass menu text
	 * @param expectedUrl pass expected URL
	 */
	public void verifyMainMenuLink(String menu, String expectedUrl) {
		Action.explicitWaitForElementTobeclickable(this.getMenuItem(menu), 20);
		Action.performActionwithExtentInfoLog(this.getMenuItem(menu), "click",
				"Clicking on : " + this.getMenuItem(menu).getText());
		Action.verifyPageUrl(expectedUrl);
	}

	/**
	 * Function to verify sub menu links
	 * 
	 * @param menu        pass menu option
	 * @param subMenu     pass sub menu text
	 * @param expectedUrl pass expected url
	 * @throws InterruptedException
	 */
	public void navigateSubMenuLink(String menu, String subMenu) throws InterruptedException {
		Action.explicitWaitForElementTobeclickable(this.getMenuItem(menu), 20);
		Action.hoverOverElement(driver, this.getMenuItem(menu));
		Action.explicitWaitForElementTobeclickable(getSubMenuItem(menu, subMenu), 20);
		Action.performActionwithExtentInfoLog(getSubMenuItem(menu, subMenu), "click",
				"Clicked on : " + getSubMenuItem(menu, subMenu).getText());
	}

	/**
	 * Function to verify where to buy link
	 * 
	 * @param expectedUrl pass expected url after clicking on where to buy link
	 */
	public void verifyWhereToBuyLink(String expectedUrl) {
		Action.explicitWaitForElementTobeclickable(whereToBuyBtn, 20);
		Action.performActionwithExtentInfoLog(whereToBuyBtn, "click", "Clicked on : " + whereToBuyBtn.getText());
		Action.verifyPageUrl(expectedUrl);
	}

	/**
	 * Function to change app language/locale
	 * 
	 * @param locale      pass desired locale
	 * @param expectedUrl pass expected url
	 */
	public void changeLanguageTo(String locale, String expectedUrl) {
		WebElement ele = null;
		String currentUrl;
		Action.explicitWaitForElementTobeclickable(userLocaleBtn, 20);
		Action.performActionwithExtentInfoLog(userLocaleBtn, "jsclick", "Clicked on : " + userLocaleBtn.getText());
		driver.switchTo().frame(lightBoxFrame);
		Action.explicitWaitForElementTobeclickable(espLocaleBtn, 20);
		if (locale.equalsIgnoreCase("Espanol")) {
			BaseClass.extentInfoLog("Selecting " + locale);
			ele = this.espLocaleBtn;
		} else if (locale.equalsIgnoreCase("English")) {
			BaseClass.extentInfoLog("Selecting " + locale);
			ele = this.engLocaleBtn;
		}
		Action.explicitWaitForElementTobeclickable(ele, 20);
		Action.performActionwithExtentInfoLog(ele, "jsclick", "Selected : " + ele.getText());
		driver.switchTo().defaultContent();
		Action.waitFor(2000);
		currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, expectedUrl,
				"Expected URL to be '" + expectedUrl + "'. But found to be : " + driver.getCurrentUrl());
		BaseClass.extentInfoLog("Verified current url to be : " + currentUrl);
	}

	/**
	 * Function to search from the header based on search criteria
	 * 
	 * @param criteria pass search criteria
	 */
	public void initiateSearch(String criteria) {
		Action.explicitWaitForElementTobeclickable(search, 20);
		Action.performActionwithExtentInfoLog(search, "click", "Clicked on search button");
		Action.explicitWait(searchinput, 10);
		Action.performActionwithExtentInfoLog(searchinput, "sendKeys", "Searching for : " + criteria, criteria);
		Action.performActionwithExtentInfoLog(searchGo, "click", "Clicked on Go");
	}

	/**
	 * Function to click on email sign up in the header
	 */
	public void clickOnEmailSignUp() {
		try {
			Action.explicitWaitForElementTobeclickable(emailSignUpRewardLink, 30);
			Action.performActionwithExtentInfoLog(emailSignUpRewardLink, "click",
					"Clicking on : " + emailSignUpRewardLink.getText());
		} catch (Exception e) {
			Assert.fail("Email Signup & Reward link not displayed");
		}
	}
}
