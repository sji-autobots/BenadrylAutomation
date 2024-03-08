/**
 * @author Rashi Tiwari
 * @date 1-March-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class HomePageProvider {

	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\HomePageTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "homePage")
	public Object[][] homePage() throws IOException {
		return provider.getData(dataPath, "homePage");
	}

	@org.testng.annotations.DataProvider(name = "ourProducts")
	public Object[][] ourProducts() throws IOException {
		return provider.getData(dataPath, "ourProducts");
	}

	@org.testng.annotations.DataProvider(name = "bestSeller")
	public Object[][] bestSeller() throws IOException {
		return provider.getData(dataPath, "bestSeller");
	}

	@org.testng.annotations.DataProvider(name = "relatedContent")
	public Object[][] relatedContent() throws IOException {
		return provider.getData(dataPath, "relatedContent");
	}

	@org.testng.annotations.DataProvider(name = "allergy")
	public Object[][] allergy() throws IOException {
		return provider.getData(dataPath, "allergy");
	}

	@org.testng.annotations.DataProvider(name = "moreOn")
	public Object[][] moreOn() throws IOException {
		return provider.getData(dataPath, "moreOn");
	}
}
