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


import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;



public class BasicConsoleGUIWindowListener extends WindowListener {
	private BasicConsoleGUI mv;
	public BasicConsoleGUIWindowListener (BasicConsoleGUI pmv){
		super (pmv);
		mv = pmv;
	}
	
	public void windowClosing (WindowEvent winE){
		if (JOptionPane.showOptionDialog(mv, "Really Quit?", "Quit?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1) == 0){
			mv.leaveRuntime();
		} else {
		}
	}
}
