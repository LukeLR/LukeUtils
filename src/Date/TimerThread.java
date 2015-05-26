package date;

import java.io.Serializable;

public class TimerThread extends Thread implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5882613853352397441L;
	private long millis = 0;
	private long precision = 1;
	private boolean running = false;
	
	public TimerThread(int start, long precision){
		millis = start;
		this.precision = precision;
	}
	
	public TimerThread(long precision){
		millis = 0;
		this.precision = precision;
	}
	
	public TimerThread(){
		millis = 0;
		precision = 1;
	}
	
	public void run(){
		running = true;
		while (running){
			try {
				Thread.sleep(precision);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			millis = millis + precision;
		}
	}
	
	public void cancel(){
		running = false;
	}
	
	public void clear(){
		millis = 0;
	}
	
	public long getMillis(){
		return millis;
	}
	
	public long transferMillis(){
		long temp = millis;
		millis = 0;
		return temp;
	}
	
	public long getPrecision(){
		return precision;
	}
	
	public void setPrecision(long precision){
		this.precision = precision;
	}
}
