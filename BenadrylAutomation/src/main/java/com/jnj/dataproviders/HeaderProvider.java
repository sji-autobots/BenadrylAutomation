/**
 * @author Goutam Naik
 * @date 27-Feb-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class HeaderProvider {

	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\HeaderTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "headerMainMenu")
	public Object[][] headerMainMenu() throws IOException {
		return provider.getData(dataPath, "headerMainMenu");
	}
	
	@org.testng.annotations.DataProvider(name = "headerSubMenu")
	public Object[][] headerSubMenu() throws IOException {
		return provider.getData(dataPath, "headerSubMenu");
	}
	
	@org.testng.annotations.DataProvider(name = "whereToBuy")
	public Object[][] whereToBuy() throws IOException {
		return provider.getData(dataPath, "whereToBuy");
	}
	
	@org.testng.annotations.DataProvider(name = "language")
	public Object[][] language() throws IOException {
		return provider.getData(dataPath, "language");
	}
	
	@org.testng.annotations.DataProvider(name = "search")
	public Object[][] search() throws IOException {
		return provider.getData(dataPath, "search");
	}
}
