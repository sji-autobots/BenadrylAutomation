/**
 * @author Goutam Naik
 * @date 12-Mar-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class BenadrylUsesPage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public BenadrylUsesPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(css = "h1[id='content-main']")
	WebElement bannerTitle;
	
	@FindBy(xpath = "//h1[@id='content-main']/following-sibling::div/descendant::p[1]")
	WebElement bannerDescText;
	
	@FindBy(xpath = "//h1[@id='content-main']/following-sibling::div/descendant::p/a")
	WebElement learnMoreLink;

	@FindBy(css = "div[id='edit-sfmc-careclub-lightbox-close'] button")
	WebElement closeLightBox;

	public void verifyMainHeaderInfo(String heading, String description) {
		String currentTitle, expectedTitle, currentDesc, expectedDesc;
		Action.scrollIntoCenterUsingJS(driver, bannerTitle);
		currentTitle = Action.removeNonAlphanumericASCII(bannerTitle.getText());
		expectedTitle = Action.removeNonAlphanumericASCII(heading);
		Assert.assertEquals(currentTitle, expectedTitle, "Assertion error while verifying main heading on page");
		BaseClass.extentInfoLog("verified banner heading to be : "+heading);
		currentDesc = Action.removeNonAlphanumericASCII(bannerDescText.getText());
		expectedDesc = Action.removeNonAlphanumericASCII(description);
		Assert.assertEquals(currentDesc, expectedDesc, "Assertion error while verifying main heading description on page");
		BaseClass.extentInfoLog("verified banner heading description to be : "+description);
	}

	public void closeSignUpPopup() {
		try {
			Action.explicitWaitForElementTobeclickable(closeLightBox, 30);
			Action.performActionwithExtentInfoLog(closeLightBox, "click", "Closing sign up lightbox");
		} catch (Exception e) {
			BaseClass.extentInfoLog("Signup lightbox not displayed");
		}
	}

}
