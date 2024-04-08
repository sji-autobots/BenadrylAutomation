/**
 * @author Vaibhav Nagvekar
 * @date 02-April-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class AllergiesPage extends BaseClass {

	/**
	 * Constructor
	 */
	public AllergiesPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//div[@class='content-container node node--slide node--full node--slide--full']")
	private WebElement bannerImg;

	@FindBy(css = "h1#content-main")
	private WebElement bannerHeading;

	@FindBy(xpath = "//p[contains(text(),'Allergy sufferers have immune systems that mean we')]")
	private WebElement bannerDescription;

	@FindBy(css = "div.jump-to-wrapper")
	private WebElement headerBanner;

	@FindBy(css = "div.slick-list.draggable")
	private WebElement relatedProduct;

	@FindBy(xpath = "//a[normalize-space()='See All Allergy Articles']")
	private WebElement seeAllAllergyArticles;

	@FindBy(xpath = "//h1[@id='content-main']")
	private WebElement articleTitle;

	@FindBy(xpath = "//h2[normalize-space()='References']")
	private WebElement referenceHeader;

	private WebElement getAllergiesHeader(String name) {
		return driver.findElement(By.xpath("//a[normalize-space()='" + name + "']"));
	}

	private WebElement getAllergiesScroll(String value) {
		return driver.findElement(By.xpath("//h3[normalize-space()='" + value + "']"));
	}

	private WebElement getAllergyScroll(String value) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + value + "']"));
	}

	private WebElement getRelated(String value) {
		return driver.findElement(By.xpath("//span[normalize-space()='" + value + "']"));
	}

	private WebElement readMoreLink(String value) {
		return driver.findElement(By.xpath("//span[normalize-space()='" + value + "']/../p[2]/a"));
	}

	private WebElement refLinks(String value) {
		return driver.findElement(By.xpath("(//li[contains(text(),'" + value + "')]/a)[1]"));
	}

	private WebElement getLink(String value) {
		return driver.findElement(By.partialLinkText(value));
	}

	/**
	 * Function to verify url and banner title
	 * 
	 * @param expectedUrl   pass expected URL
	 * @param expectedTitle pass expected title
	 */
	public void verifyUrlAndTitle(String expectedUrl, String expectedTitle) {
		Action.verifyPageUrl(expectedUrl);
		String actualTitle = driver.getTitle();
		Action.printAndAssert(actualTitle, expectedTitle);
	}

	/**
	 * Verifies if the banner is displayed and checks if the heading and description
	 * matches the expected result.
	 * 
	 * @param expectedHeading pass expected heading
	 * @param expectedDesc    pass expected expected description
	 */
	public void verifyBanner(String expectedHeading, String expectedDesc) {
		extentInfoLog("Banner is displayed : ", Action.isDisplayed(driver, bannerImg));
		String actualHeading = bannerHeading.getText();
		Action.printAndAssert(expectedHeading, actualHeading);
		String actualDesc = bannerDescription.getText();
		Action.printAndAssert(actualDesc, expectedDesc);
	}

	/**
	 * Verifies if the header banner is displayed, clicks on the specified header
	 * element, and checks if the content scrolls to the specified heading.
	 * 
	 * @param name            pass jumpto link name
	 * @param expectedHeading pass expected heading
	 */
	public void verifyHeader(String name, String expectedHeading) {
		if (name.equalsIgnoreCase("CAUSES") || name.equalsIgnoreCase("ALLERGY SYMPTOMS")) {
			Action.performActionwithExtentInfoLog(getAllergiesHeader(name), "click",
					"Clicking on : " + getAllergiesHeader(name).getText());
			String actualHeadeing = getAllergyScroll(expectedHeading).getText();
			Action.printAndAssert(actualHeadeing, expectedHeading);
		} else if (name.equalsIgnoreCase("POLLEN ALLERGIES") || name.equalsIgnoreCase("DUST ALLERGIES")
				|| name.equalsIgnoreCase("PET ALLERGIES")) {
			Action.performActionwithExtentInfoLog(getAllergiesHeader(name), "click",
					"Clicking on : " + getAllergiesHeader(name).getText());
			String actualHeadeing = getAllergiesScroll(expectedHeading).getText();
			Action.printAndAssert(actualHeadeing, expectedHeading);
		} else {
			Action.performActionwithExtentInfoLog(getAllergiesHeader(name), "click",
					"Clicking on : " + getAllergiesHeader(name).getText());
			String actualHeadeing = getRelated(expectedHeading).getText();
			Action.printAndAssert(actualHeadeing, expectedHeading);
		}
	}

	/**
	 * Function to verify the links present on the allergies page
	 * 
	 * @param jumpToName            pass jump to link name
	 * @param link pass link
	 * @param expectedUrl pass expected url
	 */
	public void verifyLinks(String jumpToName, String link, String expectedUrl) {
		Action.performActionwithExtentInfoLog(getAllergiesHeader(jumpToName), "click",
				"Clicking on : " + getAllergiesHeader(jumpToName).getText());
		Action.waitFor(2000);
		Action.performActionwithExtentInfoLog(getLink(link), "click", "Clicking on : " + getLink(link).getText());
		//Action.waitFor(2000);
		Action.verifyPageUrl(expectedUrl);
	}

	/**
	 * Function to verify the links present on the allergies page
	 * 
	 * @param jumpToName            pass jump to link name
	 * @param link pass link
	 * @param expectedUrl pass expected url
	 */
	public void verifyArticles(String article, String expectedArticleName) {
		Action.performActionwithExtentInfoLog(seeAllAllergyArticles, "click",
				"Clicking on : " + seeAllAllergyArticles.getText());
		Action.explicitWaitForElementTobeclickable(readMoreLink(article), 30);
		Action.performActionwithExtentInfoLog(readMoreLink(article), "click",
				"Clicking on : " + readMoreLink(article).getText());
		String actualArticleName = articleTitle.getText();
		Action.printAndAssert(actualArticleName, expectedArticleName);
	}

	/**
	 * Function to verify references links
	 * 
	 * @param ref pass references link
	 * @param expectedUrl pass expected url
	 */
	public void verifyReference(String ref, String expectedUrl) {
		String actualHeader = referenceHeader.getText();
		extentInfoLog("Header displayed : " + actualHeader);
		Action.explicitWaitForElementTobeclickable(refLinks(ref), 30);
		Action.performActionwithExtentInfoLog(refLinks(ref), "click", "Clicking on : " + refLinks(ref).getText());
		Action.switchToNewWindow(driver);
		String actualUrl = driver.getCurrentUrl();
		Action.printAndAssert(actualUrl, expectedUrl);
	}
}
