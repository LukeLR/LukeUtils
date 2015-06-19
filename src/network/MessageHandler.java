package network;

public class MessageHandler extends Thread {
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