/**
 * @author Goutam Naik
 * @date 27-Feb-24
 */

package com.jnj.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jnj.actions.Action;
import com.jnj.base.BaseClass;

public class CustomListener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = exprep.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		BaseClass.extentPassLog("Test-case Passed : ", result.getName());
		exprep.flush();
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Failed Test case is : "+result.getName(), ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Test Case Failed : "+result.getThrowable(), ExtentColor.RED));
			String imgPath = Action.screenShot(BaseClass.driver, result.getName());
			test.addScreenCaptureFromPath(imgPath);
			exprep.flush();
		}
	}

	public void onTestSkipped(ITestResult result) {
		BaseClass.extentSkipLog(" : Test-case Skipped ",result.getThrowable());
		exprep.flush();
	}

	public void onFinish(ITestContext context) {
		if (exprep != null) {
			exprep.flush();
		}
	}
}
