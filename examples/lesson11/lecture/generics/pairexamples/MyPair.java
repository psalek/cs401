package lesson11.lecture.generics.pairexamples;


//This version implements the parametrized type Pair<String, Integer>
//MyPair does not include type variables
public class MyPair implements Pair<String, Integer>{
	private String key;
    private Integer value;

    public MyPair(String key, Integer value) {
    	this.key = key;
    	this.value = value;
    }
	
	@Override
	public String getKey() {
		return key;
	}
	@Override
	public Integer getValue() {
		return value;
	}
	@Override
	public String toString() {
		return defaultToString();
	}
	public static void main(String[] args) {
		Pair<String, Integer> p = new MyPair("Bob", 1001);
		System.out.println(p);
	}
}
