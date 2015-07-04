package logging;

import java.util.LinkedList;
import java.util.List;

public class Logger {
	public static long counter = 0;
	public static List<Log> logs = new LinkedList();
	
	public Logger () {
		// Konstruktor nicht nötig, da statisch
	}
	
	public static void logMessage (String message){
		logMessage('U', null, message, "default");
	}
	
	public static void logMessage (Object sender, String message){
		logMessage('U', sender, message, "default");
	}
	
	public static void logMessage (char type, String message){
		logMessage(type, null, message, "default");
	}
	
	public static void logMessage(String message, String channel){
		logMessage('U', null, message, channel);
	}
	
	public static void logMessage(Object sender, String message, String channel){
		logMessage('U', sender, message, channel);
	}
	
	public static void logMessage(char type, String message, String channel){
		logMessage(type, null, message, channel);
	}
	
	public static void logMessage(char type, Object sender, String message){
		logMessage(type, sender, message, "default");
	}
	
	public static void logMessage (char type, Object sender, String message, String channel){
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
		int index = logs.indexOf(dummy);
		logs.in
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
