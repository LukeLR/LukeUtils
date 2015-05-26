package util;

import java.io.IOException;

public class Postponer extends Thread {
	//This Class, when created as an object, waits a specified amount of time until executing a command.
	private long time;
	private String[] commandStrings;
	
	public Postponer(long millis, String[] commandStrings){
		this.time = millis;
		this.commandStrings = commandStrings;
	}
	
	public void run(){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Runtime.getRuntime().exec(commandStrings);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
