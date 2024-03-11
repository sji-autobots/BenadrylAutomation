/**
 * @author Vaibhav Nagvekar
 * @date 05-Mar-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.CompareProvider;

public class ComparePageTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "urlAndTitle", dataProviderClass = CompareProvider.class)
	public void COMPARE_verifyURLAndTitle(String testcase, String execution, String menu, String subMenu,
			String expectedUrl, String expectedTitle, String expectedDescription) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			compare.verifyUrlAndTitle(expectedUrl, expectedTitle, expectedDescription);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "headingAndLinks", dataProviderClass = CompareProvider.class)
	public void COMPARE_verifyHeadingsAndLinks(String testcase, String execution, String menu, String subMenu,
			String heading, String link, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			compare.verifyHeadingAndLinks(heading, link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "medication", dataProviderClass = CompareProvider.class)
	public void COMPARE_verifyMedication(String testcase, String execution, String menu, String subMenu, String head,
			String medication, String benadryl, String claritin, String allegra, String zyrtec, String xyzal)
			throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			compare.verifyMedication(head, medication, benadryl, claritin, allegra, zyrtec, xyzal);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "relatedProduct", dataProviderClass = CompareProvider.class)
	public void COMPARE_verifyRelatedProduct(String testcase, String execution, String menu, String subMenu,
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

	@Test(priority = 5, dataProvider = "relatedArticle", dataProviderClass = CompareProvider.class)
	public void COMPARE_verifyRelatedContent(String testcase, String execution, String menu, String subMenu,
			String head, String title, String readMore, String expectedUrl) throws InterruptedException {
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

	@Test(priority = 6, dataProvider = "references", dataProviderClass = CompareProvider.class)
	public void COMPARE_verifyReferences(String testcase, String execution, String menu, String subMenu, String head,
			String refText, String link, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			compare.verifyReferences(head, refText, link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
