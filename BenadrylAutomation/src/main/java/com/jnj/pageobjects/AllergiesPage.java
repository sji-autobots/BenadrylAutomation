/**
 * @author Rashi Tiwari
 * @date 21-March-24
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

public class AllergiesPage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public AllergiesPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//div[@class='content-container node node--slide node--full node--slide--full']")
	private WebElement bannerImg;

	@FindBy(css = "h1#content-main")
	private WebElement bannerHeading;

	@FindBy(css = "div.jump-to-wrapper")
	private WebElement headerBanner;

	@FindBy(css = "div.slick-list.draggable")
	private WebElement relatedProduct;

	private WebElement getAllergiesHeader(String name) {
		return driver.findElement(By.xpath("//a[normalize-space()='" + name + "']"));
	}

	private WebElement getAllergiesScroll(String heading) {
		return driver.findElement(By.xpath("//h3[normalize-space()='" + heading + "']"));
	}

	private WebElement getAllergyScroll(String headingScroll) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + headingScroll + "']"));
	}

	private WebElement getRelatedArticleCard(String index) {
		return driver.findElement(By.xpath("(//div[@class='taco-inner'])['" + index + "']"));
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
	 * Verifies if the banner is displayed and checks if the heading matches the
	 * expected heading.
	 * 
	 * @param expectedHeading The expected heading text of the banner.
	 */
	public void verifyBanner(String expectedHeading) {
		extentInfoLog("Banner is displayed : ", Action.isDisplayed(driver, bannerImg));
		String actualHeading = bannerHeading.getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		extentInfoLog("Heading is displayed : ", actualHeading);
	}

	/**
	 * Verifies if the header banner is displayed, clicks on the specified header
	 * element, and checks if the content scrolls to the specified heading.
	 * 
	 * @param name    The name of the header element to click on.
	 * @param heading The heading text to check if content scrolls to.
	 */
	public void verifyHeaderScrolling(String name, String heading) {
		extentInfoLog("Heading banner is displayed : ", Action.isDisplayed(driver, headerBanner));
		Action.performActionwithExtentInfoLog(this.getAllergiesHeader(name), "click",
				"Clicking on : " + getAllergiesHeader(name).getText());
		extentInfoLog("Content Scrolled to : ", Action.isDisplayed(driver, getAllergiesScroll(heading)));
	}

	/**
	 * Verifies if the header banner is displayed, clicks on the specified header
	 * element, and checks if the content scrolls to the specified heading.
	 * 
	 * @param name    The name of the header element to click on.
	 * @param heading The heading text to check if content scrolls to.
	 */
	public void verifySecondHeaderScrolling(String name, String headingScroll) {
		extentInfoLog("Heading banner is displayed : ", Action.isDisplayed(driver, headerBanner));
		Action.performActionwithExtentInfoLog(this.getAllergiesHeader(name), "click",
				"Clicking on : " + getAllergiesHeader(name).getText());
		extentInfoLog("Content Scrolled to : ", Action.isDisplayed(driver, getAllergyScroll(headingScroll)));
	}

	/**
	 * Verifies if the related content card is displayed for the specified index.
	 * 
	 * @param index The index of the related content card to verify.
	 */
	public void verifyRelatedContent(String index) {
		extentInfoLog("Content card is displayed : ", Action.isDisplayed(driver, getRelatedArticleCard(index)));
	}

	/**
	 * Verifies if the related product is displayed.
	 */
	public void verifyRelatedProduct() {
		extentInfoLog("Related Product is displayed : ", Action.isDisplayed(driver, relatedProduct));
	}
}
