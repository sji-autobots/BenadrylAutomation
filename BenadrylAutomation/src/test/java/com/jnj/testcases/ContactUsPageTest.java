/**
 * @author Vaibhav Nagvekar
 * @date 27-Mar-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.ContactUsProvider;

public class ContactUsPageTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "urlAndTitle", dataProviderClass = ContactUsProvider.class)
	public void CONTACTUS_verifyTitleAndURL(String testcase, String execution, String value, String expectedTitle,
			String expectedURL) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.clickOnFooterLink(value);
			contact.verifyUrlAndTitle(expectedURL, expectedTitle);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "tabs", dataProviderClass = ContactUsProvider.class)
	public void CONTACTUS_verifyTabs(String testcase, String execution, String value, String header, String tab,
			String tabDetails) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.clickOnFooterLink(value);
			contact.checkTabs(header, tab, tabDetails);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "links", dataProviderClass = ContactUsProvider.class)
	public void CONTACTUS_verifyTabLinks(String testcase, String execution, String value, String header, String tab,
			String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.clickOnFooterLink(value);
			contact.checkTabLinks(tab, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "allFaq", dataProviderClass = ContactUsProvider.class)
	public void CONTACTUS_verifyFAQs(String testcase, String execution, String value, String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.clickOnFooterLink(value);
			contact.verifyFaq(expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 5, dataProvider = "contacts", dataProviderClass = ContactUsProvider.class)
	public void CONTACTUS_verifyConatctHeading(String testcase, String execution, String value, String conValue) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.clickOnFooterLink(value);
			contact.verifyContactDetails(conValue);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 6, dataProvider = "stayConnected", dataProviderClass = ContactUsProvider.class)
	public void CONTACTUS_verifySocailMediaLinks(String testcase, String execution, String value, String header,
			String linkValue, String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.clickOnFooterLink(value);
			contact.verifyStayConnectedlinks(header, linkValue, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
