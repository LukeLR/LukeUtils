package util;

import java.io.Serializable;

public class AverageDouble implements Serializable {
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