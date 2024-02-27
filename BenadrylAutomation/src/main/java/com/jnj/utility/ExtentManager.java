/**
 * @author Goutam Naik
 * @date 27-Feb-24
 */

package com.jnj.utility;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentManager {

	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public static ExtentReports setExtent() {
		extent = new ExtentReports();

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport/" + "BenadrylAutomationReport.html")
				.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY,
						ViewName.AUTHOR, ViewName.DEVICE, ViewName.EXCEPTION, ViewName.LOG })
				.apply();
		spark.config().setEncoding("utf-8");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Benadryl Automation Report");
		spark.config().setReportName("Benadryl Automation Report");
		spark.config().setCss(".vheader{background-color:#e22068}");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("ProjectName", "Benadryl");
		extent.setSystemInfo("Tester", "QA AutoBots");
		extent.setSystemInfo("OS", "Win11");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Selenium version", "4.18.1");
		return extent;
	}

	@AfterTest
	public static void endReport() {
		extent.removeTest(test);
		extent.flush();
	}
}
