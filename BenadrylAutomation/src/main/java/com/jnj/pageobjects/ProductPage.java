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

    @FindBy(css = "#node-title-url-386")
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

    @FindBy(css = "#mini-panel-product_header .ps-button-label")
    WebElement buyNowBtn;
    
    public WebElement getJumpToHeadings(String itemText) {
        return driver.findElement(By.xpath("//div[@class='jump-to-wrapper']//ul//li//a[text()='" + itemText + "']"));
    }

    /**
     * Visits a product page from the homepage.
     */
    public void visitPDP() {
        Action.performActionwithExtentInfoLog(this.prodHeaderMenu, "click", "Clicking on : " + prodHeaderMenu.getText());    
        Action.performActionwithExtentInfoLog(this.prodTileTitle, "click", "Clicking on : " + prodTileTitle.getText()); 	
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
        extentInfoLog("Button is displayed : ", Action.isDisplayed(driver, prodTitle));
		String actualText= writeAReviewBtn.getText();
        Assert.assertEquals(actualText, expectedText);
		Action.performActionwithExtentInfoLog(this.writeAReviewBtn, "click", "Clicking on : " + actualText);
        extentInfoLog("Write a Review button verified");
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the Buy Now button.
     */
    public void verifyBuyNowBtn(String expectedText) {
    	this.visitPDP();
        extentInfoLog("Button is displayed : ", Action.isDisplayed(driver, prodTitle));
		String actualText = buyNowBtn.getText();
        Assert.assertEquals(actualText, expectedText);
		Action.performActionwithExtentInfoLog(this.buyNowBtn, "click", "Clicking on : " + actualText);
        extentInfoLog("But Now button verified");
    }
}
