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

	@Test(priority = 1, description = "Verify URL and title", dataProvider = "urlAndTitle", dataProviderClass = DifferenceProvider.class)
	public void DIFFERENCE_verifyURLAndTitle(String testcase, String execution, String menu, String expectedUrl,
			String expectedTitle) {
		if (execution.equalsIgnoreCase(defaultFlag)) {
			extentInfoLog("Test case : ", testcase);
			difference.verifyUrlAndTitle(menu, expectedUrl, expectedTitle);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, description = "Verify heading and links", dataProvider = "headingAndLinks", dataProviderClass = DifferenceProvider.class)
	public void DIFFERENCE_verifyHeadingAndLinks(String testcase, String execution, String menu, String heading,
			String link, String expectedUrl) {
		if (execution.equalsIgnoreCase(defaultFlag)) {
			extentInfoLog("Test case : ", testcase);
			difference.verifyHeadingsAndLinks(menu, heading, link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, description = "Verify Related Content", dataProvider = "relatedContent", dataProviderClass = DifferenceProvider.class)
	public void DIFFERENCE_verifyRelatedContent(String testcase, String execution, String menu, String header,
			String title, String readMore, String expectedUrl) {
		if (execution.equalsIgnoreCase(defaultFlag)) {
			extentInfoLog("Test case : ", testcase);
			difference.verifyArticles(menu, header, title, readMore, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, description = "Verify Related Content", dataProvider = "relatedProducts", dataProviderClass = DifferenceProvider.class)
	public void DIFFERENCE_verifyRelatedProducts(String testcase, String execution, String menu, String header,
			String product, String expectedUrl, String ages, String expectedProductNmae) {
		if (execution.equalsIgnoreCase(defaultFlag)) {
			extentInfoLog("Test case : ", testcase);
			difference.verifyRelatedProducts(menu, header, product, expectedUrl, ages, expectedProductNmae);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
