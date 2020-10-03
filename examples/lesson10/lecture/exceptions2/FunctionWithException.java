package lesson10.lecture.exceptions2;

@FunctionalInterface
public interface FunctionWithException<T, R> {
	R apply(T t) throws Exception;
}
