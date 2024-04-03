/**
 * @author Goutam Naik
 * @date 27-March-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class WhereToBuyProvider {
	
	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\whereToBuyTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "headerVerification")
	public Object[][] headerVerification() throws IOException {
		return provider.getData(dataPath, "headerVerification");
	}
	
	@org.testng.annotations.DataProvider(name = "productSearch")
	public Object[][] productSearch() throws IOException {
		return provider.getData(dataPath, "productSearch");
	}
	
	@org.testng.annotations.DataProvider(name = "changeCategorySize")
	public Object[][] changeCategorySize() throws IOException {
		return provider.getData(dataPath, "changeCategorySize");
	}
	
	@org.testng.annotations.DataProvider(name = "verifyStores")
	public Object[][] verifyStores() throws IOException {
		return provider.getData(dataPath, "verifyStores");
	}
	
	@org.testng.annotations.DataProvider(name = "verifyLocations")
	public Object[][] verifyLocations() throws IOException {
		return provider.getData(dataPath, "verifyLocations");
	}
}
