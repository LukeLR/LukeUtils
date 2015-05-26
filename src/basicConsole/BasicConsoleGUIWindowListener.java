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
