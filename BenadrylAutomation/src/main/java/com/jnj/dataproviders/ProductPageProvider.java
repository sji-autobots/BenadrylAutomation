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

    @org.testng.annotations.DataProvider(name = "prodPage")
    public Object[][] prodPage() throws IOException {
        return provider.getData(dataPath, "prodPage");
    }

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

    @org.testng.annotations.DataProvider(name = "jumpTo")
    public Object[][] jumpTo() throws IOException {
        return provider.getData(dataPath, "jumpTo");
    }
}
