/**
 * @author Vaibhav Nagvekar
 * @date 08-Mar-24
 */

package com.jnj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class SignUpPage extends BaseClass {

	Actions actions;

	/**
	 * Constructor
	 */
	public SignUpPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "(//a[normalize-space()='Email Sign Up & Rewards'])[1]")
	WebElement emailSignUpRewardLink;

	@FindBy(xpath = "//div[@class='sfmc-careclub-logo']")
	WebElement logo;

	@FindBy(xpath = "//button[@class='close sfmc-careclub-lightbox-close']")
	WebElement closeBtn;

	@FindBy(xpath = "//div[@id='edit-sfmc-careclub-lightbox-title']//p[1]")
	WebElement signUpTitle;

	@FindBy(xpath = "//div[@id='edit-sfmc-careclub-lightbox-privacy']//a[@class='no-ext ext']")
	WebElement privacyPolicyLink;

	@FindBy(xpath = "//div[@id='edit-sfmc-careclub-lightbox-privacy']//a[@class='ext']//span[@class='ext']")
	WebElement financialIncentiveNoticeLink;

	@FindBy(xpath = "//button[@id='edit-submit-button']")
	WebElement submitBtn;

	private WebElement enterInputs(String value) {
		return driver.findElement(By.xpath("//input[@id='edit-sfmc-" + value + "']"));
	}

	private WebElement getValidations(String value) {
		return driver
				.findElement(By.xpath("//input[@id='edit-sfmc-" + value + "']/../div[@class='sfmc-careclub-error']"));
	}

	// --------- this should come from header page
	public void clickOnEmailSignUp() {
		home.closePrivacyPopup();
		Action.explicitWaitForElementTobeclickable(emailSignUpRewardLink, 30);
		boolean eleDisplayed = emailSignUpRewardLink.isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Email Signup & Reward link displayed : ", true);
			Action.performActionwithExtentInfoLog(emailSignUpRewardLink, "click",
					"Clicking on : " + emailSignUpRewardLink.getText());
		} else
			extentFailLog("Email Signup & Reward link displayed : ", false);
	}

	/**
	 * Function to verify logo and url on signup pop-up
	 * 
	 * @param expectedTitle pass expected title
	 */
	public void verifyLogoAndTitle(String expectedTitle) {
		Action.explicitWait(logo, 30);
		boolean eleDisplayed = logo.isDisplayed();
		if (eleDisplayed) {
			extentPassLog("Logo displayed : ", true);
			String actualTitle = signUpTitle.getText();
			Action.printAndAssert(actualTitle, expectedTitle);
			Action.performActionwithExtentInfoLog(closeBtn, "click", "Clicking on : Close button");
		} else
			extentFailLog("Logo displayed : ", false);
	}

	/**
	 * Function to verify links on signup pop-up
	 * 
	 * @param fnameValue pass first name value
	 * @param fname      pass first name
	 * @param emailValue pass email value
	 * @param email      pass email
	 * @param key        pass keyword
	 * @param validation pass validation message
	 */

	public void EnterNameAndEmail(String fnameValue, String fname, String emailValue, String email, String key,
			String validation) {
		Action.explicitWaitForElementTobeclickable(enterInputs(fnameValue), 30);
		boolean eleFirstNameDisplayed = enterInputs(fnameValue).isDisplayed();
		if (eleFirstNameDisplayed) {
			extentPassLog("First name input displayed : ", true);
			enterInputs(fnameValue).sendKeys(fname);
			extentInfoLog("Entered first name : ", fname);
			Action.explicitWaitForElementTobeclickable(enterInputs(emailValue), 30);
			boolean eleLastNameDisplayed = enterInputs(emailValue).isDisplayed();
			if (eleLastNameDisplayed) {
				extentPassLog("Last name input displayed : ", true);
				enterInputs(emailValue).sendKeys(email);
				extentInfoLog("Entered email : ", email);
				Action.explicitWaitForElementTobeclickable(submitBtn, 30);
				Action.performActionwithExtentInfoLog(submitBtn, "click", "Clicking on : " + submitBtn.getText());
				Action.waitFor(3000);
				switch (key) {
				case "First name":
					Action.explicitWait(getValidations(fnameValue), 30);
					String fnameValidationMessage = getValidations(fnameValue).getText();
					Action.printAndAssert(validation, fnameValidationMessage);
					break;
				case "Email":
					Action.explicitWait(getValidations(emailValue), 30);
					String emailValidationMessage = getValidations(emailValue).getText();
					Action.printAndAssert(validation, emailValidationMessage);
					break;
				default:
					extentInfoLog("Key not matching with ", "validation message");
					break;
				}
			} else
				extentFailLog("Last name input displayed : ", false);
		} else
			extentFailLog("First name input displayed : ", false);
	}

	/**
	 * Function to verify links on signup pop-up
	 * 
	 * @param key         pass keyword
	 * @param expectedUrl pass expected Url
	 */
	public void checkLinks(String key, String expectedUrl) {
		switch (key) {
		case "Privacy":
			Action.explicitWaitForElementTobeclickable(privacyPolicyLink, 30);
			boolean elePrivacyDisplayed = privacyPolicyLink.isDisplayed();
			if (elePrivacyDisplayed) {
				extentPassLog("Privacy link displayed : ", true);
				Action.performActionwithExtentInfoLog(privacyPolicyLink, "click",
						"Clicking on : " + privacyPolicyLink.getText());
				Action.switchToNewWindow(driver);
				String actualUrl = driver.getCurrentUrl();
				String baseUrl = actualUrl.substring(0, actualUrl.indexOf("?"));
				Action.printAndAssert(baseUrl, expectedUrl);
			} else
				extentFailLog("Privacy link displayed : ", false);
			break;
		case "Financial":
			Action.explicitWaitForElementTobeclickable(privacyPolicyLink, 30);
			boolean eleFinancialDisplayed = privacyPolicyLink.isDisplayed();
			if (eleFinancialDisplayed) {
				extentPassLog("Financial incentive link displayed : ", true);
				Action.performActionwithExtentInfoLog(financialIncentiveNoticeLink, "click",
						"Clicking on : " + financialIncentiveNoticeLink.getText());
				Action.switchToNewWindow(driver);
				String actualUrl = driver.getCurrentUrl();
				Action.printAndAssert(actualUrl, expectedUrl);
			} else
				extentFailLog("Financial incentive link displayed : ", false);
			break;
		}
	}
}
