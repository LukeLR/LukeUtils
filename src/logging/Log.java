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

public class Log {
	public StringBuilder log;
	public String channel = "default";
	public long index = 0;
	
	public Log(){
		log = new StringBuilder();
		channel = "default";
		index = 0;
	}
	
	public Log(String channel){
		log = new StringBuilder();
		this.channel = channel;
		index = 0;
	}
	
	public Log(String channel, long startIndex){
		log = new StringBuilder();
		this.channel = channel;
		index = startIndex;
	}
	
	public Log (long startIndex){
		log = new StringBuilder();
		channel = "default";
		index = startIndex;
	}
	
	public void append(String str){
		log.append(str);
		index++;
	}
	
	public void setChannel(String chnl){
		channel = chnl;
	}
	
	public String getChannel(){
		return channel;
	}
	
	public String toString(){
		return "Log channel: " + channel + "\n" + log.toString();
	}
	
	public StringBuilder getLog(){
		return log;
	}
	
	public boolean equals(Object compare){
		try{
			return ((Log)compare).getChannel().equals(getChannel());
		} catch (Exception ex) {
			Logger.logMessage('W', this, "Comparing failed! Is the comparison object of type 'Log'?");
			return false;
		}
	}
	
	public boolean isEqual(Log compare){
		return true;
	}
	
	public void clearLog(){
		log = new StringBuilder();
	}
	
	public void setIndex(long index){
		this.index = index;
	}
	
	public long getIndex(){
		return index;
	}
	
	public void increaseIndex(){
		index++;
	}
}
