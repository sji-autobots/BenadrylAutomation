/**
 * @author Vaibhav Nagvekar
 * @date 05-Mar-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class CompareProvider {

	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\CompareTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "urlAndTitle")
	public Object[][] urlAndTitle() throws IOException {
		return provider.getData(dataPath, "urlAndTitle");
	}

	@org.testng.annotations.DataProvider(name = "headingAndLinks")
	public Object[][] headingAndLinks() throws IOException {
		return provider.getData(dataPath, "headingAndLinks");
	}
	
	@org.testng.annotations.DataProvider(name = "medication")
	public Object[][] medication() throws IOException {
		return provider.getData(dataPath, "medication");
	}
	
	@org.testng.annotations.DataProvider(name = "relatedProduct")
	public Object[][] relatedProduct() throws IOException {
		return provider.getData(dataPath, "relatedProduct");
	}

	@org.testng.annotations.DataProvider(name = "relatedArticle")
	public Object[][] relatedArticle() throws IOException {
		return provider.getData(dataPath, "relatedArticle");
	}

	@org.testng.annotations.DataProvider(name = "references")
	public Object[][] references() throws IOException {
		return provider.getData(dataPath, "references");
	}
}
