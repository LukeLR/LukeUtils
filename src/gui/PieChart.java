package gui;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import logging.Logger;

public class PieChart extends JComponent {
	private Slice[] s;
	private double[] sums;
	private boolean verbose = false;
	
	public PieChart(Slice[] s){
		this.s = s;
		calcSums();
	}
	
	public void paintComponent (Graphics g){
		if (verbose){
			Logger.logMessage('I', this, "Painting PieChart...");
		}
		for (int i = 0; i < s.length; i++){
			s[i].draw(g, getX(), getY(), getWidth(), getHeight(), sums[sums.length-1], sums[i]);
		}
	}
	
	public Slice[] getSlices(){
		return s;
	}
	
	public double[] getSums(){
		return sums;
	}
	
	private void calcSums(){
		Logger.logMessage('I', this, "Calcing Sums for PieChart...");
		double temp = 0;
		sums = new double[s.length+1];
		for (int i = 0; i < sums.length; i++){
			temp = 0;
			for (int j = 0; j < i; j++){
				temp = temp + s[j].getValue();
			}
			sums[i] = temp;
		}
	}
}