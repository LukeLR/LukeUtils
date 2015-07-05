package test;

import logging.Logger;
import logging.LogManager;

public class LoggerTest {
	public static void main(String[] args){
		Logger.logMessage('I', new LoggerTest(), "Hello!", "default");
		Logger.logMessage('I', new LoggerTest(), "Hallo!", "default");
		Logger.logMessage('I', new LoggerTest(), "Ave!", "default");
		
		LogManager.saveLogFile("log.txt");
	}
}