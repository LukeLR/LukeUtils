/**
 * This file is part of LukeUtils.
 *
 * LukeUtils is free software: you can redistribute it and/or modify
 * it under the terms of the cc-by-nc-sa (Creative Commons Attribution-
 * NonCommercial-ShareAlike) as released by the Creative Commons
 * organisation, version 3.0.
 *
 * LukeUtils is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY.
 *
 * You should have received a copy of the cc-by-nc-sa-license along
 * with this LukeUtils. If not, see
 * <https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode>.
 *
 * Copyright Lukas Rose 2013 - 2015
 */

package date;

import java.io.Serializable;

import logging.Logger;

public class Timer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3984132884078514600L;
	private long milliseconds = 0;
	private int seconds = 0, minutes = 0, hours = 0, days = 0, months = 0, years = 0; //Time fields
	private long precision = 1;
	private int daysPerMonth = 30;
	private TimerThread tt;
	
	public Timer(int millis, int seconds, int minutes, int hours, int days, int months, int years, long precision){
		Logger.logMessage('I', this, "New Timer created with Starttime " + new Date(millis,seconds,minutes,hours,days,months,years).toReadableString(Date.GermanFormat) + " and Precision: " + String.valueOf(precision));
		milliseconds = millis;
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
		this.days = days;
		this.months = months;
		this.years = years;
		tt = new TimerThread (precision);
		doUebertrag();
	}
	
	public Timer(){
		Logger.logMessage('I', this, "New Timer created with default values");
		milliseconds = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		days = 0;
		months = 0;
		years = 0;
		precision = 1;
		tt = new TimerThread (precision);
		doUebertrag();
	}
	
	public Timer (long start){
		Logger.logMessage('I', this, "New Timer created with Starttime " + new Date(start).toReadableString(Date.GermanFormat));
		milliseconds = start;
		seconds = 0;
		minutes = 0;
		hours = 0;
		days = 0;
		months = 0;
		years = 0;
		precision = 1;
		tt = new TimerThread (precision);
		doUebertrag();
	}
	
	public Timer (long start, long precision){
		Logger.logMessage('I', this, "New Timer created with Starttime " + new Date(start).toReadableString(Date.GermanFormat) + " and precision: " + String.valueOf(precision));
		milliseconds = start;
		seconds = 0;
		minutes = 0;
		hours = 0;
		days = 0;
		months = 0;
		years = 0;
		this.precision = precision;
		tt = new TimerThread (precision);
		doUebertrag();
	}
	
	public Timer (Date start, long precision){
		Logger.logMessage('I', this, "New Timer created with Starttime " + start.toReadableString(Date.GermanFormat) + " and precision: " + String.valueOf(precision));
		milliseconds = start.getMillisecond();
		seconds = start.getSecond();
		minutes = start.getMinute();
		hours = start.getHour();
		days = start.getDay();
		months = start.getMonth();
		years = start.getYear();
		this.precision = precision;
		doUebertrag();
	}
	
	public Timer (Date start){
		Logger.logMessage('I', this, "New Timer created with Starttime " + start.toReadableString(Date.GermanFormat));
		milliseconds = start.getMillisecond();
		seconds = start.getSecond();
		minutes = start.getMinute();
		hours = start.getHour();
		days = start.getDay();
		months = start.getMonth();
		years = start.getYear();
	}
	
	public void doUebertrag(){
		while (milliseconds >= 1000){
			seconds = seconds + 1;
			milliseconds = milliseconds - 1000;
		}
		
		while (seconds >= 60){
			minutes = minutes + 1;
			seconds = seconds - 60;
		}
		
		while (minutes >= 60){
			hours = hours + 1;
			minutes = minutes - 60;
		}
		
		while (hours >= 24){
			days = days + 1;
			hours = hours - 24;
		}
		
		while (days >= daysPerMonth){
			months = months + 1;
			days = days - daysPerMonth;
		}
		
		while (months >= 12){
			years = years + 1;
			months = months - 12;
		}
	}
	
	public void start(){
		tt.start();
	}
	
	public void stop(){
		tt.cancel();
	}
	
	public Date getTime(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return new Date((int)milliseconds, seconds, minutes, hours, days, months, years);
	}
	
	public long getMillis(){
		milliseconds = milliseconds + tt.transferMillis();
		return (milliseconds) + (seconds * 1000) + (minutes * 60 * 1000) +
				(hours * 60 * 60 * 1000) + (days * 24 * 60 * 60 * 1000) +
				(months * daysPerMonth * 24 * 60 * 60 * 1000) +
				(years * 12 * 60 * 60 * 1000);
	}
	
	public String getTimeAsString(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return util.Math.fillUpWithZeros((int)milliseconds, 4) + util.Math.fillUpWithZeros(seconds, 2) +
				util.Math.fillUpWithZeros(minutes, 2) + util.Math.fillUpWithZeros(hours, 2) +
				util.Math.fillUpWithZeros(days, 2) + util.Math.fillUpWithZeros(months, 2) +
				util.Math.fillUpWithZeros(years, 4);
	}
	
	public long getMilliseconds(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return milliseconds;
	}
	
	public int getMillisecondsInt(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return (int)milliseconds;
	}
	
	public int getSeconds(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return seconds;
	}
	
	public int getMinutes(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return minutes;
	}
	
	public int getHours(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return hours;
	}
	
	public int getDays(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return days;
	}
	
	public int getMonths(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return months;
	}
	
	public int getYears(){
		milliseconds = milliseconds + tt.transferMillis();
		doUebertrag();
		return years;
	}
	
	public void setMillis(long millis){
		milliseconds = millis;
		doUebertrag();
	}
	
	public void setMillis(int millis){
		milliseconds = (long)millis;
		doUebertrag();
	}
	
	public void setSeconds(int secs){
		seconds = secs;
		doUebertrag();
	}
	
	public void setMinutes(int mins){
		minutes = mins;
		doUebertrag();
	}
	
	public void setHours(int hours){
		this.hours = hours;
		doUebertrag();
	}
	
	public void setDays(int days){
		this.days = days;
		doUebertrag();
	}
	
	public void setMonths(int months){
		this.months = months;
		doUebertrag();
	}
	
	public void setYears(int years){
		this.years = years;
		doUebertrag();
	}
	
	public void addMillis(long millis){
		milliseconds = milliseconds + millis;
		doUebertrag();
	}
	
	public void addMillis(int millis){
		milliseconds = milliseconds + (int)millis;
		doUebertrag();
	}
	
	public void addSeconds(int secs){
		seconds = seconds + secs;
		doUebertrag();
	}
	
	public void addMinutes(int mins){
		minutes = minutes + mins;
		doUebertrag();
	}
	
	public void addHours(int hours){
		this.hours = this.hours + hours;
		doUebertrag();
	}
	
	public void addDays(int days){
		this.days = this.days + days;
		doUebertrag();
	}
	
	public void addMonths(int months){
		this.months = this.months + months;
		doUebertrag();
	}
	
	public void addYears(int years){
		this.years = this.years + years;
		doUebertrag();
	}
}