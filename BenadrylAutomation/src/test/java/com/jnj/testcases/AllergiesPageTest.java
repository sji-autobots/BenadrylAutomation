/**
 * @author Rashi Tiwari
 * @date 21-March-24
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
			String expectedHeading) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifyBanner(expectedHeading);
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
			allergies.verifyHeaderScrolling(name, heading);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "allergyHeaderSecond", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifySecondHeader(String testcase, String execution, String menu, String subMenu,
			String name, String headingScroll) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifySecondHeaderScrolling(name, headingScroll);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 5, dataProvider = "relatedContent", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifyRelatedContentCard(String testcase, String execution, String menu, String subMenu,
			String index) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifyRelatedContent(index);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 6, dataProvider = "relatedProduct", dataProviderClass = AllergiesProvider.class)
	public void ALLERGIES_verifyRelatedProduct(String testcase, String execution, String menu, String subMenu)
			throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			allergies.verifyRelatedProduct();
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
