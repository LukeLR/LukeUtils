package basicConsole;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowListener extends WindowAdapter {
	public JFrame f;
	
	public WindowListener (JFrame pf){
		pf = f;
	}
	
	public void windowClosing (WindowEvent winE){
		if (JOptionPane.showOptionDialog(f, "Really Quit?", "Quit?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1) == 0){
			f.dispose();
		} else {
		}
	}
}