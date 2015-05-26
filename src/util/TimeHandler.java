package util;

import java.util.Calendar;
import logging.Logger;

public class TimeHandler {
	public static int getTimeInt (int GMTOffset){ //Returns current Time in YYYYMMDDHHMMSS
		Logger.logMessage('I', new TimeHandler(), "Returning TimeInt " + getTimeString(getTimeIntArray(GMTOffset)));
		return Integer.valueOf(getTimeString (GMTOffset));
	}
	
	public static int[] getTimeIntArray (int GMTOffset){ //Returns current Time in {YYYY, MM, DD, HH, MM, SS}
		Calendar now = Calendar.getInstance();
		int[] times = new int[6];
		times[0] = now.get(Calendar.YEAR);
		times[1] = now.get(Calendar.MONTH) + 1;
		times[2] = now.get(Calendar.DAY_OF_MONTH);
		times[3] = now.get(Calendar.HOUR) + GMTOffset;
		times[4] = now.get(Calendar.MINUTE);
		times[5] = now.get(Calendar.SECOND);
		Logger.logMessage('I', new TimeHandler(), "Returning TimeArray " + getTimeString(times));
		return times;
	}
	
	public static String getTimeString (int[] times){ //Returns Time from TimeArray in Format {YYYY, MM, DD, HH, MM, SS} as a String in Format YYMMDDHHMMSS
//		int times[] = getTimeIntArray (GMTOffset);
		String timeStrings[] = new String[6];
		
		if (times[0] < 100){
			timeStrings[0] = "00" + times[0];
		} else if (times[0] < 1000){
			timeStrings[0] = "0" + times[0];
		} else {
			timeStrings[0] = String.valueOf(times[0]);
		}
		
		if (times[1] < 10){
			timeStrings[1] = "0" + times[1];
		} else {
			timeStrings[1] = String.valueOf(times[1]);
		}
		
		if (times[2] < 10){
			timeStrings[2] = "0" + times[2];
		} else {
			timeStrings[2] = String.valueOf(times[2]);
		}
		
		if (times[3] < 10){
			timeStrings[3] = "0" + times[3];
		} else {
			timeStrings[3] = String.valueOf(times[3]);
		}
		
		if (times[4] < 10){
			timeStrings[4] = "0" + times[4];
		} else {
			timeStrings[4] = String.valueOf(times[4]);
		}
		
		if (times[5] < 10){
			timeStrings[5] = "0" + times[5];
		} else {
			timeStrings[5] = String.valueOf(times[5]);
		}
		
		return "" + timeStrings[0] + timeStrings[1] + timeStrings[2] + timeStrings[3] + timeStrings[4] + timeStrings[5];
	}
	
	public static String getTimeString (int GMTOffset){ //Returns current Time in Format YYMMDDHHMMSS
		int times[] = getTimeIntArray (GMTOffset);
		String timeStrings[] = new String[6];
		
		if (times[0] < 100){
			timeStrings[0] = "00" + times[0];
		} else if (times[0] < 1000){
			timeStrings[0] = "0" + times[0];
		} else {
			timeStrings[0] = String.valueOf(times[0]);
		}
		
		if (times[1] < 10){
			timeStrings[1] = "0" + times[1];
		} else {
			timeStrings[1] = String.valueOf(times[1]);
		}
		
		if (times[2] < 10){
			timeStrings[2] = "0" + times[2];
		} else {
			timeStrings[2] = String.valueOf(times[2]);
		}
		
		if (times[3] < 10){
			timeStrings[3] = "0" + times[3];
		} else {
			timeStrings[3] = String.valueOf(times[3]);
		}
		
		if (times[4] < 10){
			timeStrings[4] = "0" + times[4];
		} else {
			timeStrings[4] = String.valueOf(times[4]);
		}
		
		if (times[5] < 10){
			timeStrings[5] = "0" + times[5];
		} else {
			timeStrings[5] = String.valueOf(times[5]);
		}
		
		Logger.logMessage('I', new TimeHandler(), "" + timeStrings[0] + timeStrings[1] + timeStrings[2] + timeStrings[3] + timeStrings[4] + timeStrings[5]);
		return "" + timeStrings[0] + timeStrings[1] + timeStrings[2] + timeStrings[3] + timeStrings[4] + timeStrings[5];
	}
}
