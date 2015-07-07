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