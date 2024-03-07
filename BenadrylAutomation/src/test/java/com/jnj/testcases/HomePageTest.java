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

public class HomePageTest extends BaseClass {
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "homePage", dataProviderClass = HomePageProvider.class)
	public void HOME_verifyBanner(String testcase, String execution, String expectedHeading, String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.verifyHomeBanner(expectedHeading, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "ourProducts", dataProviderClass = HomePageProvider.class)
	public void HOME_verifyOurProducts(String testcase, String execution, String index, String expectedHeading,
			String expectedUrl, String productName, String pdctURL) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.verifyOurProducts(index, expectedHeading, expectedUrl, productName, pdctURL);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "bestSeller", dataProviderClass = HomePageProvider.class)
	public void HOME_verifyBestSeller(String testcase, String execution, String expectedHeading) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.verifyBestSeller(expectedHeading);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "relatedContent", dataProviderClass = HomePageProvider.class)
	public void HOME_verifyRelatedContent(String testcase, String execution, String expectedHeading, String index,
			String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.verifyRelatedContent(expectedHeading, index, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 5, dataProvider = "allergy", dataProviderClass = HomePageProvider.class)
	public void HOME_verifyAllergySection(String testcase, String execution, String sectionName, String expectedHeading,
			String sectionBtn, String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.verifyAllergySection(sectionName, expectedHeading, sectionBtn, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 6, dataProvider = "moreOn", dataProviderClass = HomePageProvider.class)
	public void HOME_verifyMoreOnSection(String testcase, String execution, String expHeading, String pdctName,
			String expURL) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.moreOnSection(expHeading, pdctName, expURL);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
