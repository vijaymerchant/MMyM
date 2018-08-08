package config;

import java.net.MalformedURLException;
import java.time.LocalTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import com.pageObject.Home;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import lib_methods.Browser_factory;
import lib_methods.ExcelSheetDriver;
import lib_methods.Explicit_timeout;
import lib_methods.Implicit_timeout;
import lib_methods.Log;
import lib_methods.Screenshot;
import lib_methods.Scroll;
import lib_methods.Select_dropdown;
import lib_methods.Sikuli_c;
import lib_methods.Wait_for_pageload;

public class Configuration_hub {
	public static WebDriver driver;
	public Log log;
	public Browser_factory b;
	public Home loginpage;

	public ExtentReports r;
	public ExtentTest logger;
	public Screenshot s;
	public String filepath;
	public Implicit_timeout wait;

	public Explicit_timeout e;
	public Scroll sc;
	public Select_dropdown sd;
	public WebElement link;
	public LocalTime time;
	public Wait_for_pageload wp;
	public Sikuli_c sik;
	public Dataset d;
	
	public ExcelSheetDriver excel;
	public ExcelSheetDriver ex;

	public Configuration_hub()   {
		b = new Browser_factory();
		try {
			driver = b.initiate_browser("chrome");
		} catch (MalformedURLException e1) {
		
			e1.printStackTrace();
		}
		log = new Log();
		loginpage = PageFactory.initElements(driver, Home.class);
		s = new Screenshot(driver);
		wait = new Implicit_timeout(driver);
		e = new Explicit_timeout(driver);
		sc = new Scroll(driver);
		sd = new Select_dropdown(driver);
		wp = new Wait_for_pageload(driver);
		sik = new Sikuli_c(driver);
		d = new Dataset();

	}


	@AfterTest
	public void teardown() throws InterruptedException {

		log.tracelog("Test finished");
		r.endTest(logger);
		r.flush();

		driver.get("E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\report\\report.html");

		try {

			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	

	}

	@AfterMethod()
	public void tracerror(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			try {

				filepath = s.Capturescreenshot(driver, result.getName());

				System.out.println(filepath);
			
				logger.log(LogStatus.FAIL,result.getInstanceName() + "-------Fail", logger.addScreenCapture(filepath));

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

		else {

			logger.log(LogStatus.PASS,result.getName() + "--------pass");

		}
	}

	
}
