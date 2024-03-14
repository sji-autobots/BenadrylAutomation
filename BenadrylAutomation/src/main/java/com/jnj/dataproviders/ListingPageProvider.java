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

    @org.testng.annotations.DataProvider(name = "prodPageBtns")
    public Object[][] prodPageBtns() throws IOException {
        return provider.getData(dataPath, "prodPageBtns");
    }
}
