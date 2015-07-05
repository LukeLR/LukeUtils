/**
 * This file is part of LukeUtils.
 *
 * LukeUtils is free software: you can redistribute it and/or modify
 * it under the terms of the cc-by-nc-sa (Creative Commons Attribution-
 * NonCommercial-ShareAlike) as released by the Creative Commons
 * organisation, version 3.0.
 *
 * LukeUtils is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY.
 *
 * You should have received a copy of the cc-by-nc-sa-license along
 * with this LukeUtils. If not, see
 * <https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode>.
 *
 * Copyright Lukas Rose 2013 - 2015
 */

package date;

import javax.swing.JLabel;

public class TimerLabelManager extends Thread{
	private JLabel lbl;
	private Timer tmr;
	private boolean active = false;
	private long precision = 1;
	
	public TimerLabelManager(JLabel label, Timer timer){
		lbl = label;
		tmr = timer;
		precision = 1;
	}
	
	public TimerLabelManager(JLabel label, long startMillis, long precision){
		lbl = label;
		tmr = new Timer(startMillis, precision);
		this.precision = precision;
	}
	
	public TimerLabelManager(JLabel label, Date startDate, long precision){
		lbl = label;
		tmr = new Timer(startDate, precision);
		this.precision = precision;
	}
	
	public TimerLabelManager(JLabel label, long startMillis){
		lbl = label;
		tmr = new Timer(startMillis);
		precision = 1;
	}
	
	public TimerLabelManager(JLabel label, Date startDate){
		lbl = label;
		tmr = new Timer(startDate);
		precision = 1;
	}
	
	public TimerLabelManager(Timer timer){
		lbl = new JLabel ("00:00:00:0000");
		tmr = timer;
		precision = 1;
	}
	
	public TimerLabelManager(long startMillis, long precision){
		lbl = new JLabel ("00:00:00:0000");
		tmr = new Timer (startMillis, precision);
		this.precision = precision;
	}
	
	public TimerLabelManager(Date startDate, long precision){
		lbl = new JLabel ("00:00:00:0000");
		tmr = new Timer(startDate, precision);
		this.precision = precision;
	}
	
	public TimerLabelManager(long startMillis){
		lbl = new JLabel ("00:00:00:0000");
		tmr = new Timer(startMillis);
		precision = 1;
	}
	
	public TimerLabelManager(Date startDate){
		lbl = new JLabel ("00:00:00:0000");
		tmr = new Timer(startDate);
		precision = 1;
	}
	
	public TimerLabelManager(){
		lbl = new JLabel ("00:00:00:0000");
		tmr = new Timer();
		precision = 1;
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
		lbl.setText(tmr.getTime().toReadableString(Date.WithoutDate));
	}
	
	public void cancel(){
		active = false;
		tmr.stop();
	}
	
	public JLabel getLabel(){
		return lbl;
	}
	
	public Timer getTimer(){
		return tmr;
	}
}
