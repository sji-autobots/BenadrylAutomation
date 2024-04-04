/**
 * @author Goutam Naik
 * @date 27-March-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.WhereToBuyProvider;

public class WhereToBuyTest extends BaseClass {

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
	}

	@Test(priority = 1, dataProvider = "headerVerification", dataProviderClass = WhereToBuyProvider.class)
	public void WTB_verifyHeader(String testcase, String execution, String expectedUrl, String expectedHeader) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.verifyWhereToBuyLink(expectedUrl);
			wtb.verifyHeading(expectedHeader);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 2, dataProvider = "productSearch", dataProviderClass = WhereToBuyProvider.class)
	public void WTB_verifyProductSearch(String testcase, String execution, String expectedUrl, String productKey) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.verifyWhereToBuyLink(expectedUrl);
			wtb.searchProduct(productKey);
			wtb.verifyCategoryAndSize();
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 3, dataProvider = "changeCategorySize", dataProviderClass = WhereToBuyProvider.class)
	public void WTB_verifyCategoryAndSizeChanges(String testcase, String execution, String expectedUrl,
			String productKey, String category, String size, String expectedNewProduct) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.verifyWhereToBuyLink(expectedUrl);
			wtb.searchProduct(productKey);
			wtb.changeProductOptions(category, size);
			wtb.verifyProductName(expectedNewProduct);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 4, dataProvider = "verifyStores", dataProviderClass = WhereToBuyProvider.class)
	public void WTB_verifyStoresRedirection(String testcase, String execution, String expectedUrl, String location,
			String storeName, String expectedStoreUrl) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.verifyWhereToBuyLink(expectedUrl);
			wtb.searchLocation(location);
			wtb.checkStoreRedirection(storeName, expectedStoreUrl);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@Test(priority = 5, dataProvider = "verifyLocations", dataProviderClass = WhereToBuyProvider.class)
	public void WTB_verifyRelevantStoreLocationsDisplayed(String testcase, String execution, String expectedUrl,
			String location) {
		test = test.createNode(testcase);
		if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
			header.verifyWhereToBuyLink(expectedUrl);
			wtb.searchLocation(location);
			wtb.verifyAddressesForStores(location);
		} else {
			throw new SkipException("Test skipped : " + testcase);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}