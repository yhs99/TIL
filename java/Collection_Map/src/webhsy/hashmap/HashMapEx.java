package webhsy.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapEx {
	public static void main(String[] args) {
		String words ="Hash table based implementation of the Map interface based Map Hash Map";
		words = words.toLowerCase();
        String[] wordArray = words.split(" ");

        Map<String, Integer> wordCountMap = new HashMap<>();

        Map<String, Integer> wordCountMap2 = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        
//        Map<String, Integer> wordCountMap2 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        for(String word : wordArray) {
        	if(wordCountMap.containsKey(word)) {
        		wordCountMap.put(word, wordCountMap.get(word)+1);
        	}else {
        		wordCountMap.put(word, 1);
        	}
        }
        
        for(String word : wordArray) {
        	wordCountMap2.put(word, wordCountMap2.getOrDefault(word, 0)+1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("===========================================");
        for (Map.Entry<String, Integer> entry : wordCountMap2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
