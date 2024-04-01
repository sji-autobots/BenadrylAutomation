/**
 * @author Vaibhav Nagvekar
 * @date 12-March-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class OurIngredientsPage extends BaseClass {

	/**
	 * Constructor
	 */
	public OurIngredientsPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//h1[@id='content-main']")
	private WebElement bannerTitle;

	@FindBy(xpath = "//div[@property='content:encoded']//p[2]")
	private WebElement bannerDescription;

	@FindBy(xpath = "//div[@property='content:encoded']//p[3]")
	private WebElement bannerLink;

	@FindBy(xpath = "(//div[@class='field__item even']//h2)[1]")
	private WebElement firstTitle;

	@FindBy(xpath = "(//div[@class='field__item even']//h2)[2]")
	private WebElement secondTitle;

	@FindBy(xpath = "(//div[@class='field__item even']//h2)[3]")
	private WebElement thirdTitle;

	private WebElement getHeader(String value) {
		return driver.findElement(By.xpath("//h3[contains(text(),'" + value + "')]"));
	}

	private WebElement getContent(String value) {
		return driver.findElement(By.xpath("//p[contains(text(),'" + value + "')]"));
	}

	private WebElement getSpanHeadings(String value) {
		return driver.findElement(By.xpath("//span[normalize-space()='" + value + "']"));
	}

	private WebElement contenteName(String value) {
		return driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]"));
	}

	private WebElement readMoreLink(String value) {
		return driver.findElement(By.xpath("//a[@href='/benadryl-" + value + "'][normalize-space()='READ MORE']"));
	}

	/**
	 * Function to verify url and banner title
	 * 
	 * @param expectedUrl         pass expected URL
	 * @param expectedTitle       pass expected title
	 * @param expectedDescription pass expected description
	 */
	public void verifyUrlAndTitle(String expectedUrl, String expectedTitle, String expectedDescription,
			String expectedBannerLinkUrl) {
		Action.verifyPageUrl(expectedUrl);
		String actualBannerTitle = bannerTitle.getText();
		Action.printAndAssert(actualBannerTitle, expectedTitle);
		String actualBannerDescription = bannerDescription.getText();
		Action.printAndAssert(actualBannerDescription, expectedDescription);
		Action.performActionwithExtentInfoLog(bannerLink, "click", "Clicking on : " + bannerLink.getText());
		Action.verifyPageUrl(expectedBannerLinkUrl);
	}

	/**
	 * Function to verify title, header and content
	 * 
	 * @param title   pass title
	 * @param header  pass header
	 * @param content pass content
	 */
	public void verifyHeadersAndContent(String title, String header, String content) {
		if (title.equalsIgnoreCase("BENADRYL® Ingredients")) {
			Action.explicitWait(firstTitle, 30);
			String actualTitle = firstTitle.getText();
			Action.printAndAssert(actualTitle, title);
			Action.explicitWait(getHeader(header), 30);
			String actualHeader = getHeader(header).getText();
			Action.printAndAssert(actualHeader, header);
			Action.explicitWait(getContent(content), 30);
			String actualContent = getContent(content).getText();
			Action.printAndAssert(actualContent, content);
		} else if (title.equalsIgnoreCase("Children’s BENADRYL® Ingredients")) {
			Action.explicitWait(secondTitle, 30);
			String actualTitle = secondTitle.getText();
			Action.printAndAssert(actualTitle, title);
			Action.explicitWait(getHeader(header), 30);
			String actualHeader = getHeader(header).getText();
			Action.printAndAssert(actualHeader, header);
			Action.explicitWait(getContent(content), 30);
			String actualContent = getContent(content).getText();
			Action.printAndAssert(actualContent, content);
		} else {
			Action.explicitWait(thirdTitle, 30);
			String actualTitle = thirdTitle.getText();
			Action.printAndAssert(actualTitle, title);
			Action.explicitWait(getContent(content), 30);
			String actualContent = getContent(content).getText();
			Action.printAndAssert(actualContent, content);
		}
	}

	/**
	 * Function to verify url from articles
	 * 
	 * @param heading     pass heading
	 * @param article     pass article
	 * @param readMore    pass read more
	 * @param expectedUrl pass expected Url
	 */
	public void verifyContents(String heading, String article, String readMore, String expectedUrl) {
		Action.explicitWait(getSpanHeadings(heading), 30);
		boolean eleDisplayed = getSpanHeadings(heading).isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Related Content header displayed : ", true);
			String actualHeading = getSpanHeadings(heading).getText();
			Action.printAndAssert(actualHeading, heading);
			Action.explicitWait(contenteName(article), 30);
			String actualArticle = contenteName(article).getText();
			Action.printAndAssert(actualArticle, article);
			Action.explicitWait(readMoreLink(readMore), 30);
			Action.performActionwithExtentInfoLog(readMoreLink(readMore), "click",
					"Clicking on : " + readMoreLink(readMore).getText());
			Action.verifyPageUrl(expectedUrl);
		} else
			extentFailLog("Related Content header displayed : ", false);
	}
}
