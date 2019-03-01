package Live_Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ObtainDate extends Regression
{
	final static Logger logger = Logger.getLogger(Regression.class);
	static ObtainDate obtainDate = new ObtainDate();
	static TimeZone timeZone = TimeZone.getTimeZone("Europe/Amsterdam");
	static String dateFormat = "MMMM dd,yyyy"; //MMMM dd,yyyy G
	static String timeFormat = "hh:mm:ss";
	static String dayFormat = "EEEEEE";
	static String Currenttime = "";
	//static String timeFormat1 = "hh:mm:ss";
	//static String time = obtainDate.getCurrentTime(timeFormat,timeZone);
	public static void startdate()
	{

		logger.info("Todays Day:" + obtainDate.getTodaysDay(dayFormat,timeZone));
		logger.info("Todays Date:" + obtainDate.getTodayDate(dateFormat,timeZone));
		logger.info("Current Time:" + obtainDate.getCurrentTime(timeFormat,timeZone));
		Currenttime = obtainDate.getCurrentTime(timeFormat,timeZone);

	}

	public static void enddate()
	{

		logger.info("Todays Day:" + obtainDate.getTodaysDay(dayFormat,timeZone));
		logger.info("Todays Date:" + obtainDate.getTodayDate(dateFormat,timeZone));
		logger.info("Current Time:" + obtainDate.getCurrentTime(timeFormat,timeZone));
	}
	public static void currenttime()
	{

		Keywords.clearElement("xpath", "//form[@id='aspnetForm']//table[@class='PageContent']//td[@class='ContentPageHeader']/div/div/div/div[1]/table[@class='cForm']//input[@name='ctl00$cphContent$tbPeriodB']");
		driver.findElement(By.xpath("//form[@id='aspnetForm']//table[@class='PageContent']//td[@class='ContentPageHeader']/div/div/div/div[1]/table[@class='cForm']//input[@name='ctl00$cphContent$tbPeriodB']")).sendKeys(Currenttime);
		logger.info("Current Time:" + Currenttime);

	}


	public String getTodaysDay(String dayFormat, TimeZone timeZone)
	{
		Date date = new Date();
		/* Specifying the format */
		DateFormat requiredFormat = new SimpleDateFormat(dayFormat);
		/* Setting the Timezone */
		requiredFormat.setTimeZone(timeZone);
		/* Picking the day value in the required Format */
		String strCurrentDay = requiredFormat.format(date).toUpperCase();
		return strCurrentDay;
	}


	public String getCurrentTime(String timeFormat, TimeZone timeZone)
	{
		/* Specifying the format */ 
		DateFormat dateFormat = new SimpleDateFormat(timeFormat);
		/* Setting the Timezone */
		Calendar cal = Calendar.getInstance(timeZone);
		dateFormat.setTimeZone(cal.getTimeZone());
		/* Picking the time value in the required Format */
		String currentTime = dateFormat.format(cal.getTime());
		return currentTime;
	}


	public String getTodayDate(String dateFormat, TimeZone timeZone)
	{
		Date todayDate = new Date();
		/* Specifying the format */
		DateFormat todayDateFormat = new SimpleDateFormat(dateFormat);
		/* Setting the Timezone */
		todayDateFormat.setTimeZone(timeZone);
		/* Picking the date value in the required Format */
		String strTodayDate = todayDateFormat.format(todayDate);
		return strTodayDate;
	}
}
