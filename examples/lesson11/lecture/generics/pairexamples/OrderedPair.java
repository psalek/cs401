package lesson11.lecture.generics.pairexamples;

/** This generic class implements the generic interface Pair<K, V> */
public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
    
    @Override
	public String toString() {
		return defaultToString();
	}
    
    public static void main(String[] args) {
    	Pair<String, Integer> p = new OrderedPair<>("Bob", 1001);
    	System.out.println(p);
    	
    }
    
    
    
}