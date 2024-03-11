/**
 * @author Vaibhav Nagvekar
 * @date 08-Mar-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.SignUpProvider;

public class SignUpPageTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "title", dataProviderClass = SignUpProvider.class)
	public void SIGNUP_verifyTitle(String testcase, String execution, String expectedTitle) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			signup.clickOnEmailSignUp();
			signup.verifyLogoAndTitle(expectedTitle);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "validations", dataProviderClass = SignUpProvider.class)
	public void SIGNUP_verifyValidations(String testcase, String execution, String fnameValue, String fname,
			String emailValue, String email, String key, String expectedResult) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			signup.clickOnEmailSignUp();
			signup.EnterNameAndEmail(fnameValue, fname, emailValue, email, key, expectedResult);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "links", dataProviderClass = SignUpProvider.class)
	public void SIGNUP_verifyLinks(String testcase, String execution, String key, String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			signup.clickOnEmailSignUp();
			signup.checkLinks(key, expectedUrl);

		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
