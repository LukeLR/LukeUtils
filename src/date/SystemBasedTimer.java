package date;

import java.util.Calendar;

public class SystemBasedTimer {
	private long milliseconds = 0;
	private int seconds = 0, minutes = 0, hours = 0, days = 0, months = 0, years = 0;
	private int daysPerMonth = 30;
	private long last;
	private boolean inactive;
	
	public SystemBasedTimer(){
		milliseconds = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		days = 0;
		months = 0;
		years = 0;
		daysPerMonth = 30;
		last = Calendar.getInstance().getTimeInMillis();
	}
	
	public SystemBasedTimer(Date start){
		milliseconds = start.getMillisecond();
		seconds = start.getSecond();
		minutes = start.getMinute();
		hours = start.getHour();
		days = start.getDay();
		months = start.getMonth();
		years = start.getYear();
		daysPerMonth = 30;
		last = Calendar.getInstance().getTimeInMillis();
	}
	
	public SystemBasedTimer(String timeString){
		this (new Date(timeString));
	}
	
	public SystemBasedTimer(int millis, int seconds, int minutes, int hours, int days, int months, int years){
		this (new Date(millis, seconds, minutes, hours, days, months, years));
	}
	
	public void setDaysPerMonth(int dpm){
		daysPerMonth = dpm;
	}
	
	public int getDaysPerMonth(){
		return daysPerMonth;
	}
	
	public void start(){
		last = Calendar.getInstance().getTimeInMillis();
	}
	
	public Date getTime(){
//		System.out.println("Updating Timer: " + String.valueOf(c.getTime().getTime()));
		refresh();
		
		return new Date((int)milliseconds, seconds, minutes, hours, days, months, years);
	}
	
	public long getMillis(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
		}
		return (milliseconds) + (seconds * 1000) + (minutes * 60 * 1000) +
				(hours * 60 * 60 * 1000) + (days * 24 * 60 * 60 * 1000) +
				(months * daysPerMonth * 24 * 60 * 60 * 1000) +
				(years * 12 * 60 * 60 * 1000);
	}
	
	public String getTimeAsString(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			doUebertrag();
		}
		return util.Math.fillUpWithZeros((int)milliseconds, 4) + util.Math.fillUpWithZeros(seconds, 2) +
				util.Math.fillUpWithZeros(minutes, 2) + util.Math.fillUpWithZeros(hours, 2) +
				util.Math.fillUpWithZeros(days, 2) + util.Math.fillUpWithZeros(months, 2) +
				util.Math.fillUpWithZeros(years, 4);
	}
	
	public long getMilliseconds(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
		}
		return milliseconds;
	}
	
	public int getMillisecondsInt(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			doUebertrag();
		}
		return (int)milliseconds;
	}
	
	public int getSeconds(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			doUebertrag();
		}
		return seconds;
	}
	
	public int getMinutes(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			doUebertrag();
		}
		return minutes;
	}
	
	public int getHours(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			doUebertrag();
		}
		return hours;
	}
	
	public int getDays(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			doUebertrag();
		}
		return days;
	}
	
	public int getMonths(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			doUebertrag();
		}
		return months;
	}
	
	public int getYears(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			doUebertrag();
		}
		return years;
	}
	
	public long transferMilliseconds (){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			last = Calendar.getInstance().getTimeInMillis();
		}
		return milliseconds;
	}
	
	public int transferMillisecondsInt(){
		refresh();
		return (int)milliseconds;
	}
	
	public int transferSeconds(){
		refresh();
		return seconds;
	}
	
	public int transferMinutes(){
		refresh();
		return minutes;
	}
	
	public int transferHours(){
		refresh();
		return hours;
	}
	
	public int transferDays(){
		refresh();
		return days;
	}
	
	public int transferMonths(){
		refresh();
		return months;
	}
	
	public int transferYears(){
		refresh();
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
	
	public void doUebertrag(){
		while (milliseconds > 1000){
			seconds = seconds + 1;
			milliseconds = milliseconds - 1000;
		}
		
		while (seconds > 60){
			minutes = minutes + 1;
			seconds = seconds - 60;
		}
		
		while (minutes > 60){
			hours = hours + 1;
			minutes = minutes - 60;
		}
		
		while (hours > 24){
			days = days + 1;
			hours = hours - 24;
		}
		
		while (days > daysPerMonth){
			months = months + 1;
			days = days - daysPerMonth;
		}
		
		while (months > 12){
			years = years + 1;
			months = months - 12;
		}
	}
	
	public void refresh(){
		if (!inactive){
			milliseconds = milliseconds + (Calendar.getInstance().getTimeInMillis() - last);
			last = Calendar.getInstance().getTimeInMillis();
			doUebertrag();
		}
	}
	
	public void setInactive(){
		inactive = true;
	}
	
	public void setActive(){
		inactive = false;
	}
	
	public boolean isActive(){
		return !inactive;
	}
}
