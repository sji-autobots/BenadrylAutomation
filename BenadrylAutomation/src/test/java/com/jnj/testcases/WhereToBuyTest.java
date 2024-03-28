package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.WhereToBuyProvider;

public class WhereToBuyTest extends BaseClass{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "headerVerification", dataProviderClass = WhereToBuyProvider.class)
	public void HEADER_verifyMainMenuLink(String testcase, String execution, String expectedUrl, String expectedHeader) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.verifyWhereToBuyLink(expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
