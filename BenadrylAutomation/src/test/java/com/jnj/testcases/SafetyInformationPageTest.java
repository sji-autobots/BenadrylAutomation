/**
 * @author Vaibhav Nagvekar
 * @date 15-Mar-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.SafetyInformationProvider;

public class SafetyInformationPageTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "urlAndTitle", dataProviderClass = SafetyInformationProvider.class)
	public void SAFETY_verifyURLAndTitle(String testcase, String execution, String menu, String subMenu,
			String expectedUrl, String expectedTitle, String expectedDescription)
			throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			safety.verifyUrlAndTitle(expectedUrl, expectedTitle, expectedDescription);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "links", dataProviderClass = SafetyInformationProvider.class)
	public void SAFETY_verifyURLs(String testcase, String execution, String menu, String subMenu, String keyword,
			String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			safety.verifyLinks(keyword, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "relatedProduct", dataProviderClass = SafetyInformationProvider.class)
	public void SAFETY_verifyRelatedProduct(String testcase, String execution, String menu, String subMenu, String head,
			String product, String expectedUrl, String ages, String expectedProductName) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			safety.verifyRelatedProducts(head, product, expectedUrl, ages, expectedProductName);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "relatedContent", dataProviderClass = SafetyInformationProvider.class)
	public void SAFETY_verifyRelatedArticle(String testcase, String execution, String menu, String subMenu, String head,
			String title, String readMore, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			compare.verifyArticles(head, title, readMore, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
