/**
 * @author Zahin Ahad
 * @date 4-March-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

	@FindBy(css = ".inside > .pane-node-body")
	private WebElement prodOverview;

	@FindBy(css = ".bv_war_button")
	private WebElement writeAReviewBtn;

	@FindBy(css = ".zZXQY")
	private WebElement writeAReviewModal;

	@FindBy(css = "#mini-panel-product_header .ps-button-label")
	private WebElement buyNowBtn;

	@FindBy(css = ".ps-wtb")
	private WebElement buyNowModal;

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
	public WebElement getJumpToHeadings(String headingText) { 
		 return	 driver.findElement(By.xpath("//div[@class='jump-to-wrapper']//ul//li//a[text()='" + headingText + "']"));
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
	    this.visitPDP();
	    extentInfoLog("Image is displayed : ", Action.isDisplayed(driver, prodImg));
	}

	/**
	 * Verifies that the product title is visible on the product detail page.
	 */
	public void verifyProdTitle() {
	    this.visitPDP();
	    extentInfoLog("Title is displayed : ", Action.isDisplayed(driver, prodTitle));
	    extentInfoLog("Product title verified");
	}

	/**
	 * Verifies that the product rating is visible on the product detail page.
	 */
	public void verifyProdRating() {
	    this.visitPDP();
	    extentInfoLog("Rating is displayed : ", Action.isDisplayed(driver, prodRating));
	}

	/**
	 * Verifies that the product overview section is visible on the product detail page.
	 */
	public void verifyProdOverview() {
	    this.visitPDP();
	    extentInfoLog("Overview is displayed : ", Action.isDisplayed(driver, prodOverview));
	}

	/**
	 * Verifies the presence and functionality of buttons on the product detail page, specifically 'Write a review' and 'Buy Now'.
	 * @param expectedText The text expected to be found on the button being verified.
	 */
	public void verifyButtons(String expectedText) {
	    if (expectedText.contains("Write a review")) {
	        this.verifyWriteAReviewBtn(expectedText);
	    } else {
	        this.verifyBuyNowBtn(expectedText);
	    }
	}

	/**
	 * Verifies the 'Write a Review' button's presence, text, and click functionality on the product detail page.
	 * @param expectedText The expected text to be displayed on the 'Write a Review' button.
	 */
	public void verifyWriteAReviewBtn(String expectedText) {
	    this.visitPDP();
	    extentInfoLog("Button is displayed : ", Action.isDisplayed(driver, writeAReviewBtn));
	    String actualText = writeAReviewBtn.getText();
	    Assert.assertEquals(actualText, expectedText);
	    Action.performActionwithExtentInfoLog(writeAReviewBtn, "click", "Clicking on : " + actualText);
	    extentInfoLog("Modal is displayed : ", Action.isDisplayed(driver, writeAReviewModal));
	    extentInfoLog("Write a Review button verified");
	}

	/**
	 * Verifies the 'Buy Now' button's presence, text, and click functionality on the product detail page.
	 * @param expectedText The expected text to be displayed on the 'Buy Now' button.
	 */
	public void verifyBuyNowBtn(String expectedText) {
	    this.visitPDP();
	    extentInfoLog("Button is displayed : ", Action.isDisplayed(driver, buyNowBtn));
	    String actualText = buyNowBtn.getText();
	    Assert.assertEquals(actualText, expectedText);
	    Action.performActionwithExtentInfoLog(buyNowBtn, "click", "Clicking on : " + actualText);
	    extentInfoLog("Modal is displayed : ", Action.isDisplayed(driver, buyNowModal));
	    extentInfoLog("Buy Now button verified");
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
