package com.project.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.project.base.baseclass;

public class extentreport implements ITestListener {
	ExtentSparkReporter repoter;
	ExtentReports extent;
	ExtentTest test;
	String time;
	@Override
	public void onTestStart(ITestResult result) {
		time= new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		String name="Test-report"+time+".html";
		repoter=new ExtentSparkReporter("C:\\Users\\akash\\git\\mystore\\projectdemo2\\test-output/"+name);
		extent=new ExtentReports();

		extent.attachReporter(repoter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "akash guttedar");
		repoter.config().setReportName("Funtional Test Automation Project");
		repoter.config().setDocumentTitle("OragnHrm-Test-Report");
		repoter.config().setTheme(Theme.DARK);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.BLUE));

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		baseclass base= new baseclass();
		base.screenshot(result.getMethod().getMethodName(), time);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.BROWN));


	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
