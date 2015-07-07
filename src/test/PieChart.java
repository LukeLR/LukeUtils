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
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Slice{

    private double value;
    private  Color color;
    public Slice(double _value){
        Random numGen = new Random();
        int R =  numGen.nextInt(256);
        int G = numGen.nextInt(256);
        int B = numGen.nextInt(256);
        this.setColor(new Color(R,G,B));
        this.value = _value;    
    }
    public void setColor(Color _color){
        this.color = _color;
    }
    public double getValue(){
        return value;
    }
    public Color getColor(){
        return color;
    }
}

class panel extends JPanel{
    JButton bt;
    JTextField txt;
    public panel() {
        bt = new JButton("Submit");
        txt = new JTextField(5);
        add(txt);
        add(bt);
    }   

}

class Component extends JComponent {

    int movx = 0;
    int movy = 0;
    private double angle = 0;
    private double radius = 0.0D;
    private  Random numGen;
    private int w = 500;
    private int h = 500;



    Slice[] slice ;
    public Component(double[] a, int size){
        slice = new Slice[size];
        for( int i = 0; i < size; ++i ){
            slice[i] = new Slice(a[i]);
        }
        numGen = new Random();
        Listener listener = new Listener();
        addMouseListener(listener);
        addMouseMotionListener(listener);



    }

    class Listener extends MouseAdapter{
        private double LastAngle;
        @Override
        public void mousePressed(MouseEvent e) {
            LastAngle = getAngle(e.getPoint());
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            double curAngle = getAngle(e.getPoint());
            double deltaAngle = curAngle - LastAngle;
            angle += deltaAngle;
            repaint();
            LastAngle = curAngle;
        }
        private double getAngle(Point point) {
            double x = point.getX() - 0.5 * w;
            double y = point.getY() - 0.5 * h;
            return Math.atan2(y, x);
        }

    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
      // g2.translate(250, 250);
        g2.rotate(angle,(w/2),(h/2));
        drawPie(g2, getBounds(), slice);

    }
    public void drawPie(Graphics2D g, Rectangle area, Slice[] s){
        double total = 0.0D;

        //calculate total value
        for(int i=0;i<s.length;i++)
            total+=s[i].getValue();

        radius = total/2*Math.PI;
        double curentValue = 0.0D;
        int startAngle = 0; 
        //for(int j=10;j>0;j--){
        for(int i = 0;i<s.length;i++){           
            //s[i].setColor(new Color(numGen.nextInt(256), numGen.nextInt(256), numGen.nextInt(256)));
            startAngle = (int)((curentValue*360)/total);
            int arcAngle = (int)((s[i].getValue()*360)/total) ;
            g.setColor(s[i].getColor());
            //g.rotate(angle);//row AA 
            g.setComposite ( AlphaComposite.getInstance ( AlphaComposite.SRC_OVER, 0.5f ) );

            g.fillArc(0, 0, w, h, startAngle, arcAngle);   



        curentValue+=s[i].getValue();}

        //}
    }


}

public class PieChart {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame();      
        frame.setSize(600,600);       
        int size;
        Scanner s = new Scanner(System.in);

        double a[];
        System.out.println("enter size:");
        size = s.nextInt();
        a = new double [size];
        System.out.println("enter array of value:");
        for(int i=0;i<size;i++){
            a[i] = s.nextDouble();
        }

        frame.getContentPane().add(new Component(a,size));        
        frame.setVisible(true);



    }
}