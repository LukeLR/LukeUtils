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
import java.io.File;

import util.FileHandler;
import util.TimeHandler;


public class LogManager {
	public static String saveLogFile(String filename){
		File logFile = new File(filename);
		Logger.logMessage('I', new LogManager(), "Saving Log File");
		if (logFile.exists()){
			Logger.logMessage('I', new LogManager(), "LogFile exists: " + filename);
			if (logFile.length() < 10485760){ //10 MB = 1024 * 1024 = 10,485,760 Byte
				Logger.logMessage('I', new LogManager(), "Appending to LogFile " + filename);
				StringBuilder toWrite = new StringBuilder();
				
				toWrite.append(FileHandler.readStringBuilder(logFile));
				toWrite.append(System.lineSeparator());
				toWrite.append(System.lineSeparator());
				toWrite.append("==========================================");
				toWrite.append(System.lineSeparator());
				toWrite.append("===== new Instance on " + TimeHandler.getTimeString(0) + " =====");
				toWrite.append(System.lineSeparator());
				toWrite.append("==========================================");
				toWrite.append(System.lineSeparator());
				
				for (int i = 0; i < Logger.logs.size(); i++){
					Log currentLog = Logger.logs.get(i);
					toWrite.append(" ------ dumping channel: " + currentLog.getChannel() + " ------");
					toWrite.append(System.lineSeparator());
					toWrite.append(Logger.logs.get(i));
					if (i < Logger.logs.size() - 1){
						// Check if there will come another channel after this one and add needed spare lines
						toWrite.append(System.lineSeparator());
						toWrite.append(System.lineSeparator());
					}
					Logger.logs.get(i).clearLog();
				}
				
				FileHandler.writeStringBuilder(logFile, toWrite);
			} else {
				String[] filenameArray = new String [2];
				filenameArray = filename.split("\\.(?=[^\\.]+$)");
				filenameArray[0] = filenameArray[0] + TimeHandler.getTimeString(0);
				filename = filenameArray[0] + "." + filenameArray[1];
				logFile = new File (filename);
				
				Logger.logMessage('I', new LogManager(), "Creating new LogFile " + filename);
				
				StringBuilder toWrite = new StringBuilder();
				
				toWrite.append("==========================================");
				toWrite.append(System.lineSeparator());
				toWrite.append("===== new Instance on " + TimeHandler.getTimeString(0) + " =====");
				toWrite.append(System.lineSeparator());
				toWrite.append("==========================================");
				toWrite.append(System.lineSeparator());
				
				for (int i = 0; i < Logger.logs.size(); i++){
					Log currentLog = Logger.logs.get(i);
					toWrite.append(" ------ dumping channel: " + currentLog.getChannel() + " ------");
					toWrite.append(System.lineSeparator());
					toWrite.append(Logger.logs.get(i));
					if (i < Logger.logs.size() - 1){
						// Check if there will come another channel after this one and add needed spare lines
						toWrite.append(System.lineSeparator());
						toWrite.append(System.lineSeparator());
					}
					Logger.logs.get(i).clearLog();
				}
				
				FileHandler.writeStringBuilder(logFile, toWrite);
			}
		} else {
			Logger.logMessage('I', new LogManager(), "No Log file exists, creating new one: " + filename);
			StringBuilder toWrite = new StringBuilder();
			
			toWrite.append("==========================================");
			toWrite.append(System.lineSeparator());
			toWrite.append("===== new Instance on " + TimeHandler.getTimeString(0) + " =====");
			toWrite.append(System.lineSeparator());
			toWrite.append("==========================================");
			toWrite.append(System.lineSeparator());
			
			for (int i = 0; i < Logger.logs.size(); i++){
				Log currentLog = Logger.logs.get(i);
				toWrite.append(" ------ dumping channel: " + currentLog.getChannel() + " ------");
				toWrite.append(System.lineSeparator());
				toWrite.append(Logger.logs.get(i));
				if (i < Logger.logs.size() - 1){
					// Check if there will come another channel after this one and add needed spare lines
					toWrite.append(System.lineSeparator());
					toWrite.append(System.lineSeparator());
				}
				Logger.logs.get(i).clearLog();
			}
			
			FileHandler.writeStringBuilder(logFile, toWrite);
		}
		return filename;
	}
	
	public static boolean deleteLogFile(String filename){
		Logger.logMessage('I', new LogManager(), "Deleting Log at " + filename + "!");
		return FileHandler.deleteFile(new File(filename));
	}
}
