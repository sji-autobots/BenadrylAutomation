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
	
	@Test(priority = 1, description = "Verify the footer link of first column", dataProvider = "footer", dataProviderClass = FooterProvider.class, enabled = true)
	public void Footer_verifyFirstColumn(String testcase, String execution, String link , String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			footer.verifyFooterlink(link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}  
	
	@Test(priority = 2, description = "Verify the footer link of second column", dataProvider = "footerSecondColumn", dataProviderClass = FooterProvider.class, enabled = true)
	public void Footer_verifySecondColumn(String testcase, String execution, String link , String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			footer.getSecondfooteroption(link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}  
	
	@Test(priority = 3, description = "Verify the footer link of third column", dataProvider = "footerLastColumn", dataProviderClass = FooterProvider.class, enabled = true)
	public void Footer_verifyThirdColumn(String testcase, String execution, String link , String expectedUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			footer.getThirdfooteroption(link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}  
	
	@Test(priority = 4, description = "Verify the footer heading", dataProvider = "footerHeading", dataProviderClass = FooterProvider.class, enabled = true)
	public void Footer_verifyheading(String testcase, String execution, String link) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
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