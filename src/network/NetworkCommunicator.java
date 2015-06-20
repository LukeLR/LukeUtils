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