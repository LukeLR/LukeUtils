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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logging.Logger;

public class PieChartKey extends JPanel{
	private PieChart pc;
	private GridBagConstraints c;
	private Slice[] s;
	private JLabel[] colors, names, values;
	
	public PieChartKey(PieChart pc){
		super();
		Logger.logMessage('I', this, "New PieChartKey!");
		this.pc = pc;
		s = pc.getSlices();
		prepareKey();
	}
	
	public void prepareKey(){
		Logger.logMessage('I', this, "Preparing Key for PieChart...");
		c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		
		colors = new JLabel[s.length];
		names = new JLabel[s.length];
		values = new JLabel[s.length];
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.weighty = 0;
		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.CENTER;
		
		for (int i = 0; i < s.length; i++){
			colors[i] = new JLabel();
			colors[i].setBackground(s[i].getColor());
			colors[i].setOpaque(true);
			colors[i].setBorder(BorderFactory.createLineBorder(Color.black));
			colors[i].setMinimumSize(new Dimension(10,10));
			colors[i].setPreferredSize(new Dimension(10,10));
			colors[i].setMaximumSize(new Dimension(10,10));
			
			c.gridy = i;
			this.add(colors[i], c);
		}
		
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 2;
		c.weighty = 1;
		c.insets = new Insets(0, 0, 0, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		
		for (int i = 0; i < s.length; i++){
			names[i] = new JLabel(s[i].getName());
			
			c.gridy = i;
			this.add(names[i], c);
		}
		
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 10, 0, 10);
		c.anchor = GridBagConstraints.EAST;
		c.fill = GridBagConstraints.NONE;
		
		for (int i = 0; i < s.length; i++){
			values[i] = new JLabel (String.valueOf(s[i].getValue()));
			
			c.gridy = i;
			this.add(values[i], c);
		}
		
		this.setSize(getPreferredSize());
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
	}
}