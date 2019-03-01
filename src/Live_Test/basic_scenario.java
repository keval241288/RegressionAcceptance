package Live_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import Live_Test.Regression;
import Live_Test.Keywords;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public  class basic_scenario extends Regression {




	final static Logger logger = Logger.getLogger(Regression.class);



	public static void Chrome_loginid() throws Throwable  
	{

		final String EXCEL_PATH = "D:\\KevalBackup\\Kevalkumar\\Keval\\Data\\Selenium\\Scripts2\\Regression\\src\\Exceldatadriven\\datadrivenExcel.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(EXCEL_PATH));
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();	

		Row rowNew = sheet.getRow(1);
		Cell cell = rowNew.getCell(0);
		String cellValue = dataFormatter.formatCellValue(cell);
		Row rowNew2 = sheet.getRow(1);
		Cell cell2 = rowNew2.getCell(1);
		String cellValue2 = dataFormatter.formatCellValue(cell2);

		Keywords.clearElement("xpath", ".//*[@id='ucLoginSimple_tbLoginName']");
		Keywords.insertElement("xpath", ".//*[@id='ucLoginSimple_tbLoginName']", cellValue);
		Keywords.clearElement("xpath", ".//*[@id='ucLoginSimple_tbPassword']");
		Keywords.insertElement("xpath", ".//*[@id='ucLoginSimple_tbPassword']", cellValue2);
		Keywords.clickElement("xpath", "//input[@id='ucLoginSimple_btnLogin']");
		Thread.sleep(2000);

	}

	public static void  logout()
	{
		//driver.findElement(By.xpath (".//*[@id='aspnetForm']/div[4]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[7]/a")).click(); 
		Keywords.clickElement("xpath", "/html//form[@id='aspnetForm']/div[@class='MasterPage']/div[@class='Header cNoPrint']//a[@href='Logout.ashx']");
	}


	public static void BGP_open_login()  throws Exception 
	{


		Keywords.clearElement("id","tbLoginName");
		Keywords.insertElement("id","tbLoginName","keval@devrepublic.nl");
		System.out.println("username entered");
		Keywords.clearElement("id","tbLoginPassword");
		Keywords.insertElement("id","tbLoginPassword","test@123");
		System.out.println("Password entered");
		Keywords.clickElement("id", "bLogin");
		System.out.println("Done login");




	}

	public static   void open_links() throws Exception
	{


		Systemlog();
		Thread.sleep(2000);
		clickon_Bedrijfs_beheer(); 
		Thread.sleep(2000);
		clickon_Companydetails();
		Thread.sleep(2000);
		clickon_Kentekencards();
		Thread.sleep(2000);
		clickon_Autos_in_verkoop();
		Thread.sleep(2000);
		clickon_Betalingen();
		Thread.sleep(2000);
		currentimeErrorlog();
		Thread.sleep(2000);
		switchuser();


	}

	public static  void Systemlog() throws Exception 
	{
		//System Log
		driver.get(baseUrl + "SystemLog.aspx");
		Thread.sleep(2000);
		ObtainDate.currenttime();
		Select drpCountry = new Select(driver.findElement(By.id("ctl00_cphContent_ddLogLevel")));
		drpCountry.selectByValue("9");


		logger.info("Chrome browser:-> " + "Systemlog >> error selected");
		driver.findElement(By.xpath ("//*[@id='ctl00_cphContent_ibSearch']")).click();
		Thread.sleep(2000);
		String s = driver.findElement(By.xpath("/html//form[@id='aspnetForm']//table[@class='PageContent']//td[@class='ContentPageHeader']/div/div/div/div[2]/table[@class='MasterTable_SO']/tbody/tr[1]/td")).getText();  
		//System.out.println(s);

		//String str = "Navigeer pagina: << Eerste < Vorige 12345 ... Volgende > Laatste >> | Pagina 1 van 12 | Items 1 tot 50 van 561";
		String[] line = s.split(">>");
		String part1 = line[1];
		// System.out.println("part1: -> " + part1);
		String[] line2 = s.split("van");
		String part2 = line2[1];
		String part3 = line2[2];
		System.out.println("Total Number of error:- > " + part3);
		logger.info("Total Number of error:- > " + part3);
		// System.out.println("part2: -> " + part2 + part3);
		String[] line3= part2.split(" ");
		String part4 = line3[1];
		System.out.println("Number of Error pages: -> " + part4);
		logger.info("Number of Error pages: -> " + part4);
	}	

	public static  void currentimeErrorlog() throws Exception 
	{
		//System Log
		driver.get(baseUrl + "SystemLog.aspx");
		Thread.sleep(2000);
		ObtainDate.currenttime();
		Select drpCountry = new Select(driver.findElement(By.id("ctl00_cphContent_ddLogLevel")));
		drpCountry.selectByValue("9");


		logger.info("Chrome browser:-> " + "Systemlog >> error selected");
		driver.findElement(By.xpath ("//*[@id='ctl00_cphContent_ibSearch']")).click();

		String s= "";
		try 
		{
			s = driver.findElement(By.xpath("/html//form[@id='aspnetForm']//table[@class='PageContent']//td[@class='ContentPageHeader']/div/div/div/div[2]/table[@class='MasterTable_SO']//td[.='No data']")).getText();	
			System.out.println("test " + s);
		}

		catch (NoSuchElementException e) {

		}


		if( s.contains("No data"))
		{
			System.out.println("No error generated");
			logger.info("No error generated");

		}
		else{
			String s1 = "";
			try {
				s1 = driver.findElement(By.xpath("/html//form[@id='aspnetForm']//table[@class='PageContent']//td[@class='ContentPageHeader']/div/div/div/div[2]/table[@class='MasterTable_SO']/tbody/tr[1]/td")).getText();	
			}

			catch (NoSuchElementException e) {

			}


			String s2= "";
			try {
				s2 = driver.findElement(By.xpath("/html//form[@id='aspnetForm']//table[@class='PageContent']//td[@class='ContentPageHeader']/div/div/div/div[2]/table[@class='MasterTable_SO']//th[.='Message']")).getText();

			}

			catch (NoSuchElementException e) {

			}


			if(s1.contains("Navigeer")){

				System.out.println("its in Navigeer ");

				//String str = "Navigeer pagina: << Eerste < Vorige 12345 ... Volgende > Laatste >> | Pagina 1 van 12 | Items 1 tot 50 van 561";
				String[] line = s1.split(">>");
				String part1 = line[1];
				// System.out.println("part1: -> " + part1);
				String[] line2 = s1.split("van");
				String part2 = line2[1];
				String part3 = line2[2];
				System.out.println("Total Number of error:- > " + part3);
				logger.info("Total Number of error:- > " + part3);
				// System.out.println("part2: -> " + part2 + part3);
				String[] line3= part2.split(" ");
				String part4 = line3[1];
				System.out.println("Number of Error pages: -> " + part4);
				logger.info("Number of Error pages: -> " + part4);
			}

			else if(s2.contains("Message")){

				int rowCount = driver.findElements(By.xpath("//table[@id='ctl00_cphContent_gvList']/tbody/tr")).size();
				System.out.println("Error generated on page 1. Number of Errors are = " + (rowCount-1));
				logger.info("Error generated on page 1. Number of Errors are = " + (rowCount-1));
			}


		}


	}



	public static void  clickon_Bedrijfs_beheer() 
	{

		Keywords.clickElement("linkText","Beheer");
		Keywords.clickElement("linkText","Bedrijfs beheer");
		logger.info("Bedrijfs beheer Done");

	}

	public static void  clickon_Companydetails() 
	{

		Keywords.clickElement("id","ctl00_cphContent_gvList_ctl05_lnkCompanyName");
		logger.info("Companydetails Done");
	}

	public static void  clickon_Betalingen() throws Exception 
	{

		Keywords.clickElement("id","ctl00_mmPayments_lnk");
		Keywords.clickElement("linkText", "Alles openstaand");
		Thread.sleep(5000);
		Keywords.clickElement("id","ctl00_cphContent_gvList_ctl03_lnkPDF");
		Thread.sleep(5000);
		logger.info("Open Betalingen, Filter it, click on first pdf, PDF download");
		Keywords.clickElement("xpath", "/html//form[@id='aspnetForm']/div[@class='MasterPage']/table[@class='PageContent']//td[@class='ContentPageHeader']/div/div[1]//table[@class='MasterTable_SO']/tbody/tr[3]/td[@class='cHRight']/a[@title='Click here to see the invoice']");
		Thread.sleep(5000);
		Move_to_Car_details();
		logger.info("Betalingen Done");
	}
	public static void  clickon_Kentekencards() 
	{

		Keywords.clickElement("linkText","Kentekens");
		Keywords.clickElement("linkText","Kentekencards");
		logger.info("Kentekencards Done");

	}


	public static void  clickon_Autos_in_verkoop() 
	{

		Keywords.clickElement("id","ctl00_mmBuyer_lnk");
		Keywords.clickElement("linkText","Auto's in verkoop");
		logger.info("Autos_in_verkoop Done");

	}
	public static void  Move_to_Car_details() throws InterruptedException 
	{

		String parentWindowHandler = driver.getWindowHandle(); 
		String subWindowHandler = null;

		java.util.Set<String> handles = driver.getWindowHandles(); 
		java.util.Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext())
		{
			subWindowHandler = iterator.next();
		}

		driver.switchTo().window(subWindowHandler); 
		Keywords.clickElement("linkText", "PDF Download");
		logger.info("popup windows pdf is downloaded");
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parentWindowHandler);

	}
	public static void  switchuser() throws InterruptedException 
	{

		clickon_Bedrijfs_beheer(); 
		Keywords.clickElement("id", "ctl00_cphContent_gvList_ctl05_lnkCompanyName");
		Thread.sleep(2000);
		Keywords.clickElement("id", "ctl00_cphContent_tbsCompany_tbbUsers_bTab");
		Thread.sleep(2000);
		Keywords.clickElement("id", "ctl00_cphContent_ucUsers_gvList_ctl02_imgSWU");
		Thread.sleep(5000);
		logger.info("move to switch user");
		Keywords.clickElement("id","ctl00_mmPayments_lnk");
		Thread.sleep(2000);
		Keywords.clickElement("id","ctl00_cphContent_gvList_ctl03_lnkPDF");
		Thread.sleep(5000);
		logger.info("pdf download from switch user");
		logger.info("Companydetails Done");

	}

}
