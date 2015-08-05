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

package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiTest extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel p;
	
//	public static void main (String[] args){
//		GuiTest g = new GuiTest();
//		g.repaint();
//	}
	
	public GuiTest(){
		super ("GUI-Test");
		p = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent (Graphics g)
			{
				System.out.println("painting...");
				g.setColor(Color.black);
				g.fillArc(100, 100, 200, 200, 360, 15);
				g.drawRect(100,100,100,100);
			}
		};
		setContentPane(p);
		setSize(500,500);
		setVisible(true);
		this.addWindowListener(new WindowAdapter(
				){
			public void windowClosing (WindowEvent we){
				System.exit(1);
			}
		});
	}
}
