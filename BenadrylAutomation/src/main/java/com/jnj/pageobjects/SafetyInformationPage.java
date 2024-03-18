/**
 * @author Vaibhav Nagvekar
 * @date 15-Mar-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class SafetyInformationPage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public SafetyInformationPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//h1[@id='content-main']")
	WebElement bannerTitle;

	@FindBy(xpath = "//p[contains(text(),'The safety of the people who use our products is o')]")
	WebElement bannerDescription;

	@FindBy(xpath = "(//div[@class='ps-product-details']/h2)[1]")
	WebElement productNameOnBuyNow;

	@FindBy(xpath = "//a[@href='https://www.poison.org/']")
	WebElement poisonControlCenterLink;

	@FindBy(xpath = "//a[normalize-space()='FAQs page']")
	WebElement faqsPageLink;

	@FindBy(xpath = "(//a[@href='/benadryl-dosing-guide'])[2]")
	WebElement dosageLink;

	private WebElement getHeadings(String value) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + value + "']"));
	}

	private WebElement productName(String value) {
		return driver.findElement(By.xpath("//span[@class='node__title']//a[@href='/products/" + value + "']"));
	}

	private WebElement getAges(String value) {
		return driver.findElement(By.xpath("//div[@about='/products/" + value + "']/div/div/div[3]"));
	}

	private WebElement buyNowBtn(String value) {
		return driver.findElement(By.xpath("//a[@href='https://www.benadryl.com/products/" + value + "']"));
	}

	/**
	 * Function to verify url and banner title
	 * 
	 * @param expectedUrl         pass expected URL
	 * @param expectedTitle       pass expected title
	 * @param expectedDescription pass expected description
	 */
	public void verifyUrlAndTitle(String expectedUrl, String expectedTitle, String expectedDescription) {
		Action.verifyPageUrl(expectedUrl);
		String actualBannerTitle = bannerTitle.getText();
		Action.printAndAssert(actualBannerTitle, expectedTitle);
		String actualBannerDescription = bannerDescription.getText();
		Action.printAndAssert(actualBannerDescription, expectedDescription);
	}

	/**
	 * Function to verify links and urls in safety page
	 * 
	 * @param key         pass keyword
	 * @param expectedUrl pass expected URL
	 */
	public void verifyLinks(String key, String expectedUrl) {
		if (key.equalsIgnoreCase("Poison")) {
			Action.explicitWaitForElementTobeclickable(poisonControlCenterLink, 30);
			Action.performActionwithExtentInfoLog(poisonControlCenterLink, "click",
					"Clicking on : " + poisonControlCenterLink.getText());
			Action.switchToNewWindow(driver);
			String actualUrl = driver.getCurrentUrl();
			Action.printAndAssert(actualUrl, expectedUrl);
		} else if (key.equalsIgnoreCase("Faq")) {
			Action.explicitWaitForElementTobeclickable(faqsPageLink, 30);
			Action.performActionwithExtentInfoLog(faqsPageLink, "click", "Clicking on : " + faqsPageLink.getText());
			Action.verifyPageUrl(expectedUrl);
		} else {
			Action.explicitWaitForElementTobeclickable(dosageLink, 30);
			Action.performActionwithExtentInfoLog(dosageLink, "click", "Clicking on : " + dosageLink.getText());
			Action.verifyPageUrl(expectedUrl);
		}
	}

	/**
	 * Function to verify url from related products
	 * 
	 * @param heading         pass heading
	 * @param product         pass product
	 * @param expectedUrl     pass expected Url
	 * @param expectedAges    pass expected Ages
	 * @param expectedProduct pass expected product
	 */
	public void verifyRelatedProducts(String heading, String product, String expectedUrl, String expectedAges,
			String expectedProduct) {
		Action.explicitWait(getHeadings(heading), 30);
		boolean eleDisplayed = getHeadings(heading).isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Related Products header displayed : ", true);
			String actualArticle = getHeadings(heading).getText();
			Action.printAndAssert(actualArticle, heading);
			Action.explicitWait(productName(product), 30);
			Action.performActionwithExtentInfoLog(productName(product), "click",
					"Clicking on : " + productName(product).getText());
			Action.verifyPageUrl(expectedUrl);
			Action.navigateBack();
			extentInfoLog("Navigating back to : ", "Safety page");
			Action.explicitWait(getAges(product), 30);
			String actualAges = getAges(product).getText();
			Action.printAndAssert(actualAges, expectedAges);
			Action.explicitWait(buyNowBtn(product), 30);
			buyNowBtn(product).click();
			extentInfoLog("Clicked on : ", "buy now button");
			signup.closeSignupPopup();
			String actualProduct = productNameOnBuyNow.getText();
			Action.printAndAssert(actualProduct, expectedProduct);
		} else
			extentFailLog("Related Products header displayed : ", false);
	}
}
