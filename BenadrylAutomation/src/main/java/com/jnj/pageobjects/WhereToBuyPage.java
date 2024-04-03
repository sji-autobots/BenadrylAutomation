/**
 * @author Goutam Naik
 * @date 27-March-24
 */

package com.jnj.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class WhereToBuyPage extends BaseClass {
	String actualText;

	/**
	 * Constructor
	 */
	public WhereToBuyPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(css = "#content-main")
	private WebElement headingText;

	@FindBy(css = "input[placeholder='Find a specific product']")
	private WebElement specificProductSearchBox;

	@FindBy(css = "span[class='spinner']")
	private WebElement spinner;

	@FindBy(xpath = "//ul[contains(@id,'product-finder-result-listbox')]")
	private WebElement prodResultListbox;

	@FindBy(xpath = "//div[contains(@class,'ps-product-details-title')]/label")
	private WebElement resProductName;

	@FindBy(css = "#__ps-sku-selector-0_0")
	private WebElement categoryDropdown;

	@FindBy(css = "#__ps-sku-selector-2_0")
	private WebElement sizeDropdown;

	@FindBy(css = "#__ps-map-location-textbox_0")
	private WebElement locationInput;

	@FindBy(xpath = "//div[@class='ps-address']/div[1]/div[1]")
	private List<WebElement> addresses;

	private WebElement getOption(String option) {
		return driver.findElement(By.xpath("//li[@role='option']/span[contains(text(),'" + option + "')]"));
	}

	private WebElement getStoreViewbtn(String storeName) {
		return driver.findElement(By.xpath("//button[contains(@aria-label,'" + storeName + "')]"));
	}

	/**
	 * Function to verifyheading on the Where to buy page
	 * 
	 * @param expectedHeader pass expected header
	 */
	public void verifyHeading(String expectedHeader) {
		actualText = headingText.getText().trim();
		expectedHeader = expectedHeader.trim();
		Action.printAndAssert(actualText, expectedHeader);
		BaseClass.extentInfoLog("Succesfully verifed heading : " + actualText);
	}

	public void initiateProductSearch(String productName) {
		Action.explicitWait(specificProductSearchBox, 10);
		Action.performActionwithExtentInfoLog(headingText, "sendKeys", "Sending keys to product search", productName);
	}

	/**
	 * Function to search a product
	 * 
	 * @param productKey pass product name to search
	 */
	public void searchProduct(String productKey) {
		Action.explicitWait(specificProductSearchBox, 20);
		Action.explicitWaitForElementToDisappear(spinner, 20);
		Action.performActionwithExtentInfoLog(specificProductSearchBox, "click", "Clicked inside product searchbox");
		Action.waitFor(2000);
		Action.performActionwithExtentInfoLog(specificProductSearchBox, "sendKeys",
				"Searching for products " + productKey, productKey);
		Action.explicitWait(prodResultListbox, 10);
		Action.performActionwithExtentInfoLog(this.getOption(productKey), "click",
				"Selecting product from listbox : " + productKey);
		Action.explicitWait(resProductName, 10);
		Action.printAndAssert(resProductName.getText().trim(), productKey);
		BaseClass.extentInfoLog("Verifed product name after search to be, '", productKey + "'");
	}

	/**
	 * Function to veriy 'Category' and 'Size' dropdown are displayed
	 */
	public void verifyCategoryAndSize() {
		Assert.assertTrue(categoryDropdown.isDisplayed(), "Category dropdown not displayed");
		BaseClass.extentInfoLog("Category dropdown displayed ");
		Assert.assertTrue(sizeDropdown.isDisplayed(), "Category dropdown not displayed");
		BaseClass.extentInfoLog("Size dropdown displayed ");
	}

	/**
	 * Function to set new category and size value
	 * 
	 * @param category pass category text
	 * @param size     pass size text
	 */
	public void changeProductOptions(String category, String size) {
		if (category != null) {
			Action.explicitWait(categoryDropdown, 10);
			Action.selectByVisibleText(category, categoryDropdown, "Selecting category as " + category);
		}
		Action.waitFor(2000);
		if (size != null) {
			BaseClass.extentInfoLog("Selecting size as : " + size);
			Action.explicitWait(sizeDropdown, 10);
			Action.selectByVisibleText(size, this.sizeDropdown, "Selecting size as " + size);
		}
	}

	/**
	 * Function to verify product name
	 * 
	 * @param productKey pass product name
	 */
	public void verifyProductName(String productKey) {
		Action.waitForTextToAppear(resProductName, productKey, 10);
		Action.explicitWait(resProductName, 10);
		Action.printAndAssert(resProductName.getText().trim(), productKey);
	}

	/**
	 * Function to search for a location
	 * 
	 * @param location pass location text
	 */
	public void searchLocation(String location) {
		Action.explicitWait(locationInput, 10);
		locationInput.clear();
		Action.performActionwithExtentInfoLog(locationInput, "sendKeys", "Entering location as : " + location,
				location);
		Action.pressEnter(driver, locationInput);
	}

	/**
	 * Function to check redirection for stores
	 * 
	 * @param storeName        pass seller name
	 * @param expectedStoreUrl pass expected url
	 */
	public void checkStoreRedirection(String storeName, String expectedStoreUrl) {
		Action.performActionwithExtentInfoLog(getStoreViewbtn(storeName), "jsclick",
				"clicking on " + storeName + " store view button.");
		Action.switchToNewWindow(driver);
		Action.waitUntilUrlContains(expectedStoreUrl, 20);
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains(expectedStoreUrl)) {
			Assert.assertTrue(true);
			BaseClass.extentInfoLog("Assertion success for store : " + storeName);
		} else {
			BaseClass.extentFailLog("Expected url to be , '" + expectedStoreUrl + "'.",
					" But current url is : " + currentUrl);
			Assert.assertTrue(false);
		}
	}

	/**
	 * Function to verify store locations contain the location that is passed
	 * 
	 * @param location pass location name to check for
	 */
	public void verifyAddressesForStores(String location) {
		for (WebElement element : addresses) {
			Action.scrollIntoCenterUsingJS(driver, element);
			String text = element.getText();
			if (!text.isEmpty()) {
				if (text.contains(location)) {
					Assert.assertTrue(true);
					BaseClass.extentInfoLog("Verified store with location : " + text);
				} else {
					BaseClass.extentFailLog("Store not belonging to searched area found : ", text);
					Assert.assertTrue(false);
				}
			}
		}
	}
}
