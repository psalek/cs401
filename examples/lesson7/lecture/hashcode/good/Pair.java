package lesson7.lecture.hashcode.good;

public class Pair {
	String first;
	String second;
	public Pair(String f, String s) {
		first = f;
		second = s;
	}
	
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		Pair p = (Pair)ob;
		return p.first.equals(first) && p.second.equals(second);
	}
	
	public int hashCode() {
		int result = 17; //seed
		int hashFirst = first.hashCode();
		int hashSecond = second.hashCode();
		result += 31 * result + hashFirst;
		result += 31 * result + hashSecond;
		return result;
		
	}

}
