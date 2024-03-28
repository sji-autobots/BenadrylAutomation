package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class WhereToBuyProvider {
	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\whereToBuyTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "headerVerification")
	public Object[][] headerVerification() throws IOException {
		return provider.getData(dataPath, "headerVerification");
	}
}
