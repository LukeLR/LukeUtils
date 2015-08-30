package data.list;

public class ListTools {
	public static Object[] ListToArray(java.util.List l){
		Object result[] = new Object[l.size()];
		for (int i = 0; i < l.size(); i++){
			result[i] = l.get(i);
		}
		return result;
	}
}
