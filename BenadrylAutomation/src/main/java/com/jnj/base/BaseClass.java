/**
 * @author Goutam Naik
 * @date 27-Feb-24
 */

package com.jnj.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.jnj.actions.Action;
import com.jnj.pageobjects.HeaderPage;
import com.jnj.pageobjects.HomePage;
import com.jnj.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public static ExtentTest test;
	public String defaultFlag = "Yes";
	public static String baseURI;
	public ExtentReports exprep = ExtentManager.setExtent();

	public static HeaderPage header;
	public static HomePage home;

	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/Configurations/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchApplication() {
		String browserName = prop.getProperty("browserName");
		String runOn = prop.getProperty("runOn");
		if (browserName.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browserName.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		header = new HeaderPage();
		home = new HomePage();
		
		driver.manage().window().maximize();
		Action.implicitWait(driver, 10);
		selectEnv(runOn);
	}

	public static void extentMarkupLog(Markup markup) {
		test.log(Status.INFO, markup);
	}

	public static void extentInfoLog(String text, Object object) {
		test.log(Status.INFO, text + "" + object);
	}

	public static void extentPassLog(String text, Object object) {
		test.log(Status.PASS, text + "" + object);
	}

	public static void extentFailLog(String text, Object object) {
		test.log(Status.FAIL, text + "" + object);
	}

	public static void extentSkipLog(String text, Object object) {
		test.log(Status.SKIP, text + "" + object);
	}

	public static void extentInfoLog(String text) {
		test.log(Status.INFO, text);
	}

	/**
	 * Select environment to run tests on
	 * 
	 * @param runOn pass environment as a String
	 */
	public static void selectEnv(String runOn) {
		if (runOn.equalsIgnoreCase("staging")) {
			baseURI = prop.getProperty("stage_url");
		} else if (runOn.equalsIgnoreCase("live")) {
			baseURI = prop.getProperty("live_url");
		}
		driver.get(baseURI);
	}
}
