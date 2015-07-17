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

package logging;

//import data.list.List;
import java.util.List;
import java.util.LinkedList;

public class Logger {
	public static long counter = 0;
	public static List<Log> logs = new LinkedList();
	
	public Logger () {
		// Konstruktor nicht nötig, da statisch
	}
	
	public static void logMessage (String message){
		logMessage("U", null, message, "default");
	}
	
	public static void logMessage (Object sender, String message){
		logMessage("U", sender, message, "default");
	}
	
	public static void logMessage (char type, String message){
		logMessage(String.valueOf(type), null, message, "default");
	}
	
	public static void logMessage(String message, String channel){
		logMessage("U", null, message, channel);
	}
	
	public static void logMessage(Object sender, String message, String channel){
		logMessage("U", sender, message, channel);
	}
	
	public static void logMessage(char type, String message, String channel){
		logMessage(String.valueOf(type), null, message, channel);
	}
	
	public static void logMessage(char type, Object sender, String message, String channel){
		logMessage(String.valueOf(type), sender, message, channel);
	}
	
	public static void logMessage(char type, Object sender, String message){
		logMessage(String.valueOf(type), sender, message, "default");
	}
	
	public static void logMessage(String type, String message, String channel){
		logMessage(type, null, message, channel);
	}
	
	public static void logMessage(String type, Object sender, String message){
		logMessage(type, sender, message, "default");
	}
	
	public static void logMessage (String type, Object sender, String message, String channel){
		/* logMessage("Got className: " + pObject.getClass().getName());
		String[] className = new String[2];
		className = pObject.getClass().getName().split(".");
		logMessage("Got className: " + className[0] + className[1]);
		String classNameString = className[className.length - 1];
		System.out.println("[" + type + "][" + classNameString + "][" + getMethodName(1) + "]: " + message); */
		String logString = "";
		if (sender == null){
			System.out.println(counter + " [" + type + "] " + message);
			logString = counter + " [" + type + "] " + message;
		} else {
			System.out.println(counter + " [" + type + "][" + sender.getClass().getName() + "][" + getMethodName(2) + "]: " + message);
			logString = counter + " [" + type + "][" + sender.getClass().getName() + "][" + getMethodName(2) + "]: " + message;
		}
		counter++;
		Log dummy = new Log(channel);
		System.out.println("Searching for channel " + channel + ": " + String.valueOf(logs.contains(dummy)));
		int index = logs.indexOf(dummy);
		if (index == -1){
			System.out.println(counter + " [W][Logger][logMessage]: Log for channel " + channel + " does not exist. Trying to create a new one!");
			logString =        counter + " [W][Logger][logMessage]: Log for channel " + channel + " does not exist. Trying to create a new one!" + System.lineSeparator() + logString;
			// create new log for channel and append it to the list of logs.
			
			dummy.append(logString);
			logs.add(dummy);
		} else {
			logs.get(index).append(logString + System.lineSeparator());
		}
	}
	
	private static String getMethodName(final int depth){
	  final StackTraceElement[] ste = Thread.currentThread().getStackTrace();

	  //System. out.println(ste[ste.length-depth].getClassName()+"#"+ste[ste.length-depth].getMethodName());
	  //return ste[ste.length - depth].getMethodName();  //Wrong, fails for depth = 0
	  return ste[ste.length - 1 - depth].getMethodName(); //Thank you Tom Tresansky
	}
	
	public static void logException (Object sender, String message, Exception e){
		logException(sender, message, e, "default");
	}
	
	public static void logException (Object sender, String message, Exception e, String channel){
		logMessage('E', sender, message, channel);
		for (int i = 0; i < e.getStackTrace().length; i++){
			Logger.logMessage('E', sender, e.getStackTrace()[i].toString(), channel);
		}
	}
}
