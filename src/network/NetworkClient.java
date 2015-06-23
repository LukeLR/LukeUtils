package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import logging.Logger;

//connects to a listening socket

public class NetworkClient extends Thread {
	private int port;
	private String hostname;
	private NetworkNotifier notifier;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private boolean verbose = true;
	
	public NetworkClient(NetworkNotifier notifier, String hostname, int port){
		this.port = port;
		this.hostname = hostname;
		this.notifier = notifier;
		try{
			socket = new Socket (hostname, port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e){
			Logger.logMessage('E', this, "Can't connect to host: " + hostname);
			System.exit(1);		
		} catch (IOException e){
			Logger.logMessage('E', this, "Can't get I/O for the connection to " + hostname + " on port " + port + ".");
			System.exit(1);
		}
		if (verbose) Logger.logMessage('I', this, "Starting listening to " + hostname + " on port " + port + ".");
		this.start();
	}
	
	public void run(){
		String input = "";
		try{
			while ((input = in.readLine()) != null){
				if (verbose) Logger.logMessage('I', this, "received: " + input);
				notifier.onNotify(input);
			}
		} catch (IOException e){
			Logger.logMessage('E', this, "couldn't listen to network port as client.");
		}
	}
	
	public void send(String message){
		if (out != null){
			if (verbose) Logger.logMessage('I', this, "Sending message: " + message);
			out.println(message);
		} else {
			Logger.logMessage('E', this, "Socket not established well, exiting.");
			System.exit(1);
		}
	}
}