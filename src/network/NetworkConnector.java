package network;

public class NetworkConnector extends Thread {
	private int port;
	public NetworkConnector(int port){
		this.port = port;
	}
}
