package Live_Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Live_Test.Keywords;
import Live_Test.basic_scenario;

public class Regression  {
	public static WebDriver driver;
	public static String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	final static Logger logger = Logger.getLogger(Regression.class);

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\KevalBackup\\Kevalkumar\\Keval\\Data\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().deleteAllCookies();  
		driver.manage().window().maximize();
		logger.info("\n Script Start Time \n");
		baseUrl = "https://acceptatie.autoblox.eu/";
		ObtainDate.startdate();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}

	@Test
	public void testUntitled() throws Throwable 
	{
		driver.get(baseUrl);
		Thread.sleep(2000);
		logger.info("Chrome browser:-> " + "open browser and open URL");
		basic_scenario.Chrome_loginid();
		logger.info("Chrome browser:-> " + "login done");

		
		
		//Create_company_and_workflow.CreateCompany();
		//Create_company_and_workflow.companyWorkflow();
	  	
	  	
	  	carSearchandCreate.carsearch();
	  	
	  	
		
		//driver.get("https://acceptatie.autoblox.eu/CarDetails.aspx?CarID=1231864");
	
	  	//System.out.println("details page is open");
	  	//;;Detailpage.soldcar();
	  
	  //;;Detailpage.BGP_Details();
	  
	  //;;Create_company_and_workflow.companyWorkflow();







		/*basic_scenario.open_links();
		logger.info("Basic links are Done");
		basic_scenario.logout();
		logger.info("Chrome browser:-> " + "Logout done");
		Thread.sleep(2000);
		Keywords.closeWindow();
		logger.info("Window is closed");
		System.out.println("\n Script End Time \n");
		ObtainDate.enddate();
		logger.info("PLEASE CHECK DOWNLOAD FOLDER FOR DOWNLOADED PDF FILE");*/
	}

	@After
	public void tearDown() throws Throwable {




		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
