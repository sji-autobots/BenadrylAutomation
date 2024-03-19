/**
 * @author Vaibhav Nagvekar
 * @date 15-Mar-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class SafetyInformationProvider {

	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\SafetyInformationTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "urlAndTitle")
	public Object[][] urlAndTitle() throws IOException {
		return provider.getData(dataPath, "urlAndTitle");
	}

	@org.testng.annotations.DataProvider(name = "links")
	public Object[][] links() throws IOException {
		return provider.getData(dataPath, "links");
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
