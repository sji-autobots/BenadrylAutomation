/**
 * @author Vaibhav Nagvekar
 * @date 05-Mar-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class ComparePage extends BaseClass {

	/**
	 * Constructor
	 */
	public ComparePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//h1[@id='content-main']")
	private WebElement bannerTitle;

	@FindBy(xpath = "//p[contains(text(),'With so many allergy medications')]")
	private WebElement bannerDescription;

	@FindBy(xpath = "(//div[@class='ps-product-details']/h2)[1]")
	private WebElement productNameOnBuyNow;

	private WebElement getHeadings(String value) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + value + "']"));
	}

	private WebElement getSpanHeadings(String value) {
		return driver.findElement(By.xpath("//span[normalize-space()='" + value + "']"));
	}

	private WebElement clickOnLinks(String value) {
		return driver.findElement(By.xpath("//a[normalize-space()='" + value + "']"));
	}

	private WebElement articleName(String value) {
		return driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]"));
	}

	private WebElement readMoreLink(String value) {
		return driver.findElement(
				By.xpath("//a[@href='/benadryl-difference/" + value + "'][normalize-space()='READ MORE']"));
	}

	private WebElement productName(String value) {
		return driver.findElement(By.xpath("//span[@class='node__title']//a[@href='/products/" + value + "']"));
	}

	private WebElement getAges(String value) {
		return driver.findElement(By.xpath("//div[@about='/products/" + value + "']/div/div/div[3]"));
	}

	private WebElement buyNowBtn(String value) {
		return driver.findElement(By.xpath("//a[@href='https://www.benadryl.com/products/" + value + "']"));
	}

	private WebElement refText(String value) {
		return driver.findElement(By.xpath("//p[contains(text(),'" + value + "')]"));
	}

	private WebElement refLinks(String value) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + value + "-')]"));
	}

	private WebElement getMedication(String value) {
		return driver.findElement(
				By.xpath("//div[@class='field__item even']/table/tbody/tr/td[contains(text(),'" + value + "')]"));
	}

	private WebElement getBenadrylBrandValue(String medication) {
		return driver.findElement(By.xpath("//td[text()='" + medication + "']/following-sibling::td[1]"));
	}

	private WebElement getClaritinBrandValue(String medication) {
		return driver.findElement(By.xpath("//td[text()='" + medication + "']/following-sibling::td[2]"));
	}

	private WebElement getAllegraBrandValue(String medication) {
		return driver.findElement(By.xpath("//td[text()='" + medication + "']/following-sibling::td[3]"));
	}

	private WebElement getZyrtecBrandValue(String medication) {
		return driver.findElement(By.xpath("//td[text()='" + medication + "']/following-sibling::td[4]"));
	}

	private WebElement getXyzalBrandValue(String medication) {
		return driver.findElement(By.xpath("//td[text()='" + medication + "']/following-sibling::td[5]"));
	}

	/**
	 * Function to verify url and banner title
	 * 
	 * @param expectedUrl         pass expected URL
	 * @param expectedTitle       pass expected title
	 * @param expectedDescription pass expected description
	 */
	public void verifyUrlAndTitle(String expectedUrl, String expectedTitle, String expectedDescription) {
		Action.verifyPageUrl(expectedUrl);
		String actualBannerTitle = bannerTitle.getText();
		Action.printAndAssert(actualBannerTitle, expectedTitle);
		String actualBannerDescription = bannerDescription.getText();
		Action.printAndAssert(actualBannerDescription, expectedDescription);
	}

	/**
	 * Function to verify header and followed links
	 * 
	 * @param heading     pass heading
	 * @param link        pass link
	 * @param expectedUrl pass expected URL
	 */
	public void verifyHeadingAndLinks(String heading, String link, String expectedUrl) {
		String actualHeading = getHeadings(heading).getText();
		Action.printAndAssert(actualHeading, heading);
		Action.performActionwithExtentInfoLog(clickOnLinks(link), "click",
				"Clicking on : " + clickOnLinks(link).getText());
		Action.verifyPageUrl(expectedUrl);
	}

	/**
	 * Function to verify medications
	 * 
	 * @param heading    pass heading
	 * @param medication pass medication
	 * @param benadryl   pass benadryl
	 * @param claritin   pass claritin
	 * @param allegra    pass allegra
	 * @param zyrtec     pass zyrtec
	 * @param xyzal      pass xyzal
	 */
	public void verifyMedication(String heading, String medication, String benadryl, String claritin, String allegra,
			String zyrtec, String xyzal) {
		Action.explicitWait(getHeadings(heading), 30);
		boolean eleDisplayed = getHeadings(heading).isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Header displayed : ", true);
			String actualHeading = getHeadings(heading).getText();
			Action.printAndAssert(actualHeading, heading);
			String actualMedi = getMedication(medication).getText();
			extentInfoLog("Medication : ", actualMedi);
			String benadrylVal = getBenadrylBrandValue(medication).getText();
			Action.printAndAssert(benadrylVal, benadryl);
			String claritinlVal = getClaritinBrandValue(medication).getText();
			Action.printAndAssert(claritinlVal, claritin);
			String allegraVal = getAllegraBrandValue(medication).getText();
			Action.printAndAssert(allegraVal, allegra);
			String zyrtecVal = getZyrtecBrandValue(medication).getText();
			Action.printAndAssert(zyrtecVal, zyrtec);
			String xyzalVal = getXyzalBrandValue(medication).getText();
			Action.printAndAssert(xyzalVal, xyzal);
		} else
			extentFailLog("Header displayed : ", false);
	}

	/**
	 * Function to verify url from related products
	 * 
	 * @param heading         pass heading
	 * @param product         pass product
	 * @param expectedUrl     pass expected Url
	 * @param expectedAges    pass expected Ages
	 * @param expectedProduct pass expected product
	 */
	public void verifyRelatedProducts(String heading, String product, String expectedUrl, String expectedAges,
			String expectedProduct) {
		Action.explicitWait(getSpanHeadings(heading), 30);
		boolean eleDisplayed = getSpanHeadings(heading).isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Related Products header displayed : ", true);
			String actualArticle = articleName(heading).getText();
			Action.printAndAssert(actualArticle, heading);
			Action.explicitWait(productName(product), 30);
			Action.performActionwithExtentInfoLog(productName(product), "click",
					"Clicking on : " + productName(product).getText());
			Action.verifyPageUrl(expectedUrl);
			Action.navigateBack();
			extentInfoLog("Navigating back to : ", "Compare page");
			Action.explicitWait(getAges(product), 30);
			String actualAges = getAges(product).getText();
			Action.printAndAssert(actualAges, expectedAges);
			Action.explicitWait(buyNowBtn(product), 30);
			buyNowBtn(product).click();
			extentInfoLog("Clicked on : ", "buy now button");
			signup.closeSignUpPopup();
			String actualProduct = productNameOnBuyNow.getText();
			Action.printAndAssert(actualProduct, expectedProduct);
		} else
			extentFailLog("Related Products header displayed : ", false);
	}

	/**
	 * Function to verify url from articles
	 * 
	 * @param heading     pass heading
	 * @param article     pass article
	 * @param readMore    pass read more
	 * @param expectedUrl pass expected Url
	 */
	public void verifyArticles(String heading, String article, String readMore, String expectedUrl) {
		Action.explicitWait(getSpanHeadings(heading), 30);
		boolean eleDisplayed = getSpanHeadings(heading).isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Related Content header displayed : ", true);
			String actualHeading = getSpanHeadings(heading).getText();
			Action.printAndAssert(actualHeading, heading);
			Action.explicitWait(articleName(article), 30);
			String actualArticle = articleName(article).getText();
			Action.printAndAssert(actualArticle, article);
			Action.explicitWait(readMoreLink(readMore), 30);
			Action.performActionwithExtentInfoLog(readMoreLink(readMore), "click",
					"Clicking on : " + readMoreLink(readMore).getText());
			Action.verifyPageUrl(expectedUrl);
		} else
			extentFailLog("Related Content header displayed : ", false);
	}

	/**
	 * Function to verify url from references
	 * 
	 * @param heading     pass heading
	 * @param refText     pass reference Text
	 * @param link        pass expected link
	 * @param expectedUrl pass expected Url
	 */
	public void verifyReferences(String heading, String refText, String link, String expectedUrl) {
		String actualHeading = getHeadings(heading).getText();
		Action.printAndAssert(actualHeading, heading);
		boolean eleDisplayed = refText(refText).isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Reference point displayed : ", true);
			String actualRef = refText(refText).getText();
			extentPassLog("Reference point : ", actualRef);
			Action.performActionwithExtentInfoLog(refLinks(link), "click", "Clicking on : " + refLinks(link).getText());
			Action.switchToNewWindow(driver);
			String actualUrl = driver.getCurrentUrl();
			Action.printAndAssert(actualUrl, expectedUrl);
		} else
			extentFailLog("Reference point displayed : ", false);
	}
}
