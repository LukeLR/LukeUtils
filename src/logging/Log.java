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
	
	public void clearLog(){
		log = new StringBuilder();
	}
}
