package lesson8.lecture.lambdaexamples.trifunction;

@FunctionalInterface
public interface TriFunction<S,T,U,R> {
	R apply(S s, T t, U u);
}
