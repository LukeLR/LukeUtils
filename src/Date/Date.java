package date;

import java.io.Serializable;
import java.util.Calendar;

import logging.Logger;

public class Date implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -528288110514622832L;
	public static int AmericanFormat = 0;
	public static int AmericanShort = 1;
	public static int GermanFormat = 2;
	public static int GermanShort = 3;
	public static int WithoutDate = 4;
	public static int AmericanFormatWithoutTime = 5;
	public static int AmericanShortWithoutTime = 6;
	public static int GermanFormatWithoutTime = 7;
	public static int GermanShortWithoutTime = 8;
	
	private int year = 0, month = 0, day = 0, hour = 0, minute = 0, second = 0;
	private long millisecond = 0;
	private int daysPerMonth = 30;
	
	public Date(){
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minute = cal.get(Calendar.MINUTE);
		second = cal.get(Calendar.SECOND);
		millisecond = cal.get(Calendar.MILLISECOND);
		daysPerMonth = 30;
	}
	
	public Date(int milliseconds, int seconds, int minutes, int hours, int days, int months, int years){
		this.millisecond = milliseconds;
		this.second = seconds;
		this.minute = minutes;
		this.hour = hours;
		this.day = days;
		this.month = months;
		this.year = years;
		daysPerMonth = 30;
	}
	
	public Date(String timestring){
		set(timestring);
		daysPerMonth = 30;
	}
	
	public Date (long millis){
		if (millis < 0){
			millisecond = millis * -1;
		} else {
			millisecond = millis;
		}
		doUebertrag();
	}
	
	public int getYear(){
		return year;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getHour(){
		return hour;
	}
	
	public int getMinute(){
		return minute;
	}
	
	public int getSecond(){
		return second;
	}
	
	public long getMillisecond(){
		return millisecond;
	}
	
	public void setYear(int value){
		year = value;
	}
	
	public void setMonth(int value){
		month = value;
	}
	
	public void setDay(int value){
		day = value;
	}
	
	public void setHour(int value){
		hour = value;
	}
	
	public void setMinute(int value){
		minute = value;
	}
	
	public void setSecond(int value){
		second = value;
	}
	
	public void setMillisecond(int value){
		millisecond = value;
	}
	
	public void set(Date d){
		year = d.getYear();
		month = d.getMonth();
		day = d.getDay();
		hour = d.getHour();
		minute = d.getMinute();
		second = d.getSecond();
		millisecond = d.getMillisecond();
	}
	
	public void set (String timestring){
	/* Let "timestring" be a String of the following format:
	 * YYYYMMDDHHMMSSMMMM
	 * 
	 * so that the indices are:
	 * Y Y Y Y M M D D H H  M  M  S  S  M  M  M  M
	 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
	 */
		if (util.Math.isNumber(timestring)){
			year = Integer.valueOf(timestring.substring(0,3));
			month = Integer.valueOf(timestring.substring(4,5));
			day = Integer.valueOf(timestring.substring(6,7));
			hour = Integer.valueOf(timestring.substring(8,9));
			minute = Integer.valueOf(timestring.substring(10,11));
			second = Integer.valueOf(timestring.substring(12,13));
			millisecond = Integer.valueOf(timestring.substring(14,17));
		} else {
			Logger.logMessage('E', new Date(), "Given timestring not numeric! Cannot set.");
		}
	}
	
	public void set (long millis){
		millisecond = millis;
		doUebertrag();
	}
	
	public String toString(){
		return util.Math.fillUpWithZeros(year, 4) + util.Math.fillUpWithZeros(month, 2) + util.Math.fillUpWithZeros(day, 2) + util.Math.fillUpWithZeros(hour, 2) + util.Math.fillUpWithZeros(minute, 2) + util.Math.fillUpWithZeros(second, 2) + util.Math.fillUpWithZeros(millisecond, 4);
	}
	
	public String toReadableString(int format){
		StringBuilder result = new StringBuilder();
		switch (format){
		case 0: //American Format
			result.append(util.Math.fillUpWithZeros(year, 4));
			result.append("/");
			result.append(util.Math.fillUpWithZeros(month, 2));
			result.append("/");
			result.append(util.Math.fillUpWithZeros(day, 2));
			result.append(" ");
			result.append(util.Math.fillUpWithZeros(hour, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(minute, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(second, 2));
			break;
		case 1: //American Short Format
			result.append(util.Math.concatToEnd(year, 2));
			result.append("/");
			result.append(month);
			result.append("/");
			result.append(day);
			result.append(" ");
			result.append(util.Math.fillUpWithZeros(hour, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(minute, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(second, 2));
			break;
		case 2: //German Format
			result.append(util.Math.fillUpWithZeros(day, 2));
			result.append(".");
			result.append(util.Math.fillUpWithZeros(month, 2));
			result.append(".");
			result.append(util.Math.fillUpWithZeros(year, 4));
			result.append(" ");
			result.append(util.Math.fillUpWithZeros(hour, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(minute, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(second, 2));
			break;
		case 3: //German Short Format
			result.append(day);
			result.append(".");
			result.append(month);
			result.append(".");
			result.append(year);
			result.append(" ");
			result.append(util.Math.fillUpWithZeros(hour, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(minute, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(second, 2));
			break;
		case 4: //Without Date
			result.append(util.Math.fillUpWithZeros(hour, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(minute, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(second, 2));
			result.append(":");
			result.append(util.Math.fillUpWithZeros(millisecond, 3));
			break;
		case 5: //American Format Without Time
			result.append(util.Math.fillUpWithZeros(year, 4));
			result.append("/");
			result.append(util.Math.fillUpWithZeros(month, 2));
			result.append("/");
			result.append(util.Math.fillUpWithZeros(day, 2));
			break;
		case 6: //American Short Format Without Time
			result.append(util.Math.concatToEnd(year, 2));
			result.append("/");
			result.append(month);
			result.append("/");
			result.append(day);
			break;
		case 7: //German Format Without Time
			result.append(util.Math.fillUpWithZeros(day, 2));
			result.append(".");
			result.append(util.Math.fillUpWithZeros(month, 2));
			result.append(".");
			result.append(util.Math.fillUpWithZeros(year, 4));
			break;
		case 8: //German Short Format Without Time
			result.append(day);
			result.append(".");
			result.append(month);
			result.append(".");
			result.append(year);
			break;
		default: break;
		}
		return result.toString();
	}
	
	public void doUebertrag(){
		while (millisecond >= 1000){
			second = second + 1;
			millisecond = millisecond - 1000;
		}
		
		while (second >= 60){
			minute = minute + 1;
			second = second - 60;
		}
		
		while (minute >= 60){
			hour = hour + 1;
			minute = minute - 60;
		}
		
		while (hour >= 24){
			day = day + 1;
			hour = hour - 24;
		}
		
		while (day >= daysPerMonth){
			month = month + 1;
			day = day - daysPerMonth;
		}
		
		while (month >= 12){
			year = year + 1;
			month = month - 12;
		}
	}
	
	public void setDaysPerMonth(int daysPerMonth){
		this.daysPerMonth = daysPerMonth;
	}
	
	public int getDaysPerMonth(){
		return daysPerMonth;
	}
	
	public long getLong(){
		return (millisecond) + (second * 1000) + (minute * 60 * 1000) +
				(hour * 60 * 60 * 1000) + (day * 24 * 60 * 60 * 1000) +
				(month * daysPerMonth * 24 * 60 * 60 * 1000) + 
				(year * 365 * 24 * 60 * 60 * 1000);
	}
}