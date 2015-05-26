package date;

import javax.swing.JLabel;

public class SystemBasedTimerLabelManager extends Thread{
	private JLabel lbl;
	private SystemBasedTimer tmr;
	private boolean active = false;
	private int precision = 1;
	
	public SystemBasedTimerLabelManager(JLabel lbl, SystemBasedTimer tmr, int precision){
		this.lbl = lbl;
		this.tmr = tmr;
		this.precision = precision;
		refresh();
	}
	
	public SystemBasedTimerLabelManager(JLabel lbl, SystemBasedTimer tmr){
		this(lbl, tmr, 10);
		refresh();
	}
	
	public SystemBasedTimerLabelManager(JLabel lbl){
		this(lbl, new SystemBasedTimer(), 10);
	}
	
	public SystemBasedTimerLabelManager(JLabel lbl, Date start){
		this(lbl, new SystemBasedTimer(start), 10);
	}
	
	public SystemBasedTimerLabelManager(JLabel lbl, Date start, int precision){
		this(lbl, new SystemBasedTimer(start), precision);
	}
	
	public SystemBasedTimerLabelManager(JLabel lbl, String timeString){
		this(lbl, new SystemBasedTimer(timeString), 10);
	}
	
	public SystemBasedTimerLabelManager(JLabel lbl, String timeString, int precision){
		this(lbl, new SystemBasedTimer(timeString), precision);
	}
	
	public SystemBasedTimerLabelManager(JLabel lbl, long startMillis){
		this(lbl, new SystemBasedTimer(new Date(startMillis)), 10);
	}
	
	public SystemBasedTimerLabelManager(JLabel lbl, long startMillis, int precision){
		this(lbl, new SystemBasedTimer(new Date(startMillis)), precision);
	}
	
	public SystemBasedTimerLabelManager(Date start){
		this(new JLabel(), start, 10);
	}
	
	public SystemBasedTimerLabelManager(Date start, int precision){
		this(new JLabel(), start, precision);
	}
	
	public SystemBasedTimerLabelManager(String timeString){
		this(new JLabel(), new Date(timeString), 10);
	}
	
	public SystemBasedTimerLabelManager(String timeString, int precision){
		this(new JLabel(), new Date(timeString), precision);
	}
	
	public SystemBasedTimerLabelManager(long startMillis){
		this(new JLabel(), new Date(startMillis), 10);
	}
	
	public SystemBasedTimerLabelManager(long startMillis, int precision){
		this(new JLabel(), new Date(startMillis), precision);
	}
	
	public void run(){
		active = true;
		tmr.start();
		while (active){
			try {
				Thread.sleep(precision);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			refresh();
		}
	}
	
	public void refresh(){
		Date time = tmr.getTime();
		
		String hours;
		if (time.getHour() == 0){
			hours = "";
		} else {
			hours = util.Math.fillUpWithZeros(time.getHour(), 2) + ":";
		}
		
		String minutes = util.Math.fillUpWithZeros(time.getMinute(), 2) + ":";
		String seconds = util.Math.fillUpWithZeros(time.getSecond(), 2) + ":";
		String milliseconds = util.Math.fillUpWithZeros(time.getMillisecond(), 3);
		
		if (precision < 10){
			//Leave milliseconds as is (full precision)
		} else if (precision < 100){
			milliseconds = milliseconds.substring(0, milliseconds.length() - 1);
		} else if (precision < 1000){
			milliseconds = milliseconds.substring(0, milliseconds.length() - 2);
		} else if (precision < 10000){
			milliseconds = "";
			seconds = seconds.substring(0, seconds.length() - 1); //Cut the ":" after the seconds.
		}
		
		lbl.setText(hours + minutes + seconds + milliseconds);
	}
	
	public void cancel(){
		active = false;
		tmr.setInactive();
	}
	
	public JLabel getLabel(){
		return lbl;
	}
	
	public SystemBasedTimer getTimer(){
		return tmr;
	}
}