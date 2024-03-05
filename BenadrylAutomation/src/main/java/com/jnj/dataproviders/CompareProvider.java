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

}
