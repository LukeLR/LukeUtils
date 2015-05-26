package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiTest2 extends JFrame{
	private JPanel p;
	private GridBagConstraints c;
	private gui.Slice[] s;
	private gui.PieChart pc;
	
	public static void main (String[] args){
		GuiTest2 g = new GuiTest2();
		g.repaint();
	}
	
	public GuiTest2(){
		super ("GUI-Test2");
		p = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		s = new gui.Slice[5];
		s[0] = new gui.Slice(2, "Banane");
		s[1] = new gui.Slice(4, "Apfel");
		s[2] = new gui.Slice(5, "Schinken");
		s[3] = new gui.Slice(6, "Käsebrot");
		s[4] = new gui.Slice(7, "Test");
		pc = new gui.PieChart(s);
		p.add(pc, c);
		c.gridx = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.NONE;
		p.add(new gui.PieChartKey(pc), c);
		setContentPane(p);
		setSize(500,500);
		setVisible(true);
//		this.addWindowListener(new WindowAdapter(
//				){
//			public void windowClosing (WindowEvent we){
//				System.exit(1);
//			}
//		});
	}
}
