package logging;

import java.awt.List;

public class Logger {
	public static long counter = 0;
	public static StringBuilder log = new StringBuilder();
	public Logger () {
		// Konstruktor nicht nötig, da statisch
	}
	
	public static void logMessage (Object sender, String message){
		char type = 'U';
		logMessage(type, sender, message);
	}
	
	public static void logMessage (char type, Object sender, String message){
		//TODO: logMessage (char type, Object pObject, String message) schreiben!
		/* logMessage("Got className: " + pObject.getClass().getName());
		String[] className = new String[2];
		className = pObject.getClass().getName().split(".");
		logMessage("Got className: " + className[0] + className[1]);
		String classNameString = className[className.length - 1];
		System.out.println("[" + type + "][" + classNameString + "][" + getMethodName(1) + "]: " + message); */
		System.out.println(counter + " [" + type + "][" + sender.getClass().getName() + "][" + getMethodName(2) + "]: " + message);
		counter++;
		log.append(counter + " [" + type + "][" + sender.getClass().getName() + "][" + getMethodName(2) + "]: " + message);
		log.append(System.lineSeparator());
	}
	
	public static void logMessage (char type, String message){
		//TODO: logMessage (char type, String message) schreiben!
		System.out.println(counter + " [" + type + "] " + message);
		counter++;
		log.append(counter + " [" + type + "] " + message);
		log.append(System.lineSeparator());
	}
	
	public static void logMessage (String message){
		char type = 'U';
		logMessage(type, message);
	}
	
	private static String getMethodName(final int depth){
	  final StackTraceElement[] ste = Thread.currentThread().getStackTrace();

	  //System. out.println(ste[ste.length-depth].getClassName()+"#"+ste[ste.length-depth].getMethodName());
	  //return ste[ste.length - depth].getMethodName();  //Wrong, fails for depth = 0
	  return ste[ste.length - 1 - depth].getMethodName(); //Thank you Tom Tresansky
	}
	
	public static void logException (Object sender, String message, Exception e){
		logMessage('E', sender, message);
		for (int i = 0; i < e.getStackTrace().length; i++){
			Logger.logMessage('E', sender, e.getStackTrace()[i].toString());
		}
	}
}
