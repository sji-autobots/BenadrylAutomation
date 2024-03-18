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
}
