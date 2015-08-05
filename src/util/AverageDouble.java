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

package util;

import java.io.Serializable;

public class AverageDouble implements Serializable {
	private static final long serialVersionUID = 1L;
	private double value, sum;
	private int num;
	
	public AverageDouble(){
		
	}
	
	public AverageDouble(double value){
		this.value = value;
	}
	
	public void addToAverage(double value){
		num++;
		sum = sum + value;
		this.value = (double)(sum/num);
	}
	
	public double getValue(){
		return value;
	}
	
	public int getNum(){
		return num;
	}
	
	public double getSum(){
		return sum;
	}
	
	public void setValue(double value){
		this.value = value;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	public void setSum(double sum){
		this.sum = sum;
	}
}