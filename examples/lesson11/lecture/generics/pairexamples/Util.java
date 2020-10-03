package lesson11.lecture.generics.pairexamples;

/** Example of syntax for a generic method */
public class Util {
	
    public static <K, V> boolean compare(SimplePair<K, V> p1, SimplePair<K, V> p2) {
        return (Boolean)(p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue()));
    }
    
    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	//with type value
    	SimplePair<Integer, String> p1 = new SimplePair<>(1, "apple");
    	SimplePair<Integer, String> p2 = new SimplePair<>(2, "pear");
    	boolean areTheySame = Util.<Integer, String>compare(p1, p2); //type value shown
    	
    	//without type value
    	
    	SimplePair<Integer, String> q1 = new SimplePair<>(1, "apple");
    	SimplePair<Integer, String> q2 = new SimplePair<>(2, "pear");
    	boolean areTheySame2 = Util.compare(q1, q2);
    	
    	
    	
    }
	
}
