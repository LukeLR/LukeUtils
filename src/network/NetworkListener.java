package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkListener extends Thread {
	NetworkNotifier nN;
	int port;
	String input;
	ServerSocket serverSocket;
	Socket clientSocket;
	PrintWriter out;
	BufferedReader in;
	
	public NetworkListener(NetworkNotifier nN, int port){
		this.nN = nN;
		this.port = port;
		try{
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		while (!this.isInterrupted()){
			try {
				clientSocket = serverSocket.accept();
				out = new PrintWriter(clientSocket.getOutputStream());
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("start");
			try {
				while((input = in.readLine()) != null){
					nN.onNotify(input);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
