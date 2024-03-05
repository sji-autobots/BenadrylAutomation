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
import com.jnj.dataproviders.DifferenceProvider;

public class ComparePageTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, description = "Verify URL and title", dataProvider = "urlAndTitle", dataProviderClass = DifferenceProvider.class)
	public void DIFFERENCE_verifyURLAndTitle(String testcase, String execution, String menu, String expectedUrl,
			String expectedTitle) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			difference.verifyUrlAndTitle(menu, expectedUrl, expectedTitle);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
