package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import logging.Logger;

public class NetworkServer extends Thread {
	private NetworkNotifier nN;
	private int port;
	private String input;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private boolean verbose = true;
	
	public NetworkServer(NetworkNotifier nN, int port){
		this.nN = nN;
		this.port = port;
		try{
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){ //start listening
		while (!this.isInterrupted()){
			try {
				clientSocket = serverSocket.accept();
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("start");
			try {
				while((input = in.readLine()) != null){
					if (verbose) Logger.logMessage('I', this, "received:" + input);
					nN.onNotify(input);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void send(String message){
		if (this.isAlive()){
			if (verbose) Logger.logMessage('I', this, "sending: " + message);
			out.println(message);
		}
	}
}
