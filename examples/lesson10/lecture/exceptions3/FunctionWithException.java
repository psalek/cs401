package lesson10.lecture.exceptions3;

import java.util.function.Function;

@FunctionalInterface
public interface FunctionWithException<T, R> {
	R apply(T t) throws Exception;


	public static <T,R> Function<T,R> helper(FunctionWithException<T,R> f) {
		return x -> {	
			try {
				return f.apply(x);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
