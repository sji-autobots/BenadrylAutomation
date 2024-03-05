/**
 * @author Rashi Tiwari
 * @date 1-March-24
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

public class HomePage extends BaseClass{
	Actions actions;

	/**
	 * Constructor
	 */
	public HomePage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(css = "#file-871")
	WebElement bannerImg;

	@FindBy(xpath = "//a[@class='btn btn-secondary-inverted']")
	WebElement learnMoreBtn;

	@FindBy(css = "h1#content-main")
	WebElement bannerHeading;

	@FindBy(xpath = "//p//a[@href='/products']")
	WebElement allPdctBtn;

	@FindBy(xpath = "(//span[@class='h2'])[1]")
	WebElement bestSellerHeading;

	@FindBy(css = "div.related-content-carousel-container-slick")
	WebElement bestSellerPdct;

	@FindBy(xpath = "(//span[@class='h2'])[2]")
	WebElement relatedContent;

	@FindBy(xpath = "(//h2)[5]")
	WebElement moreOnSectn;

	public WebElement getSection(String index) {
		return driver.findElement(By.xpath("(//h2)['" + index + "']"));
	}

	public WebElement getRelatedContentCard(String index) {
		return driver.findElement(By.xpath("(//a[normalize-space()='READ MORE'])['" + index + "']"));
	}

	public WebElement getPdct(String productName) {
		return driver.findElement(By.xpath("//img[@alt='" + productName + "']"));
	}

	public WebElement getAllergiesSection(String name) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + name + "']"));
	}

	public WebElement getAllergiesLearnMore(String sectionBtn) {
		return driver.findElement(By.xpath("//a[@href='" + sectionBtn + "'][normalize-space()='LEARN MORE']"));
	}

	public WebElement moreOnSectn(String name) {
		return driver.findElement(By.xpath("//a[normalize-space()='" + name + "']"));
	}

	/**
	 * Verifies the home banner by checking the displayed banner image, heading, and Learn More button.
	 * Then, clicks on the Learn More button and verifies the resulting page URL.
	 *
	 * @param expectedHeading The expected heading of the home banner.
	 * @param expectedUrl The expected URL after clicking the Learn More button.
	 */
	public void verifyHomeBanner(String expectedHeading, String expectedUrl) {
		extentInfoLog("Banner is displayed : ",Action.isDisplayed(driver, bannerImg));
		String actualHeading = bannerHeading.getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		extentInfoLog("Heading is displayed : ",actualHeading);
		Action.explicitWaitForElementTobeclickable(this.learnMoreBtn, 10);
		Action.performActionwithExtentInfoLog(this.learnMoreBtn, "click",
				"Clicking on : " + learnMoreBtn.getText());
		Action.verifyPageUrl(expectedUrl);
		extentInfoLog("URL Verified : ", baseURI+expectedUrl);
	}

	/**
	 * Verifies the Our Products section by checking the displayed section, heading,
	 * clicking on a specific product, and verifying its URL.
	 *
	 * @param index The index of the Our Products section.
	 * @param expectedHeading The expected heading of the Our Products section.
	 * @param expectedUrl The expected URL after clicking on "All Products".
	 * @param productName The name of the specific product to click on.
	 * @param pdctURL The expected URL after clicking on the specific product.
	 */
	public void verifyOurProducts(String index, String expectedHeading, String expectedUrl, String productName, String pdctURL) {
		extentInfoLog("Section is displayed : ",Action.isDisplayed(driver,this.getSection(index)));
		String actualHeading = this.getSection(index).getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		extentInfoLog("Heading is displayed : ",actualHeading);
		Action.performActionwithExtentInfoLog(this.allPdctBtn, "click",
				"Clicking on : " + allPdctBtn.getText());
		Action.verifyPageUrl(expectedUrl);
		extentInfoLog("URL Verified : ", baseURI+pdctURL);
		Action.navigateBack();	
		Action.performActionwithExtentInfoLog(this.getPdct(productName), "click",
				"Clicking on : " + productName);
		Action.verifyPageUrl(pdctURL);
		Action.navigateBack();
	}

	/**
	 * Verifies the Best Seller section by checking the displayed section, heading,
	 * and the presence of products within the Best Seller section.
	 *
	 * @param expectedHeading The expected heading of the Best Seller section.
	 */
	public void verifyBestSeller(String expectedHeading) {
		extentInfoLog("Bestseller Section is displayed : ",Action.isDisplayed(driver,this.bestSellerHeading));
		String actualHeading = this.bestSellerHeading.getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		extentInfoLog("Heading is displayed : ",actualHeading);
		extentInfoLog("Products are displayed : ",Action.isDisplayed(driver,this.bestSellerPdct));
	}

	/**
	 * Verifies the Related Content section by checking the displayed section, heading,
	 * clicking on a specific content card, and verifying the resulting page URL.
	 *
	 * @param expectedHeading The expected heading of the Related Content section.
	 * @param index The index of the content card to click on.
	 * @param expectedUrl The expected URL after clicking on the content card.
	 */
	public void verifyRelatedContent(String expectedHeading, String index, String expectedUrl) {
		extentInfoLog("Related Content Section is displayed : ",Action.isDisplayed(driver,this.relatedContent));
		String actualHeading = this.relatedContent.getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		Action.performActionwithExtentInfoLog(this.getRelatedContentCard(index), "click",
				"Clicking on : " + getRelatedContentCard(index).getText());
		Action.verifyPageUrl(expectedUrl);
		extentInfoLog("URL Verified : ", baseURI+expectedUrl);
	}

	/**
	 * Verifies the Allergy Section by checking the displayed section, heading,
	 * clicking on the "Learn More" button, and verifying the resulting page URL.
	 * After verification, it navigates back to the previous page.
	 *
	 * @param sectionName The name or identifier of the Allergy Section.
	 * @param expectedHeading The expected heading of the Allergy Section.
	 * @param sectionBtn The identifier or information to locate the "Learn More" button.
	 * @param expectedUrl The expected URL after clicking on the "Learn More" button.
	 */
	public void verifyAllergySection(String sectionName, String expectedHeading,String sectionBtn, String expectedUrl) {
		extentInfoLog("Allergy Section is displayed : ",Action.isDisplayed(driver,this.getAllergiesSection(sectionName)));
		String actualHeading = this.getAllergiesSection(sectionName).getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		Action.performActionwithExtentInfoLog(this.getAllergiesLearnMore(sectionBtn), "click",
				"Clicking on : " + getAllergiesLearnMore(sectionBtn).getText());
		Action.verifyPageUrl(expectedUrl);
		extentInfoLog("URL Verified : ", baseURI+expectedUrl);
		Action.navigateBack();
	}

	/**
	 * Verifies the "More on Benadryl" Section by checking the displayed section, heading,
	 * clicking on a specific product in the section, and verifying the resulting page URL.
	 * After verification, it navigates back to the previous page.
	 *
	 * @param expHeading The expected heading of the "More on Benadryl" Section.
	 * @param pdctName The name or identifier of the product to click on in the section.
	 * @param expURL The expected URL after clicking on the specified product.
	 */
	public void moreOnSection(String expHeading,String pdctName, String	expURL) {
		extentInfoLog("More on Benadryl Section is displayed : ",Action.isDisplayed(driver,this.moreOnSectn));
		String actualHeading = this.moreOnSectn.getText();
		Assert.assertEquals(actualHeading, expHeading);
		Action.performActionwithExtentInfoLog(this.moreOnSectn(pdctName), "click",
				"Clicking on : " + moreOnSectn(pdctName).getText());
		Action.verifyPageUrl(expURL);
		extentInfoLog("URL Verified : ", baseURI+expURL);
		Action.navigateBack();
	}
}
