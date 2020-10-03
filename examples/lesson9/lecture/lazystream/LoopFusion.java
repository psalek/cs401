package lesson9.lecture.lazystream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The method here illustrates the idea of loop
 * fusion by analogy. The point is that, rather
 * than (inefficiently) creating multiple new
 * streams as outputs for intermediate operations,
 * the intermediate operations are combined (to the
 * extent possible) into a large loop, which supports
 * lazy evaluation
 * @author paul_
 *
 */
public class LoopFusion {
		
	private final static int LIMIT = 2;
	/** This is an imperative imitation of Java's under-the-hood stream solution */
	public List<String> findStartsWithLetterLimit(List<String> list, String letter) {
		List<String> outputList = new ArrayList<>();
		for(String s: list) {
			if (outputList.size() <= LIMIT) {  //limit step
				if(s.startsWith("N")) { //filter step
					s = s.toUpperCase();  //map step
					outputList.add(s);
				}
			}
		}
		return outputList;
			
	}
	
}
