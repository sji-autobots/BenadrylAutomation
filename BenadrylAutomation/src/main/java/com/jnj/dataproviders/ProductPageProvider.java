/**
 * @author Zahin Ahad
 * @date 4-March-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class ProductPageProvider {

    DataFormatter formatter = new DataFormatter();
    String dataPath = "src\\test\\resources\\TestData\\ProdPageTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "prodImg")
    public Object[][] prodImg() throws IOException {
        return provider.getData(dataPath, "prodImg");
    }

    @org.testng.annotations.DataProvider(name = "prodTitle")
    public Object[][] prodTitle() throws IOException {
        return provider.getData(dataPath, "prodTitle");
    }

    @org.testng.annotations.DataProvider(name = "prodRating")
    public Object[][] prodRating() throws IOException {
        return provider.getData(dataPath, "prodRating");
    }

    @org.testng.annotations.DataProvider(name = "prodOverview")
    public Object[][] prodOverview() throws IOException {
        return provider.getData(dataPath, "prodOverview");
    }

    @org.testng.annotations.DataProvider(name = "prodPageBtns")
    public Object[][] prodPageBtns() throws IOException {
        return provider.getData(dataPath, "prodPageBtns");
    }

    @org.testng.annotations.DataProvider(name = "jumpToOverview")
    public Object[][] jumpToOverview() throws IOException {
        return provider.getData(dataPath, "jumpToOverview");
    }

    @org.testng.annotations.DataProvider(name = "jumpToDirections")
    public Object[][] jumpToDirections() throws IOException {
        return provider.getData(dataPath, "jumpToDirections");
    }

    @org.testng.annotations.DataProvider(name = "jumpToIngredients")
    public Object[][] jumpToIngredients() throws IOException {
        return provider.getData(dataPath, "jumpToIngredients");
    }

    @org.testng.annotations.DataProvider(name = "jumpToUsed")
    public Object[][] jumpToUsed() throws IOException {
        return provider.getData(dataPath, "jumpToUsed");
    }

    @org.testng.annotations.DataProvider(name = "jumpToWarnings")
    public Object[][] jumpToWarnings() throws IOException {
        return provider.getData(dataPath, "jumpToWarnings");
    }

    @org.testng.annotations.DataProvider(name = "jumpToFAQs")
    public Object[][] jumpToFAQs() throws IOException {
        return provider.getData(dataPath, "jumpToFAQs");
    }

    @org.testng.annotations.DataProvider(name = "jumpToReviews")
    public Object[][] jumpToReviews() throws IOException {
        return provider.getData(dataPath, "jumpToReviews");
    }

    @org.testng.annotations.DataProvider(name = "jumpTo")
    public Object[][] jumpTo() throws IOException {
        return provider.getData(dataPath, "jumpTo");
    }
}
