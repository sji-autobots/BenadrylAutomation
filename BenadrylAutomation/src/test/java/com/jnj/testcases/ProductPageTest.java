/**
 * @author Zahin Ahad
 * @date 4-March-24
 */

package com.jnj.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jnj.base.BaseClass;
import com.jnj.dataproviders.ProductPageProvider;

public class ProductPageTest extends BaseClass {
    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApplication();
    }

    @Test(priority = 1, description = "Verify the product image", dataProvider = "prodPage", dataProviderClass = ProductPageProvider.class, enabled = true)
    public void PDP_verifyProductImage(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            pdp.verifyProdImage();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, description = "Verify the product title", dataProvider = "prodPage", dataProviderClass = ProductPageProvider.class, enabled = true)
    public void PDP_verifyProductTitle(String testcase, String execution, String expectedText) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            pdp.verifyProdTitle(expectedText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, description = "Verify the product rating", dataProvider = "prodPage", dataProviderClass = ProductPageProvider.class, enabled = true)
    public void PDP_verifyProductRating(String testcase, String execution, String expectedText) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            pdp.verifyProdRating();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, description = "Verify the product overview", dataProvider = "prodPage", dataProviderClass = ProductPageProvider.class, enabled = true)
    public void PDP_verifyProductOverview(String testcase, String execution, String expectedText) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            pdp.verifyProdOverview();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 5, description = "Verify the write a review button", dataProvider = "prodPage", dataProviderClass = ProductPageProvider.class, enabled = true)
    public void PDP_verifyWriteAReviewButton(String testcase, String execution, String expectedText) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            pdp.verifyWriteAReviewBtn(expectedText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 6, description = "Verify the buy now button", dataProvider = "prodPage", dataProviderClass = ProductPageProvider.class, enabled = true)
    public void PDP_verifyBuyNowButton(String testcase, String execution, String expectedText) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            pdp.verifyBuyNowBtn(expectedText);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}