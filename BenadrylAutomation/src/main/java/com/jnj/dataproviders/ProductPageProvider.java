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

    @org.testng.annotations.DataProvider(name = "jumpTo")
    public Object[][] jumpTo() throws IOException {
        return provider.getData(dataPath, "jumpTo");
    }
}
