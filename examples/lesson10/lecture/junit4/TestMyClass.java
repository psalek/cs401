package lesson10.lecture.junit4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyClass {
	@Test
	public void unitTestMyMethod() {
		int expected = 5;
		int computedVal = (new MyClass()).myMethod("hello");
		assertEquals(expected, computedVal);
	}
}
