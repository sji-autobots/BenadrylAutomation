/**
 * @author Zahin Ahad
 * @date 4-March-24
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

public class ListingPage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public ListingPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(css = "#tab-menu-8651")
	private WebElement prodHeaderMenu;

	@FindBy(css = "#file-926 img")
	private WebElement bannerImage;

	@FindBy(css = ".inner > #content-main")
	private WebElement bannerHeading;

	@FindBy(css = ".inner p")
	private WebElement bannerSubHeading;

	@FindBy(css = "[data-value='56']")
	private WebElement adultOralQuickFilter;

	@FindBy(css = "[data-value='711']")
	private WebElement adultTopicalQuickFilter;

	@FindBy(css = "[data-value='61']")
	private WebElement kidsProdQuickFilter;

	@FindBy(xpath = "//div[@id='onetrust-close-btn-container']")
	private WebElement closePrivacyBtn;

	@FindBy(css = ".main-row .three-quarters")
	private WebElement productsPanel;

	@FindBy(id = "edit-sort-by")
	private WebElement sortBySelector;

	@FindBy(css = ".sfmc-careclub-lightbox-close")
	private WebElement closeSignUpBtn;

	private WebElement getBanner(String text) {
		return driver.findElement(By.xpath("//div[@class='inner']/*[contains(.,'" + text + "')]"));
	}

	private WebElement getFilter(String text) {
		return driver.findElement(By.xpath("//div[@class='filter-row-shortcuts']/a[contains(.,'" + text + "')]"));
	}

	/**
	 * Function to click on close privacy pop-up button
	 */
	public void closePrivacyPopup() {
		Action.explicitWaitForElementTobeclickable(closePrivacyBtn, 30);
		boolean eleDisplayed = closePrivacyBtn.isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Privacy pop-up displayed : ", true);
			Action.performActionwithExtentInfoLog(closePrivacyBtn, "click", "Clicking on : Close button");
		} else
			extentFailLog("Privacy pop-up displayed : ", false);
	}

	/**
	 * Function to click on close sign up pop-up button
	 */
	public void closeSignupPopup() {
		Action.explicitWaitForElementTobeclickable(closeSignUpBtn, 30);
		boolean eleDisplayed = closeSignUpBtn.isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Privacy pop-up displayed : ", true);
			Action.performActionwithExtentInfoLog(closeSignUpBtn, "click", "Clicking on : Close button");
		} else
			extentFailLog("Signup pop-up displayed : ", false);
	}

	/**
	 * Visits a product listing page from the homepage.
	 */
	public void visitPLP() {
		Action.performActionwithExtentInfoLog(prodHeaderMenu, "click", "Clicking on : " + prodHeaderMenu.getText());
	}

	/**
	 * Visits a listing page from the homepage. Then, verifies the banner image in
	 * the listing page.
	 */
	public void verifyBannerImage() {
		this.visitPLP();
		extentInfoLog("Image is displayed : ", Action.isDisplayed(driver, bannerImage));
	}

	/**
	 * Visits a listing page from the homepage. Then, verifies the banner texts in
	 * the listing page.
	 */
	public void verifyBannerTexts(String text) {
		this.visitPLP();
		WebElement actualElem = getBanner(text);
		String actualText = actualElem.getText();
		extentInfoLog("Banner heading is displayed : ", Action.isDisplayed(driver, actualElem));
		Assert.assertEquals(actualText, text);
		extentInfoLog("Banner text verified");
	}

	/**
	 * Visits a listing page from the homepage. Then, verifies the filters in the
	 * listing page.
	 */
	public void verifyQuickFilters(String text) {
		this.visitPLP();
		WebElement actualElem = getFilter(text);
		String actualText = actualElem.getText();
		extentInfoLog("Filter text is displayed : ", Action.isDisplayed(driver, actualElem));
		Action.performActionwithExtentInfoLog(actualElem, "click", "Clicking on : " + actualText);
		extentInfoLog("Products are displayed : ", Action.isDisplayed(driver, productsPanel));
	}

	/**
	 * Visits a listing page from the homepage. Then, verifies the sort by selector
	 * the listing page.
	 */
	public void verifySortBy(String text) {
		this.visitPLP();
		extentInfoLog("Sort by displayed : ", Action.isDisplayed(driver, sortBySelector));
		Action.selectByValue(sortBySelector, text);
		extentInfoLog("Products are displayed : ", Action.isDisplayed(driver, productsPanel));
	}
}
