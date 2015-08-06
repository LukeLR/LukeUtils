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

package gui;

import java.awt.Color;
import java.util.Random;

import logging.Logger;

public class Slice {
	private double value = 0;
	private Color color = Color.black;
	private int order = 0;
	private String name = "";
	
	/**
	 * Ein Slice stellt ein "Kuchenst��ck" f��r die Klasse PieChart (ein Kreisdiagramm).
	 * @param value Speichert den Wert, den das jeweilige Slice darstellen soll.
	 * @param color Speichert die Farbe, in der das Slice gezeichnet werden soll.
	 * @param order Soll sp��ter die M��glichkeit geben, allen Slices eine gew��nschte Reihenfolge zuzuweisen, sodass diese sortiert werden k��nnen.
	 */
	
	public Slice (double value, Color color, int order, String name){
		/**
		 * Erzeugt ein neues Slice, und speichert sofort alle Parameter:
		 * @param value Der Wert, den das jeweilige Slice darstellen soll.
		 * @param color Die Farbe des Slices.
		 * @param order Soll sp��ter die M��glichkeit geben, allen Slices eine gew��nschte Reihenfolge zuzuweisen, sodass diese sortiert werden k��nnen.
		 */
		this.value = value;
		this.color = color;
		this.order = order;
		this.name = name;
	}
	
	public Slice (double value, int order){
		/**
		 * Erzeugt ein neues Slice mit den gegebenen Werten, als Farbe wird eine zuf��llig gew��hlte Farbe im RGB-Farbraum zugewiesen.
		 * @param value Der Wert, den das jeweilige Slice darstellen soll.
		 * @param order Soll sp��ter die M��glichkeit geben, allen Slices eine gew��nschte Reihenfolge zuzuweisen, sodass diese sortiert werden k��nnen.
		 */
		this (value, randColor(), order, "");
	}
	
	public Slice (double value, int order, String name){
		this (value, randColor(), order, name);
	}
	
	public Slice (double value, Color color){
		/**
		 * Erzeugt ein neues Slice mit den gegebenen Werten, die Reihenfolge order wird dabei ausgelassen (auf 0 gesetzt).
		 * @param value Der Wert, den das jeweilige Slice darstellen soll.
		 * @param color Die Farbe des Slices.
		 */
		this (value, color, 0, "");
	}
	
	public Slice (double value, Color color, String name){
		this (value, color, 0, name);
	}
	
	public Slice (double value){
		this (value, randColor(), 0, "");
	}
	
	public Slice (double value, String name){
		this (value, randColor(), 0, name);
	}
	
	public Slice (){
		/**
		 * Erzeugt ein neues Slice. Der Wert wird zun��chst als 0 angenommen, auch die Reihenfolge wird zun��chst auf 0 gesetzt. Als Farbe ist standardm����ig schwarz vorgesehen.
		 */
		this (0, Color.black, 0, "");
	}
	
	public void setValue (double value){
		/**
		 * Setzt den Wert des Slices auf value.
		 * @param value Wert des Slices.
		 */
		this.value = value;
	}
	
	public void setColor (Color color){
		/**
		 * Setzt die F��llfarbe des Slices auf color.
		 * @param color F��llfarbe des Slices.
		 */
		this.color = color;
	}
	
	public void setColor (int R, int G, int B){
		/**
		 * Setzt die F��llfarbe des Slices anhand einzelner RGB-Farbwerte.
		 * @param R Rot-Farbanteil der Farbe.
		 * @param G Gr��n-Farbanteil der Farbe.
		 * @param B Blau-Farbanteil der Farbe.
		 */
		color = new Color (R,G,B);
	}
	
	public void setOrder (int order){
		/**
		 * Setzt die Wertigkeit des Slices zur Sortierung auf order.
		 * @param order Wertigkeit des Slices.
		 */
	}
	
	public double getValue(){
		/**
		 * Gibt den Wert des Slices zur��ck.
		 */
		return value;
	}
	
	public Color getColor(){
		/**
		 * Gibt die Farbe des Slices zur��ck.
		 */
		return color;
	}
	
	public int getOrder(){
		/**
		 * Gibt die Wertigkeit des Slices zur��ck.
		 */
		return order;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void makeRandomColor(){
		/**
		 * Setzt die Farbe des Slices auf eine zuf��llig gew��hlte Farbe im RGB-Farbraum.
		 */
		color = Slice.randColor();
	}
	
	private static Color randColor(){
		Random numGen = new Random();
		return new Color (numGen.nextInt(255),numGen.nextInt(255),numGen.nextInt(255));
	}
	
	public void draw (java.awt.Graphics g, int x, int y, int width, int height, double overallValue, double beforeValue){
		/**
		 * Zeichnet das Slice an der Stelle x,y.
		 * @param g Grafikobjekt, das zum Zeichnen erforderlich ist (java.awt.Graphics).
		 * @param x x-Koordinate des zu zeichnenden Slices.
		 * @param y y-Koordinate des zu zeichnenden Slices.
		 */
		Logger.logMessage('I', this, "Drawing Slice at: " + String.valueOf(x) + "," + String.valueOf(x) + " with dimensions: " + String.valueOf(width) + "," + String.valueOf(height) + " and Values value,overallValue,beforeValue:" + String.valueOf(value) + "," + String.valueOf(overallValue) + "," + String.valueOf(beforeValue));
		int startAngle = (int)(360*(beforeValue/overallValue));
		int arcAngle = (int)(360*(value/overallValue));
		Logger.logMessage('I', this, "Drawing Slice with Angles startAngle,arcAngle: " + String.valueOf(startAngle) + ","  + String.valueOf(arcAngle));
		Color temp = g.getColor();
		g.setColor(color);
		g.fillArc(x, y, width, height, startAngle, arcAngle);
		g.setColor(temp);
	}
}