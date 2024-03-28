/**
 * @author Goutam Naik
 * @date 12-Mar-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class BenadrylUsesPage extends BaseClass {

	/**
	 * Constructor
	 */
	public BenadrylUsesPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(css = "h1[id='content-main']")
	private WebElement bannerTitle;

	@FindBy(xpath = "//h1[@id='content-main']/following-sibling::div/descendant::p[1]")
	private WebElement bannerDescText;

	@FindBy(xpath = "//h1[@id='content-main']/following-sibling::div/descendant::p/a")
	private WebElement learnMoreLink;

	@FindBy(xpath = "(//*[@class='field__item even']/h2/following-sibling::h3[1])[1]")
	private WebElement seasonalAllergyHeading;

	@FindBy(xpath = "(//h3[text()='Seasonal Allergies']/following-sibling::p)[1]")
	private WebElement seasonalAllergyDesc;

	@FindBy(xpath = "//a[normalize-space()='Seasonal allergies']")
	private WebElement seasonalAllergyLink;

	@FindBy(xpath = "(//h2)[3]")
	private WebElement itchySkinHeading;

	@FindBy(xpath = "//h2[contains(text(),'Which BENADRYL')]")
	private WebElement whichProductHeader;

	@FindBy(xpath = "//h2[contains(text(),'How to Use')]")
	private WebElement howToUseHeader;

	@FindBy(xpath = "(//h2[contains(text(),'BENADRYL')])[4]")
	private WebElement forColdHeader;

	@FindBy(xpath = "(//h2[contains(text(),'BENADRYL')])[3]")
	private WebElement itchySkinSympHeader;

	private WebElement getAllergyDescEle(String section, String heading) {
		return driver.findElement(By.xpath("//h3[text()='" + section + "']/following-sibling::h4[text()='" + heading
				+ "']/following-sibling::p[1]"));
	}

	private WebElement getItchySkinSympEle(String cause) {
		return driver.findElement(
				By.xpath("(//h2)[3]/following-sibling::h3[text()='" + cause + "']/following-sibling::p[1]"));
	}

	private WebElement getColdSympEle(String cause) {
		return driver.findElement(
				By.xpath("(//h2)[4]/following-sibling::h3[text()='" + cause + "']/following-sibling::p[1]"));
	}

	private WebElement getLinkByText(String text) {
		return driver.findElement(By.partialLinkText(text));
	}

	private WebElement getSpanHeadings(String value) {
		return driver.findElement(By.xpath("//span[normalize-space()='" + value + "']"));
	}

	private WebElement articleName(String value) {
		return driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]"));
	}

	private WebElement readMoreLink(String value) {
		return driver.findElement(By.xpath("//a[contains(@href,'" + value + "')][normalize-space()='READ MORE']"));
	}

	private WebElement getHeadings(String value) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + value + "']"));
	}

	private WebElement refText(String value) {
		return driver.findElement(By.xpath("//*[contains(text(),'" + value + "')]"));
	}

	private WebElement refLinks(String value) {
		return driver.findElement(By.xpath("//a[contains(@href,'" + value + "')]"));
	}

	/**
	 * Function to verify main heading information
	 * 
	 * @param heading     pass expected heading
	 * @param description pass expected description
	 */
	public void verifyMainHeaderInfo(String heading, String description) {
		String currentTitle, expectedTitle, currentDesc, expectedDesc;
		Action.scrollIntoCenterUsingJS(driver, bannerTitle);
		currentTitle = Action.removeNonAlphanumericASCII(bannerTitle.getText());
		expectedTitle = Action.removeNonAlphanumericASCII(heading);
		Assert.assertEquals(currentTitle, expectedTitle, "Assertion error while verifying main heading on page");
		BaseClass.extentInfoLog("verified banner heading to be : " + heading);
		currentDesc = Action.removeNonAlphanumericASCII(bannerDescText.getText());
		expectedDesc = Action.removeNonAlphanumericASCII(description);
		Assert.assertEquals(currentDesc, expectedDesc,
				"Assertion error while verifying main heading description on page");
		BaseClass.extentInfoLog("verified banner heading description to be : " + description);
	}

	/**
	 * Function to verify Seasonal Allergies heading and description
	 * 
	 * @param expectedHeading     pass expected heading as 'Seasonal Allergies'
	 * @param expectedDescription pass expected description text
	 * @param expectedUrl         pass expected url as a string
	 */
	public void verifySeasonalAllergies(String expectedHeading, String expectedDescription, String expectedUrl) {
		String currentHeading, currentDesc;
		Action.scrollIntoCenterUsingJS(driver, seasonalAllergyHeading);
		currentHeading = Action.removeNonAlphanumericASCII(seasonalAllergyHeading.getText());
		expectedHeading = Action.removeNonAlphanumericASCII(expectedHeading);
		Assert.assertEquals(currentHeading, expectedHeading, "Verification failed for 'Seasonal Allergies' heading.");
		BaseClass.extentInfoLog("Assertion success for 'Seasonal Allergies' heading");
		Action.scrollIntoCenterUsingJS(driver, seasonalAllergyDesc);
		currentDesc = Action.removeNonAlphanumericASCII(seasonalAllergyDesc.getText());
		expectedDescription = Action.removeNonAlphanumericASCII(expectedDescription);
		Assert.assertEquals(currentDesc, expectedDescription,
				"Verification failed for 'Seasonal Allergies' heading description.");
		BaseClass.extentInfoLog("verified banner heading description to be : " + currentDesc);
		this.verifySeasonalAllergiesLink(expectedUrl);
	}

	/**
	 * Function to verify seasonal allergies link
	 * 
	 * @param expectedUrl pass expected URL
	 */
	public void verifySeasonalAllergiesLink(String expectedUrl) {
		Action.performActionwithExtentInfoLog(seasonalAllergyLink, "click",
				"Clicked on : " + seasonalAllergyLink.getText());
		Action.verifyPageUrl(expectedUrl);
	}

	/**
	 * Function to verify description for all allergies
	 * 
	 * @param section     pass section
	 * @param heading     pass expected heading
	 * @param description pass expected description
	 */
	public void verifyAllergiesDesc(String section, String heading, String description) {
		String actualDesc;
		Action.scrollIntoCenterUsingJS(driver, this.getAllergyDescEle(section, heading));
		actualDesc = Action.removeNonAlphanumericASCII(this.getAllergyDescEle(section, heading).getText());
		description = Action.removeNonAlphanumericASCII(description);
		Action.printAndAssert(actualDesc, description);
	}

	/**
	 * Function to verify sysmptoms causes
	 * 
	 * @param symptom     pass symptom
	 * @param cause       pass cause
	 * @param description pass expected desc
	 */
	public void verifySymptomCasuses(String symptom, String cause, String description) {
		String actualDesc;
		WebElement ele = null;
		switch (symptom) {
		case "Itchy Skin":
			ele = this.getItchySkinSympEle(cause);
			break;
		case "Cold":
			ele = this.getColdSympEle(cause);
			break;
		default:
			BaseClass.extentInfoLog("Invalid case specified : " + symptom);
		}
		Action.scrollIntoCenterUsingJS(driver, ele);
		actualDesc = Action.removeNonAlphanumericASCII(ele.getText());
		Action.printAndAssert(actualDesc, Action.removeNonAlphanumericASCII(description));
	}

	/**
	 * Function to verify links
	 * 
	 * @param linktext    pass linktext to click on
	 * @param expectedUrl pass expected url
	 */
	public void verifyLink(String linktext, String expectedUrl) {
		Action.scrollIntoCenterUsingJS(driver, this.getLinkByText(linktext));
		Action.performActionwithExtentInfoLog(this.getLinkByText(linktext), "click",
				"Clicked on : " + this.getLinkByText(linktext).getText());
		Action.verifyPageUrl(expectedUrl);
	}

	/**
	 * Function to verify headings
	 * 
	 * @param expectedHeading pass expected heading
	 */
	public void verifyheading(String expectedHeading) {
		WebElement ele = null;
		String currentHeading;
		if (expectedHeading.contains("Product Should I Take")) {
			ele = this.whichProductHeader;
		} else if (expectedHeading.contains("How to Use BENADRYL")) {
			ele = this.howToUseHeader;
		} else if (expectedHeading.contains("for Cold Symptoms")) {
			ele = this.forColdHeader;
		} else if (expectedHeading.contains("for Itchy Skin Symptoms")) {
			ele = this.itchySkinSympHeader;
		} else {
			BaseClass.extentFailLog("Invalid header expected : ", expectedHeading);
		}
		Action.scrollIntoCenterUsingJS(driver, ele);
		expectedHeading = Action.removeNonAlphanumericASCII(expectedHeading);
		currentHeading = Action.removeNonAlphanumericASCII(ele.getText());
		Action.printAndAssert(currentHeading, expectedHeading);
		BaseClass.extentInfoLog("Assertion success for header : " + currentHeading);
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
