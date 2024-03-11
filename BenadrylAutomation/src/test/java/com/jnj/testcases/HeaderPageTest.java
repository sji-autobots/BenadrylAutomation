/**
 * @author Goutam Naik
 * @date 27-Feb-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.actions.Action;
import com.jnj.base.BaseClass;
import com.jnj.dataproviders.HeaderProvider;

public class HeaderPageTest extends BaseClass {
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "headerMainMenu", dataProviderClass = HeaderProvider.class)
	public void HEADER_verifyMainMenuLink(String testcase, String execution, String menu, String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.verifyMainMenuLink(menu, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "headerSubMenu", dataProviderClass = HeaderProvider.class)
	public void HEADER_verifySubMenuLink(String testcase, String execution, String menu, String subMenu,
			String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			Action.verifyPageUrl(expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "whereToBuy", dataProviderClass = HeaderProvider.class)
	public void HEADER_verifyWhereToBuyLink(String testcase, String execution, String expectedUrl)
			throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.verifyWhereToBuyLink(expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "language", dataProviderClass = HeaderProvider.class)
	public void HEADER_verifyLanguageLink(String testcase, String execution, String locale, String expectedUrl)
			throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.changeLanguageTo(locale, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 5, dataProvider = "search", dataProviderClass = HeaderProvider.class)
	public void HEADER_search(String testcase, String execution, String criteria, String expectedUrl)
			throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.initiateSearch(criteria);
			Action.verifyPageUrl(expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
