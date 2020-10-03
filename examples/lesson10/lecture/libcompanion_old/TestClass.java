package lesson10.lecture.libcompanion_old;
import static org.junit.Assert.*;

import org.junit.Test;

/* Tests firstToUpperCaseLambda by testing
 * its core processing function stored in the
 * LibraryCompanion
 */
public class TestClass {
	/* Tests core piece of firstToUpperCaseLambda */
	@Test
    public void twoLetterStringConvertedToUppercase() {
      String input = "ab";
      String result = LibraryCompanion.firstToUpper(input);
      assertEquals("Ab", result);
    }
	

}
