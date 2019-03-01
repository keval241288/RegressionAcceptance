package Live_Test;

import org.apache.log4j.Logger;
import Live_Test.Keywords;
import Live_Test.exceldatadriven;
import Live_Test.Regression;
import Live_Test.Detailpage;
public class carSearchandCreate  extends Regression
{

	static String search_insert;
	final static Logger logger = Logger.getLogger(Regression.class);

	
	public static void  carsearch() throws Exception
	{
		
		driver.get(baseUrl + "CarSearchGlobal.aspx");
		Thread.sleep(2000);
		for (int i = 1; i <= 3; i++) 
		{
			Keywords.excelpath2();
			search_insert = exceldatadriven.getCellData(i,3);//put "i"(instead of 1) when you check all excel data
			
			logger.info(search_insert);
			
			Keywords.clearElement("xpath", "/html//form[@id='aspnetForm']//table[@class='PageContent']//td[@class='ContentPageHeader']/div/div[1]/div[1]/table[@class='cForm']//input[@name='ctl00$cphContent$tbLicense']");
			Keywords.insertElement("xpath", "/html//form[@id='aspnetForm']//table[@class='PageContent']//td[@class='ContentPageHeader']/div/div[1]/div[1]/table[@class='cForm']//input[@name='ctl00$cphContent$tbLicense']",search_insert );
			
			logger.info("insert car number:->  " + search_insert );
					
			Keywords.clickElement("id", "ctl00_cphContent_imgSearch");
			
			logger.info("search car");
			Thread.sleep(4000);
			String Kentekendetails = "";
			try
			{
			Kentekendetails = Keywords.getText ("xpath","/html//form[@id='aspnetForm']//table[@class='PageContent']//td[@class='ContentPageHeader']/div/div[1]//table[@class='MasterTable_SO']//td[.='Geen data']");
			
			logger.info(Kentekendetails);
		
			}
			catch(Exception e)
			{
				
			}
			if( Kentekendetails.contains("Geen data"))
			{
				
				logger.info("\n\n\n****************New car create with this licence number -->" + search_insert);
				Thread.sleep(4000);
				car_create();
				
			}  
			else  
			{ 
				logger.info(search_insert + "<--This Car Number is in Autoblox");
				Thread.sleep(2000);
				
			}   
			

		}
		
	}
	

