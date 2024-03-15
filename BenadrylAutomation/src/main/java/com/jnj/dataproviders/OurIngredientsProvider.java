/**
 * @author Vaibhav Nagvekar
 * @date 12-March-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class OurIngredientsProvider {

	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\OurIngredientsTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "urlAndTitle")
	public Object[][] urlAndTitle() throws IOException {
		return provider.getData(dataPath, "urlAndTitle");
	}

	@org.testng.annotations.DataProvider(name = "headersAndContent")
	public Object[][] headersAndContent() throws IOException {
		return provider.getData(dataPath, "headersAndContent");
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
