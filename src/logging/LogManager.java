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
				toWrite.append(Logger.log);
				
				FileHandler.writeStringBuilder(logFile, toWrite);
				Logger.log = new StringBuilder();
//				return "";
			} else {
//				Date d = cal.getTime();
				
				String[] filenameArray = new String [2];
				filenameArray = filename.split("\\.(?=[^\\.]+$)");
				filenameArray[0] = filenameArray[0] + TimeHandler.getTimeString(0);
				filename = filenameArray[0] + "." + filenameArray[1];
				
//				filename = filename + d.getYear() + d.getMonth() + d.getDay() + d.getHours() + d.getMinutes() + d.getSeconds();
				logFile = new File (filename);
				
				Logger.logMessage('I', new LogManager(), "Creating new LogFile " + filename);
				
				FileHandler.writeStringBuilder(logFile, Logger.log);
				Logger.log = new StringBuilder();
//				return filename;
			}
		} else {
			Logger.logMessage('I', new LogManager(), "No Log file exists, creating new one: " + filename);
			FileHandler.writeStringBuilder(logFile, Logger.log);
			Logger.log = new StringBuilder();
//			return filename;
		}
		return filename;
	}
	
	public static boolean deleteLogFile(String filename){
		Logger.logMessage('I', new LogManager(), "Deleting Log at " + filename + "!");
		return FileHandler.deleteFile(new File(filename));
	}
}
