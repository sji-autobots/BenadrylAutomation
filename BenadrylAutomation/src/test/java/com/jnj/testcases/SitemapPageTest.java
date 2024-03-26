/**
 * @author Vaibhav Nagvekar
 * @date 19-Mar-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.SitemapProvider;

public class SitemapPageTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "title", dataProviderClass = SitemapProvider.class)
	public void SITEMAP_verifyTitleAndURL(String testcase, String execution, String value, String expectedTitle,
			String expectedURL) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.clickOnFooterLink(value);
			sitemap.verifyTitleAndUrl(expectedTitle, expectedURL);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "links", dataProviderClass = SitemapProvider.class)
	public void SITEMAP_verifyLinks(String testcase, String execution, String value, String keyword, String linkValue,
			String expectedURL) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.clickOnFooterLink(value);
			sitemap.verifyLinks(keyword, linkValue, expectedURL);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
