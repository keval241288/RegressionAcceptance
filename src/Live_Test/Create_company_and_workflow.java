package Live_Test;
import Live_Test.Keywords;
import Live_Test.Regression;
import org.apache.log4j.Logger;


public class Create_company_and_workflow extends Regression

{
	static String search_insert;
	final static Logger logger = Logger.getLogger(carSearchandCreate.class);

	public static void  companyWorkflow()  throws Exception 
	{
		/*mouse_move("id","ctl00_mmFS_lnk", "linkText","Bedrijfs beheer" );
		System.out.println("click on companydetails");
		Thread.sleep(10000);*/

		//company_open();  /*perticular company open with id */
		Keywords.clickElement("id", "ctl00_cphContent_tbsCompany_tbbProtocols_bTab	");
		System.out.println("click on workflow");
		logger.info("click on workflow");
		Thread.sleep(5000);

		Keywords.clickElement("xpath", "//a[contains(.,'Workflow (5)')]");
		System.out.println("click on create new workflow");
		logger.info("click on create new workflow");
		Thread.sleep(5000);

		Keywords.clickElement("id", "ctl_cbIsDefaul");
		System.out.println("tested ok");

	}


	public static void  CreateCompany()  throws Exception 
	{

		Keywords.mouse_move("xpath",".//*[@id='ctl00_mmFS_lnk']","linkText","Bedrijfs beheer");


		Keywords.clickElement("xpath",".//*[@id='ctl00_cphContent_lnkCreateNew']");
		System.out.println("click on create new Company");
		logger.info("click on create new Company");
		Thread.sleep(2000);

		Keywords.clearElement("xpath", ".//*[@id='ctl00_cphContent_tbName']"); 
		Keywords.insertElement("xpath", ".//*[@id='ctl00_cphContent_tbName']","testcompany3" );/*company name must be unique  */
		System.out.println("Company Name Inserted");
		logger.info("Company Name Inserted");
		Thread.sleep(2000);

		Keywords.clearElement("xpath", ".//*[@id='ctl00_cphContent_tbCode']");
		Keywords.insertElement("xpath", ".//*[@id='ctl00_cphContent_tbCode']","TC1" ); 
		System.out.println("Code Inserted");
		logger.info("Code Inserted");
		Thread.sleep(2000);



		Keywords.clearElement("xpath", ".//*[@id='ctl00_cphContent_tbKvK']");
		Keywords.insertElement("xpath", ".//*[@id='ctl00_cphContent_tbKvK']","08083555" );
		System.out.println("Keknumber Inserted");
		logger.info("Keknumber Inserted");
		Thread.sleep(2000);

		Keywords.clearElement("xpath", "html[1]/body[1]/form[1]/div[4]/table[3]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[14]/td[2]/div[1]/input[1]");
		Keywords.insertElement("xpath", "html[1]/body[1]/form[1]/div[4]/table[3]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[14]/td[2]/div[1]/input[1]","+31-36-5403895" );
		System.out.println("phone number Inserted");
		logger.info("phone number Inserted");
		Thread.sleep(2000);

		Keywords.clearElement("xpath", ".//*[@id='ctl00_cphContent_tbAddrVisitStr']");
		Keywords.insertElement("xpath", ".//*[@id='ctl00_cphContent_tbAddrVisitStr']","Woudweg 7" );
		Keywords.clearElement("xpath", ".//*[@id='ctl00_cphContent_tbAddrVisitZIP']");
		Keywords.insertElement("xpath", ".//*[@id='ctl00_cphContent_tbAddrVisitZIP']","3771 LN" );
		Keywords.clearElement("xpath", ".//*[@id='ctl00_cphContent_tbAddrVisitCity']");
		Keywords.insertElement("xpath", ".//*[@id='ctl00_cphContent_tbAddrVisitCity']","Barneveld" );
		Keywords.dropdownByValue("xpath",".//*[@id='ctl00_cphContent_ddAddrVisitCountry']", "31");
		System.out.println("address1 inserted");
		logger.info("address1 inserted");
		Thread.sleep(2000);


		Keywords.clickElement("xpath", ".//*[@id='ctl00_cphContent_btnOK']");

		System.out.println("click on ok");
		logger.info("click on ok");
		Thread.sleep(5000);




	}
}
