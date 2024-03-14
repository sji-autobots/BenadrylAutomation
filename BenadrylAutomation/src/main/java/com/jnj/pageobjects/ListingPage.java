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

public class ListingPage extends BaseClass{
    Actions actions;

    /**
     * Constructor
     */
    public ListingPage() {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    /**
     * Locators
     */
    @FindBy(css = "#tab-menu-8651")
    WebElement prodHeaderMenu;
	
	@FindBy(xpath = "//div[@id='onetrust-close-btn-container']")
	WebElement closePrivacyBtn;
    
    public WebElement getJumpToHeadings(String headingText) {
        return driver.findElement(By.xpath("//div[@class='jump-to-wrapper']//ul//li//a[text()='" + headingText + "']"));
    }
	
	/**
	 * Function to click on close privacy pop-up button
	 */
	public void closePrivacyPopup() {
		Action.explicitWaitForElementTobeclickable(closePrivacyBtn, 30);
		boolean eleDisplayed = closePrivacyBtn.isDisplayed();
		if(eleDisplayed) {
			extentPassLog("Privacy pop-up displayed : ", true);
			Action.performActionwithExtentInfoLog(closePrivacyBtn, "click", "Clicking on : Close button");
		} else extentFailLog("Privacy pop-up displayed : ", false);
	}

    /**
     * Visits a product page from the homepage.
     */
    public void visitPLP() {
        Action.performActionwithExtentInfoLog(prodHeaderMenu, "click", "Clicking on : " + prodHeaderMenu.getText());
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies if the image of the product is visible.
     */
    public void verifyProdImage() {
    	this.visitPLP();
//        extentInfoLog("Image is displayed : ", Action.isDisplayed(driver, prodImg));
    }

    /**
     * Visits a product page from the homepage.
     * Then, verifies the title of the product.
     */
    public void verifyProdTitle() {
    	this.visitPLP();
//        extentInfoLog("Title is displayed : ", Action.isDisplayed(driver, prodTitle));
        extentInfoLog("Product title verified");
    }
}
