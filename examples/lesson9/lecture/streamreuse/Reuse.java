package lesson9.lecture.streamreuse;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Illustrates a workaround for limitation on stream reuse: Make the stream
//part of a larger  lambda expression implementing some type of Function interface,
//and then gain access to the desired stream with a call to the Function's apply method
public class Reuse {
  private static final BiFunction<List<String>, String, Stream<String>> listStartsWith 
    = (list, letter) -> list.stream()
                            .filter(name -> name.startsWith(letter));
                        
  public int countNumberFriendsStartingWithB() {
	  return (int) listStartsWith.apply(Folks.friends, "B").count();
  }
  public List<String> listEditorsNamesStartingWithNUpperCase() {
	  return listStartsWith.apply(Folks.editors, "N")
			               .map(name -> name.toUpperCase())
			               .collect(Collectors.toList());
  }
  
  
  public static void main(String[] args) {
	  Reuse r = new Reuse();
	  System.out.println(r.countNumberFriendsStartingWithB());
	  System.out.println(r.listEditorsNamesStartingWithNUpperCase());
  }
}
