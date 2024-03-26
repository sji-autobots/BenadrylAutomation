/**
 * @author Rashi Tiwari
 * @date 18-March-24
 */

package com.jnj.dataproviders;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.jnj.utility.DataProvider;

public class FooterProvider {
	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\FooterPageTestData.xlsx";

	DataProvider provider = new DataProvider();

	@org.testng.annotations.DataProvider(name = "footer")
	public Object[][] footer() throws IOException {
		return provider.getData(dataPath, "footer");
	}
	
	@org.testng.annotations.DataProvider(name = "footerSecondColumn")
	public Object[][] footerSecondColumn() throws IOException {
		return provider.getData(dataPath, "footerSecondColumn");
	}
	
	@org.testng.annotations.DataProvider(name = "footerLastColumn")
	public Object[][] footerLastColumn() throws IOException {
		return provider.getData(dataPath, "footerLastColumn");
	}
	
	@org.testng.annotations.DataProvider(name = "footerHeading")
	public Object[][] footerHeading() throws IOException {
		return provider.getData(dataPath, "footerHeading");
	}
}