	public static void  car_create()  throws Exception 
	{
		driver.get(baseUrl + "NewCar2.aspx");
		Thread.sleep(2000);
		Keywords.clickElement("id","ctl00_mmNewCar_tab"); 
		System.out.println("click on Create car button");
		logger.info("click on Create car button");
		Thread.sleep(2000);

		Keywords.clearElement("id", "ctl00_cphContent_tbKenteken");
		Keywords.insertElement("id", "ctl00_cphContent_tbKenteken",search_insert );
		System.out.println("insert car number:->  " + search_insert );
		logger.info("insert car number:->  " + search_insert );
		Thread.sleep(5000);

		Keywords.clickElement("id", "ctl00_cphContent_bSelectCompany");
		System.out.println("click on Owner Workflow");
		logger.info("click on Owner Workflow");
		Thread.sleep(5000);

		System.out.println("move on frame");
		logger.info("move on frame");
		Thread.sleep(5000);
		Keywords.dropdownByValue("id", "ctl00_cphContent_mctlCompanySelection_ucControlLoader_ctl00_ddFilterAdminID", "-1");
		System.out.println("select administration Company - All");
		logger.info("select administration Company - All");
		Thread.sleep(5000);

		Keywords.clearElement("id", "ctl00_cphContent_mctlCompanySelection_ucControlLoader_ctl00_tbSearch");
		Keywords.insertElement("id", "ctl00_cphContent_mctlCompanySelection_ucControlLoader_ctl00_tbSearch","A & D Auto's (two)" );
		System.out.println("inserted company name");
		logger.info("inserted company name");
		Thread.sleep(5000);

		Keywords.clickElement("id", "ctl00_cphContent_mctlCompanySelection_ucControlLoader_ctl00_ibSearchS");
		System.out.println("click on Search button");
		logger.info("click on Search button");
		Thread.sleep(10000);

		Keywords.clickElement("id", "ctl00_cphContent_mctlCompanySelection_ucControlLoader_ctl00_gvList_ctl03_ibSelect");
		System.out.println("Company selected");
		logger.info("Company selected");
		Thread.sleep(10000);

		Keywords.clickElement("xpath", "//label[contains(.,'test by keval')]");
		System.out.println("workflow selected");
		logger.info("workflow selected");
		Thread.sleep(5000);

		Keywords.dropdownByValue("id", "ctl00_cphContent_ddlRetrieveDataFrom", "1");
		System.out.println("retrive car data");
		logger.info("retrive car data");
		Thread.sleep(5000);

		Keywords.clickElement("id", "ctl00_cphContent_bNext");
		System.out.println("click on next");
		logger.info("click on next");
		Thread.sleep(10000);


		Keywords.clickElement("id", "ctl00_cphContent_rbBTWNo");
		System.out.println("BTW/Marge selected");
		logger.info("BTW/Marge selected");
		Thread.sleep(5000);

		Keywords.clickElement("id", "ctl00_cphContent_bNext");
		System.out.println("click on next");
		logger.info("click on next");
		Thread.sleep(10000);

		System.out.println("move to step-3");
		logger.info("move to step-3");
		Keywords.clickElement("id", "ctl00_cphContent_ucProtocolData_0_ucLocation_bSelect");
		System.out.println("click on Address search");
		logger.info("click on Address search");
		Thread.sleep(5000);


		Keywords.clickElement("id", "ctl00_cphContent_ucProtocolData_0_ucLocation_mctlAddressSelection_ucControlLoader_ctl00_cbShowStorages");
		System.out.println("click on storage location");
		logger.info("click on storage location");
		Thread.sleep(5000);


		Keywords.clickElement("id", "ctl00_cphContent_ucProtocolData_0_ucLocation_mctlAddressSelection_ucControlLoader_ctl00_gvList_ctl03_btnSelect");
		System.out.println("click on storage location");
		logger.info("click on storage location");
		Thread.sleep(5000);
		//finish click 

		Keywords.clickElement("id", "ctl00_cphContent_bNext");
		System.out.println("click on Finish");
		logger.info("click on Finish");
		Thread.sleep(10000);
		System.out.println("create car done");
		logger.info("create car done");
		System.out.println("\n\n\n**************************************\n\n\n");

		String Finishinfo = Keywords.getText("id", "ctl00_cphContent_lbFinishInfo");
		System.out.println(Finishinfo);
		logger.info(Finishinfo);
		System.out.println("Licence number info generated");
		logger.info("Licence number info generated");
		Thread.sleep(5000);

		String[] tokens = Finishinfo.split(",");

		String[] id= tokens[2].toString().split("=");
		String carid = id[1];
		System.out.println("Card id is : -> " + carid);
		logger.info("Card id is : -> " + carid);

		//open new tab and insert kenteken
		Keywords.opentab();
		System.out.println("new tab is open"); 
		logger.info("new tab is open"); 
		Keywords.kenteken_fillup_after_car_create_path(carid);

		System.out.println(Keywords.currentURL());
		logger.info("Current link: " + Keywords.currentURL());
		Thread.sleep(5000);

		Detailpage.kenteken_fillup_after_car_create();
		Keywords.closetab();
		//now start process of car selling
		Keywords.opentab();
		Keywords.car_Details_page_path(carid);

		System.out.println(Keywords.currentURL());
		logger.info("Current link: " + Keywords.currentURL());
		Thread.sleep(5000);
		System.out.println("details page is open");
		logger.info("details page is open");	
		Detailpage.soldcar();

	}



}


