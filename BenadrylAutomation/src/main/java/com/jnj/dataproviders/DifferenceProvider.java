/**
 * @author Vaibhav Nagvekar
 * @date 01-Mar-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class DifferenceProvider {

	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\DifferenceTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "urlAndTitle")
	public Object[][] urlAndTitle() throws IOException {
		return provider.getData(dataPath, "urlAndTitle");
	}

	@org.testng.annotations.DataProvider(name = "headingAndLinks")
	public Object[][] headingAndLinks() throws IOException {
		return provider.getData(dataPath, "headingAndLinks");
	}

	@org.testng.annotations.DataProvider(name = "relatedContent")
	public Object[][] relatedContent() throws IOException {
		return provider.getData(dataPath, "relatedContent");
	}

	@org.testng.annotations.DataProvider(name = "relatedProducts")
	public Object[][] relatedProducts() throws IOException {
		return provider.getData(dataPath, "relatedProducts");
	}
}
