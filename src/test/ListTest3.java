package test;

import java.util.List;
import java.util.LinkedList;

import logging.Log;

public class ListTest3 {
	public static void main(String[] args){
		List list = new LinkedList();
		Log logDefault = new Log();
		logDefault.setChannel("default");
		Log logAdvanced = new Log();
		logAdvanced.setChannel("advanced");
		Log logDebug = new Log();
		logDebug.setChannel("debug");
		
		list.add(logDefault);
		list.add(logAdvanced);
		list.add(logDebug);
		
		System.out.println("Index of logDefault: " + list.indexOf(logDefault));
		System.out.println("Index of logAdvanced: " + list.indexOf(logAdvanced));
		System.out.println("Index of logDebug: " + list.indexOf(logDebug));
		
		Log logDefaultDummy = new Log();
		logDefaultDummy.setChannel("default");
		System.out.println("Index of logDefaultDummy: " + list.indexOf(logDefaultDummy));
		
		Log logAdvancedDummy = new Log();
		logAdvancedDummy.setChannel("advanced");
		System.out.println("Index of logAdvancedDummy: " + list.indexOf(logAdvancedDummy));
		
		Log logDebugDummy = new Log();
		logDebugDummy.setChannel("debug");
		System.out.println("Index of logDebugDummy: " + list.indexOf(logDebugDummy));
	}
}
