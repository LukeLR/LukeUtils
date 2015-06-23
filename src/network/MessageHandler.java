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