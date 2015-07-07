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
	
	public Log(){
		log = new StringBuilder();
		channel = "default";
	}
	
	public Log(String channel){
		log = new StringBuilder();
		this.channel = channel;
	}
	
	public void append(String str){
		log.append(str);
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
	
	public boolean equals(Log compare){
//		return getChannel().equals(compare.getChannel());
		return true;
	}
	
	public boolean isEqual(Log compare){
		return true;
	}
	
	public void clearLog(){
		log = new StringBuilder();
	}
}
