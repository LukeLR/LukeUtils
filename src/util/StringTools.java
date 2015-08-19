package util;

public class StringTools {

	public StringTools() {
		// TODO Auto-generated constructor stub
	}
	
	public static java.lang.String StringArrayToString(java.lang.String[] in){
		java.lang.String result = "";
		for (int i = 0; i < in.length; i++){
			if (i != 0){
				result = result + " ";
			}
			result = result + in[i];
		}
		return result;
	}
}
