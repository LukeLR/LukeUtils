package util;

import logging.Logger;

public class Math {
	public static void main(String[] args){
		for(int i = 0; i < 20; i++) System.out.println(eineFibonacci(i));
	}
	
	public static int[] getFibonacci (int n){
		int[] result = new int[n];
		for(int i = 0; i < 20; i++) result[i] = eineFibonacci(i);
		return result;
	}

	private static int eineFibonacci(int i){
		return i < 2 ? i : eineFibonacci(i-1) + eineFibonacci(i-2);
	}
	
	public static String fillUpWithZeros(int in, int length){
		return fillUp(in, length, "0");
	}
	
	public static String fillUpWithZeros(long in, int length){
		return fillUp(in, length, "0");
	}
	
	public static String fillUp (int in, int length, String filler){
		String result = "";
		int diff = 0;
		if (String.valueOf(in).length() < length){
			diff = length - String.valueOf(in).length();
		}
		
		for (int i = 0; i < diff; i++){
			result = result + filler;
		}
		
		result = result + String.valueOf(in);
		
		return result;
	}
	
	public static String fillUp (long in, int length, String filler){
		String result = "";
		int diff = 0;
		if (String.valueOf(in).length() < length){
			diff = length - String.valueOf(in).length();
		}
		
		for (int i = 0; i < diff; i++){
			result = result + filler;
		}
		
		result = result + String.valueOf(in);
		
		return result;
	}
	
	public static boolean isDigit(String in){
		if (in.length()==1){
			return isNumber(in, "");
		} else {
			Logger.logMessage('I', new Math(), in + "contains more than one character and is not Digit.");
			return false;
		}
	}
	
	public static boolean isNumber(String in, String extras){
		if (in.equals("")){
			Logger.logMessage('E', new Math(), "String provided for testing for number is empty!");
			return false;
		} else {
			String numbers = "0123456789" + extras;
			boolean found = false;
			for (int i = 0; i < in.length(); i++){
				if (numbers.indexOf(in.charAt(i)) == -1){
					found = true;
				}
			}
			if (!found){
				Logger.logMessage('I', new Math(), "String " + in + " is numeric!");
				return true;
			} else {
				Logger.logMessage('I', new Math(), "String " + in + " is not numeric!");
				return false;
			}
		}
		
	}
	
	public static boolean isNumber(String in){
		return isNumber(in, "");
	}
	
	public static boolean isDigit (String in, String extras){
		if (in.length()==1){
			return isNumber(in, extras);
		} else {
			Logger.logMessage('I', new Math(), in + "contains more than one character and is not Digit.");
			return false;
		}
	}
	
	public static int concatToEnd(int in, int length){
		String str = String.valueOf(in);
		if (str.length() > length){
			return Integer.valueOf(str.substring(str.length()-length, length));
		} else {
			return in;
		}
	}
}
