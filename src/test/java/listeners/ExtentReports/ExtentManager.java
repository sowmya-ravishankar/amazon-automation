package listeners.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Test Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Java", "v11");
        extentReports.setSystemInfo("Selenium", "v3.141");
        extentReports.setSystemInfo("Framework", "TestNG POM");
        return extentReports;
    }
}
