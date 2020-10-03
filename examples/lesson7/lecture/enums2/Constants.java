package lesson7.lecture.enums2;

public enum Constants {
	MAX_VAL(50), 
	SHORTEST_NAME("Bob");
	
	int intval;
	String strval;
	Constants(int x) {
		intval = x;
	}
	Constants(String str) {
		strval = str;
	}
	public int intval() {
		return intval;
	}
	public String strval() {
		return strval;
	}
}

