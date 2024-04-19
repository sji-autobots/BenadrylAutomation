/**
 * @author Zahin Ahad
 * @date 4-March-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.ListingPageProvider;
import com.jnj.dataproviders.ProductPageProvider;

public class ListingPageTest extends BaseClass {
    @BeforeClass
    public void setup() throws InterruptedException {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "bannerImg", dataProviderClass = ListingPageProvider.class)
    public void PLP_verifyBannerImage(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
			home.closePrivacyPopup();
            plp.verifyBannerImage();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "bannerTexts", dataProviderClass = ListingPageProvider.class)
    public void PLP_verifyBannerTexts(String testcase, String execution, String expectedText) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            plp.verifyBannerTexts(expectedText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "quickFilter", dataProviderClass = ListingPageProvider.class)
    public void PLP_verifyQuickFilters(String testcase, String execution, String expectedText) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            plp.verifyQuickFilters(expectedText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "sortBy", dataProviderClass = ListingPageProvider.class)
    public void PLP_verifySortBy(String testcase, String execution, String selectorText) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            plp.verifySortBy(selectorText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
