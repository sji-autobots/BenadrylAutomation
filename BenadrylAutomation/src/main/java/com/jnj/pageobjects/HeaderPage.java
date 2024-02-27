/**
 * @author Goutam Naik
 * @date 27-Feb-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class HeaderPage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public HeaderPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "(//*[@id='header-search-btn']/span)[1]")
	WebElement searchBtn;

	public WebElement getMenuItem(String menu) {
		return driver.findElement(By.xpath("//ul[@role='menubar']/li/a[text()='" + menu + "']"));
	}

	/**
	 * Function to verify main menu links
	 * @param menu pass menu text
	 * @param expectedUrl pass expected URL
	 */
	public void verifyMainMenuLink(String menu, String expectedUrl) {
		Action.explicitWaitForElementTobeclickable(this.getMenuItem(menu), 20);
		Action.performActionwithExtentInfoLog(this.getMenuItem(menu), "click",
				"Clicking on : " + this.getMenuItem(menu).getText());
		Action.verifyPageUrl(expectedUrl);
	}
}
