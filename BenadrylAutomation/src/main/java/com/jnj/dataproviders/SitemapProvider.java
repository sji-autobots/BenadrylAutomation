/**
 * @author Vaibhav Nagvekar
 * @date 19-Mar-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class SitemapProvider {

	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\SitemapTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "title")
	public Object[][] title() throws IOException {
		return provider.getData(dataPath, "title");
	}
	
	@org.testng.annotations.DataProvider(name = "links")
	public Object[][] links() throws IOException {
		return provider.getData(dataPath, "links");
	}

}
