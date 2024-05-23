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

    @org.testng.annotations.DataProvider(name = "sortBy")
    public Object[][] sortBy() throws IOException {
        return provider.getData(dataPath, "sortBy");
    }

    @org.testng.annotations.DataProvider(name = "article")
    public Object[][] article() throws IOException {
        return provider.getData(dataPath, "article");
    }

    @org.testng.annotations.DataProvider(name = "filter")
    public Object[][] filter() throws IOException {
        return provider.getData(dataPath, "filter");
    }
}
