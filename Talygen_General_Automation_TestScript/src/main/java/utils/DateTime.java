package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DateTime {

	public static String weekEndDate;
	public static String weekStartDate;
	public static String monthStartDate;
	public static String monthEndDate;
	public static String yesterdayDate;
	public static String lastWeekStartDate;
	public static String lastWeekEndDate;
	public static String lastMonthStartDate;
	public static String lastMonthEndDate;
	public static String tenDaysEndDate;
	public static String oneDayDate;
	public static LocalDate date3;
	static String pattern = "MM/dd/yyyy";
	static Date date = new Date();
	public static String todayAsString;

	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	public static String datevalue = dateformat.format(date);
	public static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	static Date currentY = new Date();
	int year = date.getYear();
	int currentYear = year + 1900;
	Date popUpDate;

	private WebDriver driver;
	public static Logger logger;

	public DateTime(WebDriver driver) {
		this.driver = driver;
	}

	// --------------------------Current month ---------------//
	public void getCurrentMonthStartEndDate() {
		try {
			Calendar currentCalendar = Calendar.getInstance();

			currentCalendar.set(Calendar.DAY_OF_MONTH, 1);

			Date currentMonthStart = currentCalendar.getTime();
			monthStartDate = formatter.format(currentMonthStart);
			System.out.println("Month Start Date: " + monthStartDate);
			currentCalendar.setTime(date);
			currentCalendar.set(Calendar.DAY_OF_MONTH, currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date currentMonthEnd = currentCalendar.getTime();
			monthEndDate = formatter.format(currentMonthEnd);
			System.out.println("Month End Date: " + monthEndDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------week Date ---------------//
	public void getWeekStartEndDate() {
		try {

			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

			Date currentWeekStart = currentCalendar.getTime();
			weekStartDate = formatter.format(currentWeekStart);
			System.out.println("Week Start Date: " + weekStartDate);

			currentCalendar.add(Calendar.DATE, 6); // add 6 days after aaaMonday
			Date currentWeekEnd = currentCalendar.getTime();
			weekEndDate = formatter.format(currentWeekEnd);

			System.out.println("Week End Date: " + weekEndDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------Last week Date ---------------//
	public void getLastWeekStartEndDate() {
		try {
			Date date = new Date();
			Calendar currentCalendar = Calendar.getInstance();

			currentCalendar.setTime(date);
			int i = currentCalendar.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY;
			currentCalendar.add(Calendar.DATE, -i - 7);
			Date lastWeekStart = currentCalendar.getTime();

			lastWeekStartDate = formatter.format(lastWeekStart);
			System.out.println("Last start end date" + lastWeekStartDate);

			currentCalendar.add(Calendar.DATE, 6);
			Date lastWeekEnd = currentCalendar.getTime();

			lastWeekEndDate = formatter.format(lastWeekEnd);

			System.out.println("Last week end date" + lastWeekEndDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------Last month Date ---------------//
	public void getLastMonthStartEndDate() {
		try {
			Date date = new Date();
			Calendar currentCalendar = Calendar.getInstance();

			currentCalendar.setTime(date);
			currentCalendar.add(Calendar.MONTH, -1);
			// set DATE to 1, so first date of previous month
			currentCalendar.set(Calendar.DATE, 1);

			Date lastMonthStart = currentCalendar.getTime();

			lastMonthStartDate = formatter.format(lastMonthStart);
			System.out.println("Last month start date" + lastMonthStartDate);
			currentCalendar.set(Calendar.DATE, currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

			Date lastMonthEnd = currentCalendar.getTime();
			lastMonthEndDate = formatter.format(lastMonthEnd);

			System.out.println("Last Month end date" + lastMonthEndDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------yesterday Date -----------------------//
	public void getYesterdayDate() {
		try {
			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.add(Calendar.DATE, -1);
			Date yesterday = currentCalendar.getTime();
			yesterdayDate = formatter.format(yesterday);

			System.out.println("yesterday Date: " + yesterdayDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------10 days + Date ---------------//
	public void getTenDaysDate() {
		try {
			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.add(Calendar.DATE, 10);

			Date tenDaysStartDate = currentCalendar.getTime();
			tenDaysEndDate = formatter.format(tenDaysStartDate);
			System.out.println("ten Days End Date: " + tenDaysEndDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------1 day + Date ---------------//
	public void getOneDaysDate(int oneDay, String dateToParse) {
		try {
			String[] date = dateToParse.split("/");
			System.out.println(":: " + date);
			date3 = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[0]), Integer.parseInt(date[1]))
					.plusDays(oneDay);

//			SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");

			todayAsString = date3.toString();

			// Print the result!
			System.out.println("Today is: " + todayAsString);

//			System.out.println("One Days End Date: " + date3);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
