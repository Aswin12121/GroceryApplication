package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtilities {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() { //sysnchronized --> used to avoid overlap while the time of  parallel execution
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // ExtentSparkReporter class is used to 
		reporter.config().setReportName("7RMart  Project");//name 
		extentReports.attachReporter(reporter);//Connect or attach ExtentReports and ExtentSparkReporter using the method attachReporter
		extentReports.setSystemInfo("Organization", "Obsqura"); //
		extentReports.setSystemInfo("Name", "AA"); // to set system information
		return extentReports; //means it returns a report
}
	
}