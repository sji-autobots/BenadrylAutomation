/**
 * @author Vaibhav Nagvekar
 * @date 08-Mar-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class SignUpProvider {

	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\SignUpTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "title")
	public Object[][] title() throws IOException {
		return provider.getData(dataPath, "title");
	}

	@org.testng.annotations.DataProvider(name = "validations")
	public Object[][] validations() throws IOException {
		return provider.getData(dataPath, "validations");
	}

	@org.testng.annotations.DataProvider(name = "links")
	public Object[][] links() throws IOException {
		return provider.getData(dataPath, "links");
	}
}
