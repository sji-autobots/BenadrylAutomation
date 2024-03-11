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

public class ProductPage extends BaseClass{
    Actions actions;

    /**
     * Constructor
     */
    public ProductPage() {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    /**
     * Locators
     */
    @FindBy(css = "#tab-menu-8651")
    WebElement prodHeaderMenu;

    @FindBy(css = "[itemprop=\"name\"] > #node-title-url-386")
    WebElement prodTileTitle;

    @FindBy(css = "[alt=\"BENADRYL® Allergy ULTRATABS® Tablets\"]")
    WebElement prodImg;

    @FindBy(css = "#content-main")
    WebElement prodTitle;

    @FindBy(css = ".bv_ratings_summary")
    WebElement prodRating;

    @FindBy(css = ".inside > .pane-node-body")
    WebElement prodOverview;

    @FindBy(css = ".bv_war_button")
    WebElement writeAReviewBtn;

    @FindBy(css = ".zZXQY")
    WebElement writeAReviewModal;

    @FindBy(css = "#mini-panel-product_header .ps-button-label")
    WebElement buyNowBtn;

    @FindBy(css = ".ps-wtb")
    WebElement buyNowModal;

    @FindBy(css = ".jump-to-title")
    WebElement jumpToTitle;

    @FindBy(css = "[href=\"#product-overview\"] > h2")
    WebElement prodOverviewHeading;

    @FindBy(css = ".pane-node-field-product-directions")
    WebElement directionSection;

    @FindBy(css = ".pane-node-field-product-directions h2")
    WebElement directionHeading;

    @FindBy(css = "#mini-panel-product_ingredients_modal")
    WebElement ingredientsSection;

    @FindBy(css = "#mini-panel-product_ingredients_modal h2")
    WebElement ingredientsHeading;

    @FindBy(css = "li #used-for")
    WebElement usedForSection;

    @FindBy(css = "#tab_used-for")
    WebElement usedForHeading;

    @FindBy(css = "li #warnings")
    WebElement warningsSection;

    @FindBy(css = "#tab_warnings")
    WebElement warningsHeading;

    @FindBy(css = "#mini-panel-product_faq")
    WebElement faqsSection;

    @FindBy(css = "#mini-panel-product_faq span")
    WebElement faqsHeading;

    @FindBy(css = "#bv_review_maincontainer")
    WebElement reviewsSection;

    @FindBy(css = "#bv_review_maincontainer h2")
    WebElement reviewsHeading;
    
    public WebElement getJumpToHeadings(String headingText) {
        return driver.findElement(By.xpath("//div[@class='jump-to-wrapper']//ul//li//a[text()='" + headingText + "']"));
    }

    /**
     * Visits a product page from the homepage.
     */
    public void visitPDP() {
        Action.performActionwithExtentInfoLog(prodHeaderMenu, "click", "Clicking on : " + prodHeaderMenu.getText());    
        Action.performActionwithExtentInfoLog(prodTileTitle, "click", "Clicking on : " + prodTileTitle.getText()); 	
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies if the image of the product is visible.
     */
    public void verifyProdImage() {
    	this.visitPDP();
        extentInfoLog("Image is displayed : ", Action.isDisplayed(driver, prodImg));
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the title of the product.
     */
    public void verifyProdTitle(String expectedText) {
    	this.visitPDP();
        extentInfoLog("Title is displayed : ", Action.isDisplayed(driver, prodTitle));
		String actualTitle = prodTitle.getText();
        Assert.assertEquals(actualTitle, expectedText);
        extentInfoLog("Product title verified");
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies if the rating of the product is visible.
     */
    public void verifyProdRating() {
    	this.visitPDP();
        extentInfoLog("Rating is displayed : ", Action.isDisplayed(driver, prodRating));
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies if the overview of the product is visible.
     */
    public void verifyProdOverview() {
    	this.visitPDP();
        extentInfoLog("Overview is displayed : ", Action.isDisplayed(driver, prodOverview));
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the Write a Review button.
     */
    public void verifyWriteAReviewBtn(String expectedText) {
    	this.visitPDP();
        extentInfoLog("Button is displayed : ", Action.isDisplayed(driver, writeAReviewBtn));
		String actualText= writeAReviewBtn.getText();
        Assert.assertEquals(actualText, expectedText);
		Action.performActionwithExtentInfoLog(writeAReviewBtn, "click", "Clicking on : " + actualText);
        extentInfoLog("Modal is displayed : ", Action.isDisplayed(driver, writeAReviewModal));
        extentInfoLog("Write a Review button verified");
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the Buy Now button.
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
     * Visits a product page from the homepage.
     * Then, verifies the jump to heading.
     */
    public void verifyJumpToOverview(String jumpToHeading, String sectionHeading) {
    	this.visitPDP();
		WebElement jumpToHead= getJumpToHeadings(jumpToHeading);
		String jumpToHeadingText = jumpToHead.getText();
		String actualHeadingText = prodOverviewHeading.getText();
    	Action.scrollUntilElementVisible(jumpToTitle);
		Action.performActionwithExtentInfoLog(jumpToHead, "click", "Clicking on : " + jumpToHeadingText);
        extentInfoLog("Section is displayed : ", Action.isDisplayed(driver, prodOverview));
        Assert.assertEquals(actualHeadingText, sectionHeading);
        extentInfoLog(jumpToHeadingText + "jump heading verified");
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the jump to heading.
     */
    public void verifyJumpToDirections(String jumpToHeading, String sectionHeading) {
    	this.visitPDP();
		WebElement jumpToHead= getJumpToHeadings(jumpToHeading);
		String jumpToHeadingText = jumpToHead.getText();
		String actualHeadingText = directionHeading.getText();
    	Action.scrollUntilElementVisible(jumpToTitle);
		Action.performActionwithExtentInfoLog(jumpToHead, "click", "Clicking on : " + jumpToHeadingText);
        extentInfoLog("Section is displayed : ", Action.isDisplayed(driver, directionSection));
        Assert.assertEquals(actualHeadingText, sectionHeading);
        extentInfoLog(jumpToHeadingText + "jump heading verified");
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the jump to heading.
     */
    public void verifyJumpToIngredients(String jumpToHeading, String sectionHeading) {
    	this.visitPDP();
		WebElement jumpToHead= getJumpToHeadings(jumpToHeading);
		String jumpToHeadingText = jumpToHead.getText();
		String actualHeadingText = ingredientsHeading.getText();
    	Action.scrollUntilElementVisible(jumpToTitle);
		Action.performActionwithExtentInfoLog(jumpToHead, "click", "Clicking on : " + jumpToHeadingText);
        extentInfoLog("Section is displayed : ", Action.isDisplayed(driver, ingredientsSection));
        Assert.assertEquals(actualHeadingText, sectionHeading);
        extentInfoLog(jumpToHeadingText + "jump heading verified");
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the jump to heading.
     */
    public void verifyJumpToUsedFor(String jumpToHeading, String sectionHeading) {
    	this.visitPDP();
		WebElement jumpToHead= getJumpToHeadings(jumpToHeading);
		String jumpToHeadingText = jumpToHead.getText();
		String actualHeadingText = usedForHeading.getText();
    	Action.scrollUntilElementVisible(jumpToTitle);
		Action.performActionwithExtentInfoLog(jumpToHead, "click", "Clicking on : " + jumpToHeadingText);
        extentInfoLog("Section is displayed : ", Action.isDisplayed(driver, usedForSection));
        Assert.assertEquals(actualHeadingText, sectionHeading);
        extentInfoLog(jumpToHeadingText + "jump heading verified");
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the jump to heading.
     */
    public void verifyJumpToWarnings(String jumpToHeading, String sectionHeading) {
    	this.visitPDP();
		WebElement jumpToHead= getJumpToHeadings(jumpToHeading);
		String jumpToHeadingText = jumpToHead.getText();
		String actualHeadingText = warningsHeading.getText();
    	Action.scrollUntilElementVisible(jumpToTitle);
		Action.performActionwithExtentInfoLog(jumpToHead, "click", "Clicking on : " + jumpToHeadingText);
        extentInfoLog("Section is displayed : ", Action.isDisplayed(driver, warningsSection));
        Assert.assertEquals(actualHeadingText, sectionHeading);
        extentInfoLog(jumpToHeadingText + "jump heading verified");
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the jump to heading.
     */
    public void verifyJumpToFAQs(String jumpToHeading, String sectionHeading) {
    	this.visitPDP();
		WebElement jumpToHead= getJumpToHeadings(jumpToHeading);
		String jumpToHeadingText = jumpToHead.getText();
		String actualHeadingText = faqsHeading.getText();
    	Action.scrollUntilElementVisible(jumpToTitle);
		Action.performActionwithExtentInfoLog(jumpToHead, "click", "Clicking on : " + jumpToHeadingText);
        extentInfoLog("Section is displayed : ", Action.isDisplayed(driver, faqsSection));
        Assert.assertEquals(actualHeadingText, sectionHeading);
        extentInfoLog(jumpToHeadingText + "jump heading verified");
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the jump to heading.
     */
    public void verifyJumpToReview(String jumpToHeading, String sectionHeading) {
    	this.visitPDP();
		WebElement jumpToHead= getJumpToHeadings(jumpToHeading);
		String jumpToHeadingText = jumpToHead.getText();
		String actualHeadingText = reviewsHeading.getText();
    	Action.scrollUntilElementVisible(jumpToTitle);
		Action.performActionwithExtentInfoLog(jumpToHead, "click", "Clicking on : " + jumpToHeadingText);
        extentInfoLog("Section is displayed : ", Action.isDisplayed(driver, reviewsSection));
        Assert.assertEquals(actualHeadingText, sectionHeading);
        extentInfoLog(jumpToHeadingText + "jump heading verified");
    }
}
