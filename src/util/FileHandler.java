package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import logging.Logger;


public class FileHandler {
	public static void writeStringBuilder (File out, StringBuilder in){
		Logger.logMessage('I', new FileHandler(), "Writing StringBuilder to " + out.getName());
		BufferedWriter writer;
		try {
	    	writer = new BufferedWriter(new FileWriter(out));
			writer.append(in);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logger.logMessage('E', new FileHandler(), "Error writing StringBuilder");
			for (int i = 0; i < e.getStackTrace().length; i++){
				Logger.logMessage('E', new FileHandler(), e.getStackTrace()[i].toString());
			}
		}
	}
	
	public static void writeString (File out, StringBuilder in){
		Logger.logMessage('I', new FileHandler(), "Writing String to " + out.getName());
		writeStringBuilder(out,new StringBuilder(in));
	}
	
	public static String readString (File in) {
		Logger.logMessage('I', new FileHandler(), "reading String from " + in.getName());
	    String text = "";
	    int read, N = 1024 * 1024;
	    char[] buffer = new char[N];

	    try {
	        FileReader fr = new FileReader(in);
	        BufferedReader br = new BufferedReader(fr);

	        while(true) {
	            read = br.read(buffer, 0, N);
	            text += new String(buffer, 0, read);

	            if(read < N) {
	            	br.close();
	                break;
	            }
	        }
	    } catch(Exception e) {
	    	Logger.logMessage('E', new FileHandler(), "Error reading String!");
			for (int i = 0; i < e.getStackTrace().length; i++){
				Logger.logMessage('E', new FileHandler(), e.getStackTrace()[i].toString());
			}
	    }

	    return text;
	}
	
	public static StringBuilder readStringBuilder (File in) {
		Logger.logMessage('I', new FileHandler(), "Reading StringBuilder from " + in.getName());
	    StringBuilder text = new StringBuilder();
	    int read, N = 1024 * 1024;
	    char[] buffer = new char[N];

	    try {
	        FileReader fr = new FileReader(in);
	        BufferedReader br = new BufferedReader(fr);

	        while(true) {
	            read = br.read(buffer, 0, N);
	            text.append(new String(buffer, 0, read));

	            if(read < N) {
	            	br.close();
	                break;
	            }
	        }
	    } catch(Exception e) {
	    	Logger.logMessage('E', new FileHandler(), "Error reading StringBuilder!");
			for (int i = 0; i < e.getStackTrace().length; i++){
				Logger.logMessage('E', new FileHandler(), e.getStackTrace()[i].toString());
			}
	    }

	    return text;
	}
	
	public static boolean deleteFile(File f) {
		Logger.logMessage('I', new FileHandler(), "Deleting File saved at " + f.getName());

		if (!f.exists()){
			Logger.logMessage('E', new FileHandler(), "Could not delete File at " + f.getName() + ": File does not exist");
			return false;
		} else {
			if (!f.canWrite()){
				Logger.logMessage('E', new FileHandler(), "Could not delete File at " + f.getName() + ": No write access");
				return false;
			} else {
				if (f.isDirectory()){
					String[] files = f.list();
					if (files.length > 0) {
						 Logger.logMessage('E', new FileHandler(), "Could not delete File at " + f.getName() + ": Is a direcotry (And not empty)");
						 return false;
					} else {
						boolean success = f.delete();
						if (!success){
							Logger.logMessage('E', new FileHandler(), "Could not delete File at " + f.getName() + ": An unknown error occured!");
						} else {
							Logger.logMessage('S', new FileHandler(), "Successfully deletet File at " + f.getName() + "!");
						}
						return success;
					}
				} else {
					boolean success = f.delete();
					if (!success){
						Logger.logMessage('E', new FileHandler(), "Could not delete File at " + f.getName() + ": An unknown error occured!");
					} else {
						Logger.logMessage('S', new FileHandler(), "Successfully deletet File at " + f.getName() + "!");
					}
					return success;
				}
			}
		}
	}
}