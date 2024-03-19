/**
 * @author Goutam Naik
 * @date 12-Mar-24
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

	@FindBy(xpath = "(//*[@class='field__item even']/h2/following-sibling::h3[1])[1]")
	WebElement seasonalAllergyHeading;

	@FindBy(xpath = "(//h3[text()='Seasonal Allergies']/following-sibling::p)[1]")
	WebElement seasonalAllergyDesc;

	@FindBy(xpath = "//a[normalize-space()='Seasonal allergies']")
	WebElement seasonalAllergyLink;

	@FindBy(xpath = "(//h2)[3]")
	WebElement itchySkinHeading;
	
	@FindBy(xpath = "//h2[contains(text(),'Which BENADRYL')]")
	WebElement whichProductHeader;
	
	@FindBy(xpath = "//h2[contains(text(),'How to Use')]")
	WebElement howToUseHeader;
	
	@FindBy(xpath = "(//h2[contains(text(),'BENADRYL')])[4]")
	WebElement forColdHeader;
	
	@FindBy(xpath = "(//h2[contains(text(),'BENADRYL')])[3]")
	WebElement itchySkinSympHeader;

	public WebElement getAllergyDescEle(String section, String heading) {
		return driver.findElement(By.xpath("//h3[text()='" + section + "']/following-sibling::h4[text()='" + heading
				+ "']/following-sibling::p[1]"));
	}

	public WebElement getSymptomDescEle(String symptom, String cause) {
		return driver.findElement(By.cssSelector("h2:contains('" + symptom + "')+p+h3:contains('" + cause + "')+p"));
	}

	public WebElement getItchySkinSympEle(String cause) {
		return driver.findElement(
				By.xpath("(//h2)[3]/following-sibling::h3[text()='" + cause + "']/following-sibling::p[1]"));
	}

	public WebElement getColdSympEle(String cause) {
		return driver.findElement(
				By.xpath("(//h2)[4]/following-sibling::h3[text()='" + cause + "']/following-sibling::p[1]"));
	}
	
	public WebElement getLinkByText(String text) {
		return driver.findElement(By.partialLinkText(text));
		//return driver.findElement(By.css("a:contains('" + text + "')"));
	}

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
		String currentHeading, currentDesc, currentUrl;
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

	private void verifySeasonalAllergiesLink(String expectedUrl) {
		Action.performActionwithExtentInfoLog(seasonalAllergyLink, "click",
				"Clicked on : " + seasonalAllergyLink.getText());
		Action.verifyPageUrl(expectedUrl);
	}

	public void verifyAllergiesDesc(String section, String heading, String description) {
		String actualDesc;
		Action.scrollIntoCenterUsingJS(driver, this.getAllergyDescEle(section, heading));
		actualDesc = Action.removeNonAlphanumericASCII(this.getAllergyDescEle(section, heading).getText());
		description = Action.removeNonAlphanumericASCII(description);
		Action.printAndAssert(actualDesc, description);
	}

	public void verifySymptomCasuses(String symptom, String cause, String description) {
		String actualDesc;
		WebElement ele = null;
		// Action.scrollIntoCenterUsingJS(driver, this.getSymptomDescEle(symptom,
		// cause));
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

	public void verifyLink(String linktext, String expectedUrl) {
		Action.scrollIntoCenterUsingJS(driver, this.getLinkByText(linktext));
		Action.performActionwithExtentInfoLog(this.getLinkByText(linktext), "click", "Clicked on : "+this.getLinkByText(linktext).getText());
		Action.verifyPageUrl(expectedUrl);
	}

	public void verifyheading(String expectedHeading) {
		WebElement ele =null;
		String currentHeading;
		if(expectedHeading.contains("Product Should I Take")) {
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
		BaseClass.extentInfoLog("Assertion success for header : "+currentHeading);
	}

}
