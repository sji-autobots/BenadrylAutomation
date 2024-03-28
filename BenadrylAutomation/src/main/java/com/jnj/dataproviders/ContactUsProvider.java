/**
 * @author Vaibhav Nagvekar
 * @date 27-Mar-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class ContactUsProvider {
	
	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\ContactUsTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "urlAndTitle")
	public Object[][] urlAndTitle() throws IOException {
		return provider.getData(dataPath, "urlAndTitle");
	}
	
	@org.testng.annotations.DataProvider(name = "tabs")
	public Object[][] tabs() throws IOException {
		return provider.getData(dataPath, "tabs");
	}
	
	@org.testng.annotations.DataProvider(name = "links")
	public Object[][] links() throws IOException {
		return provider.getData(dataPath, "links");
	}
	
	@org.testng.annotations.DataProvider(name = "allFaq")
	public Object[][] allFaq() throws IOException {
		return provider.getData(dataPath, "allFaq");
	}
	
	@org.testng.annotations.DataProvider(name = "contacts")
	public Object[][] contacts() throws IOException {
		return provider.getData(dataPath, "contacts");
	}
	
	@org.testng.annotations.DataProvider(name = "stayConnected")
	public Object[][] stayConnected() throws IOException {
		return provider.getData(dataPath, "stayConnected");
	}
}
