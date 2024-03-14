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

public class ListingPageTest extends BaseClass {
    @BeforeClass
    public void setup() throws InterruptedException {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "prodImg", dataProviderClass = ProductPageProvider.class)
    public void PDP_verifyProductImage(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
			selectEnv(runOn);
//            plp.verifyProdImage();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
