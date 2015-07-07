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

import logging.Logger;

//unused class, not needed anymore

public class NetworkCommunicator {
	private NetworkServer listener;
	private NetworkNotifier notifier;
	private boolean verbose = true;
	
	public NetworkCommunicator(NetworkServer listener, NetworkNotifier notifier){
		this.listener = listener;
		this.notifier = notifier;
	}
	
	public void receive(String message){
		if (verbose) Logger.logMessage('I', this, "passing message to notifier: " + message);
		notifier.onNotify(message);
	}
	
	public void send(String message){
		if (verbose) Logger.logMessage('I', this, "passing message to listener: " + message);
		listener.send(message);
	}
} 