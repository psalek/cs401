package lesson7.lecture.enums2;

public enum AnEnum {
	INST1(3) {public void modify() {val++;}}, 
	INST2(2) {public void modify() {val = val*2;}};
	
	int val = 0;
	AnEnum(int x) {
		val = x;
	}
	public int val()  {
		return val;
	}
	abstract public void modify();
	
}
