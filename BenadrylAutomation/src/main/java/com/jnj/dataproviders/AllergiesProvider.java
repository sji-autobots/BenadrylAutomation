/**
 * @author Rashi Tiwari
 * @date 21-March-24
 */
package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class AllergiesProvider {
	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\AllergiesTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "allergiesNav")
	public Object[][] allergiesNav() throws IOException {
		return provider.getData(dataPath, "allergiesNav");
	}
	
	@org.testng.annotations.DataProvider(name = "allergyBanner")
	public Object[][] allergyBanner() throws IOException {
		return provider.getData(dataPath, "allergyBanner");
	}
	
	@org.testng.annotations.DataProvider(name = "allergyHeader")
	public Object[][] allergyHeader() throws IOException {
		return provider.getData(dataPath, "allergyHeader");
	}
	
	@org.testng.annotations.DataProvider(name = "allergyHeaderSecond")
	public Object[][] allergyHeaderSecond() throws IOException {
		return provider.getData(dataPath, "allergyHeaderSecond");
	}
	
	@org.testng.annotations.DataProvider(name = "relatedContent")
	public Object[][] relatedContent() throws IOException {
		return provider.getData(dataPath, "relatedContent");
	}
	
	@org.testng.annotations.DataProvider(name = "relatedProduct")
	public Object[][] relatedProduct() throws IOException {
		return provider.getData(dataPath, "relatedProduct");
	}
}
