
package lesson9.lecture.optional;

import java.util.List;
import java.util.Optional;

public class PickAnElementOrElse {
    //NEW WAY
	public static void pickName(final List<String> names, final String startingLetter) {
		final Optional<String> foundName = names.stream()
				                                .filter(name -> name.startsWith(startingLetter))
				                                .findFirst();
		System.out.println(
				String.format("A name starting with %s: %s", 
						       startingLetter, 
						       foundName.orElse("No name found")));
	}

	public static void main(final String[] args) {
		pickName(Folks.friends, "N");
		pickName(Folks.friends, "Z");
	}
}
