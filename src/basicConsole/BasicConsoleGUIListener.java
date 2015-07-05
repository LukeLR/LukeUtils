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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BasicConsoleGUIListener implements ActionListener {
	private BasicConsoleGUI bg;
	public BasicConsoleGUIListener(BasicConsoleGUI pbg){
		super();
		bg = pbg;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Bestatigen")){
			bg.outputText(bg.getEingabe());
		}
	}
}