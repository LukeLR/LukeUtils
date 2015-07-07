package test;

import logging.Log;
//import data.list.List;
import java.util.List;
import java.util.LinkedList;

public class ListTest {
	List<Log> list;
	Log logDefault, logAdvanced, logDebug;
	String strDefault, strAdvanced, strDebug;
	
	public ListTest(){
		list = new LinkedList();
		strDefault = "default";
		strAdvanced = "advanced";
		strDebug = "debug";
		logDefault = new Log();
		logDefault.setChannel(strDefault);
		logAdvanced = new Log();
		logAdvanced.setChannel(strAdvanced);
		logDebug = new Log();
		logDebug.setChannel(strDebug);
	}
	
	public void start(){
		list.add(logDefault);
		list.add(logAdvanced);
		list.add(logDebug);
		
		System.out.println("Index of logDefault: " + list.indexOf(logDefault));
		System.out.println("Index of logAdvanced: " + list.indexOf(logAdvanced));
		System.out.println("Index of logDebug: " + list.indexOf(logDebug));
		
		Log logDefaultDummy = new Log();
		logDefaultDummy.setChannel(strDefault);
		System.out.println("Index of logDefaultDummy: " + list.indexOf(logDefaultDummy));
		
		Log logAdvancedDummy = new Log();
		logAdvancedDummy.setChannel(strAdvanced);
		System.out.println("Index of logAdvancedDummy: " + list.indexOf(logAdvancedDummy));
		
		Log logDebugDummy = new Log();
		logDebugDummy.setChannel(strDebug);
		System.out.println("Index of logDebugDummy: " + list.indexOf(logDebugDummy));
	}
}
