/**
 * @author Vaibhav Nagvekar
 * @date 02-April-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.AllergiesProvider;

public class AllergiesPageTest extends BaseClass {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "allergiesNav", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifyPageNavigation(String testcase, String execution, String menu, String subMenu,
			String expectedUrl, String expectedTitle) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifyUrlAndTitle(expectedUrl, expectedTitle);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "allergyBanner", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifyBanner(String testcase, String execution, String menu, String subMenu,
			String expectedHeading, String expectedDesc) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifyBanner(expectedHeading,expectedDesc);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "allergyHeader", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifyHeader(String testcase, String execution, String menu, String subMenu, String name,
			String heading) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifyHeader(name, heading);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 4, dataProvider = "links", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifyLinks(String testcase, String execution, String menu, String subMenu, String name, String link, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifyLinks(name,link,expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 5, dataProvider = "relatedArticles", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifyRelatedArticles(String testcase, String execution, String menu, String subMenu, String articles, String expectedArticleName) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifyArticles(articles, expectedArticleName);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 6, dataProvider = "relatedProducts", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifyRelatedProducts(String testcase, String execution, String menu, String subMenu, String head, String product, String expectedUrl, String ages, String expectedProductName) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			compare.verifyRelatedProducts(head, product, expectedUrl, ages, expectedProductName);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 7, dataProvider = "references", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifyReferenceLinks(String testcase, String execution, String menu, String subMenu, String refLinks, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifyReference(refLinks, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
