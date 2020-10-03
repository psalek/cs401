package lesson9.lecture.tryIt;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Try {
	public static void main(String[] args) {
		print(Stream.iterate(1, n->n+1).skip(3));
	}
	
	public static <T> void print(Stream<T> stream) {
		System.out.println(stream.limit(8).collect(Collectors.toList()));
	}
}
