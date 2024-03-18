package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.HeaderProvider;

public class AllergiesPageTest extends BaseClass {
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "allergy", dataProviderClass = HeaderProvider.class)
	public void HEADER_verifyMainMenuLink(String testcase, String execution, String menu, String subMenu, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
}
