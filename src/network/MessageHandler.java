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

package network;

public class MessageHandler extends Thread{
	//this is what a message handler should look like, this class is not used.
	String message;
	public MessageHandler(String message){
		this.message = message;
	}
	
	public void run(){
		handleMessage();
	}
	
	public void handleMessage(){
		//This method has to be filled by subclasses.
	}
}