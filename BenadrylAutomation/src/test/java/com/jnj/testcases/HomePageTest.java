/**
 * @author Rashi Tiwari
 * @date 1-March-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.HomePageProvider;

public class HomePageTest extends BaseClass{
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, description = "Verify the banner", dataProvider = "homePage", dataProviderClass = HomePageProvider.class, enabled = true)
	public void HOME_verifyBanner(String testcase, String execution, String expectedHeading, String expectedUrl ) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			home.verifyHomeBanner(expectedHeading, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, description = "Verify - Our Products section", dataProvider = "ourProducts", dataProviderClass = HomePageProvider.class, enabled = true)
	public void HOME_verifyOurProducts(String testcase, String execution,String index, String expectedHeading, String expectedUrl,String productName, String pdctURL ) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			home.verifyOurProducts(index, expectedHeading, expectedUrl, productName, pdctURL);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, description = "Verify - BestSeller section", dataProvider = "bestSeller", dataProviderClass = HomePageProvider.class, enabled = true)
	public void HOME_verifyBestSeller(String testcase, String execution,String expectedHeading) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			home.verifyBestSeller(expectedHeading);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, description = "Verify - Related Content section", dataProvider = "relatedContent", dataProviderClass = HomePageProvider.class, enabled = true)
	public void HOME_verifyRelatedContent(String testcase, String execution, String expectedHeading, String index,String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			home.verifyRelatedContent( expectedHeading,  index,  expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 5, description = "Verify - Allergy section", dataProvider = "allergy", dataProviderClass = HomePageProvider.class, enabled = true)
	public void HOME_verifyAllergySection(String testcase, String execution, String sectionName, String expectedHeading,String sectionBtn, String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			home.verifyAllergySection(sectionName, expectedHeading,sectionBtn, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 6, description = "Verify - More On Benadryl", dataProvider = "moreOn", dataProviderClass = HomePageProvider.class, enabled = true)
	public void HOME_verifyMoreOnSection(String testcase, String execution, String expHeading,String pdctName, String expURL) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			home.moreOnSection(expHeading, pdctName,expURL);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
