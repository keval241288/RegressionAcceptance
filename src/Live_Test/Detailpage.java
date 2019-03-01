package Live_Test;

import org.apache.log4j.Logger;
import Live_Test.Keywords;
import Live_Test.Regression;


public class Detailpage extends Regression 
{

	static String search_insert;
	final static Logger logger = Logger.getLogger(Regression.class); 

	public static void  kenteken_fillup_after_car_create()  throws Exception 
	{

		Thread.sleep(10000);

		Keywords.clearElement("xpath", "//input[@id='ucCarDocs_tbDocNo']");
		Keywords.insertElement("xpath", "//input[@id='ucCarDocs_tbDocNo']","0000000000" );
		System.out.println("Documentnummer inserted" );
		logger.info("Documentnummer inserted" );
		Thread.sleep(5000);

		Keywords.clearElement("xpath", "//input[@id='ucCarDocs_tbDocCode']");
		Keywords.insertElement("xpath", "//input[@id='ucCarDocs_tbDocCode']", "000000000" );
		System.out.println("Tenaamstellingscode inserted");
		logger.info("Tenaamstellingscode inserted");
		Thread.sleep(5000);

		Keywords.clearElement("xpath", "//input[@id='ucCarDocs_tbMileageD']");
		Keywords.insertElement("xpath", "//input[@id='ucCarDocs_tbMileageD']", "50000" );
		System.out.println("Tellerstand inserted");
		logger.info("Tellerstand inserted");
		Thread.sleep(5000);

		Keywords.clearElement("xpath", "//input[@id='ucCarDocs_tbMeldCodeD']");
		Keywords.insertElement("xpath", "//input[@id='ucCarDocs_tbMeldCodeD']","1234");
		System.out.println("Meldcode inserted");
		logger.info("Meldcode inserted");
		Thread.sleep(5000);

		/*Keywords.clickElement("xpath","//input[@id='ucCarDocs_btnCancel']");
		System.out.println("click on Cancel");
		Thread.sleep(5000);*/

		Keywords.clickElement("xpath","//input[@id='ucCarDocs_btnOK']");
		System.out.println("click on OK");
		logger.info("click on OK");
		Thread.sleep(5000);

		logger.info("kenteken inserted");
		System.out.println("kenteken inserted");

		System.out.println("\n\n\n New Car**************************************\n\n\n");
		Thread.sleep(5000);
	}

	public static void  soldcar()  throws Exception 
	{

		Thread.sleep(10000);

		Keywords.clickElement("xpath","//input[@id='ucCarDetails_CarToDoStep_1_btnDirectSale']");
		System.out.println("click on Direct Verkoop");
		logger.info("click on Direct Verkoop");
		Thread.sleep(5000);

		Keywords.clickElement("xpath","//input[@id='ucCarDetails_CarToDoStep_1_btnDirectBuyerSelectO']");
		System.out.println("click on koper search");
		logger.info("click on koper search");

		Thread.sleep(5000);

		System.out.println("move on frame");
		logger.info("move on frame");


		Keywords.clearElement("xpath", "//input[@id='ucCarDetails_CarToDoStep_1_ucDirectBuyerSelectLoader_ucControlLoader_ctl00_tbSearch']");
		Keywords.insertElement("xpath", "//input[@id='ucCarDetails_CarToDoStep_1_ucDirectBuyerSelectLoader_ucControlLoader_ctl00_tbSearch']","DevRepublictestBCA-Germony");
		System.out.println("inserted company name");
		logger.info("inserted company name");
		Thread.sleep(5000);

		Keywords.clickElement("xpath", "//input[@id='ucCarDetails_CarToDoStep_1_ucDirectBuyerSelectLoader_ucControlLoader_ctl00_gvList_ctl03_ibSelect']");
		System.out.println("Company selected");
		logger.info("Company selected");
		Thread.sleep(10000);

		Keywords.clearElement("xpath", "//input[@id='ucCarDetails_CarToDoStep_1_tbDirectPriceBruto']");
		Keywords.insertElement("xpath", "//input[@id='ucCarDetails_CarToDoStep_1_tbDirectPriceBruto']","25000");
		System.out.println("inserted Car Selling Price");
		logger.info("inserted Selling Price");
		Thread.sleep(5000);

		//Keywords.clickElement("xpath", "//a[@id='ucCarDetails_CarToDoStep_1_btnOnSale']");
		Keywords.getText("xpath", "//a[@id='ucCarDetails_CarToDoStep_1_btnOnSale']");
		System.out.println("car is sold");
		logger.info("car id sold");
		Thread.sleep(5000);
		Keywords.refresh();

	}
	public static void  BGP_Details()  throws Exception 
	{
		Keywords.opentab();
		Keywords.BGPURL();
		basic_scenario.BGP_open_login();
		Keywords.clickElement("id","ctl00_phMasterPage_cbPageAutoRefresh");
		System.out.println("click on Autorefresh");
		logger.info("click on Autorefresh");
		Thread.sleep(2000);

		Keywords.clickElement("id","ctl00_phMasterPage_lnkStartProcess_60");
		System.out.println("click on Complete sale");
		logger.info("click on Complete sale");

		Keywords.multiplewindow4();
		System.out.println("Complete sale Process is started");
		logger.info("Complete sale Process is started");


	}

}
