package test;

import java.util.List;
import java.util.LinkedList;

public class ListTest2 {
	public static void main(String[] args){
		List<String> list = new LinkedList<String>();
		String str1, str2, str3;
		
		str1 = "abc";
		str2 = "def";
		str3 = "ghj";
		
		list.add(str1);
		list.add(str2);
		list.add(str3);
		
		System.out.println("Index of str1: " + list.indexOf(str1));
		System.out.println("Index of str2: " + list.indexOf(str2));
		System.out.println("Index of str3: " + list.indexOf(str3));
		
		String str1Dummy, str2Dummy, str3Dummy;
		
		str1Dummy = "abc";
		str2Dummy = "def";
		str3Dummy = "ghj";
		
		System.out.println("Index of str1Dummy: " + list.indexOf(str1Dummy));
		System.out.println("Index of str2Dummy: " + list.indexOf(str2Dummy));
		System.out.println("Index of str3Dummy: " + list.indexOf(str3Dummy));
	}
}
