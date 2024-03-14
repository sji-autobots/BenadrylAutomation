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
import com.jnj.dataproviders.ProductPageProvider;

public class ProductPageTest extends BaseClass {
    @BeforeClass
    public void setup() throws InterruptedException {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "prodImg", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyProductImage(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyProdImage();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "prodTitle", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyProductTitle(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyProdTitle();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "prodRating", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyProductRating(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyProdRating();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "prodOverview", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyProductOverview(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyProdOverview();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 5, dataProvider = "prodPageBtns", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyButtons(String testcase, String execution, String expectedText) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyButtons(expectedText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 6, dataProvider = "jumpToOverview", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyJumpToOverview(String testcase, String execution, String jumpToHeading, String sectionHeading) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyJumpToOverview(jumpToHeading, sectionHeading);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 7, dataProvider = "jumpToDirections", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyJumpToDirections(String testcase, String execution, String jumpToHeading, String sectionHeading) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyJumpToDirections(jumpToHeading, sectionHeading);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 8, dataProvider = "jumpToIngredients", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyJumpToIngredients(String testcase, String execution, String jumpToHeading, String sectionHeading) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyJumpToIngredients(jumpToHeading, sectionHeading);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 9, dataProvider = "jumpToUsed", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyJumpToUsedFor(String testcase, String execution, String jumpToHeading, String sectionHeading) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyJumpToUsedFor(jumpToHeading, sectionHeading);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 10, dataProvider = "jumpToWarnings", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyJumpToWarnings(String testcase, String execution, String jumpToHeading, String sectionHeading) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyJumpToWarnings(jumpToHeading, sectionHeading);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 11, dataProvider = "jumpToFAQs", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyJumpToFAQs(String testcase, String execution, String jumpToHeading, String sectionHeading) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyJumpToFAQs(jumpToHeading, sectionHeading);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 12, dataProvider = "jumpToReviews", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyJumpToReview(String testcase, String execution, String jumpToHeading) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
            pdp.verifyJumpToReview(jumpToHeading);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
