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

package date;

import java.io.Serializable;

public class TimerThread extends Thread implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5882613853352397441L;
	private long millis = 0;
	private long precision = 1;
	private boolean running = false;
	
	public TimerThread(int start, long precision){
		millis = start;
		this.precision = precision;
	}
	
	public TimerThread(long precision){
		millis = 0;
		this.precision = precision;
	}
	
	public TimerThread(){
		millis = 0;
		precision = 1;
	}
	
	public void run(){
		running = true;
		while (running){
			try {
				Thread.sleep(precision);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			millis = millis + precision;
		}
	}
	
	public void cancel(){
		running = false;
	}
	
	public void clear(){
		millis = 0;
	}
	
	public long getMillis(){
		return millis;
	}
	
	public long transferMillis(){
		long temp = millis;
		millis = 0;
		return temp;
	}
	
	public long getPrecision(){
		return precision;
	}
	
	public void setPrecision(long precision){
		this.precision = precision;
	}
}
