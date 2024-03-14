/**
 * @author Vaibhav Nagvekar
 * @date 12-March-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.OurIngredientsProvider;

public class OurIngredientsPageTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "urlAndTitle", dataProviderClass = OurIngredientsProvider.class)
	public void OURINGREDIENTS_verifyURLAndTitle(String testcase, String execution, String menu, String subMenu,
			String expectedUrl, String expectedTitle, String expectedDescription, String expectedBannerLink)
			throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			ingredient.verifyUrlAndTitle(expectedUrl, expectedTitle, expectedDescription, expectedBannerLink);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "headersAndContent", dataProviderClass = OurIngredientsProvider.class)
	public void OURINGREDIENTS_verifyHeadersAndContent(String testcase, String execution, String menu, String subMenu,
			String title, String head, String content) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			ingredient.verifyHeadersAndContent(title, head, content);

		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "relatedContent", dataProviderClass = OurIngredientsProvider.class)
	public void OURINGREDIENTS_verifyRelatedContent(String testcase, String execution, String menu, String subMenu,
			String head, String title, String readMore, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			ingredient.verifyContents(head, title, readMore, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "relatedProduct", dataProviderClass = OurIngredientsProvider.class)
	public void OURINGREDIENTS_verifyRelatedProduct(String testcase, String execution, String menu, String subMenu,
			String head, String product, String expectedUrl, String ages, String expectedProductName)
			throws InterruptedException {
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

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
