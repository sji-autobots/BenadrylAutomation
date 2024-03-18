/**
 * @author Goutam Naik
 * @date 27-Feb-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.HeaderProvider;

public class HeaderPageTest extends BaseClass {
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, description = "Verify main menu links", dataProvider = "headerMainMenu", dataProviderClass = HeaderProvider.class, enabled = true)
	public void HEADER_verifyMainMenuLink(String testcase, String execution, String menu, String expectedUrl) {
		if (execution.equalsIgnoreCase(defaultFlag)) {
			extentInfoLog("Test case : ", testcase);
			header.verifyMainMenuLink(menu, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
