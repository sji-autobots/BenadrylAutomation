/**
 * @author Vaibhav Nagvekar
 * @date 02-April-24
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
	
	@org.testng.annotations.DataProvider(name = "links")
	public Object[][] links() throws IOException {
		return provider.getData(dataPath, "links");
	}
	
	@org.testng.annotations.DataProvider(name = "relatedArticles")
	public Object[][] relatedArticles() throws IOException {
		return provider.getData(dataPath, "relatedArticles");
	}
	
	@org.testng.annotations.DataProvider(name = "relatedProducts")
	public Object[][] relatedProducts() throws IOException {
		return provider.getData(dataPath, "relatedProducts");
	}
	
	@org.testng.annotations.DataProvider(name = "references")
	public Object[][] references() throws IOException {
		return provider.getData(dataPath, "references");
	}
}
