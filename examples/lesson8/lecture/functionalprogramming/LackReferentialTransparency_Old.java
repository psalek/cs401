package lesson8.lecture.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LackReferentialTransparency_Old {
	private HashMap<Character, Integer> allLetterCount = new HashMap<>();
	private List<HashMap<Character,Integer>> l = new ArrayList<HashMap<Character,Integer>>();
	
	/* stateful */
	public void recordWord(String word) {
		char[] chars = word.toCharArray();
		HashMap<Character, Integer> temp = new HashMap<>();
		for(char c: chars) {
			recordLetter(c);
			updateMap(temp, c);
		}
		l.add(temp);
	}
	
	/* Lacks referential transparency -- calling recordLetter('a')
	 * twice yields two distinct outputs.
	 * 
	 */
	// This method updates the allLetterCount map, and returns
	// the current value in the map that is matched with the char c
	private int recordLetter(char c) {
		updateMap(allLetterCount, c);
		return allLetterCount.get(c);
	}
	
	private void updateMap(HashMap<Character,Integer> map, Character c) {
		if(map.containsKey(c)) {
			int val = map.get(c);
			map.put(c,  val+1);
		} else {
			map.put(c, 1);
		}
	}
	
	public static void main(String[] args) {
		//shows how recordLetter lacks referential transparency
		LackReferentialTransparency_Old lrt = new LackReferentialTransparency_Old();
		System.out.printf("first call: %s", lrt.recordLetter('a'));
		System.out.printf("\nsecond call: %s", lrt.recordLetter('a'));
		
		//how this app might be used (optional)
		lrt = new LackReferentialTransparency_Old();
		List<String> someWords = Arrays.asList("dog", "cat", "buffalo", "snake", "sheep");
		for(String w: someWords) {
			lrt.recordWord(w);
		}
		System.out.println("\n\nA record of all letters found in input list of words:");
		System.out.println(lrt.allLetterCount);
		System.out.println("A record of all letters -- by word -- in the input list of words:");
		System.out.println(lrt.l);
		
	}
	
	
	
}
