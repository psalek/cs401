package lesson11.lecture.generics.pairexamples;

public interface Pair<K, V> {
    public K getKey();
    public V getValue();

    default String defaultToString() {
    	return "(" + getKey().toString() + ", " + getValue().toString() + ")";
    }
}