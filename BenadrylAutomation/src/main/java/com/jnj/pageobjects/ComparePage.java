/**
 * @author Vaibhav Nagvekar
 * @date 05-Mar-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class ComparePage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public ComparePage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//h1[@id='content-main']")
	WebElement bannerTitle;
	
	//p[contains(text(),'With so many allergy medications')]
	
	public WebElement getHeadings(String value) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + value + "']"));
	}
	

	
	public void verifyUrlAndTitle(String menu, String expectedUrl, String expectedTitle) {
		Action.explicitWaitForElementTobeclickable(header.getMenuItem(menu), 30);
		Action.performActionwithExtentInfoLog(header.getMenuItem(menu), "click",
				"Clicking on : " + header.getMenuItem(menu).getText());
		Action.verifyPageUrl(expectedUrl);
		String actualTitle = bannerTitle.getText();
		Action.printAndAssert(actualTitle, expectedTitle);
	}

}
