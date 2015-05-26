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
