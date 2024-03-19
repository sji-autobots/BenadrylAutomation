/**
 * @author Rashi Tiwari
 * @date 18-March-24
 */
package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.FooterProvider;

public class FooterPageTest extends BaseClass {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}
	
	@Test(priority = 1, dataProvider = "footer", dataProviderClass = FooterProvider.class)
	public void FOOTER_verifyFirstColumn(String testcase, String execution, String link , String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.verifyFooterlink(link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}  
	
	@Test(priority = 2, dataProvider = "footerSecondColumn", dataProviderClass = FooterProvider.class)
	public void FOOTER_verifySecondColumn(String testcase, String execution, String link , String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.verifySecondFooterOption(link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}  
	
	@Test(priority = 3,dataProvider = "footerLastColumn", dataProviderClass = FooterProvider.class)
	public void FOOTER_verifyThirdColumn(String testcase, String execution, String link , String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.verifyThirdFooterOption(link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}  
	
	@Test(priority = 4,dataProvider = "footerHeading", dataProviderClass = FooterProvider.class)
	public void FOOTER_verifyheading(String testcase, String execution, String link) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			footer.footerHeading(link);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}  
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}