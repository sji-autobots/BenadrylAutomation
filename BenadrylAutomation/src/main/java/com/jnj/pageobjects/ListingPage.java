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

	@FindBy(id = "show-filter")
	private WebElement showFiltersBtn;

	private WebElement getBanner(String text) {
		return driver.findElement(By.xpath("//div[@class='inner']/*[contains(.,'" + text + "')]"));
	}

	private WebElement getQuickFilter(String text) {
		return driver.findElement(By.xpath("//div[@class='filter-row-shortcuts']/a[contains(.,'" + text + "')]"));
	}

	private WebElement getArticle(String text) {
		return driver.findElement(By.xpath("//img[@alt='" + text + "']"));
	}

	private WebElement getFilter(String text) {
		return driver.findElement(By.xpath("//a[contains(.,'" + text + "')]"));
	}

	private WebElement getSubFilter(String text) {
		return driver.findElement(By.xpath("//input//following-sibling::label[contains(@for,'field-product') and contains(.,'" + text + "')]/.."));
	}

	private WebElement getSubFilterCheckbox(String text) {
		return driver.findElement(By.xpath("//input//following-sibling::label[contains(@for,'field-product') and contains(.,'" + text + "')]/../input"));
	}

	public int getNumberOfProducts(String text) {
		Action.explicitWait(getSubFilter(text), 20);
		String subFilterText = getSubFilter(text).getText();
		String productCountString = subFilterText.substring(subFilterText.indexOf("(")+1, subFilterText.indexOf(")"));		
		int numberOfProducts = Integer.parseInt(productCountString);
		
		return numberOfProducts;
	}

	private int numberOfVisibleTiles() {
		return driver.findElements(By.xpath("//div[contains(@class,'views-row') and not(contains(@style,'display'))]")).size();
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
		Assert.assertTrue(bannerImage.isDisplayed());
	}

	/**
	 * Visits a listing page from the homepage. Then, verifies the banner texts in
	 * the listing page.
	 */
	public void verifyBannerTexts(String text) {
		WebElement actualElem = getBanner(text);
		String actualText = actualElem.getText();
		extentInfoLog("Banner heading is displayed : ", Action.isDisplayed(driver, actualElem));
		Action.printAndAssert(actualText, text);
		extentInfoLog("Banner text verified");
	}

	/**
	 * Visits a listing page from the homepage. Then, verifies the filters in the
	 * listing page.
	 */
	public void verifyQuickFilters(String text) {
		WebElement actualElem = getQuickFilter(text);
		String actualText = actualElem.getText();
		Assert.assertTrue(actualElem.isDisplayed());
		Action.performActionwithExtentInfoLog(actualElem, "click", "Clicking on : " + actualText);
		Assert.assertTrue(productsPanel.isDisplayed());
	}

	/**
	 * Visits a listing page from the homepage. Then, verifies the sort by selector
	 * the listing page.
	 */
	public void verifySortBy(String text) {
		Assert.assertTrue(sortBySelector.isDisplayed());
		Action.selectByValue(sortBySelector, text);
		Assert.assertTrue(productsPanel.isDisplayed());
	}

	/**
	 * Visits a listing page from the homepage. Then, verifies the articles
	 */
	public void verifyArticles(String altTxt, String url) {
		WebElement articleElem = getArticle(altTxt);
		Action.performActionwithExtentInfoLog(articleElem, "click", "Clicking on : " + altTxt);
		String actualUrl = Action.getCurrentURL(driver);
		Action.printAndAssert(actualUrl, url);
	}

	/**
	 * Visits a listing page from the homepage. Then, verifies the articles
	 */
	public void verifyFilters(String filterText, String subFilter) {
		Action.performActionwithExtentInfoLog(showFiltersBtn, "click", "Clicking on : Filter button");
		Action.performActionwithExtentInfoLog(getFilter(filterText), "click", "Clicking on : " + getFilter(filterText).getText());
		Action.performActionwithExtentInfoLog(getSubFilterCheckbox(subFilter), "click", "Clicking on : " + getSubFilterCheckbox(subFilter).getText());
		int numberOfProducts = getNumberOfProducts(subFilter);
		int numberOfTiles = numberOfVisibleTiles();
		Action.printAndAssert(numberOfTiles, numberOfProducts);
	}
}
