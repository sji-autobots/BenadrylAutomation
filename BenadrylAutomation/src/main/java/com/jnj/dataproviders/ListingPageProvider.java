/**
 * @author Zahin Ahad
 * @date 4-March-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class ListingPageProvider {

    DataFormatter formatter = new DataFormatter();
    String dataPath = "src\\test\\resources\\TestData\\ListingPageTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "bannerImg")
    public Object[][] bannerImg() throws IOException {
        return provider.getData(dataPath, "bannerImg");
    }

    @org.testng.annotations.DataProvider(name = "bannerTexts")
    public Object[][] bannerTexts() throws IOException {
        return provider.getData(dataPath, "bannerTexts");
    }

    @org.testng.annotations.DataProvider(name = "quickFilter")
    public Object[][] quickFilter() throws IOException {
        return provider.getData(dataPath, "quickFilter");
    }

    @org.testng.annotations.DataProvider(name = "products")
    public Object[][] products() throws IOException {
        return provider.getData(dataPath, "products");
    }
}
