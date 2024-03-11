/**
 * @author Vaibhav Nagvekar
 * @date 01-Mar-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.DifferenceProvider;

public class DifferencePageTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "urlAndTitle", dataProviderClass = DifferenceProvider.class)
	public void DIFFERENCE_verifyURLAndTitle(String testcase, String execution, String menu, String expectedUrl,
			String expectedTitle) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			difference.verifyUrlAndTitle(menu, expectedUrl, expectedTitle);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "headingAndLinks", dataProviderClass = DifferenceProvider.class)
	public void DIFFERENCE_verifyHeadingAndLinks(String testcase, String execution, String menu, String heading,
			String link, String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			difference.verifyHeadingsAndLinks(menu, heading, link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "relatedContent", dataProviderClass = DifferenceProvider.class)
	public void DIFFERENCE_verifyRelatedContent(String testcase, String execution, String menu, String header,
			String title, String readMore, String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			difference.verifyArticles(menu, header, title, readMore, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "relatedProducts", dataProviderClass = DifferenceProvider.class)
	public void DIFFERENCE_verifyRelatedProducts(String testcase, String execution, String menu, String header,
			String product, String expectedUrl, String ages, String expectedProductName) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			difference.verifyRelatedProducts(menu, header, product, expectedUrl, ages, expectedProductName);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
