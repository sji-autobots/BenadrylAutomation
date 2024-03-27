/**
 * @author Vaibhav Nagvekar
 * @date 19-Mar-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class SitemapPage extends BaseClass {

	Actions actions;

	/**
	 * Constructor
	 */
	public SitemapPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//h1[@id='content-main']")
	private WebElement title;

	private WebElement getMainLink(String value) {
		return driver.findElement(By.xpath("//div[@class='field__item even']//a[normalize-space()='" + value + "']"));
	}

	private WebElement getSubLink(String value) {
		return driver.findElement(By.xpath("//a[@href='/products/" + value + "']"));
	}

	private WebElement getAllergyLink(String value) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + value + "')]"));
	}

	/**
	 * Function to verify title and url on sitemap page
	 * 
	 * @param expectedTitle pass expected title
	 * @param expectedUrl   pass expected url
	 */
	public void verifyTitleAndUrl(String expectedTitle, String expectedUrl) {
		Action.explicitWait(title, 30);
		String actualTitle = title.getText();
		Action.printAndAssert(actualTitle, expectedTitle);
		Action.verifyPageUrl(expectedUrl);
	}

	/**
	 * Function to click and verify links on sitemap page
	 * 
	 * @param key         pass keyword
	 * @param link        pass link
	 * @param expectedUrl pass expected url
	 */
	public void verifyLinks(String key, String link, String expectedUrl) {
		if (key.equalsIgnoreCase("class")) {
			Action.explicitWaitForElementTobeclickable(getMainLink(link), 30);
			Action.performActionwithExtentInfoLog(getMainLink(link), "click",
					"Clicking on : " + getMainLink(link).getText());
			signup.closeSignUpPopup();
			Action.verifyPageUrl(expectedUrl);
		} else if (key.equalsIgnoreCase("href")) {
			Action.explicitWaitForElementTobeclickable(getSubLink(link), 30);
			Action.performActionwithExtentInfoLog(getSubLink(link), "click",
					"Clicking on : " + getSubLink(link).getText());
			signup.closeSignUpPopup();
			Action.verifyPageUrl(expectedUrl);
		} else {
			Action.explicitWaitForElementTobeclickable(getAllergyLink(link), 30);
			Action.performActionwithExtentInfoLog(getAllergyLink(link), "click",
					"Clicking on : " + getAllergyLink(link).getText());
			signup.closeSignUpPopup();
			Action.verifyPageUrl(expectedUrl);
		}
	}
}
