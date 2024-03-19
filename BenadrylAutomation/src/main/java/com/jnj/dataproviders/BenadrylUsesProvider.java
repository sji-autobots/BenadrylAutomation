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
	
	@org.testng.annotations.DataProvider(name = "seasonalAllergies")
	public Object[][] seasonalAllergies() throws IOException {
		return provider.getData(dataPath, "seasonalAllergies");
	}

	@org.testng.annotations.DataProvider(name = "allergiesDesc")
	public Object[][] allergiesDesc() throws IOException {
		return provider.getData(dataPath, "allergiesDesc");
	}
	
	@org.testng.annotations.DataProvider(name = "symptoms")
	public Object[][] symptoms() throws IOException {
		return provider.getData(dataPath, "symptoms");
	}
	
	@org.testng.annotations.DataProvider(name = "links")
	public Object[][] links() throws IOException {
		return provider.getData(dataPath, "links");
	}
	
	@org.testng.annotations.DataProvider(name = "headings")
	public Object[][] headings() throws IOException {
		return provider.getData(dataPath, "headings");
	}
}
