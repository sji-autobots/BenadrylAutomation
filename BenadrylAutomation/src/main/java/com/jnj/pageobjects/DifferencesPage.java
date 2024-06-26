/**
 * @author Vaibhav Nagvekar
 * @date 01-Mar-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class DifferencesPage extends BaseClass {

	/**
	 * Constructor
	 */
	public DifferencesPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//h1[@id='content-main']")
	private WebElement bannerTitle;

	@FindBy(xpath = "//span[normalize-space()='Related Content']")
	private WebElement relatedContentHeader;

	@FindBy(xpath = "(//div[@class='ps-product-details']/h2)[1]")
	private WebElement productNameOnBuyNow;

	private WebElement getHeadings(String value) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + value + "']"));
	}

	private WebElement links(String value) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + value + "')]"));
	}

	private WebElement articleName(String value) {
		return driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]"));
	}

	private WebElement readMoreLink(String value) {
		return driver.findElement(
				By.xpath("//a[@href='/benadryl-difference/" + value + "'][normalize-space()='READ MORE']"));
	}

	private WebElement productName(String value) {
		return driver.findElement(By.xpath("//span[@class='node__title']//a[@href='/products/" + value + "']"));
	}

	private WebElement buyNowBtn(String value) {
		return driver.findElement(By.xpath("//a[@href='https://www.benadryl.com/products/" + value + "']"));
	}

	private WebElement getAges(String value) {
		return driver.findElement(By.xpath("//div[@about='/products/" + value + "']/div/div/div[3]"));
	}

	/**
	 * Function to verify url and banner title
	 * 
	 * @param menu          pass menu text
	 * @param expectedUrl   pass expected URL
	 * @param expectedTitle pass expected title
	 */
	public void verifyUrlAndTitle(String menu, String expectedUrl, String expectedTitle) {
		Action.explicitWaitForElementTobeclickable(header.getMenuItem(menu), 30);
		Action.performActionwithExtentInfoLog(header.getMenuItem(menu), "click",
				"Clicking on : " + header.getMenuItem(menu).getText());
		Action.verifyPageUrl(expectedUrl);
		String actualTitle = bannerTitle.getText();
		Action.printAndAssert(actualTitle, expectedTitle);
	}

	/**
	 * Function to verify header and followed links
	 * 
	 * @param menu        pass menu text
	 * @param heading     pass heading
	 * @param link        pass link
	 * @param expectedUrl pass expected URL
	 */
	public void verifyHeadingsAndLinks(String menu, String heading, String link, String expectedUrl) {
		Action.explicitWaitForElementTobeclickable(header.getMenuItem(menu), 30);
		Action.performActionwithExtentInfoLog(header.getMenuItem(menu), "click",
				"Clicking on : " + header.getMenuItem(menu).getText());
		Action.explicitWait(getHeadings(heading), 30);
		boolean eleDisplayed = getHeadings(heading).isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Header displayed : ", true);
			String head = getHeadings(heading).getText();
			Action.printAndAssert(head, heading);
			Action.performActionwithExtentInfoLog(links(link), "click",
					"Clicking on : " + links(link).getText());
			Action.verifyPageUrl(expectedUrl);
		} else
			extentFailLog("Header displayed : ", false);
	}

	/**
	 * Function to verify article links
	 * 
	 * @param menu        pass menu text
	 * @param headerTitle pass header title
	 * @param article     pass article
	 * @param readMore    pass read more link
	 * @param expectedUrl pass expected URL
	 */
	public void verifyArticles(String menu, String headerTitle, String article, String readMore, String expectedUrl) {
		Action.explicitWaitForElementTobeclickable(header.getMenuItem(menu), 30);
		Action.performActionwithExtentInfoLog(header.getMenuItem(menu), "click",
				"Clicking on : " + header.getMenuItem(menu).getText());
		Action.explicitWait(relatedContentHeader, 30);
		boolean eleDisplayed = relatedContentHeader.isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Related Content header displayed : ", true);
			String actualHeader = relatedContentHeader.getText();
			Action.printAndAssert(actualHeader, headerTitle);
			Action.explicitWait(articleName(article), 30);
			String actualArticle = articleName(article).getText();
			Action.printAndAssert(actualArticle, article);
			Action.explicitWait(readMoreLink(readMore), 30);
			Action.performActionwithExtentInfoLog(readMoreLink(readMore), "click",
					"Clicking on : " + readMoreLink(readMore).getText());
			Action.verifyPageUrl(expectedUrl);
		} else
			extentFailLog("Related Content header displayed : ", false);
	}

	/**
	 * Function to verify related product
	 * 
	 * @param menu            pass menu text
	 * @param heading         pass header heading
	 * @param product         pass product
	 * @param expectedUrl     pass expected URL
	 * @param ecpectedAges    pass expected ages
	 * @param expectedProduct pass expected product
	 * 
	 */
	public void verifyRelatedProducts(String menu, String heading, String product, String expectedUrl,
			String expectedAges, String expectedProduct) {
		Action.explicitWaitForElementTobeclickable(header.getMenuItem(menu), 30);
		Action.performActionwithExtentInfoLog(header.getMenuItem(menu), "click",
				"Clicking on : " + header.getMenuItem(menu).getText());
		Action.explicitWait(articleName(heading), 30);
		boolean eleDisplayed = articleName(heading).isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Related Products header displayed : ", true);
			String actualArticle = articleName(heading).getText();
			Action.printAndAssert(actualArticle, heading);
			Action.explicitWait(productName(product), 30);
			Action.performActionwithExtentInfoLog(productName(product), "click",
					"Clicking on : " + productName(product).getText());
			Action.verifyPageUrl(expectedUrl);
			Action.navigateBack();
			extentInfoLog("Navigating back to : ", "Difference page");
			Action.explicitWait(getAges(product), 30);
			String actualAges = getAges(product).getText();
			Action.printAndAssert(actualAges, expectedAges);
			Action.explicitWait(buyNowBtn(product), 30);
			Action.performActionwithExtentInfoLog(buyNowBtn(product), "click",
					"Clicking on : " + buyNowBtn(product).getText());
			Action.waitFor(5000);
			String actualProduct = productNameOnBuyNow.getText();
			Action.printAndAssert(actualProduct, expectedProduct);
		} else
			extentFailLog("Related Products header displayed : ", false);
	}
}
