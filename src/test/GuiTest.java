package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiTest extends JFrame {
	private JPanel p;
	
//	public static void main (String[] args){
//		GuiTest g = new GuiTest();
//		g.repaint();
//	}
	
	public GuiTest(){
		super ("GUI-Test");
		p = new JPanel(){
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
