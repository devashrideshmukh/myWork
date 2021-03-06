package arraysAndStrings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Problem4_CTCI {

	/**
	 * Checks if the given input string is a permutation of palindromes 
	 * Take hashmap for keeping frequency of characters All the frequencies should be
	 * even Only one odd frequency is allowed
	 */
	public static boolean checkIfPermuationOfPalindrome(String input) {

		input = input.trim().toLowerCase().replace(" ", "");

		if (input.length() == 0) {
			System.err.println("Empty String");
			return false;
		}

		HashMap<Character, Integer> characterFrequencyMap = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {

			char key = input.charAt(i);
			if(characterFrequencyMap.containsKey(key)){
				int count = characterFrequencyMap.get(key);
				characterFrequencyMap.put(key, count+1);
			}else{
				characterFrequencyMap.put(key, 1);
			}

		}

		int countOfOdds = 0;

		Iterator iter = characterFrequencyMap.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) iter.next();

			Integer frequency = (Integer) pair.getValue();

			if (frequency % 2 != 0) {

				countOfOdds++;

			}

			iter.remove(); // avoids concurrent modification exception
		}

		if (countOfOdds > 1) {
			return false;
		} else {
			return true;
		}

	}

}
