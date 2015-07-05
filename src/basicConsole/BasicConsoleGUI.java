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

package basicConsole;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;

public class BasicConsoleGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1184128041781114644L;
	private JPanel p, down;
	private JTextArea output;
	private JTextField input;
	private JButton send;
	private BasicConsoleGUIListener listener;
	private JScrollPane outputScroller;
	private String lastInput;
	private boolean wasInput;
	
	public BasicConsoleGUI (String text) {
		super();
		System.out.println("basicGUI initialized!");
		
		p = new JPanel (new BorderLayout());
		
		output = new JTextArea (text);
		output.setFont(new Font ("Andale Mono", Font.PLAIN, 10));
		output.setOpaque(true);
		output.setBackground(Color.black);
		output.setForeground(Color.green);
		output.setLineWrap(true);
		
		outputScroller = new JScrollPane (output);
		outputScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		outputScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		outputScroller.setBackground(Color.black);
		
		p.add(outputScroller, BorderLayout.CENTER);
		
		down = new JPanel (new GridBagLayout());
		down.setBackground(Color.black);
		p.add(down, BorderLayout.PAGE_END);
		
		Insets firstInRow = new Insets (0, 5, 0, 0);
		Insets lastInRow = new Insets (0, 3, 0, 3);
		
		input = new JTextField ("Eingabe");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = firstInRow;
		c.fill = GridBagConstraints.BOTH;
		
		down.add(input, c);
		
		send = new JButton ("Bestatigen");
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0;
		c.weighty = 0;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = lastInRow;
		c.fill = GridBagConstraints.NONE;
		
		down.add(send, c);
		
		this.addWindowListener(new BasicConsoleGUIWindowListener(this));
		
		this.setContentPane(p);
		this.setSize (500,500);
		this.setVisible(true);
		
		listener = new BasicConsoleGUIListener(this);
		send.addActionListener(listener);
	}
	
	public BasicConsoleGUI(){
		this("");
	}
	
	public void outputText (String out){
		output.setText(output.getText() + "\n" + out);
		lastInput = out;
		wasInput = true;
	}
	
	public String getEingabe (){
		return input.getText();
	}
	
	public String getLastEingabe(){
		return lastInput;
	}
	
	public boolean wasInput(){
		if (wasInput){
			wasInput = false;
			return true;
		} else {
			return false;
		}
	}
	
	public String getText(){
		return output.getText();
	}
	
	public void leaveRuntime() {
		// TODO: Save before closing!
		System.exit (0);
	}
}
