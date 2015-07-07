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

public class AverageLong implements Serializable {
	private long value, sum;
	private int num;
	
	public AverageLong(){
		
	}
	
	public AverageLong(long value){
		this.value = value;
	}
	
	public void addToAverage(long value){
		num++;
		sum = sum + value;
		this.value = (long)(sum/num);
	}
	
	public long getValue(){
		return value;
	}
	
	public int getNum(){
		return num;
	}
	
	public long getSum(){
		return sum;
	}
	
	public void setValue(long value){
		this.value = value;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	public void setSum(long sum){
		this.sum = sum;
	}
}
