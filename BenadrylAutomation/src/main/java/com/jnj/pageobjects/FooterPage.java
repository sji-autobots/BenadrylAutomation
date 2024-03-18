/**
 * @author Rashi Tiwari
 * @date 18-March-24
 */
package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class FooterPage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public FooterPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//*[@id='footer']")
	WebElement footerbanner;

	public WebElement getfooteroption(String link) {
		return driver.findElement(By.xpath("//a[normalize-space()='" + link + "']"));
	}
	
	public WebElement getSecondfooteroption(String link) {
		return driver.findElement(By.xpath("//*[@id='footer']//a[normalize-space()='" + link + "']"));
	}
	
	public WebElement getFooterHeading(String link) {
		return driver.findElement(By.xpath("//span[normalize-space()='" + link + "']"));
	}
	
	/**
	 * Verifies a footer link by clicking on it and checking the resulting URL.
	 * 
	 * @param link text of the footer link to be verified.
	 * @param expectedUrl The expected URL that the link should navigate to.
	 */
	public void verifyFooterlink(String link, String expectedUrl) {
		extentInfoLog("Banner is displayed : ",Action.isDisplayed(driver, footerbanner));
		Action.explicitWaitForElementTobeclickable(this.getfooteroption(link), 10);
		Action.performActionwithExtentInfoLog(this.getfooteroption(link), "click",
				"Clicking on : " + this.getfooteroption(link).getText());
		Action.verifyPageUrl(expectedUrl);
		extentInfoLog("URL Verified : ", baseURI+expectedUrl);
		Action.navigateBack();
	}
	
	/**
	 * Verifies a footer link by clicking on it and checking the resulting URL.
	 * 
	 * @param link text of the footer link to be verified.
	 * @param expectedUrl The expected URL that the link should navigate to.
	 */
	public void getSecondfooteroption(String link, String expectedUrl) {
		extentInfoLog("Banner is displayed : ",Action.isDisplayed(driver, footerbanner));
		Action.explicitWaitForElementTobeclickable(this.getSecondfooteroption(link), 10);
		Action.performActionwithExtentInfoLog(this.getSecondfooteroption(link), "click",
				"Clicking on : " + this.getSecondfooteroption(link).getText());
		Action.verifyPageUrl(expectedUrl);
		extentInfoLog("URL Verified : ", baseURI+expectedUrl);
		Action.navigateBack();
	}
	
	/**
	 * Verifies a footer link by clicking on it and checking the resulting URL.
	 * 
	 * @param link text of the footer link to be verified.
	 * @param expectedUrl The expected URL that the link should navigate to.
	 */
	public void getThirdfooteroption(String link, String expectedUrl) {
		extentInfoLog("Banner is displayed : ",Action.isDisplayed(driver, footerbanner));
		Action.explicitWaitForElementTobeclickable(this.getSecondfooteroption(link), 10);
		Action.performActionwithExtentInfoLog(this.getSecondfooteroption(link), "click",
				"Clicking on : " + this.getSecondfooteroption(link).getText());
		Action.verifyPageUrl(expectedUrl);
		extentInfoLog("URL Verified : ", baseURI+expectedUrl);
		Action.navigateBack();
	}
	
	/**
	 * Verifies if a footer heading is displayed on the page.
	 * 
	 * @param link The text or identifier of the footer heading to be verified.
	 */
	public void footerHeading(String link) {
		extentInfoLog("Footer heading is displayed : ",Action.isDisplayed(driver, getFooterHeading(link)));		
	}	
}
