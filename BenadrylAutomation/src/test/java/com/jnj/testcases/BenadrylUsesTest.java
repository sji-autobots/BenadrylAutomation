/**
 * @author Goutam Naik
 * @date 12-Mar-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.BenadrylUsesProvider;

public class BenadrylUsesTest extends BaseClass {
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "banner", dataProviderClass = BenadrylUsesProvider.class)
	public void USES_verifyBannerContent(String testcase, String execution, String menu, String subMenu, String heading, String description) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			signup.closeSignUpPopup();
			uses.verifyMainHeaderInfo(heading, description);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 2, dataProvider = "seasonalAllergies", dataProviderClass = BenadrylUsesProvider.class)
	public void USES_verifySeasonalAllergies(String testcase, String execution, String menu, String subMenu, String expectedHeading, String expectedDescription, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			signup.closeSignUpPopup();
			uses.verifySeasonalAllergies(expectedHeading, expectedDescription, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 3, dataProvider = "allergiesDesc", dataProviderClass = BenadrylUsesProvider.class)
	public void USES_verifyAllergiesDesc(String testcase, String execution, String menu, String subMenu, String section, String heading, String description) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			signup.closeSignUpPopup();
			uses.verifyAllergiesDesc(section, heading, description);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 3, dataProvider = "symptoms", dataProviderClass = BenadrylUsesProvider.class)
	public void USES_verifySymptomCasuses(String testcase, String execution, String menu, String subMenu, String symptom, String cause, String description) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			signup.closeSignUpPopup();
			uses.verifySymptomCasuses(symptom, cause, description);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "links", dataProviderClass = BenadrylUsesProvider.class)
	public void USES_verifylinksUnder(String testcase, String execution, String menu, String subMenu, String linktext, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			signup.closeSignUpPopup();
			uses.verifyLink(linktext, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 5, dataProvider = "headings", dataProviderClass = BenadrylUsesProvider.class)
	public void USES_verifyHeading(String testcase, String execution, String menu, String subMenu, String heading) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			signup.closeSignUpPopup();
			uses.verifyheading(heading);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 6, dataProvider = "relatedProduct", dataProviderClass = BenadrylUsesProvider.class)
	public void USES_verifyRelatedProduct(String testcase, String execution, String menu, String subMenu, String head,
			String product, String expectedUrl, String ages, String expectedProductName) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			signup.closeSignUpPopup();
			compare.verifyRelatedProducts(head, product, expectedUrl, ages, expectedProductName);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 7, dataProvider = "relatedContent", dataProviderClass = BenadrylUsesProvider.class)
	public void USES_verifyRelatedArticle(String testcase, String execution, String menu, String subMenu, String head,
			String title, String readMore, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			signup.closeSignUpPopup();
			uses.verifyArticles(head, title, readMore, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@Test(priority = 8, dataProvider = "references", dataProviderClass = BenadrylUsesProvider.class)
	public void USES_verifyReferences(String testcase, String execution, String menu, String subMenu, String head,
			String refText, String link, String expectedUrl) throws InterruptedException {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.navigateSubMenuLink(menu, subMenu);
			signup.closeSignUpPopup();
			uses.verifyReferences(head, refText, link, expectedUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
