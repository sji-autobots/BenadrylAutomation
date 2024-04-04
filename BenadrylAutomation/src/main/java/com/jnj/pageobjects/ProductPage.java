/**
 * @author Zahin Ahad
 * @date 4-March-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class ProductPage extends BaseClass {

	/**
	 * Constructor
	 */
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(css = "#tab-menu-8651")
	private WebElement prodHeaderMenu;

	@FindBy(css = "[itemprop='name'] > #node-title-url-386")
	private WebElement prodTileTitle;

	@FindBy(css = "[alt='BENADRYL® Allergy ULTRATABS® Tablets']")
	private WebElement prodImg;

	@FindBy(css = "#content-main")
	private WebElement prodTitle;

	@FindBy(css = ".bv_ratings_summary")
	private WebElement prodRating;

	@FindBy(css = ".bv_ratings_summary > [itemprop='ratingValue']")
	private WebElement prodRatingNum;

	@FindBy(css = ".inside > .pane-node-body")
	private WebElement prodOverview;

	@FindBy(css = ".inside > .pane-node-body > div > div > div > p:nth-child(1)")
	private WebElement prodOverviewTxt;

	@FindBy(css = ".bv_war_button")
	private WebElement writeAReviewBtn;

	@FindBy(css = ".zZXQY")
	private WebElement writeAReviewModal;

	@FindBy(xpath = "//div[@id='mini-panel-product_header']//button[@aria-label='Find where to buy this product']")
	private WebElement buyNowBtn;

	@FindBy(css = ".ps-wtb")
	private WebElement buyNowModal;

	@FindBy(xpath = "//h2[normalize-space()='Benadryl Allergy Ultratabs Tablets, 48 Count']")
	private WebElement buyNowModalHeading;

	@FindBy(css = ".jump-to-title")
	private WebElement jumpToTitle;

	@FindBy(css = "[href=\"#product-overview\"] > h2")
	private WebElement prodOverviewHeading;

	@FindBy(css = ".pane-node-field-product-directions")
	private WebElement directionSection;

	@FindBy(css = ".pane-node-field-product-directions h2")
	private WebElement directionHeading;

	@FindBy(id = "mini-panel-product_ingredients_modal")
	private WebElement ingredientsSection;

	@FindBy(css = "#mini-panel-product_ingredients_modal h2")
	private WebElement ingredientsHeading;

	@FindBy(css = "li #used-for")
	private WebElement usedForSection;

	@FindBy(id = "tab_used-for")
	private WebElement usedForHeading;

	@FindBy(css = "li #warnings")
	private WebElement warningsSection;

	@FindBy(id = "tab_warnings")
	private WebElement warningsHeading;

	@FindBy(id = "mini-panel-product_faq")
	private WebElement faqsSection;

	@FindBy(css = "#mini-panel-product_faq span")
	private WebElement faqsHeading;

	@FindBy(css = "#bv-product-reviews")
	private WebElement reviewsSection;
	
	/**
	 * Returns the WebElement of a 'Jump To' heading based on its text.
	 *
	 * @param headingText The text of the 'Jump To' heading.
	 * @return WebElement The WebElement of the specified 'Jump To' heading.
	 */
	public WebElement getProductName(String path) { 
		 return	 driver.findElement(By.xpath("//span[@class='node__title']//a[@href='/products/" + path + "']"));
	}
	
	/**
	 * Returns the WebElement of a 'Jump To' heading based on its text.
	 *
	 * @param headingText The text of the 'Jump To' heading.
	 * @return WebElement The WebElement of the specified 'Jump To' heading.
	 */
	public WebElement getJumpToHeadings(String headingText) { 
		 return	 driver.findElement(By.xpath("//div[@class='jump-to-wrapper']//ul//li//a[text()='" + headingText + "']"));
	}
	
	/**
	 * Returns the WebElement of the Write a Review modal.
	 */
	public WebElement getWriteAReviewHeading() { 
		 return	 driver.findElement(By.id("shadow-root")).getShadowRoot().findElement(By.cssSelector("#bv-ips-loading-text_bv-ips-title > span.ips__sc-r8pfgm-3.fINXNs"));
	}
	
	/**
	 * Navigates to a product detail page from the homepage by clicking on the product header menu 
	 * and a specific product title.
	 * 
	 * @param link of the product url
	 */
	public void visitDetailsPage(String path) {
	    Action.performActionwithExtentInfoLog(prodHeaderMenu, "click", "Clicking on : " + prodHeaderMenu.getText());
	    Action.performActionwithExtentInfoLog(getProductName(path), "click", "Clicking on : " + prodTileTitle.getText());
	    Action.verifyPageUrl("products/" + path);
	}
	
	/**
	 * Navigates to a product detail page from the homepage by clicking on the product header menu 
	 * and a specific product title.
	 */
	public void visitPDP() {
	    Action.performActionwithExtentInfoLog(prodHeaderMenu, "click", "Clicking on : " + prodHeaderMenu.getText());
	    Action.performActionwithExtentInfoLog(prodTileTitle, "click", "Clicking on : " + prodTileTitle.getText());
	}

	/**
	 * Verifies that the product image is visible on the product detail page.
	 */
	public void verifyProdImage() {
//	    this.visitPDP();
	    extentInfoLog("Image is displayed : ", Action.isDisplayed(driver, prodImg));
	}

	/**
	 * Verifies that the product title is visible on the product detail page.
	 * @param expectedTitle The text expected to be found on the title of the product page.
	 */
	public void verifyProdTitle(String expectedTitle) {
	    this.visitPDP();
	    String actualText = prodTitle.getText();
	    Action.printAndAssert(actualText, expectedTitle);
	    extentInfoLog("Title is displayed : ", Action.isDisplayed(driver, prodTitle));
	}

	/**
	 * Verifies that the product rating is visible on the product detail page.
	 */
	public void verifyProdRating(String expectedRating) {
	    this.visitPDP();
	    String actualRating = prodRatingNum.getText();
	    Action.printAndAssert(actualRating, expectedRating);
	    extentInfoLog("Rating is displayed : ", Action.isDisplayed(driver, prodRating));
	}

	/**
	 * Verifies that the product overview section is visible on the product detail page.
	 * @param expectedOverview The text expected to be found on the overview being verified.
	 */
	public void verifyProdOverview(String expectedOverview) {
	    this.visitPDP();
	    String actualOverview = prodOverviewTxt.getText();
	    Action.printAndAssert(actualOverview, expectedOverview);
	    extentInfoLog("Overview is displayed : ", Action.isDisplayed(driver, prodOverview));
	}

	/**
	 * Verifies the presence and functionality of buttons on the product detail page, specifically 'Write a review' and 'Buy Now'.
	 * @param expectedText The text expected to be found on the button being verified.
	 * @param expectedModalText The text expected to be found on the heading of the modal.
	 */
	public void verifyButtons(String expectedText, String expectedModalText) {
	    if (expectedText.contains("Write a review")) {
	        this.verifyWriteAReviewBtn(expectedText);
	    } else {
	        this.verifyBuyNowBtn(expectedText, expectedModalText);
	    }
	}

	/**
	 * Verifies the 'Write a Review' button's presence, text, and click functionality on the product detail page.
	 * @param expectedText The expected text to be displayed on the 'Write a Review' button.
	 * @param expectedModalText The text expected to be found on the heading of the modal.
	 */
	public void verifyWriteAReviewBtn(String expectedText) {
	    this.visitPDP();
	    extentInfoLog("Button is displayed : ", Action.isDisplayed(driver, writeAReviewBtn));
	    String actualText = writeAReviewBtn.getText();
	    Action.printAndAssert(actualText, expectedText);
	    Action.performActionwithExtentInfoLog(writeAReviewBtn, "click", "Clicking on : " + actualText);
	    extentInfoLog("Write a Review modal is displayed : ", Action.isDisplayed(driver, writeAReviewModal));
	}

	/**
	 * Verifies the 'Buy Now' button's presence, text, and click functionality on the product detail page.
	 * @param expectedText The expected text to be displayed on the 'Buy Now' button.
	 * @param expectedModalText The text expected to be found on the heading of the modal.
	 */
	public void verifyBuyNowBtn(String expectedBtnText, String expectedModalText) {
	    this.visitPDP();
	    extentInfoLog("Button is displayed : ", Action.isDisplayed(driver, buyNowBtn));
	    String actualBtnText = buyNowBtn.getText();
	    String actualModalText = buyNowModalHeading.getText();
	    Action.printAndAssert(actualBtnText, expectedBtnText);
	    Action.explicitWaitForElementTobeclickable(buyNowBtn, 30);
	    Action.performActionwithExtentInfoLog(buyNowBtn, "click", "Clicking on : " + actualBtnText);
	    Action.explicitWaitForElementTobeclickable(buyNowModalHeading, 30);
	    Action.printAndAssert(actualModalText, expectedModalText);
	    extentInfoLog("Buy Now modal is displayed : ", Action.isDisplayed(driver, buyNowModal));
	}
	
	/**
	 * Verifies the jump to section by clicking on the 'Jump To' heading and validating the resulting section heading.
	 *
	 * @param jumpToHeading The 'Jump To' heading to interact with
	 * @param sectionHeading The expected heading text to verify afterwards
	 */
	public void verifyJumpToSection(String jumpToHeading, String sectionHeading) {
		this.visitPDP();
	    WebElement jumpToHead = getJumpToHeadings(jumpToHeading);
	    String jumpToHeadingText = jumpToHead.getText();
	    WebElement actualHeadingElement;

		Action.scrollUntilElementVisible(jumpToTitle);
	    Action.performActionwithExtentInfoLog(jumpToHead, "click", "Clicking on : " + jumpToHeadingText);

	    switch (jumpToHeading.toLowerCase()) {
	        case "overview":
	            actualHeadingElement = prodOverviewHeading;
	            break;
	        case "directions":
	            actualHeadingElement = directionHeading;
	            break;
	        case "ingredients":
	            actualHeadingElement = ingredientsHeading;
	            break;
	        case "used for":
	            actualHeadingElement = usedForHeading;
	            break;
	        case "warnings":
	            actualHeadingElement = warningsHeading;
	            break;
	        case "faqs":
	            actualHeadingElement = faqsHeading;
	            break;
	        case "reviews":
	            actualHeadingElement = reviewsSection;
	            extentInfoLog("Section is displayed: ", Action.isDisplayed(driver, actualHeadingElement));
	            return;
	        default:
	            throw new IllegalArgumentException("Invalid section type provided: " + jumpToHeading);
	    }

	    String actualHeadingText = actualHeadingElement.getText();
	    extentInfoLog("Section is displayed : ", Action.isDisplayed(driver, actualHeadingElement));
	    Action.printAndAssert(actualHeadingText, sectionHeading);
	    extentInfoLog(jumpToHeadingText + " jump to heading verified");
	}
}
