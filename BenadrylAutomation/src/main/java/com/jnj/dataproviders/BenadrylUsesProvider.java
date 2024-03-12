package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class BenadrylUsesProvider {
	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\BenadrylUsesTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "banner")
	public Object[][] banner() throws IOException {
		return provider.getData(dataPath, "banner");
	}


}
