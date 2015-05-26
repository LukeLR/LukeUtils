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